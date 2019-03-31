package DesignPattern.Factory.SpringFactory;


import java.util.Properties;

/**
 * Created by Ziv on 2019/3/27.
 * 模拟Spring的BeanFactory实现（IOC控制反转面向接口编程思维）
 * Spring的BeanFactory是一个接口，有getBean方法，有多种类具体实现（例如ClassPathXmlApplication）
 */
public class test {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.load(test.class.getClassLoader()
                .getResourceAsStream("DesignPattern/Factory/SpringFactory/spring.properties"));
        String VehicleTypeName = props.getProperty("VehicleType");
        Object o = Class.forName(VehicleTypeName).newInstance();
        Vehicle v = (Vehicle) o;
        v.run();
    }
}
