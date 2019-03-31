package DesignPattern.FilterChain.NormalChain;

/**
 * Created by Ziv on 2019/3/28.
 */
public class HTMLFilter implements Filter {
    @Override
    public String doFilter(String str) {
        String res = str.replace("<", "[").replace(">", "]");
        return res;
    }
}
