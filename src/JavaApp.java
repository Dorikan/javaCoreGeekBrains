

public class JavaApp {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        System.out.println(first(new String[4][4]));
    }

    private static int first(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int temp=0;

        if (arr.length!=4)throw new MyArraySizeException("Длина массива должна быть равна 4.");

        for (int i=0;i<4;i++){
            if (arr[i].length!=4)throw new MyArraySizeException("Длина массива должна быть равна 4.");
            for (int z=0; z<4;z++){
                try {
                    temp+=Integer.parseInt(arr[i][z]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Невозможно сделать строку числом.\nошибка в ячейке "+(i+1)+"-"+(z+1));
                }
            }
        }
        return temp;
    }
}
