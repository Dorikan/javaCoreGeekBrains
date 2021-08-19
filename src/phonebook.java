import java.util.*;

public class phonebook {
    private static HashMap<String, List<String>> book = new HashMap<String, List<String>>();

    public static void add(String surname, String number){
        if(book.containsKey(surname)){
            List<String> numbers = book.get(surname);
            if(!numbers.contains(number)){
                numbers.add(number);
                book.remove(surname);
                book.put(surname, numbers);
                System.out.printf("Номер %s добавлен для фамилии %s%n", number, surname);
            } else {
                System.out.printf("Номер %s уже существует для фамилии %s%n", number, surname);
            }
        } else {
            book.put(surname, new ArrayList<>(Collections.singletonList(number)));
            System.out.printf("Номер %s добавлен для фамилии %s%n", number, surname);
        }
    }
    public List<String> get(String surname){
        if(book.containsKey(surname)){
            return book.get(surname);
        } else {
            System.out.printf("В справочнике нет записи для фамилии %s%n", surname);
            return new ArrayList<>();
        }
    }
}
