import javax.security.auth.Subject;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Echetik on 11.09.2016.
 */
public class Group {
    HashSet<Student> students = new HashSet<>();
    HashSet<Discipline> disciplineList = new HashSet<>();
    String groupName;

    public boolean addStudent(Student st) {
        students.add(st);
        return st.setGroup(this);
    }

    public boolean setSubjectToGroup(Discipline discipline) {
        if (disciplineList.add(discipline)) {
            for (Student stud : students) {
                stud.getRecordBook().setDiscipline(discipline);
            }
            return true;
        }
        return false;
    }

    public HashSet<Discipline> getDisciplines() {
        return disciplineList;
    }
}
