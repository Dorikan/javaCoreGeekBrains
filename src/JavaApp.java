import java.util.*;

public class JavaApp {
    public static void main(String[] args){
        first();
    }


    public static void first(){
        List<String> words = Arrays.asList(
                "Mercedes", "BMW", "Audi", "Toyota", "Volkswagen",
                "Opel", "Subaru", "Range Rover", "Toyota", "Volkswagen",
                "BMW", "Audi", "Toyota", "Subaru", "Subaru",
                "Audi", "Toyota", "Subaru", "Subaru", "Toyota"
        );

        Set<String> unique = new HashSet<String>(words);
        System.out.println("Уникальные слова");
        for(String i : unique){
            System.out.printf("%s ", i);
        }
        System.out.println();
        System.out.println("Частота встречаемости слов");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    }
}
