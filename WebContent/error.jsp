<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>株価予測アプリ - エラー</title>
    <!-- CSSの正しいパス -->
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/error.css">
</head>
<body>
    <header>株価予測アプリ</header>
    <div class="container">
        <h2>エラーが発生しました</h2>
        <p>${message}</p>
        <div class="buttons">
            <button onclick="location.href='index.jsp'">入力画面に戻る</button>
        </div>
    </div>
</body>
</html>
