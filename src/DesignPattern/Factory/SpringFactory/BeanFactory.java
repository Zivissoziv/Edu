package DesignPattern.Factory.SpringFactory;

/**
 * Created by Ziv on 2019/3/27.
 */
public interface BeanFactory {
    Object getBean(String id);
}
