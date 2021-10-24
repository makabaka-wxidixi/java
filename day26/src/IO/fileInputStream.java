package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-23 16:28
 */
public class fileInputStream {
    public static void main(String[] args) {
        File file = new File("c:/Users/liu/Desktop/文章.txt");
        FileInputStream fileIn = null;
        int len = 0;
        byte[] read = new byte[1024];
        try {
            fileIn = new FileInputStream(file);
            while ((len = fileIn.read(read)) != -1) {
                System.out.print(new String(read, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
