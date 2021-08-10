import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

public class JavaApp {
    public static void main(String[] args) throws IOException {
        System.out.println(createDirArr());
    }

    public static boolean createDirArr() throws IOException {
        File dir;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("введите путь к папке");
            dir = new File(scanner.nextLine());
        }while(!dir.exists());

        File[] listFile = dir.listFiles();
        assert listFile != null;
        String[] listPaths = new String[listFile.length];

        for(int i=0; i<listFile.length; i++){
            if(listFile[i].getName().endsWith(".txt"))listPaths[i] = listFile[i].getPath();
        }
        StringBuilder s = new StringBuilder();
        for (String path : listPaths) {
            if (path != null) {
                s.append(new String(Files.readAllBytes(Paths.get(path))));
                s.append(" ");
            }
        }
        System.out.println("введите слово для поиска");
        return s.toString().toLowerCase(Locale.ROOT).contains(scanner.nextLine().toLowerCase(Locale.ROOT));
    }
}
