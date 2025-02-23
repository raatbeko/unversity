package domain;

public class Course {

    private Semester currentSemester;

    public Course() {
    }

    public Course(Semester currentSemester) {
        this.currentSemester = currentSemester;
    }

    public Semester getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(Semester currentSemester) {
        this.currentSemester = currentSemester;
    }

}
