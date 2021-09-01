package IO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-01 10:15
 */
//.jpg,.mp3,.pm4,.avi,.doc,.ppt
public class fileInputFIleOutStreamTest {//用于处理视频和图片

    //用于处理文本文件是可能出现乱码
    @Test
    public void Test1() {
        FileInputStream fis = null;
        try {
            //造文件
            File file = new File("hello.txt");
            //造流
            fis = new FileInputStream(file);
            //操作流
            byte[] arr = new byte[5];
            int len;
            while ((len = fis.read(arr)) != -1) {
                String s = new String(arr, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    //实现对图片的复制
    public void Test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建文件
            File src = new File("集合.jpg");
            File dest = new File("集合(copy).jpg");
            //造流
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            //操作流
            byte[] arr=new byte[5];
            int len;
            while((len=fis.read(arr))!=-1){
                fos.write(arr,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        //关闭流
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void copy1(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建文件
            File src = new File(srcPath);
            File dest = new File(destPath);
            //造流
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            //操作流
            byte[] arr=new byte[5];
            int len;
            while((len=fis.read(arr))!=-1){
                fos.write(arr,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
