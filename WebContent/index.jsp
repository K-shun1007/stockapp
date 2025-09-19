<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>株価予測アプリ - 入力</title>
    <!-- CSSの正しいパス -->
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/index.css">
</head>
<body>
    <header>株価予測アプリ</header>
    <div class="container">
        <h2>シンボルを入力してください</h2>
        <form action="stock" method="post">
            <input type="text" name="symbol" placeholder="例: AAPL, MSFT, 7203.T">
            <button type="submit">予測する</button>
        </form>
    </div>
</body>
</html>
