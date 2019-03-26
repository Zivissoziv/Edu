package DesignMode.Iterator;

/**
 * Created by Ziv on 2019/3/26.
 * 自己写一个ArrayList
 */
public class myArrayList implements myCollections {

    private Object[] objs = new Object[10];
    private int index = 0;

    @Override
    public void add(Object o) {
        if (index >= objs.length) {
            Object[] newobjs = new Object[new Double(index * 1.5).intValue()];
            System.arraycopy(objs,0,newobjs,0,objs.length);
            objs = newobjs;
        }
        objs[index] = o;
        index++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public myIteractor iteractor() {
        return new myArrayItercator();
    }

    private class myArrayItercator implements myIteractor {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex < index) return true;
            else return false;
        }

        @Override
        public Object next() {
            Object obj = objs[currentIndex];
            currentIndex++;
            return obj;

        }
    }

}
