package DesignMode.FilterChain.JavaWEBChain;

/**
 * Created by Ziv on 2019/3/28.
 * 模拟Servlet里面的拦截器（实现双向拦截,有点像栈）
 * 即对request依次调用filterA，filterB，filterC
 * 而对response则依次调用filterC，filterB，filterA
 */
public class test {
    public static void main(String[] args) {
        String s = "<script> :)";
        Request request = new Request();
        request.requestStr = s;
        Response response = new Response();
        response.responseStr = "response";
        WEBFilterChain fc = new WEBFilterChain();
        fc.add(new WEBHTMLFilter()).add(new WEBSmileFilter());
        fc.doFilter(request,response,fc);

        System.out.println(request.requestStr);
        System.out.println(response.responseStr);
    }
}
