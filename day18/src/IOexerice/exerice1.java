package IOexerice;

import org.junit.Test;

import java.io.File;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-31 18:18
 */
public class exerice1 {
    /*
    创建一个与a.txt文件同目录下的另外一个文件b.txt
     */
    @Test
    public void Test1(){
        File file1=new File("d:\\a\\a.txt");
        File file2=new File(file1.getParent(),"b.txt");
    }
}
