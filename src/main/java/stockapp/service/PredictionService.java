package stockapp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;

public class PredictionService {

    public static JSONObject predict(String symbol) throws IOException, InterruptedException {
        String pythonScriptPath = "C:\\Users\\kuritas\\eclipse-workspace\\stockapp\\python\\predict_real.py";

        ProcessBuilder pb = new ProcessBuilder("python", pythonScriptPath, symbol);
        pb.redirectErrorStream(true); // 標準エラーもまとめて取得

        Process process = pb.start();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));

        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Python script failed with code: " + exitCode);
        }

        String jsonText = output.toString().trim();
        System.out.println("Python出力内容 >>> " + jsonText); // 🚨 デバッグ用

        return new JSONObject(jsonText);
    }
}
