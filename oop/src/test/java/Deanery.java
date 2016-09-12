import org.junit.Test;

import java.util.HashSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Echetik on 11.09.2016.
 */
public class Deanery {

    Group group = new Group();
    Group group1 = new Group();

    @Test
    public void correctFillGroups() {
        Student student1 = new Student("A");
        Student student2 = new Student("B");
        Student student3 = new Student("C");
        Student student4 = new Student("D");
        Student student5 = new Student("E");
        Student student6 = new Student("F");
        Student student7 = new Student("J");
        assertThat(true, is(group.setSubjectToGroup(Discipline.CHEMISTRY)));
        assertThat(true, is(group.setSubjectToGroup(Discipline.LINGUISTICS)));

        assertThat(true, is(group.addStudent(student1)));
        assertThat(true, is(group.addStudent(student2)));
        assertThat(true, is(group.addStudent(student3)));

        assertThat(true, is(group.setSubjectToGroup(Discipline.PHYSICS)));
        assertThat(true, is(group.setSubjectToGroup(Discipline.MATHEMATICS)));

        assertThat(true, is(group1.addStudent(student4)));
        assertThat(true, is(group1.addStudent(student5)));
        assertThat(true, is(group1.addStudent(student6)));
    }

    @Test
    public void correctGetStudentsGroup() {
        Student student1 = new Student("A");
        group.addStudent(student1);
        group1.addStudent(student1);
        HashSet<Group> groupList = student1.getStudentsGroups();
        assertThat(true, is(groupList.contains(group)));
        assertThat(true, is(groupList.contains(group1)));
        assertThat(2, is(groupList.size()));
    }

    @Test
    public void correctSetMarks() {
        Student student1 = new Student("A");
        group.addStudent(student1);
        assertThat(true, is(group.setSubjectToGroup(Discipline.CHEMISTRY)));
        assertThat(true, is(group.setSubjectToGroup(Discipline.LINGUISTICS)));
        assertThat(true, is(student1.getRecordBook().setMark(4.6, Discipline.CHEMISTRY)));
        assertThat(true, is(student1.getRecordBook().setMark(4, Discipline.LINGUISTICS)));
    }


}
