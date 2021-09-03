package IO;

import org.junit.Test;

import java.io.*;
import java.net.http.WebSocket;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-03 16:24
 * <p>
 * 使用字节数组
 * 直接继承于object类，不继承于四大抽象基类，实现了DataInput和DataOutput两个接口
 * 即可以作为输入流，又可以作为输出流
 * r是只读
 * rw打开以便于读取和写入
 * rwd，打开以便读取和写入，同步文件内容的更新
 * rws,打开以便读取和写入，同步文件内容和元数据的更新
 * 写数据时，不会继续写，只会从原有文件上进行覆盖
 */
public class RandomAccessFileTest {

    @Test
    public void FileWriterTest() {
        FileWriter fw = null;
        try {
            File file = new File("测试.txt");
            fw = new FileWriter(file);
            fw.write("我是你爸爸真伟大，养你这么大");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw == null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void Test1() {
        RandomAccessFile r = null;
        RandomAccessFile rw = null;
        try {
            r = new RandomAccessFile(new File("测试.txt"), "r");
            rw = new RandomAccessFile(new File("测试1.txt"), "rw");

            byte[] arr = new byte[1024];
            int len;
            while ((len = r.read(arr)) != -1) {
                rw.write(arr, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (r == null) {
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (rw == null) {
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void copy() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("测试.txt"));
            bw = new BufferedWriter(new FileWriter("测试2.txt"));
            int len;
            char[] arr = new char[1024];
            while ((len = br.read(arr)) != -1) {
                bw.write(arr, 0, len);
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br == null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw == null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @Test
    public void insert() {
        RandomAccessFile rw = null;
        try {
            rw = new RandomAccessFile("测试1.txt", "rw");//这里要注意
            StringBuilder sb = new StringBuilder((int)new File("测试1.txt").length());

            rw.seek(3);//将指针下标移动到下标为3的位置
            byte[] arr=new byte[20];
            int len;
            while((len=rw.read(arr))!=-1){
                sb.append(new String(arr, 0, len));
            }
            //此时指针指向的是最后一个位置
            rw.seek(3);
            rw.write("ads".getBytes());
            rw.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(rw==null){
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
