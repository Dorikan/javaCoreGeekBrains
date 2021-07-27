import java.util.Arrays;

public class SimpleAI {

    private static int winCondition;
    private static char enemyChar;
    private static char emptyChar;
    private static char botChar;

    public SimpleAI(int winCondition, char enemyChar, char emptyChar, char botChar){
        SimpleAI.winCondition = winCondition;
        SimpleAI.enemyChar = enemyChar;
        SimpleAI.emptyChar = emptyChar;
        SimpleAI.botChar = botChar;
    }

    public static int[] getTurn(char[][] map){
       int x;
       int y;

       int pos[] = new int[2];
       int counter=0;

       pos = checkHorizontal(map, enemyChar);

       if (pos[0]==-1 || pos[1]==-1){
           pos = checkVertical(map, enemyChar);
           if (pos[0]==-1 || pos[1]==-1){
               pos = checkDiagonal(map, enemyChar);
               if (pos[0]==-1 || pos[1]==-1){
                   pos = checkHorizontal(map, botChar);
                   if (pos[0]==-1 || pos[1]==-1){
                       pos = checkVertical(map, botChar);
                       if (pos[0]==-1 || pos[1]==-1){
                           pos = checkDiagonal(map, botChar);
                           if (pos[0]==-1 || pos[1]==-1) {
                               do {
                                   x =(int) (Math.random()*map.length-1);
                                   y =(int) (Math.random()*map.length-1);
                                   counter++;
                               }while (!cellIsEmpty(x, y, map) && counter<10);
                               if (counter==10){
                                   for (int i=0; i< map.length; i++){
                                       for (int v=0; v<map.length; v++){
                                           if(map[i][v] == emptyChar) {
                                               pos[0] = i;
                                               pos[1] = v;
                                           }
                                       }
                                   }
                               }
                               pos = new int[]{y, x};
                           }
                       }
                   }
               }
           }
       }
       return pos;
    }

    public static int[] checkVertical(char[][] map, char charToFind){
        char[] tempArr = new char[map.length];
        int[] pos = new int[2];
        int counter;

        for (int i=0; i<map.length; i++){
            counter=0;
            for (int z=0; z<map.length; z++) {
                tempArr[z] = map[z][i];
            }
            if (getDangerPosOnArr( counter, tempArr, pos, i, false, -1, charToFind)) return new int[] {pos[1], pos[0]}; //изначально функцию писал для горизонтали.
            // с таким костылем оно применимо и для вертикали, поэтому я к нему прибегнул.
        }
        return new int[] {-1, -1};
    }

    public static int[] checkDiagonal(char[][] map, char charToFind){
        char[] tempArr1 = new char[map.length];
        char[] tempArr2 = new char[map.length];
        char[] tempArr3 = new char[map.length];
        char[] tempArr4 = new char[map.length];
        int counter;
        int[] pos = new int[2];

        for (int i=0;i< map.length;i++){
            tempArr1[i]=map[i][i];
            tempArr2[i]=map[i][map.length-1-i]; // x=6-1
        }

        if (getDangerPosOnArr(0, tempArr1, pos, 0, true, 1, charToFind)) if(cellIsEmpty(pos[1], pos[0], map)) return pos;
        if (getDangerPosOnArr(0, tempArr2, pos, 0, true, 2, charToFind)) if(cellIsEmpty(pos[0], pos[1], map)) return new int[] {pos[1], pos[0]};
    // 6 1 4 3 2 5 1 6
        char[][] arrOfTempArr = new char[][]{tempArr1, tempArr2, tempArr3, tempArr4};

        if(winCondition<map.length){
            for (int i=1; i<=map.length-winCondition;i++){
                for (int x=0;x<map.length-i;x++){
                    arrOfTempArr[0][x]=map[x][x+i];
                    arrOfTempArr[1][x]=map[x+i][x];
                    arrOfTempArr[2][x]=map[x][map.length-i-x-1];
                    arrOfTempArr[3][x]=map[x+i][map.length-x-1];
                }
                for (int c=0; c<arrOfTempArr.length;c++){
                    counter=0;
                    for (char n : arrOfTempArr[c]){
                        if(n == charToFind) counter++;
                    }
                    if (counter>=winCondition-1 && getDangerPosOnArr(0, arrOfTempArr[c], pos, 0, true, 1, charToFind)) {
                        switch (c){
                            case 0: pos[0] = pos[1]+i; break;
                            case 1: pos[0] = pos[1]; pos[1] = pos[0]+i; break;
                            case 2: pos[0] = map.length-i-pos[1]-1;
                            case 3: pos[1]+=i; pos[0]=map.length-i-1-pos[1]; break;
                        }
                        System.out.println(Arrays.toString(pos));
                        counter = pos[0];
                        pos[0]=pos[1];
                        pos[1]=counter;
                        return pos;
                    }
                }
            }
        }

        return new int[]{-1,-1};
    }

    public static int[] checkHorizontal(char[][] map, char charToFind){
        int counter;
        char[] tempArr;
        int[] pos = new int[2];

        for(int i=0; i<map.length; i++){
            counter=0;
            tempArr = map[i];

            if (getDangerPosOnArr(counter, tempArr, pos, i, false, -1, charToFind)) return pos;
        }
        return new int[]{-1, -1};
    }

    private static boolean getDangerPosOnArr(int counter, char[] tempArr, int[] pos, int i, boolean diagonal, int diagn, char charToFind) {
        for (char x : tempArr){
            if (x == charToFind) counter++;
        }
        if(counter>=(winCondition-1)){
            //если условие победы равно размеру стороны квадрата,
            //то в строке будет всего одно место, куда можно поставить
            //0, чтобы не дать победу.
            //пример: [x, -, x], [x, x, -], [-, x, x]
            if(winCondition==tempArr.length){
                for (int x=0; x<tempArr.length;x++) {
                    if (tempArr[x] == emptyChar) {
                        pos[1] = x;
                        if(!diagonal)pos[0] = i;
                        else{
                            if(diagn==1) pos[0] = x;
                            else pos[0]=tempArr.length-1-x;
                        }
                        return true;
                    }
                }
                return false;
            }else{
                int counter2=0;
                int lastEmpty=-1;
                // [x,-,x,x,-]
                // [x, -, x, -, x, x]
                for (int cint=0; cint<tempArr.length ;cint++) {
                    counter2=0;

                    if (tempArr[cint] == charToFind && (tempArr.length-cint-winCondition)>0) {
                        for (int z = cint; z < winCondition+cint; z++) {
                            if (tempArr[z] == charToFind) counter2++;
                            else if(tempArr[z]==emptyChar) lastEmpty=z;
                        }
                        if (counter2==winCondition - 1){
                            pos[1]=lastEmpty;
                            if(!diagonal)pos[0] = i;
                            else{
                                if(diagn==1) pos[0] = lastEmpty;
                                else if (diagn==2) pos[0]=tempArr.length-1-lastEmpty;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean cellIsEmpty(int x, int y, char[][] map){
        if(x<0 || y<0) return false;
        return (map[y][x] == emptyChar);
    }

}
