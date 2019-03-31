package DesignPattern.FilterChain.JavaWEBChain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziv on 2019/3/28.
 *
 */
public class WEBFilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();
    //为了实现双向拦截，引入index，判断Chain中还有无Filter
    int index = 0;

    WEBFilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response,WEBFilterChain fc) {
        if(index==filters.size()) return;
        Filter f = filters.get(index);
        index++;
        f.doFilter(request,response,fc);
    }
}
