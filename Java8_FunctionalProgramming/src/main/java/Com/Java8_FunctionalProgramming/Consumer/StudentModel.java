package Com.Java8_FunctionalProgramming.Consumer;

import java.util.List;
import java.util.Optional;

public class StudentModel {
    private String name;
    private int gradeLevel;
    private double gpa;
    private int noteBooks;
//    The bike field is optional ie, it's not for every ppl so we dont need to add this as the constructor
    private Optional<Bike> bike;

    @Override
    public String toString() {
        return "StudentModel{" +
                "name='" + name + '\'' +
                ", gradeLevel=" + gradeLevel +
                ", gpa=" + gpa +
                ", noteBooks=" + noteBooks +
                ", bike=" + bike +
                ", gender='" + gender + '\'' +
                ", activities=" + activities +
                '}';
    }

    public Optional<Bike> getBike() {
        return bike;
    }

    public void setBike(Optional<Bike> bike) {
        this.bike = bike;
    }

    public int getNoteBooks() {
        return noteBooks;
    }

    public void setNoteBooks(int noteBooks) {
        this.noteBooks = noteBooks;
    }

    public StudentModel(String name, int gradeLevel, double gpa, int noteBooks, String gender, List<String> activities) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.noteBooks = noteBooks;
        this.gender = gender;
        this.activities = activities;
    }

    //    This constructor is created inorder to get the Student instance using the Constructor reference
    public StudentModel() {}
// This constructor reference takes the string and return the toString with name only as not null
    public StudentModel(String s) {
        this.name=s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentModel that = (StudentModel) o;

        if (gradeLevel != that.gradeLevel) return false;
        if (Double.compare(that.gpa, gpa) != 0) return false;
        if (!name.equals(that.name)) return false;
        if (!gender.equals(that.gender)) return false;
        return activities.equals(that.activities);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + gradeLevel;
        temp = Double.doubleToLongBits(gpa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + gender.hashCode();
        result = 31 * result + activities.hashCode();
        return result;
    }

    private String gender;
    private List<String> activities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public StudentModel(String name, int gradeLevel, double gpa, String gender, List<String> activities) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.gender = gender;
        this.activities = activities;
    }
    public void printAllActivities(){
        System.out.println(activities);
    }
}
