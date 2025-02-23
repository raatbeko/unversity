package domain;

import java.util.ArrayList;
import java.util.List;

public class Semester {

    private List<Schedule> schedules;

    public Semester() {
        schedules = new ArrayList<>();
    }

    public Semester(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
