package by.itacademy.lessen21.notepad;

import java.time.LocalDateTime;
import java.util.Objects;

public class Note {
    private String content;
    private LocalDateTime createDate;
    public Note() {};

    public Note(String content) {
        this.content = content;
        this.createDate = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void displayNote() {
        System.out.println("Date: " + createDate);
        System.out.println("Content: " + content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(content, note.content) && Objects.equals(createDate, note.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, createDate);
    }

    @Override
    public String toString() {
        return "Note{" +
                "content='" + content + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
