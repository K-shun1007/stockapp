# -*- coding: utf-8 -*-
import sys
import warnings

# Warnings を無効化（JSON出力を汚さないため）
warnings.filterwarnings("ignore")

import yfinance as yf
import pandas as pd
import numpy as np
from sklearn.linear_model import LinearRegression
import json


def main():
    if len(sys.argv) < 2:
        print(json.dumps({"error": "シンボルが指定されていません"}))
        sys.exit(1)

    symbol = sys.argv[1]

    # 株価データを取得（進捗バーを非表示）
    data = yf.download(symbol, start="2020-01-01", end=None, interval="1d", progress=False)

    if data.empty:
        print(json.dumps({"error": f"{symbol} のデータが取得できませんでした"}))
        sys.exit(1)

    # 移動平均 (SMA)
    data["SMA_5"] = data["Close"].rolling(window=5).mean()
    data["SMA_25"] = data["Close"].rolling(window=25).mean()

    # RSI (14日)
    delta = data["Close"].diff()
    gain = delta.where(delta > 0, 0)
    loss = -delta.where(delta < 0, 0)
    avg_gain = gain.rolling(window=14).mean()
    avg_loss = loss.rolling(window=14).mean()
    rs = avg_gain / avg_loss
    data["RSI_14"] = 100 - (100 / (1 + rs))

    # 欠損値を削除
    data = data.dropna()

    # 最新データ
    latest = data.iloc[-1]
    latest_close = latest["Close"]
    sma5 = latest["SMA_5"]
    sma25 = latest["SMA_25"]
    rsi = latest["RSI_14"]

    # ==============================
    # 機械学習（単純な線形回帰）
    # ==============================
    X = np.arange(len(data)).reshape(-1, 1)  # 日数
    y = data["Close"].values
    model = LinearRegression()
    model.fit(X, y)
    predicted_price = float(model.predict([[len(data) + 1]]))  # 翌日の予測

    # 結果を JSON にまとめる
    result = {
        "symbol": symbol,
        "close": float(latest_close),
        "sma5": float(sma5),
        "sma25": float(sma25),
        "rsi": float(rsi),
        "predicted": predicted_price
    }

    # JSON 文字列として出力（Java 側がパースする）
    print(json.dumps(result, ensure_ascii=False))

if __name__ == "__main__":
    main()
