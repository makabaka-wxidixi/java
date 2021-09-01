package IO;

import org.junit.Test;

import java.io.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-01 13:14
 */
public class BufferedTest {
    @Test
    public void Test1() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //造对象
            File src = new File("集合.jpg");
            File dest = new File("集合1.jpg");
            //造流
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //操作流
            byte[] arr = new byte[1024];
            int len;
            while ((len = bis.read(arr)) != -1) {
                bos.write(arr, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放流
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void copy(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //造对象
            File src = new File(srcPath);
            File dest = new File(destPath);
            //造流
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //操作流
            byte[] arr = new byte[1024];
            int len;
            while ((len = bis.read(arr)) != -1) {
                bos.write(arr, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放流
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
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

    @Test
    public void Test() {
        long start = System.currentTimeMillis();

        String srcPath="E:\\javaproject\\JAVA\\day19\\集合.jpg";
        String destPath="E:\\javaproject\\JAVA\\day19\\集合(copy2).jpg";

        copy(srcPath,destPath);
        long end = System.currentTimeMillis();//用缓冲流的是10，不用是229，缓冲流有加快文件传输的作用
        System.out.println((end - start));
    }

}
