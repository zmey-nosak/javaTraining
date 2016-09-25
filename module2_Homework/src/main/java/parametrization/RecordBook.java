package parametrization;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Echetik on 11.09.2016.
 */
public class RecordBook {
    Student student;
    HashMap<Discipline, Number> validation = new HashMap<Discipline, Number>();

    public RecordBook(Student student) {
        this.student = student;
    }

    public void setDiscipline(Discipline discipline) {
        validation.put(discipline, null);
    }

    public void setDisciplines(HashSet<Discipline> disciplines) {
        for (Discipline disc : disciplines) {
            validation.put(disc, null);
        }
    }

    public boolean setMark(Number mark, Discipline discipline) {
        if (validation.containsKey(discipline) && mark.getClass().getTypeName().equals(discipline.getType())) {
            validation.put(discipline, mark);
            return true;
        }
        return false;
    }


}
