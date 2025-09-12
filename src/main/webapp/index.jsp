<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>株価予測</title>
</head>
<body>
    <h1>株価予測フォーム</h1>
    <form action="stock" method="post">
        <label>シンボル: </label>
        <input type="text" name="symbol">
        <input type="submit" value="予測開始">
    </form>
</body>
</html>
