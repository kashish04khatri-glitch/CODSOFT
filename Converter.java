import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Converter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base currency (e.g., USD): ");
        String baseCurrency = sc.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g., INR): ");
        String targetCurrency = sc.nextLine().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        try {
            // API URL
            String urlStr = "https://api.exchangerate.host/latest?base=" + baseCurrency + "&symbols=" + targetCurrency;

            // Open connection
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            // Parse JSON response
            JSONObject json = new JSONObject(response.toString());
            JSONObject rates = json.getJSONObject("rates");
            double exchangeRate = rates.getDouble(targetCurrency);

            // Calculate conversion
            double convertedAmount = amount * exchangeRate;

            // Display result
            System.out.printf("\n%.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
