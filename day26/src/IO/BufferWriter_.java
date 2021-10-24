package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-24 17:19
 */
public class BufferWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "c:/Users/liu/Desktop/是文章.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
        bufferedWriter.write("我是你爸爸真伟大，养你真么大");
        bufferedWriter.newLine();
        bufferedWriter.write("我是你爸爸真伟大，养你真么大");
        bufferedWriter.newLine();
        bufferedWriter.write("我是你爸爸真伟大，养你真么大");
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
