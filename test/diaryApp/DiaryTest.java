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
        Diaries diaries = new Diaries();
        diaries.add(diary);
        assertEquals(1, diaries.count());
        Diary diary1 = new Diary("Dare", "423");
        diaries.add(diary1);
        assertEquals(2, diaries.count());
    }

    @Test
    public void testThatDiaryCanFindByUserNameTest(){
        diary = new Diary("Danny", "123");
        Diaries diaries = new Diaries();
        diaries.add(diary);
        assertEquals(1, diaries.count());
        Diary newUserName = diaries.findByUserName("Danny");
        assertEquals("Danny", newUserName.generateUserName());
    }

    @Test
    public void testThatDiaryCanDeleteTest(){
        diary = new Diary("Danny", "123");
        Diaries diaries = new Diaries();
        diaries.add(diary);
        assertEquals(1, diaries.count());
        Diary diary1 = new Diary("Dare", "423");
        diaries.add(diary1);
        assertEquals(2, diaries.count());
        diaries.delete("Danny");
        assertEquals(1, diaries.count());
    }

    @Test
    public void testThatEntryCanBeCreatedInDiaryTest(){
        Entry entry = new Entry(0, "My first day at school","I am boy");
        diary = new Diary("Danny", "123");
        diary.add(entry);
        assertEquals(1, diary.count());
    }
    @Test
    public void testThatEntryCanBeCreatedInDiaryTwiceTest(){
        Entry entry = new Entry(0, "My first day at school","I am boy");
        diary.add(entry);
        assertEquals(1, diary.count());

        entry = new Entry(1, "My second day at school","I am girl");
        diary.add(entry);
        assertEquals(2, diary.count());
    }

}