package stockapp.filter;

import javax.servlet.*;
import java.io.IOException;

public class UTF8Filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // リクエストをUTF-8に設定
        request.setCharacterEncoding("UTF-8");

        // レスポンスがHTMLの場合のみUTF-8を設定
        if (response.getContentType() == null || response.getContentType().startsWith("text/html")) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
        }

        // 次の処理へ
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
