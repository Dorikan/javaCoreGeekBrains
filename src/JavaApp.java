public class JavaApp {

    public static void main(String[] args){
        int[] x = seventh(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 12);
        for (int i : x) {
            System.out.println(i);
        }
    }

    private static int[] first(){
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for(int i=0; i<array.length; i++){
            switch (array[i]) {
                case 0 -> array[i] = 1;
                case 1 -> array[i] = 0;
            }
        }
        return array;
    }
    private static int[] second(){
        int[] array = new int[8];
        for(int i = 0; i<8; i++){
            array[i]=i*3;
        }
        return array;
    }
    private static int[] third(){
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i = 0; i<array.length; i++){
            if(array[i]<6){
                array[i] = array[i]*2;
            }
        }
        return array;
    }
    private static int[][] fourth(){
        int[][] array = new int[4][4];
        for(int i = 0; i < array.length; i++){
            array[i] = new int[4];
        }
        for(int i=0;i<4;i++){
            array[i][i]=1;
            array[i][3-i]=1;
        }
        return array;
    }
    private static void fifth(){
        int[] array = {0, 1, 2, 3, 8, -2};
        int max = array[0];
        int min = array[0];
        for (int i : array) {
            if (min > i) {
                min = i;
            }
            if (max < i) {
                max = i;
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
    private static boolean sixth(int[] array){
        int sum=0;

        for (int i : array) {
            sum += i;
        }
        if(sum%2!=0){
            return false; /*если массив можно разбить на 2 равные части любым способом,
            значит сумма двух этих частей равна x+x, где х -- суммы с каждой из двух сторон.
            таким образом, массив можно разбить на две части тогда и только тогда, когда сумма всех его частей равна 2х.
            */
        }
        sum/=2; // обращаясь к прошлому комментарию, получаем х.
        int count = 0;

        for(int i=0; count<sum;i++){
            count+=array[i]; // из цикла выйдем если набранная сумма >= x
        }

        return count==sum; //если равна, то такая возможность есть.
    }

    public static int[] seventh(int[] incomingArray, int shift) {
        if(shift != 0){ //не указано, что мы имеем ненулевые параметры, поэтому обрабатываем значение 0.

            while(shift>incomingArray.length){
                shift-= incomingArray.length; //в этом цикле обрабатываются значения больше длины массива.
            }

            if (shift > 0) { //изначально я пытался двигать число за числом, но в итоге понял, что
                // легче будет двигать циклично, весь массив. если двигать весь массив, то
                // shift<0 и shift>0 стоит обрабатывать отдельно.
                for (int i = 0; i < shift; i++) {
                    int tempVar = incomingArray[0]; // сохраняем значение, которое заменим, чтобы передвинуть его после.
                    incomingArray[0] = incomingArray[incomingArray.length - 1]; //заменяем первый элемент на последний.
                    for (int n = 1; n < incomingArray.length - 1; n++) {
                        incomingArray[incomingArray.length - n] = incomingArray[incomingArray.length - n - 1]; // движение массива.
                    }
                    incomingArray[1] = tempVar;// элемент, сохраненный в начале цикла, вставляем на 1 позицию.
                }
            }
            else if (shift < 0) {
                for (int i = 0; i > shift; i--) {// в целом, логика такая же, как и в прошлом if.
                    int tempVar = incomingArray[incomingArray.length - 1];
                    incomingArray[incomingArray.length - 1] = incomingArray[0];
                    for (int n = 1; n < incomingArray.length - 1; n++) {
                        incomingArray[n - 1] = incomingArray[n];
                    }
                    incomingArray[incomingArray.length - 2] = tempVar;
                }
            }
        }

        return incomingArray;
    }
}
