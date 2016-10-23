package task6;

import java.util.Objects;

/**
 * Created by Echetik on 04.09.2016.
 */
public class Record {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;
        Record record1 = (Record) o;
        return Objects.equals(record, record1.record);
    }

    @Override
    public int hashCode() {
        return Objects.hash(record);
    }

    private String record;

    public Record(String string) {
        this.record = string;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String showRecord() {
        return record;
    }

    @Override
    public String toString() {
        return record;
    }
}
