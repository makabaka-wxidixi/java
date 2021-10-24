package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-23 17:57
 */
public class fileCopy {
    public static void main(String[] args) {
//        FileInputStream fileInputStream = null;
//        FileOutputStream fileOutputStream = null;
        byte[] readByte = new byte[1024];
        int readLen = 0;
        try (FileInputStream fileInputStream = new FileInputStream("c:/Users/liu/Desktop/神龙尊者.jpg");
             FileOutputStream fileOutputStream = new FileOutputStream("c:/Users/liu/Desktop/冒牌神龙.jpg");) {
            while ((readLen = fileInputStream.read(readByte)) != -1) {
                fileOutputStream.write(readByte, 0, readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
