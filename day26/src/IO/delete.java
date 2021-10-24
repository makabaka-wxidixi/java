package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-23 13:26
 */
public class delete {
    @Test
    public void delete1(){
        String path="e:/directory";
        File file = new File(path);
        file.delete();
//        InputStream
//        OutputStream
//        Reader
//        Writer
//        FileInputStream
    }

    @Test
    public void createDir(){
        String path="e:/game/LOL/yasuo";
        File file = new File(path);
        if(file.mkdirs()){
            System.out.println("目录创建成功");
        }
    }

    @Test
    public void createDir2(){
        String path="e:/Dota";
        File file = new File(path);
        file.mkdir();
    }

    @Test
    public void deleteDir(){
        String path="e:/game";
        File file = new File(path);
        file.delete();
    }

    @Test
    public void delete(){
        String fileName="e:/newFile.txt";
        File file = new File(fileName);
        file.delete();
    }

    @Test
    public void delete2(){
        String fileName="e:/newFile2.txt";
        File file = new File(fileName);
        file.delete();
    }
}
