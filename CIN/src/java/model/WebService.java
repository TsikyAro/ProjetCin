package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebService {
    public Operation[] tableauOperation(String cin){
        Operation[] objets = null ;
        try {
            String url = " http://localhost:5111/api/OperationController";
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                String jsonResponse = response.toString();
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    objets = objectMapper.readValue(jsonResponse, Operation[].class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Erreur HTTP : " + responseCode);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objets;
    }
    
}
