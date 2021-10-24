package IO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-23 12:49
 */
public class file_create {

    @Test
    public void create1() {
        String filePath = "e:/directory";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create2() {
        String parentPath = "e:/";
        String fileName = "directory2";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {

        }
    }

    @Test
    public void create3() {
        File file = new File("e:/");
        String fileName = "directory";
        File file1 = new File(file, fileName);
        try {
            file1.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
