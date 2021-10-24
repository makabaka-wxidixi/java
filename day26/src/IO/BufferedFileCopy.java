package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-24 17:49
 */
public class BufferedFileCopy {
    public static void main(String[] args) {
        String srcPath = "c:/Users/liu/Desktop/英雄简介.txt";
        String destPath = "c:/Users/liu/Desktop/英雄说明.txt";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(srcPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destPath))) {
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test() {
        String srcPath = "c:/Users/liu/Desktop/文章.txt";
        String descPath = "c:/Users/liu/Desktop/文章拷贝.txt";
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcPath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(descPath))) {
            int readLen = 0;
            byte[] read = new byte[1024];//当是1024时，是不会出现乱码，因为一个字节为一组
            while ((readLen = bis.read(read)) != -1) {
                bos.write(read, 0, readLen);
                System.out.println(new String(read, 0, readLen));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
