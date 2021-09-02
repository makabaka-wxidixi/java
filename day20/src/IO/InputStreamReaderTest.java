package IO;

import org.junit.Test;

import java.io.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-01 22:14
 * <p>
 * 处理流二：转换流的使用
 * 1.处理流：属于字符流
 * InputStreamReader：将输入的字节流转化成字符流
 * OutputStreamWriter：将输出的字符流转化为字节流
 * 2.作用：提供字节流和字符流之间的转换
 * 3.编码：将字符转化成字节
 * 解码：将字节转化成字符
 */
public class InputStreamReaderTest {
    @Test
    public void Test1() throws IOException {
        BufferedInputStream br = new BufferedInputStream(new FileInputStream("文章.txt"));
        byte[] arr = new byte[100];
        int len;
        while ((len = br.read(arr)) != -1) {
            String s = new String(arr, 0, len);
            System.out.println(s);
        }
        br.close();
    }

    @Test
    public void Test2() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("文章.txt")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("文章(copy).txt")));
            int len;
            byte[] arr = new byte[1024];
            while ((len = bis.read(arr)) != -1) {
                bos.write(arr, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

    @Test
    public void Test3() {
        FileInputStream bis = null;//字节流
        InputStreamReader isr = null;
//        BufferedOutputStream bos = null;
        try {
            bis = new FileInputStream("文章.txt");
//            bos = new BufferedOutputStream(new FileOutputStream("文章(copy2).txt"));
            isr = new InputStreamReader(bis);//这里默认就是UTF-8，isr中的read参数只能是char形
            int len;
            char[] arr = new char[10];
            while ((len = isr.read(arr)) != -1) {
                String s = new String(arr, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            if(bos!=null) {
//                try {
//                    bos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    @Test
    public void Test4() {
        //造流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("文章.txt"));
            bos = new BufferedOutputStream(new FileOutputStream("文章(copy3).txt"));
            isr = new InputStreamReader(bis);
            osw = new OutputStreamWriter(bos, "gbk");
            //操作流
            int len;
            char[] arr = new char[20];
//            byte[] arr = new byte[20];
            while ((len = isr.read(arr)) != -1) {
                String s = new String(arr, 0, len);
                System.out.println(s);
                osw.write(arr, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
