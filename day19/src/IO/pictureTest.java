package IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-01 14:50
 */
public class pictureTest {
    @Test
    public void Test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //流
            fis = new FileInputStream("集合.jpg");
            fos = new FileOutputStream("集合secret.jpg");
            //操作流
            byte[] arr = new byte[20];
            int len;
            while (((len = fis.read(arr)) != -1)) {
                for (int i = 0; i < len; i++) {
                    arr[i] = (byte) (arr[i] ^ 5);
                }
                fos.write(arr, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void Test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //流
            fis = new FileInputStream("集合secret.jpg");
            fos = new FileOutputStream("集合2.jpg");
            //操作流
            byte[] arr = new byte[20];
            int len;
            while (((len = fis.read(arr)) != -1)) {
                for (int i = 0; i < len; i++) {
                    arr[i] = (byte) (arr[i] ^ 5);
                }
                fos.write(arr, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
