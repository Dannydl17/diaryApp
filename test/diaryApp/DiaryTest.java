package diaryApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiaryTest {
    private Diary diary;

    @BeforeEach
    public void setUp(){
        diary = new Diary("Danny", "123");
    }

    @Test
    public void testThatDiaryCanHaveANameAndPasswordTest(){
        diary = new Diary("Danny", "123");
        diary = new Diary(diary.getUserName(), diary.getPassword());
        Diaries diaries = new Diaries();
        diaries.add(diary.getUserName(), diary.getPassword());
        assertEquals(1, diaries.count());
    }

    @Test
    public void testThatDiaryCanFindByUserNameTest(){
        diary = new Diary("Danny", "123");
        diary = new Diary(diary.getUserName(), diary.getPassword());
        Diaries diaries = new Diaries();
        diaries.add(diary.getUserName(), diary.getPassword());
        assertEquals(1, diaries.count());
        Diary newUserName = diaries.findByUserName("Danny");
        assertEquals("Danny", newUserName.generateUserName());
    }

    @Test
    public void testThatDiaryCanDeleteTest(){
        diary = new Diary("Danny", "123");
        diary = new Diary(diary.getUserName(), diary.getPassword());
        Diaries diaries = new Diaries();
        diaries.add(diary.getUserName(), diary.getPassword());
        assertEquals(1, diaries.count());
        diaries.delete("Danny");
        assertEquals("Danny", newUserName.generateUserName());
    }

}