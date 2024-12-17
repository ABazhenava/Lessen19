package by.itacademy.lessen21.notepad;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NoteBook {

    private List<Note> notes;

    public NoteBook(List<Note> notes) {
        this.notes = notes;
    }

    public NoteBook() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> findNotesByContent(String searchText) {
        List<Note> result = new ArrayList<>();
        for (Note note : notes) {
            if (note.getContent().contains(searchText)) {
                result.add(note);
            }
        }
        return result;
    }

    public List<Note> findNotesByDate(LocalDateTime date) {
        List<Note> result = new ArrayList<>();
        for (Note note : notes) {
            if (note.getCreateDate().toLocalDate().equals(date.toLocalDate())) {
                result.add(note);
            }
        }
        return result;
    }

    public void displayAllNotes() {
        for (Note note : notes) {
            note.displayNote();
            System.out.println();
        }
    }
}
