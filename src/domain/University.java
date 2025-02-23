package domain;

import domain.base.NamedObject;

import java.util.ArrayList;
import java.util.List;

public class University extends NamedObject {

    private List<Faculty> faculties;

    public University() {
        faculties = new ArrayList<>();
    }

    public University(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
