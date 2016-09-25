package parametrization;

import org.junit.Test;
import parametrization.Discipline;
import parametrization.Student;

import java.util.HashSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Echetik on 11.09.2016.
 */
public class Deanery {

    @Test
    public void correctFillGroups() {
        Student student1 = new Student("A");
        Student student2 = new Student("B");
        Student student3 = new Student("C");
        Student student4 = new Student("D");
        Student student5 = new Student("E");
        Student student6 = new Student("F");
        Student student7 = new Student("J");

        assertThat(true, is(Discipline.CHEMISTRY.addStudent(student1)));
        assertThat(true, is(Discipline.CHEMISTRY.addStudent(student5)));

        assertThat(true, is(Discipline.LINGUISTICS.addStudent(student1)));
        assertThat(true, is(Discipline.LINGUISTICS.addStudent(student6)));

        assertThat(true, is(Discipline.PHYSICS.addStudent(student3)));
        assertThat(true, is(Discipline.MATHEMATICS.addStudent(student7)));
    }

    @Test
    public void correctGetStudentsGroup() {
        Student student1 = new Student("A");
        assertThat(true, is(Discipline.CHEMISTRY.addStudent(student1)));
        assertThat(true, is(Discipline.LINGUISTICS.addStudent(student1)));
        HashSet<Discipline> groupList = student1.getStudentsDisciplines();
        assertThat(true, is(groupList.contains(Discipline.CHEMISTRY)));
        assertThat(true, is(groupList.contains(Discipline.LINGUISTICS)));
        assertThat(2, is(groupList.size()));
    }

    @Test
    public void correctSetMarks() {
        Student student1 = new Student("A");
        assertThat(true, is(Discipline.PHYSICS.addStudent(student1)));
        assertThat(true, is(Discipline.LINGUISTICS.addStudent(student1)));
        assertThat(true, is(student1.getRecordBook().setMark(4.6, Discipline.PHYSICS)));
        assertThat(false, is(student1.getRecordBook().setMark(4, Discipline.PHYSICS)));
        assertThat(true, is(student1.getRecordBook().setMark(4, Discipline.LINGUISTICS)));
    }


}
