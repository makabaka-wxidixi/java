package IO;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-04 9:26
 * <p>
 * 客户端发送文件给服务端，服务端接收并保存到本地
 */
public class TCPTest2 {

    @Test
    public void client() {
        Socket socket = null;
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            //建立文件对象
            File file = new File("黑夜亚索.jpg");
            //建立socket，并且输入要传输到的服务器IP地址
            socket = new Socket("127.0.0.1", 12121);
            //建立字节流
            os = socket.getOutputStream();
            fis = new FileInputStream(file);
            //向socket上写数据
            byte[] arr = new byte[1024];
            int len;
            while ((len = fis.read(arr)) != -1) {//读数据到arr数组中
                os.write(arr, 0, len);
                os.flush();
            }
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
        }

    }

    @Test
    public void service() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //建立一个服务器socket
            ss = new ServerSocket(12121);
            //得到从客户端发送来的socket
            socket = ss.accept();
            //建立输入流/输出流
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("黑夜亚索(copy).jpg"));
            int len;
            byte[] arr = new byte[1024];
            while ((len = is.read(arr)) != -1) {
                fos.write(arr, 0, len);
            }
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
            if (socket != null) {
                try {
                    socket.close();
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
        }
    }
}
