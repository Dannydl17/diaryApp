package diaryApp;

import exception.InvalidUserName;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private List<Diary> diaries = new ArrayList<>();
    private int size;
    public void add(Diary diary) {
//        Diary diary = new Diary(name,passW);
        diaries.add(diary);
    }

    private String generateUserName(String userName) {
        return userName;
    }
    private String generatePassWord(String password) {
        return password;
    }

    public int count() {
        return diaries.size();
    }

    public Diary findByUserName(String userName) {
        for(Diary diary: diaries){
            if(diary.generateUserName().equals(userName)){
                return diary;
            }
        }
        throw new InvalidUserName("UserName not found");
    }

    public void delete(String userName) {
         Diary diary = findByUserName(userName);
         diaries.remove(diary);
    }
}
