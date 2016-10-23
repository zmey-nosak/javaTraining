package task6;

import java.util.Arrays;

public class Notepad {
    private int pointNextEmptyPosition;
    private int capacity = 1;
    private Record[] records = new Record[capacity];

    /**
     * Create Record and add it to Notepad
     *
     * @param str text of {@Link Record}
     */
    public void addRecord(String str) {
        addRecord(new Record(str));
    }

    /**
     * Create Record and add it to Notepad
     *
     * @param record record will append to Notepad
     */
    public void addRecord(Record record) {
        if (pointNextEmptyPosition == capacity) {
            capacity += 16;
            records = Arrays.copyOf(records, capacity);
        }
        records[pointNextEmptyPosition] = record;
        pointNextEmptyPosition++;
    }


    /**
     * Removes record by index from this Notepad.
     *
     * @return true if this Notepad contained the specified record
     */
    public boolean removeRecord(int index) {
        if (index == pointNextEmptyPosition - 1) {
            records[index] = null;
            pointNextEmptyPosition--;
        } else if (index < pointNextEmptyPosition - 1) {
            for (int i = index; i < pointNextEmptyPosition - 1; i++) {
                records[i] = records[i + 1];
            }
            records[--pointNextEmptyPosition] = null;
        } else {
            System.out.println("index out of size");
            return false;
        }
        return true;
    }

    /**
     * Removes from this notepad all of its records
     */
    public void removeAllRecords() {
        records = new Record[capacity];
        pointNextEmptyPosition = 0;
    }

    /**
     * Replaces the text at the specified record in this notepad.
     *
     * @param index   index of record to be edited
     * @param newText new text for {@link Record}
     * @return true if this Notepad contains the specified record
     */
    public boolean editRecord(int index, String newText) {
        if (index < pointNextEmptyPosition) {
            records[index].setRecord(newText);
            return true;
        }
        return false;
    }

    public void showNotepad() {
        for (int i = 0; i < pointNextEmptyPosition; i++) {
            System.out.print(records[i] + ", ");
        }
        System.out.println();
        System.out.println("capacity:" + capacity);
        System.out.println("pointNextEmptyPosition:" + pointNextEmptyPosition);
    }

    /**
     * Returns array of records which notebook contains.
     *
     * @return array of all records in this notebook
     */
    public Record[] getAllRecords() {
        return records;
    }

}
