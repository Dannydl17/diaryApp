package diaryApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("Danny", newUserName.getUserName());
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
    @Test
    public void testThatEntryCanFindEntryTest(){
        Entry entry = new Entry(0, "My first day at school","I am boy");
        diary.add(entry);
        assertEquals(1, diary.count());

        entry = new Entry(1, "My second day at school","I am girl");
        diary.add(entry);
        assertEquals(2, diary.count());

        Entry newEntry = diary.findEntry(entry.getId());
        assertEquals(1, newEntry.getId());
    }

    @Test
    public void testThatEntryCanBeDeletedOnceTest(){
        Entry entry = new Entry(0, "My first day at school","I am boy");
        diary.add(entry);
        assertEquals(1, diary.count());

        entry = new Entry(1, "My second day at school","I am girl");
        diary.add(entry);
        assertEquals(2, diary.count());
        diary.delete(entry.getId());
        assertEquals(1, diary.count());
    }

    @Test
    public void testThatEntryCanBeUpdatedTest(){
        Entry entry = new Entry(0, "My first day at school","I am boy");
        diary.add(entry);
        assertEquals(1, diary.count());
        diary.updateEntry(0," and i am going home");
        assertEquals("I am boy and i am going home", diary.getEntry(0).getBody());
    }

    @Test
    public void testThatDiaryCanBeLockedTest(){
        diary = new Diary("Danny", "1234");
        Diaries diaries = new Diaries();
        diaries.add(diary);
        assertEquals(1, diaries.count());
        Diary newUserName = diaries.findByUserName("Danny");
        assertEquals("Danny", newUserName.getUserName());
        diary.lockDiary();
        diary.unlockDiary("1234");
        assertFalse(diary.isLocked());
    }

    @Test
    public void test_That_Diary_Can_lock_Diary_Test(){
        diary = new Diary("Danny", "1234");
        Diaries diaries = new Diaries();
        diaries.add(diary);
        assertEquals(1, diaries.count());
        Diary newUserName = diaries.findByUserName("Danny");
        assertEquals("Danny", newUserName.getUserName());

        diary.lockDiary();
        assertTrue(diary.isLocked());
    }
}