package diaryApp;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Entry {
    private int id;
    private String title;
    private String body;
    private LocalDateTime date = LocalDate.now().atStartOfDay();


    public Entry(int id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = LocalDate.now().atStartOfDay();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
