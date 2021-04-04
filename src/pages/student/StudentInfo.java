package pages.student;

public class StudentInfo {
    private final String name;
    private final String ID;
    private final String performance;
    private final String attendance;

    public StudentInfo (String name, String ID, String performance, String attendance) {
        this.name = name;
        this.ID = ID;
        this.performance = performance;
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getPerformance() {
        return performance;
    }

    public String getAttendance() {
        return attendance;
    }
}
