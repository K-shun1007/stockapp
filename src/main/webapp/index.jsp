<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>StockApp</title>
</head>
<body>
    <h1>株式予測アプリ</h1>
    <form action="stock" method="get">
        <label>銘柄コード：</label>
        <input type="text" name="symbol" placeholder="例: AAPL">
        <input type="submit" value="予測する">
    </form>
</body>
</html>
