<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>株価予測アプリ - 結果</title>
    <!-- CSSの正しいパス -->
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/result.css">
</head>
<body>
    <header>株価予測アプリ</header>
    <div class="container">
        <h2>予測結果</h2>
        <table>
            <tr><th>シンボル</th><td>${symbol}</td></tr>
            <tr><th>最新終値</th><td>${close}</td></tr>
            <tr><th>SMA 5日</th><td>${sma5}</td></tr>
            <tr><th>SMA 25日</th><td>${sma25}</td></tr>
            <tr><th>RSI(14)</th><td>${rsi}</td></tr>
            <tr><th>予測価格</th><td class="predicted">${predicted}</td></tr>
        </table>
        <div class="buttons">
            <button onclick="location.href='index.jsp'">戻る</button>
        </div>
    </div>
</body>
</html>
