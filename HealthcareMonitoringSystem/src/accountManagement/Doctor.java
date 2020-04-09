package accountManagement;
import recordManagement.*;
import java.util.ArrayList;

public class Doctor extends User {
    private ArrayList<Record> records;

    public Doctor(String name, String email, String password, String contact) {
        super(name, email, password, contact);
        records = new ArrayList<Record>();
    }

    void addRecord(Record r) {
        records.add(r);
    }
}