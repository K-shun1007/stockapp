<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>予測結果</title>
</head>
<body>
    <h1>予測結果</h1>
    <p>シンボル: ${symbol}</p>
    <p>最新終値: ${close} USD</p>
    <p>5日移動平均 (SMA5): ${sma5} USD</p>
    <p>25日移動平均 (SMA25): ${sma25} USD</p>
    <p>RSI(14): ${rsi}</p>
    <p>予測価格（機械学習モデル）: ${predicted} USD</p>
    <a href="index.jsp">戻る</a>
</body>
</html>
