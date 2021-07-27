import java.util.Arrays;
import java.util.Scanner;

public class JavaApp {

    private static Scanner scanner;

    private static char[][] map;
    public static final int SIZE = 3;
    public static final int WIN_COND = 3;

    public static final char EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void main(String[] args){
        scanner = new Scanner(System.in);
        SimpleAI ai = new SimpleAI(WIN_COND, DOT_X, EMPTY, DOT_O);
        initMap();
        do{
            userTurn();
            showMap();
            if(checkHorizontal(DOT_X)==1 || checkVertical(DOT_X)==1 || checkDiagonal(DOT_X)==1) {
                System.out.println("Вы выиграли");
                break;
            }
            if(isNotADraw()){
                int[] pos = ai.getTurn(map);
                map[pos[0]][pos[1]]=DOT_O;
                showMap();
                if(checkHorizontal(DOT_O)==0 || checkVertical(DOT_O)==0 || checkDiagonal(DOT_O)==0) {
                    System.out.println("Вы проиграли");
                    break;
                }
            }
        }while (isNotADraw());
    }

    private static void initMap(){
        map = new char[SIZE][SIZE];

        for(int i=0;i<SIZE;i++){
            for (int x=0;x<SIZE;x++){
                map[i][x]=EMPTY;
            }
        }
        showMap();
    }

    private static void showMap(){
        for (char[] i : map){
            for (char x : i){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }

    private static void userTurn(){
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!cellIsEmpty(x, y));
        map[y][x] = DOT_X;
    }

    private static boolean cellIsEmpty(int x, int y){
        if(x<0 || y<0) return false;
        return (map[y][x] == EMPTY) && (x<SIZE && y<SIZE);
    }



    private static int checkHorizontal(char charToCheck){
        int counter;

        for (char[] i : map) {
            counter=0;
            for (char x : i) {
                if (x == charToCheck) counter++;
            }
            if (counter >= (WIN_COND)) {
                if (checkArr(charToCheck, i)!=-2) return checkArr(charToCheck, i);
            }
        }
        return -1;
    }

    private static int checkVertical(char charToCheck) {
        int counter;
        char[] tempArr = new char[map.length];

        for (int i = 0; i < map.length; i++) {
            counter = 0;
            for (int z = 0; z < map.length; z++) {
                tempArr[z] = map[z][i];
            }
            for (char x : tempArr) {
                if (x == charToCheck) counter++;
            }
            if (counter >= (WIN_COND)) {
                if (checkArr(charToCheck, tempArr)!=-2) return checkArr(charToCheck, tempArr);
            }
        }
        return -1;
    }

    private static int checkDiagonal(char charToCheck){
        char[] tempArr1 = new char[map.length];
        char[] tempArr2 = new char[map.length];
        char[] tempArr3 = new char[map.length];
        char[] tempArr4 = new char[map.length];
        int counter = 0;


        for (int i=0;i< map.length;i++){
            tempArr1[i]=map[i][i];
            tempArr2[i]=map[i][map.length-1-i]; // x=6-1
        }
        for (char i : tempArr1){if (i==charToCheck) counter++;}
        if (checkArr(charToCheck, tempArr1)!=-2 && counter>= map.length) return checkArr(charToCheck, tempArr1);
        counter = 0;
        for (char i : tempArr2){if (i==charToCheck) counter++;}
        if (checkArr(charToCheck, tempArr2)!=-2 && counter>= map.length) return checkArr(charToCheck, tempArr2);

        char[][] arrOfTempArr = new char[][]{tempArr1, tempArr2, tempArr3, tempArr4};

        if(WIN_COND<SIZE){
            for (int i=1; i<=SIZE-WIN_COND;i++){
                for (int x=0;x<map.length-i;x++){
                    arrOfTempArr[0][x]=map[x][x+i];
                    arrOfTempArr[1][x]=map[x+i][x];
                    arrOfTempArr[2][x]=map[x][map.length-i-x-1];
                    arrOfTempArr[3][x]=map[x+i][map.length-x-1];
                }
                for (char[] c : arrOfTempArr){
                    counter=0;
                    for (char n : c){
                        if(n == charToCheck) counter++;
                    }
                    if (checkArr(charToCheck, c)!=-2)
                        return checkArr(charToCheck, c);
                }
            }
        }

        return -1;
    }

    private static int checkArr(char charToCheck, char[] i) {
        int counter2;
        if (WIN_COND==SIZE){
            return (charToCheck ==DOT_X) ? 1 : 0;
        }
        else{
            for(int x = 0; x< map.length; x++){
                counter2=0;
                if (i[x]== charToCheck && (i.length-x-WIN_COND)>0){
                    for (int z=x;(z<WIN_COND+x) ;z++){
                        if(i[z]== charToCheck) counter2++;
                        if (counter2==WIN_COND) return (charToCheck ==DOT_X) ? 1 : 0;
                    }
                }
            }
        }
        return -2;
    }
    private static boolean isNotADraw(){
        for(char[] i : map){
            for(char x : i){
                if (x==EMPTY) return true;
            }
        }
        return false;
    }
}
