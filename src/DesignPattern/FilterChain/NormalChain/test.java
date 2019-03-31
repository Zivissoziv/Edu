package DesignPattern.FilterChain.NormalChain;

/**
 * Created by Ziv on 2019/3/28.
 * 测试：把输入的s处理后用FilterChain处理后输出
 */
public class test {
    public static void main(String[] args) {
        String s = "<script> :)";
        FilterChain fc1 = new FilterChain();
        fc1.add(new HTMLFilter()).add(new SmileFilter());
        String res = fc1.doFilter(s);
        System.out.println(res);
    }
}
