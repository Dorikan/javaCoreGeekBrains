import java.util.Arrays;

public class JavaApp {


    public static void main(String[] args){
        secondMethod();
    }

    private static void firstMethod(){
        int SIZE = 10000000;
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.printf("Затраченное время: %f секунд.\n", (float)(System.currentTimeMillis()-a)/1000);
    }

    private static float[] calculate(float[] arr) {
        for (int i = 0; i< arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        return arr;
    }

    private static void secondMethod() {
        int SIZE = 10000000;
        int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        new Thread() {
            public void run() {
                float[] a1 = calculate(arr1);
                System.arraycopy(a1, 0, arr1, 0, a1.length);
            }
        }.start();

        new Thread() {
            public void run() {
                float[] a2 = calculate(arr2);
                System.arraycopy(a2, 0, arr2, 0, a2.length);
            }
        }.start();

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        System.out.println((System.currentTimeMillis() - a));
    }
}
