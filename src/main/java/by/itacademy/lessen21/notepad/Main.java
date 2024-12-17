package by.itacademy.lessen21.notepad;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NoteBookProvider provider = NoteBookProvider.getInstance();
        NoteBook noteBook = provider.getNoteBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить запись в блокнот");
            System.out.println("2. Найти записи в блокноте по содержимому");
            System.out.println("3. Найти записи в блокноте по дате создания");
            System.out.println("4. Показать все записи в блокноте");
            System.out.println("5. Выход");
            System.out.print("Выберите пункт от 1 до 5: ");
            int enterValue = scanner.nextInt();
            scanner.nextLine();

            switch (enterValue) {
                case 1:
                    System.out.print("Введите запись: ");
                    String content = scanner.nextLine();
                    noteBook.addNote(new Note(content));
                    System.out.println("Запись в блокнот добавлена.");
                    break;
                case 2:
                    System.out.print("Введите текст для поиска: ");
                    String searchText = scanner.nextLine();
                    List<Note> foundNotesByContent = noteBook.findNotesByContent(searchText);
                    if (foundNotesByContent.isEmpty()) {
                        System.out.println("Внимание!!! Вы НЕ ввели текст!!!");
                    } else {
                        for (Note note : foundNotesByContent) {
                            note.displayNote();
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Введите дату создания записи для поиска (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();
                    LocalDateTime searchDate = LocalDateTime.parse(dateStr + "T00:00:00");
                    List<Note> foundNotesByDate;
                    foundNotesByDate = noteBook.findNotesByDate(searchDate);
                    if (foundNotesByDate.isEmpty()) {
                        System.out.println("Внимание!!! Вы не ввели дату!!!");
                    } else {
                        for (Note note : foundNotesByDate) {
                            note.displayNote();
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    noteBook.displayAllNotes();
                    break;
                case 5:
                    System.out.println("Выход.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nВы ввели неправильное значение!!!! Попробуйте еще раз.");
            }
        }
    }
}
