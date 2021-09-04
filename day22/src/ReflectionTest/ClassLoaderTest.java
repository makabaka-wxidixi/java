package ReflectionTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-04 18:42
 */
public class ClassLoaderTest {
    //Properties用来读取配置文件
    //方式一：文件默认在module下
    @Test
    public void Test1() throws IOException {
        //实例化对象
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user=" + user + "\npassword=" + password);

    }

    //方式二：
    //文件默认在module下的src下
    @Test
    public void Test2() throws IOException {
        Properties pros = new Properties();
        //获取类的系统加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("asdf.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user= " + user + "\npassword= " + password);
    }
}
