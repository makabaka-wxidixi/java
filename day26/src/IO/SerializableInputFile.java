package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-24 19:52
 */
public class SerializableInputFile {
    public static void main(String[] args) throws ClassNotFoundException {
        String srcPath = "c:/Users/liu/Desktop/序列化.abc";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(srcPath))) {
            System.out.println(ois.readInt());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readUTF());
            System.out.println(ois.readChar());
            Object o = ois.readObject();
            System.out.println(o);
            Dog dog = (Dog) o;
            System.out.println(dog.getName());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
