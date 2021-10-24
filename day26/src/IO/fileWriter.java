package IO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-24 15:19
 */
public class fileWriter {
    public static void main(String[] args) {
        String filePath="c:/Users/liu/Desktop/怪兽简介.txt";
        File file = new File(filePath);
        try (FileWriter fileWrite=new FileWriter(file)){
            fileWrite.write("科加斯是一个来自虚空的怪物");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void test(){
        String filePath="c:/Users/liu/Desktop/怪兽简介.txt";
        FileWriter fileWrite=null;
        try {
            fileWrite=new FileWriter(filePath);
            fileWrite.write("我是卡莎，但我不是怪物");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileWrite!=null){
                try {
                    fileWrite.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
