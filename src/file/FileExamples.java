/*
 * Copyright for FileExamples.java by kumar since 13/10/20, 2:20 PM
 */

package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Set;

/**
 * @author kumar
 * @project java-8
 * @since 13-10-2020
 */
public class FileExamples {
    public static void main(String[] args) {
        File files = new File("D:\\MOCK_DATA.csv");
        Path path = files.toPath();
        System.out.println(isInSecureDir(path));
    }

    private static boolean isInSecureDir1(Path path) {
        try{
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            if (!attributes.isRegularFile()){
                System.out.println("not a regular file");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean isInSecureDir(Path file) {
        return isInSecureDir(file, null);
    }
    public static boolean isInSecureDir(Path file, UserPrincipal user) {
        return isInSecureDir(file, user, 5);
    }

    public static boolean isInSecureDir(Path file, UserPrincipal user,
                                        int symlinkDepth) {
        if (!file.isAbsolute()) {
            file = file.toAbsolutePath();
        } if (symlinkDepth <=0) {
            // Too many levels of symbolic links
            return false;
        }

        // Get UserPrincipal for specified user and superuser
        FileSystem fileSystem =
                Paths.get(file.getRoot().toString()).getFileSystem();
        UserPrincipalLookupService upls =
                fileSystem.getUserPrincipalLookupService();
        UserPrincipal root = null;
        try {
            root = upls.lookupPrincipalByName("root");
            if (user == null) {
                user = upls.lookupPrincipalByName(System.getProperty("user.name"));
            }
            if (root == null || user == null) {
                return false;
            }
        } catch (IOException x) {
            return false;
        }
        for (int i = 1; i <= file.getNameCount(); i++) {
            Path partialPath = Paths.get(file.getRoot().toString(),
                    file.subpath(0, i).toString());

            try {
                if (Files.isSymbolicLink(partialPath)) {
                    if (!isInSecureDir(Files.readSymbolicLink(partialPath),
                            user, symlinkDepth - 1)) {
                        // Symbolic link, linked-to dir not secure
                        return false;
                    }
                } else {
                    UserPrincipal owner = Files.getOwner(partialPath);
                    if (!user.equals(owner) && !root.equals(owner)) {
                        // dir owned by someone else, not secure
                        return false;
                    }
                    PosixFileAttributes attr =
                            Files.readAttributes(partialPath, PosixFileAttributes.class);
                    Set<PosixFilePermission> perms = attr.permissions();
                    if (perms.contains(PosixFilePermission.GROUP_WRITE) ||
                            perms.contains(PosixFilePermission.OTHERS_WRITE)) {
                        // Someone else can write files, not secure
                        return false;
                    }
                }
            } catch (IOException x) {
                return false;
            }
        }

        return true;
    }
}
