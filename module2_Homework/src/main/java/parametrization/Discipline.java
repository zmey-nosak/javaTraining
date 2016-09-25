package parametrization;

import java.util.HashSet;

/**
 * Created by Echetik on 11.09.2016.
 */
public enum Discipline {
    MATHEMATICS(Integer.class),
    PHYSICS(Double.class),
    CHEMISTRY(Double.class),
    LINGUISTICS(Integer.class);
    private final Class type;
    HashSet<Student> students = new HashSet<>();

    Discipline(Class type) {
        this.type = type;
    }

    public String getType() {
        return this.type.getTypeName();
    }

    public boolean addStudent(Student st) {
        students.add(st);
        return st.setDiscipline(this);
    }

}
