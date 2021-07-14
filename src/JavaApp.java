public class JavaApp {

    private final int abstractVariableInteger = 1;
    private final float abstractVariableFloat = 3.14f;
    private final String abstractVariableString = "string";
    private final boolean abstractVariableBoolean = false;


    public static void main(String[] args) {
        System.out.println(first(5, 7, 6, 2));
        System.out.println(second(11, 10));
        third(-1);
        System.out.println(fourth(1));
        fifth("Майк");
        System.out.println(last(2004));
    }

    private static float first(float a, float b, float c, float d){
        return a * (b + (c / d));
    }
    private static boolean second(int a, int b){
        return (a + b) >= 10 && (a + b) <= 20;
    }
    private static void third(int a){
        if(a<0){
            System.out.println("отрицательное");
        }else {
            System.out.println("положительное");
        }
    }
    private static boolean fourth(int a){
        return a<0;
    }
    private static void fifth(String name){
        System.out.printf("привет, %s.\n", name);
    }
    private static boolean last(int year){
        if(year%4==0){
            if(year%100==0){
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }


}
