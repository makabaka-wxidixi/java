package IO;

import org.junit.Test;

import java.io.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-02 13:53
 * <p>
 * 其他流的使用
 * 1.标准的输入，输出流
 * 2.打印流
 * 3.数据流
 */
public class OtherStreamTest {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            //标准输入流
            InputStreamReader isr = new InputStreamReader(System.in);
            //转化为字符流
            br = new BufferedReader(isr);
            while (true) {
                System.out.println("请输入字符串");
                char c = (char) br.read();//数据未读完时，就会持续执行。当程序执行到这里时，如果没有数据，就会等待输入
                String s = String.valueOf(c);
                if ("exit".equalsIgnoreCase(s) || "e".equalsIgnoreCase(s)) {
                    System.out.println("程序结束");
                    break;
                }
                String s1 = s.toUpperCase();
                System.out.println(s1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void Test1(){
        PrintStream ps = null;
        try {
            //创建一结点输出字节流
            FileOutputStream fos = new FileOutputStream("E:\\javaproject\\JAVA\\day20\\打印流.txt");
            //造一个打印流
            ps = new PrintStream(fos);
            //更换打印地址
            System.setOut(ps);
            for(int i=0;i<256;i++){
                char c = (char) i;
                System.out.print(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //将磁盘中的数据读到内存中，度的过程必须按照写的过程读
    @Test
    public void Test2() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        String s = dis.readUTF();
        int i = dis.readInt();
        boolean b = dis.readBoolean();

        System.out.println("name="+s);
        System.out.println("age="+i);
        System.out.println("isMale="+b);
        dis.close();
    }
    //将数据读入磁盘中
    @Test
    public void Test3() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeUTF("亚索");
        dos.flush();//刷新操作，执行一次就会将数据读到磁盘中
        dos.writeInt(21);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();
        dos.close();
    }
}
