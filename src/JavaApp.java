public class JavaApp {
    public static void main(String[] args) {
        Cat[] catArr = new Cat[5];
        Plate plate = new Plate(0);

        for(int i=0;i<5;i++){
            catArr[i] = new Cat("cat"+(i+1), (int)(Math.random()*20)+10);
        }
        for (Cat cat : catArr){
            cat.eat(plate);
        }
        for (Cat cat : catArr){
            if (cat.getHunger()) System.out.printf("%s не голоден\n", cat.getName());
            else System.out.printf("%s голоден\n", cat.getName());
        }
    }
}
