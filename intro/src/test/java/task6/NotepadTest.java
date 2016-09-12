package task6;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Echetik on 12.09.2016.
 */
public class NotepadTest {
    Notepad notepad = new Notepad();

    @Test
    public void testAddRecord() throws Exception {
        for (int i = 1; i < 22; i++) {
            notepad.addRecord("" + i + " record");
        }
        //System.out.println(Arrays.ToString(notepad.getAllRecords()));
        notepad.showNotepad();
    }

    @Test
    public void testGetInt() throws Exception {

    }

    @Test
    public void testGetString() throws Exception {

    }

    @Test
    public void testRemoveRecordByIndex() throws Exception {
        for (int i = 1; i < 4; i++) {
            notepad.addRecord("" + i + " record");
        }
        System.out.println(Arrays.deepToString(notepad.getAllRecords()));
        notepad.removeRecord(0);
        System.out.println(Arrays.deepToString(notepad.getAllRecords()));
        notepad.showNotepad();
    }

    @Test
    public void testEditRecord() throws Exception {

    }

    @Test
    public void testShowNotepad() throws Exception {

    }

    @Test
    public void testShowMenu() throws Exception {

    }

    @Test
    public void testStartWorking() throws Exception {

    }
}