import sys

# 引数で銘柄コードを受け取る
symbol = sys.argv[1] if len(sys.argv) > 1 else "UNKNOWN"

# ダミーの予測結果を返す
print(f"銘柄 {symbol} の予測株価は 123.45 USD です")
