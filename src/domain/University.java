package domain;

import domain.base.NamedObject;

import java.util.ArrayList;
import java.util.List;

public class University extends NamedObject {

    private static final University KAZNU = new University("Казну");
    private List<Faculty> faculties;

    public University(String name) {
        super(name);
        this.faculties = new ArrayList<>();
    }

    private University() {
        faculties = new ArrayList<>();
    }

    public static University getInstance() {
        return KAZNU;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
}
