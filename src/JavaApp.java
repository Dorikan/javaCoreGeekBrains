import java.util.Scanner;

public class JavaApp {

    public static void main(String[] args){
        second();
    }

    private static void first(){
        int userAnswer;

        Scanner scanner = new Scanner(System.in);
        do{
            int num = (int) (Math.random()*9);
            do {
                userAnswer = scanner.nextInt();
                if(userAnswer>num){
                    System.out.println("загаданное число меньше");
                }else if(userAnswer<num){
                    System.out.println("загаданное число большн");
                }
            }while (userAnswer!=num);
            System.out.printf("да, это %d.\n", num);
            do{
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                userAnswer=scanner.nextInt();
            }
            while (userAnswer!=1 || userAnswer!=0);
        }while(userAnswer==1);
    }
    private static void second(){
        Scanner scanner = new Scanner(System.in);

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int wordPos = (int) (Math.random() * 24);
        String word = words[wordPos];

        String userAnswer="";
        String[] line = {"#","#","#","#","#","#","#","#","#","#","#","#","#","#","#",};

        do{
            for(int i=0;i<userAnswer.length() && i<word.length();i++){
                if(userAnswer.charAt(i)==word.charAt(i)){
                   line[i]=Character.toString(userAnswer.charAt(i));
                }
            }
            System.out.print("слово сейчас: ");
            for(String i : line){
                System.out.print(i);
            }
            System.out.println("\nВведите слово:");
            userAnswer = scanner.nextLine();
        }while(!userAnswer.equals(word));
        System.out.println("вы угадали слово.");
    }
}
