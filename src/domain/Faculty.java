package domain;

import domain.base.NamedObject;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends NamedObject {

    private List<Course> courses;
    private List<Student> students;

    public Faculty() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public Faculty(String name) {
        super(name);
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public Faculty(List<Course> courses, List<Student> students) {
        this.courses = courses;
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
