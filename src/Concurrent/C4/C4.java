package Concurrent.C4;

/**
 * Created by Ziv on 2019/3/17.
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 容易产生脏读问题（dirtyRead）
 */
public class C4 {
    String name;
    int balance;

    synchronized void setBalance(String name, int balance) {
        this.name = name;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    /*synchronized*/ int getBalance(String name) {
        return balance;
    }

    public static void main(String[] args) {
        C4 c4 = new C4();
        new Thread(() -> c4.setBalance("zhangsan", 100)).start();
        System.out.println("第一次读");
        new Thread(() -> System.out.println(c4.getBalance("zhangsan"))).start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第二次读");
        new Thread(() -> System.out.println(c4.getBalance("zhangsan"))).start();
    }
}
