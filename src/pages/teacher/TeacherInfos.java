package pages.teacher;

public class TeacherInfos {
    private final String name;
    private final String ID;
    private final String firstClass;
    private final String secondClass;
    private final String thirdClass;

    public TeacherInfos(String name, String ID, String firstClass, String secondClass, String thirdClass) {
        this.name = name;
        this.ID = ID;
        this.firstClass = firstClass;
        this.secondClass = secondClass;
        this.thirdClass = thirdClass;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public String getThirdClass() {
        return thirdClass;
    }
}