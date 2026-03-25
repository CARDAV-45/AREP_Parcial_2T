package arep.parcial.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpConnectionExample {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String URL1 = "http://3.88.197.52:8080";
    private static final String URL2 = "http://44.212.0.20:8081";

    @GetMapping("/linearsearch")
    public ProxyBody linearSearch(@RequestParam int[] array, @RequestParam int target) throws IOException {
        try {
            return new ProxyBody(getMethod(URL1 + "/linearsearch?array=" + arrayToString(array) + "&target=" + target));
        } catch (Exception e) {
            return new ProxyBody(getMethod(URL2 + "/linearsearch?array=" + arrayToString(array) + "&target=" + target));
        }
    }

    @GetMapping("/binarysearch")
    public ProxyBody binarySearch(@RequestParam int[] array, @RequestParam int target) throws IOException {
        try {
            return new ProxyBody(getMethod(URL1 + "/binarysearch?array=" + arrayToString(array) + "&target=" + target));
        } catch (Exception e) {
            return new ProxyBody(getMethod(URL2 + "/binarysearch?array=" + arrayToString(array) + "&target=" + target));
        }
    }

    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }


    private String getMethod(String GET_URL) throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setConnectTimeout(3000);

        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new IOException("GET request not worked");
        }
    }
}
