package IO;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-04 8:06
 */
public class TCPTest {

    @Test
    public void Test1() {
        //客户端
        //这里的ip是服务端的ip
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress localHost = InetAddress.getByName("127.0.0.1");
            socket = new Socket(InetAddress.getLocalHost(), 8899);
            //建立输出流
            os = socket.getOutputStream();
            os.write("我是你爸爸真伟大，养你这么大".getBytes());
            os.flush();
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
    public void Test2() {
        //服务端
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //创建一个服务器socket，并指明端口号
            ss = new ServerSocket(8899);
            //接收来自客户端的socket
            s = ss.accept();
            //建立输入流
            is = s.getInputStream();

            baos = new ByteArrayOutputStream();

            byte[] arr = new byte[12];
            int len;
            while ((len = is.read(arr)) != -1) {
                baos.write(arr, 0, len);
                baos.flush();
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
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
        }
    }
}
