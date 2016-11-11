package carillegalquery.carillegalquery.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Administrator on 2016/11/6.
 */

public class HttpUtils {
    private static String TAG = "TAG";
    public static String getJsonData(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int code = conn.getResponseCode();
            String line = "";
            if (code == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                line = br.readLine();
                is.close();
                br.close();
             conn.disconnect();
            }

            return line;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
}

}
