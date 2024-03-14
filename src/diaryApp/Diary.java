package diaryApp;

import exception.InvalidUserId;
import exception.WrongPinException;

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

    public void add(Entry entry) {
        entries.add(entry);
//        size++;
    }

    public int count() {
        return entries.size();
    }

    public void delete(int id) {
        Entry entry = findEntry(id);
        entries.remove(entry);
    }

    public Entry findEntry(int id) {
        int number = 0;
        for (Entry entry: entries) {
            number = entry.getId();
            if(number == id){
                return entry;
            }
        }
        throw new InvalidUserId("Id not found");
    }

    public void updateEntry(int  entryId, String body) {
        for (Entry entry:entries) {
            Entry foundEntry;
           if (entry.getId() == entryId){
               foundEntry = entry;
               foundEntry.setBody(foundEntry.getBody()+ body);
               System.out.println(foundEntry.getBody());
               break;
           }
        }
    }

    public Entry getEntry(int id) {
        for (Entry entry:entries) {
            if (entry.getId() == id){
                return entry;
            }
        }
        return null;
    }

    public void lockDiary() {
       isLocked = true;
    }

    public void unlockDiary(String password) {
        validatePassword(password);
        isLocked = false;
    }

    private void validatePassword(String password) {
        if(!this.password.equals(password)) {
            throw new WrongPinException("Incorrect Password");
        }
    }

    public boolean isLocked() {
        return isLocked;
    }
}
