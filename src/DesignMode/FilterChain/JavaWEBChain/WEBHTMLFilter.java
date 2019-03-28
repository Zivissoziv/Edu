package DesignMode.FilterChain.JavaWEBChain;


/**
 * Created by Ziv on 2019/3/28.
 * doFilter前依次进入递归，doFilter后倒次退出递归，实现双向拦截
 */
public class WEBHTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, WEBFilterChain fc) {
        request.requestStr = request.requestStr.replace("<", "[").
                replace(">", "]");
        fc.doFilter(request, response, fc);
        response.responseStr = response.responseStr += "--HTMLFilter()--";
    }
}
