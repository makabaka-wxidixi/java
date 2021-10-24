package IO;

import java.io.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-24 16:54
 */
public class BufferReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "c:/Users/liu/Desktop/文章.txt";
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
