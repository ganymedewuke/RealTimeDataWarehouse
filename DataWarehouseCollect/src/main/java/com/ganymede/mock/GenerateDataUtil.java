package com.ganymede.mock;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GenerateDataUtil {

    public static long genernateDateData(int[] days, Random random) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, -days[random.nextInt(days.length)]);
        long resultTime = calendar.getTime().getTime();
        return resultTime;
    }

    public static void postHttpMethod(String urlpath, String data) {
        try {
            URL url = new URL(urlpath);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setInstanceFollowRedirects(true);
            urlConnection.setUseCaches(true);

            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setConnectTimeout(1000 * 5);
            urlConnection.connect();

            OutputStream outputStream = urlConnection.getOutputStream();

            outputStream.write(data.getBytes("utf-8"));
            outputStream.flush();
            outputStream.close();
            InputStream inputStream = urlConnection.getInputStream();
            int httpCode = urlConnection.getResponseCode();
            byte[] inputData = new byte[1024];
            StringBuffer stringBuffer = new StringBuffer();
            while (inputStream.read(inputData, 0, 1024) != -1) {
                stringBuffer.append(new String(inputData));
            }
            System.out.println(httpCode);
            System.out.println(stringBuffer.toString());
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        postHttpMethod("http://localhost:8081/testCollectData", "helloword!! 你好，谢谢！！");
    }
}
