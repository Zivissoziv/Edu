package DesignPattern.Factory.SpringFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ziv on 2019/3/27.
 * 以下是ClassPathXmlApplication的伪代码
 */
public class ClassPathXmlApplication implements BeanFactory {

    Map<String,Object> map = new HashMap<>();

    public ClassPathXmlApplication(String fileName){
        //通过JDOM等加载applicationContext.xml文件里的id和class
        //通过Class.forName反射机制创建对象
        //把id—>object加入map中
    }


    @Override
    public Object getBean(String id) {
        //通过id获取对象
        return map.get(id);
    }
}
