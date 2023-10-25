package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class Operation {
    int idOperation;
    String  nomTransaction;
    int idTransaction;
    double montant;
    String cinE;
    String cinR;
    Date dates;
    String date;
    double volany;

    public double getVolany() {
        return volany;
    }

    public void setVolany(double volany) {
        this.volany = volany;
    }

    public Operation(int idTransaction, double montant, String cinE, String cinR, String date) {
        this.idTransaction = idTransaction;
        this.montant = montant;
        this.cinE = cinE;
        this.cinR = cinR;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Operation() {
    }
    public Operation[] tableauOperation(){
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
    public double  Vola(String cinR){
        Double objets = null ;
        try {
            String url = "http://localhost:5111/api/OperationController/Selectmontant?cinR="+cinR;
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
                    objets = objectMapper.readValue(jsonResponse, Double.class);
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
    
    public void insertOperation(){
        Operation[] objets = null ;
        try {
            String url = "http://localhost:5111/api/OperationController/InsertionOperation?id="+this.getIdTransaction()+"&montant="+this.getMontant()+"&cinR="+this.getCinR()+"&cinE="+this.getCinE()+"&date="+this.getDate();
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Succes");
            } else {
                System.out.println("Erreur HTTP : " + responseCode);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public Operation[] getOperationbyId(String cin){
        ArrayList<Operation> liste = new ArrayList<Operation>();
        Operation[] response = this.tableauOperation();
        for(int i =0; i< response.length; i++){
            if(response[i].getCinR().equalsIgnoreCase(cin)){
                liste.add(response[i]);
            }
        }
        Operation [] valiny = new Operation[liste.size()];
        return liste.toArray(valiny);
    }
    public Operation(int idOperation, int idTransaction, double montant, String cinR,String cinE, Date dates,String nomTransaction) {
        this.idOperation = idOperation;
        this.idTransaction = idTransaction;
        this.nomTransaction = nomTransaction;
        this.montant = montant;
        this.cinR = cinR;
        this.cinE = cinE;
        this.dates = dates;
    }
    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }
    public String getNomTransaction() {
        return nomTransaction;
    }

    public void setNomTransaction(String nomTransaction) {
        this.nomTransaction = nomTransaction;
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }


    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getCinR() {
        return cinR;
    }

    public void setCinR(String cinR) {
        this.cinR = cinR;
    }
     public String getCinE() {
        return cinE;
    }

    public void setCinE(String cinE) {
        this.cinE = cinE;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
}
