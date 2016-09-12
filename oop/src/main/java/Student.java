import java.util.HashSet;

/**
 * Created by Echetik on 11.09.2016.
 */
public class Student {
    private final String name;
    private HashSet<Group> groupList = new HashSet<>();
    private RecordBook recordBook;

    public Student(String name) {
        this.name = name;
        recordBook = new RecordBook(this);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public boolean setGroup(Group group) {
        recordBook.setDisciplines(group.getDisciplines());
        return groupList.add(group);
    }

    public RecordBook getRecordBook() {
        return recordBook;
    }

    public HashSet<Group> getStudentsGroups() {
        return groupList;
    }
}