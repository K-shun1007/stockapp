package stockapp.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/stock")
public class StockServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        String symbol = request.getParameter("symbol");
        if (symbol == null || symbol.isEmpty()) {
            symbol = "UNKNOWN";
        }

        // Pythonスクリプトのパス
        String pythonScriptPath = "C:/Users/kuritas/eclipse-workspace/stockapp/python/predict.py";

        // Python呼び出し
        ProcessBuilder pb = new ProcessBuilder("python", pythonScriptPath, symbol);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        // Pythonの出力を受け取る
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line).append("<br>");
        }

        // ブラウザに出力
        response.getWriter().println("<h1>株式予測アプリ</h1>");
        response.getWriter().println("<p>入力銘柄: " + symbol + "</p>");
        response.getWriter().println("<h2>Pythonの予測結果</h2>");
        response.getWriter().println("<p>" + result.toString() + "</p>");
    }
}
