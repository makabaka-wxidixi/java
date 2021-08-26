package compare;

/**
 * 商品类
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-25 12:05
 */
public class Goods implements Comparable {
    private String name;
    private double price;

    public Goods() {

    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品比较大小的方式
    @Override
    public int compareTo(Object o) {
        System.out.println("--=--------");
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else
                return this.name.compareTo(goods.name);//默认都是从小到大排列
            //return Double.compare(this.price,goods.price)
        }
        throw new RuntimeException("传入数据类型不一致");
    }
}
