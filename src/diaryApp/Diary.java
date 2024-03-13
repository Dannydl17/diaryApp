package diaryApp;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String userName;
    private String password;
    private boolean isLocked;
    private List<Entry> entries = new ArrayList<>();
    private int size;
    public Diary(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String generateUserName() {
        return userName;
    }

    public void add(Entry entry) {
        entries.add(entry);
        size++;
    }

    public int count() {
        return entries.size();
    }
}
