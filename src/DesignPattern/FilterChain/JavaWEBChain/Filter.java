package DesignPattern.FilterChain.JavaWEBChain;

/**
 * Created by Ziv on 2019/3/28.
 * 为了实现双向拦截，doFilter里传入FilterChain
 */
public interface Filter {
     void doFilter(Request request,Response response,WEBFilterChain fc);
}
