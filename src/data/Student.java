/*
 * Copyright for Student.java by kumar since 8/16/20, 12:42 AM
 */

package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created By Saurav Kumar on 7/5/2020
 */
public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    private String gender;
    private int noteBooks;
    private Optional<Bike> bike;
     private int count = 0;
    /**
     * Gets bike.
     *
     * @return the bike
     */
    public Optional<Bike> getBike() {
        return bike;
    }

    /**
     * Sets bike.
     *
     * @param bike the bike
     */
    public void setBike(Optional<Bike> bike) {
        this.bike = bike;
    }

    /**
     * Instantiates a new Student.
     */
    public Student() {

    }

    /**
     * Instantiates a new Student.
     *
     * @param name       the name
     * @param gradeLevel the grade level
     * @param gpa        the gpa
     * @param gender     the gender
     * @param noteBooks  the note books
     * @param activities the activities
     */
    public Student(String name, int gradeLevel, double gpa, String gender, int noteBooks, List<String> activities) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.gender = gender;
        this.noteBooks = noteBooks;
        this.activities = activities;
    }

    /**
     * Gets note books.
     *
     * @return the note books
     */
    public int getNoteBooks() {

        return noteBooks;
    }

    /**
     * Sets note books.
     *
     * @param noteBooks the note books
     */
    public void setNoteBooks(int noteBooks) {
        this.noteBooks = noteBooks;
    }

    /**
     * Instantiates a new Student.
     *
     * @param name       the name
     * @param gradeLevel the grade level
     * @param gpa        the gpa
     * @param gender     the gender
     * @param activities the activities
     */
    public Student(String name, int gradeLevel, double gpa, String gender, List<String> activities) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.gender = gender;
        this.activities = activities;
    }

    /**
     * Instantiates a new Student.
     *
     * @param s the s
     */
    public Student(String s) {
        this.name = s;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
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
     * Gets grade level.
     *
     * @return the grade level
     */
    public int getGradeLevel() {
        return gradeLevel;
    }

    /**
     * Sets grade level.
     *
     * @param gradeLevel the grade level
     */
    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    /**
     * Gets gpa.
     *
     * @return the gpa
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Sets gpa.
     *
     * @param gpa the gpa
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * The Activities.
     */
    List<String> activities = new ArrayList<>();

    /**
     * Gets activities.
     *
     * @return the activities
     */
    public List<String> getActivities() {
        return this.activities;
    }

    /**
     * Sets activities.
     *
     * @param activities the activities
     */
    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    /**
     * Print list of activities.
     */
    public void printListOfActivities() {

        System.out.println("List of Activities are : " + this.activities);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Student{").append("name=").append(name).append(", gradeLevel=").append(gradeLevel).append(", gpa=").append(gpa).append(", gender=").append(gender).append(", activities=").append(activities).append('}').toString();
    }
}
