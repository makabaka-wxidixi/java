package IO;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-04 10:08
 * 客户端发送文件到服务端，服务端接收之后，在给客户端一个回馈
 */
public class TCPTest3 {
    @Test
    public void client() {

        Socket socket = null;
        FileInputStream fis = null;
        OutputStream os = null;
        ByteArrayOutputStream baos1 = null;
        InputStream is = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 12345);
            fis = new FileInputStream("真实伤害.jpg");
            os = socket.getOutputStream();

            int len;
            byte[] arr = new byte[1024];
            while ((len = fis.read(arr)) != -1) {
                os.write(arr, 0, len);
            }
            //关闭数据的输出
            socket.shutdownOutput();

            //接收服务端返回来的信息
            is = socket.getInputStream();
            baos1 = new ByteArrayOutputStream();
            int len1;
            byte[] arr1 = new byte[20];
            while ((len1 = is.read(arr1)) != -1) {
                baos1.write(arr1, 0, len1);
            }
            System.out.println(baos1.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos1 != null) {
                try {
                    baos1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void service() {
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            //建立一个接收端
            ss = new ServerSocket(12345);
            //接收来着客户端的socket
            s = ss.accept();
            is = s.getInputStream();
            fos = new FileOutputStream("真实伤害(copy).jpg");
            int len;
            byte[] arr = new byte[1024];
            while ((len = is.read(arr)) != -1) {
                fos.write(arr, 0, len);
            }
            //给客户端反馈
            os = s.getOutputStream();
            os.write("图片已收到".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
