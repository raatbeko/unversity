package service;

import domain.Course;
import domain.Faculty;
import domain.Student;
import domain.University;

public class FacultyService {

    private final University university;

    private FacultyService() {
        this.university = University.getInstance();
    }

    public static FacultyService createService() {
        return new FacultyService();
    }

    public Faculty create(String name) {
        Faculty faculty = new Faculty(name);
        university.addFaculty(faculty);
        return faculty;
    }

    public void addStudent(Faculty faculty, Student student) {
        faculty.getStudents().add(student);
    }

    public void addCourse(Faculty faculty, Course course) {
        faculty.getCourses().add(course);
    }
}
