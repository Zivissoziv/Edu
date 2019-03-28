package DesignMode.FilterChain.NormalChain;

import java.util.ArrayList;

/**
 * Created by Ziv on 2019/3/28.
 * 简单的单向过滤链
 * 让FlterChain实现Filter接口可以实现多条FilterChain相连
 */
public class FilterChain implements Filter {
    ArrayList<Filter> filters = new ArrayList<>();

    FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }


    @Override
    public String doFilter(String str) {
        String res = str;
        for (Filter filter : filters) {
            res = filter.doFilter(res);
        }
        return res;
    }
}
