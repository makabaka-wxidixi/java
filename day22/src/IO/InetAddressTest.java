package IO;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-04 7:12
 *
 * InetAddressl类每一个实例化对象代表的都是一个真实存在的IP地址
 */
public class InetAddressTest {

    @Test
    public void Test1(){
        InetAddress inet1 = null;
        InetAddress inet2=null;
        try {
            //如何实例化
            inet1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet1);
            inet2=InetAddress.getByName("www.vip.com");
            System.out.println(inet2);

            //获取本地IP
            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            //主机地址
            System.out.println(inet2.getHostAddress());
            //主机域名
            System.out.println(inet2.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
