package by.itacademy.lessen21.notepad;

public class NoteBookProvider {
    private static NoteBookProvider instance;
    private NoteBook noteBook;

    private NoteBookProvider() {
        noteBook = new NoteBook();
    }

    public static NoteBookProvider getInstance() {
        if (instance == null) {
            instance = new NoteBookProvider();
        }
        return instance;
    }

    public NoteBook getNoteBook() {
        return noteBook;
    }
}
