package IO;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-01 15:06
 * <p>
 * 查询文章中字符出现的次数
 */

public class exericeTest {
    @Test
    public void Test1() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            //创建流
            br = new BufferedReader(new FileReader("C:\\Users\\liu\\Desktop\\文章.txt"));
            int c = 0;
            while ((c = br.read()) != -1) {//一个一个读取
                char ch = (char) c;
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }

            bw = new BufferedWriter(new FileWriter("C:\\Users\\liu\\Desktop\\WordCount.txt"));

            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entries) {
                switch (entry.getKey()) {
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行符=" + entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab符=" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bw.newLine();
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
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
