package stockapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import stockapp.service.PredictionService;

@WebServlet("/stock")
public class StockServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String symbol = request.getParameter("symbol");

        try {
            // Pythonから予測データを取得（JSON形式）
            JSONObject result = PredictionService.predict(symbol);

            // JSPに渡すデータをセット
            request.setAttribute("symbol", result.optString("symbol", "N/A"));
            request.setAttribute("close", result.optDouble("close", 0));
            request.setAttribute("sma5", result.optDouble("sma5", 0));
            request.setAttribute("sma25", result.optDouble("sma25", 0));
            request.setAttribute("rsi", result.optDouble("rsi", 0));
            request.setAttribute("predicted", result.optDouble("predicted", 0));

            // 結果ページへ
            request.getRequestDispatcher("/result.jsp").forward(request, response);

        } catch (Exception e) {
            // エラー時はエラーページへ
            request.setAttribute("message", "予測に失敗しました: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
