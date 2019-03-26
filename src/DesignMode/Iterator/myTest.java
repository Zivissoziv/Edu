package DesignMode.Iterator;

/**
 * Created by Ziv on 2019/3/26.
 * 测试类
 */
public class myTest {
    public static void main(String[] args) {
        myCollections ca = new myArrayList();
        myCollections cl = new myLinkedList();
        for(int i = 0;i<15;i++){
            ca.add(i);
        }
        System.out.println(ca.size());

        for(int i = 0;i<15;i++){
            cl.add(i);
        }
        System.out.println(cl.size());

        myIteractor ica = ca.iteractor();
        while (ica.hasNext()){
            System.out.print(ica.next()+" ");
        }

        System.out.println();
        myIteractor icl = cl.iteractor();
        while (icl.hasNext()){
            System.out.print(icl.next()+" ");
        }
    }
}
