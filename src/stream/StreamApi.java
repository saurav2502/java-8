/*
 * Copyright for StreamApi.java by kumar since 14/02/21, 4:55 PM
 */

package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * The type Stream api.
 */
public class StreamApi {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<User> userList;
        userList = new ArrayList<>(
                Arrays.asList(new User("Saurav"), new User("Monu"), new User("Ritesh"))
        );

        Map<String, Integer> listToMap = userList.stream()
                .collect(toMap(User::getName, User::getAge));
        System.out.println(listToMap);


        List<User> users;
        users = Arrays.asList(
          new User(20, "Saurav", Arrays.asList("2","3","4")) ,
          new User(30, "Saurav", Arrays.asList("5","6","7")) ,
          new User(40, "Saurav", Arrays.asList("8","9","10"))
        );

        Optional<String> phone = users.stream()
                .map(user -> user.getPhoneNumbers().stream())
                .flatMap(stringStream -> stringStream.filter(phoneNo -> phoneNo.equals("11")))
                .findAny();
        if (phone.isPresent()) {
            System.out.println(phone);
        }
        List<String> collect = users.stream()
                .flatMap(user -> user.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}

/**
 * The type User.
 */
class User {
    /**
     * The Age.
     */
    private int age = 30;
    /**
     * The Name.
     */
    private String name;

    /**
     * The Phone numbers.
     */
    private List<String> phoneNumbers;

    /**
     * Instantiates a new User.
     *
     * @param name the name
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new User.
     *
     * @param age          the age
     * @param name         the name
     * @param phoneNumbers the phone numbers
     */
    public User(int age, String name, List<String> phoneNumbers) {
        this.age = age;
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets phone numbers.
     *
     * @return the phone numbers
     */
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Sets phone numbers.
     *
     * @param phoneNumbers the phone numbers
     */
    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("age=").append(age);
        sb.append(", name='").append(name).append('\'');
        sb.append(", phoneNumbers=").append(phoneNumbers);
        sb.append('}');
        return sb.toString();
    }
}
