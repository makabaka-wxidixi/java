package IO;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-23 18:27
 */
public class tryCatch {
    public static void main(String[] args) throws Exception {
        try (Test test1 = new Test(1); Test test2 = new Test(2);) {
            test1.run();
            test2.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally执行了");
        }
    }
}

class Test implements AutoCloseable {
    public int val = 0;

    public Test(int val) {
        this.val = val;
        System.out.println(val + "流创建");
    }

    @Override
    public void close() throws Exception {
        System.out.println(val + "的close被调用");
    }

    public void run() {
        System.out.println(val + "的run被调用");
        throw new RuntimeException(val + "抛出异常，catch块被执行了");
    }
}
