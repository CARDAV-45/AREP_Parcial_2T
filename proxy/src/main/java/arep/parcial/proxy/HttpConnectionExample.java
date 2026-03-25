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
    private static final String URL1 = "http://localhost:8080";
    private static final String URL2 = "http://localhost:8081";

    @GetMapping("/linearsearch")
    public String linearSearch(@RequestParam int[] array, @RequestParam int target) throws IOException {
        String inputList = arrayToString(array);
        int result;

        try {
            result = Integer.parseInt(
                getMethod(URL1 + "/linearsearch?arr=" + inputList + "&value=" + target)
                         .replace("Output: ", "").trim()
            );
        } catch (Exception e) {
            result = Integer.parseInt(
                getMethod(URL2 + "/linearsearch?arr=" + inputList + "&value=" + target)
                         .replace("Output: ", "").trim()
            );
        }

        return "{"
                + "\"operation\":\"linearSearch\","
                + "\"inputlist\":\"" + inputList + "\","
                + "\"value\":\"" + target + "\","
                + "\"output\":\"" + result + "\""
                + "}";
    }

    @GetMapping("/binarysearch")
    public String binarySearch(@RequestParam int[] array, @RequestParam int target) throws IOException {
        String inputList = arrayToString(array);
        int result;

        try {
            result = Integer.parseInt(
                getMethod(URL1 + "/binarysearch?arr=" + inputList + "&value=" + target)
                         .replace("Output: ", "").trim()
            );
        } catch (Exception e) {
            result = Integer.parseInt(
                getMethod(URL2 + "/binarysearch?arr=" + inputList + "&value=" + target)
                         .replace("Output: ", "").trim()
            );
        }

        return "{"
                + "\"operation\":\"binarySearch\","
                + "\"inputlist\":\"" + inputList + "\","
                + "\"value\":\"" + target + "\","
                + "\"output\":\"" + result + "\""
                + "}";
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
            StringBuilder response = new StringBuilder();
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