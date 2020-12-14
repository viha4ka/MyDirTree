import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите путь до директории, чтобы увидеть ее содержимое");
        var path = new Scanner(System.in).next();
        var sb = new StringBuilder();
        try {
            GetDirectoryTree(path, 0, sb);
        } catch (NullPointerException e) {
            System.out.println("Нет такой директории");
        }

        System.out.println(sb);
    }

    public static void GetDirectoryTree(String path, int indentCount, StringBuilder sb) throws NullPointerException {
        var files = new File(path).listFiles();

        for (var file : files) {
            for (var i =0 ; i< indentCount; i++)
                sb.append("-");

            sb.append(file.getName()).append("\n");
            if (file.isDirectory()) {
                GetDirectoryTree(file.getAbsolutePath(), indentCount + 1, sb);
            }
        }
    }
}
