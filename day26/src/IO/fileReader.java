package IO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-24 14:53
 */
public class fileReader {
    public static void main(String[] args) {
        String filePath = "c:/Users/liu/Desktop/英雄简介.txt";
        File file = new File(filePath);
        int read = 0;
        try (FileReader fileRead = new FileReader(file)) {
            while ((read = fileRead.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test1() {
        String filePath = "c:/Users/liu/Desktop/英雄简介.txt";
        char[] readArr = new char[8];
        int arrLen = 0;
        try (FileReader fileRead = new FileReader(filePath)) {
            while ((arrLen = fileRead.read(readArr)) != -1) {
                System.out.print(new String(readArr, 0, arrLen));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
