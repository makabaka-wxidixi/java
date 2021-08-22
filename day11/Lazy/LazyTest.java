package Lazy;

/**
 * 懒汉式解决线程安全问题
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-22 20:25
 */
public class LazyTest {


}

class Bank {
    private Bank() {
    }

    ;//提供一个构造器

    private static Bank instance = null;

    public static Bank getInstance() {
//        //方式一，效率较差
//        synchronized (Bank.class){
//            if(getInstance()==null){
//                return new Bank();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if (instance == null) {//判断，如果已经不为null，那就直接返回
            synchronized (Bank.class) {
                if (getInstance() == null) {
                    return new Bank();
                }
            }
        }
        return instance;
    }
}
