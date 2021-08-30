package HashMap;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-30 16:05
 */
public class PropertiesTest {

    public static void main(String[] args){
        FileInputStream fis = null;
        try{
            Properties pros = new Properties();
            fis = new FileInputStream("asdf.properties");
            pros.load(fis);//加载对应流文件
            String Account = pros.getProperty("Account");
            String Password = pros.getProperty("Password");
            System.out.println("Account="+Account+";Password="+Password);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
