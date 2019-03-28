package DesignMode.FilterChain.NormalChain;

/**
 * Created by Ziv on 2019/3/28.
 */
public class SmileFilter implements Filter {
    @Override
    public String doFilter(String str) {
        String res = str.replace(":)","^_^");
        return res;
    }
}
