package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-24 19:46
 */
public class SerializableOutputFile {
    public static void main(String[] args) {
        String destPath = "c:/Users/liu/Desktop/序列化.abc";
        try (ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(destPath))) {
            oop.writeInt(123);
            oop.writeBoolean(false);
            oop.writeUTF("我是你爸爸");
            oop.writeChar('A');
            oop.writeObject(new Dog("龟龟", 5));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
