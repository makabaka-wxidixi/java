package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-23 17:30
 */
public class fileOutputStream {
    public static void main(String[] args) {
        String path = "e:/File.txt";
        FileOutputStream fileOutput = null;
        String target="i am your father";
        try {
            fileOutput = new FileOutputStream(path,true);
            fileOutput.write(target.getBytes(),1,3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
