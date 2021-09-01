package IO;

import org.junit.Test;

import java.io.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-01 7:50
 */

//.txt,.java,.C,.Cpp
public class FileReaderWriterTest {//用于处理文本
    /*
    1.read()的理解：读取一个一个字符，返回的是int值，返回-1时读取文件结束
    2.异常处理：为保证流资源一定可以执行关闭操作，需要使用try/catch/finally来处理异常
    3.读入的文件一定要存在，否则就会报FileNotFoundException。
     */
    @Test
    public void Test1() {
        FileReader fileReader = null;
        try {
            //实例化File类的对象，指明要操作的对象
            File file = new File("hello.txt");
            //提供具体的流
            fileReader = new FileReader(file);
            //数据的读入
            int data = fileReader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //调用read的重载方法（升级）
    @Test
    public void Test2() throws FileNotFoundException {
        FileReader fr = null;
        try {
            //1.File的实例化（要操作的对象的创建）
            File file = new File("hello.txt");
            //2.FileReader的实例化（流的创建）
            fr = new FileReader(file);
            //3.读入操作
            char[] readBuffer = new char[5];
            int len;
            while ((len = fr.read(readBuffer)) != -1) {//返回的是读取数据的个数
                //方式一：
                for (int i = 0; i < len; i++) {
                    System.out.print(readBuffer[i]);
                }

                //方式二：
                String s = new String(readBuffer, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void Test3() {
        FileWriter fw = null;
        try {
            //创建文件对象
            File file = new File("hello1.txt");
            //创建流
            fw = new FileWriter(file);
            //输入操作
            fw.write("hello java\n");
            fw.write("byebye C++\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //通过输入输出流实现文件的copy操作
    @Test
    public void fileCopy() {
        //创建操作对象
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File src = new File("hello1.txt");
            File dest = new File("hello2.txt");
            //创建流
            fr = new FileReader(src);
            fw = new FileWriter(dest);
            //操作流
            char[] arr = new char[5];
            int len;//返回的是读取的字符个数
            while ((len = fr.read(arr)) != -1) {
                fw.write(new String(arr), 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
