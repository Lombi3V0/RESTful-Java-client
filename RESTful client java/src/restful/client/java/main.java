package restful.client.java;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class main {
    public static void main(String[] args) {
        int Scelta = 0;
        while (Scelta != 6) {
            System.out.println("\n|---------------------------------------------|");
            System.out.println("|----------[  RESTFUL JAVA CLIENT  ]----------|");
            System.out.println("|---------------------------------------------|");
            System.out.println("| 1) GET                                      |");
            System.out.println("| 2) POST                                     |");
            System.out.println("| 3) DELETE {id}                              |");
            System.out.println("| 4) GET {id}                                 |");
            System.out.println("| 5) PUT {id}                                 |");
            System.out.println("| 6) ESCI dal programma                       |");
            System.out.println("|_____________________________________________|");
            System.out.println("\nN° Opzione:");

            Scanner input = new Scanner(System.in);
            Scelta = input.nextInt();
            while (Scelta < 1 || Scelta > 6) {
                if (Scelta > 1 || Scelta < 6) {
                    System.out.println("Valore non valido, ritenta: ");
                    Scelta = input.nextInt();
                }
            }
            if (Scelta == 6) {
                System.exit(0);
            }
            switch(Scelta) {
                case 1:
                    try {
                        URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty("Accept", "application/json");
                        if (conn.getResponseCode() != 200) {
                            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                        }
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                (conn.getInputStream())));
                        String output;
                        System.out.println("Output from Server .... \n");
                        while ((output = br.readLine()) != null) {
                            System.out.println(output);
                        }
                        conn.disconnect();
                    } catch (MalformedURLException e) {
                    } catch (IOException e) {
                    }
                    break;
                case 2:
                    try {
                        URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setDoOutput(true);
                        conn.setRequestMethod("POST");
                        conn.setRequestProperty("Content-Type", "application/json");
                        String in = "{\"employeeId\": 1,\n" +
                                    "  \"firstName\": \"Pappa\",\n" +
                                    "  \"lastName\": \"Ciccia\",\n" +
                                    "  \"email\": \"pappaciccia@gmail.com\",\n" +
                                    "  \"phone\": \"234234234\"}";
                        OutputStream os = conn.getOutputStream();
                        os.write(in.getBytes());
                        os.flush();
                        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                        }
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                        (conn.getInputStream())));
                        String output;
                        System.out.println("Output from Server .... \n");
                        while ((output = br.readLine()) != null) {
                                System.out.println(output);
                        }
                        conn.disconnect();
                    } catch (MalformedURLException e) {
                    } catch (IOException e) {
                    }
                    break;
                case 3:
                    try {
                        URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/2");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setDoOutput(true);
                        conn.setRequestMethod("DELETE");
                        conn.setRequestProperty("Content-Type", "application/json");  
                        if (conn.getResponseCode() != 200) {
                            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                        }
                    } catch (MalformedURLException e) {
                    } catch (IOException e) {
                    }
                    break;
                case 4:
                    try {
                        URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/5");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty("Accept", "application/json");
                        if (conn.getResponseCode() != 200) {
                            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                        }
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                (conn.getInputStream())));
                        String output;
                        System.out.println("Output from Server .... \n");
                        while ((output = br.readLine()) != null) {
                            System.out.println(output);
                        }
                        conn.disconnect();
                    } catch (MalformedURLException e) {
                    } catch (IOException e) {
                    }
                    break;
                case 5:
                    try {
                        URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/1");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setDoOutput(true);
                        conn.setRequestMethod("PUT");
                        conn.setRequestProperty("Content-Type", "application/json");
                        String in = "{\"employeeId\": 1,\n" +
                                    "  \"firstName\": \"Porro\",\n" +
                                    "  \"lastName\": \"Ciccia\",\n" +
                                    "  \"email\": \"porrociccia@gmail.com\",\n" +
                                    "  \"phone\": \"9879798758\"}";
                        OutputStream os = conn.getOutputStream();
                        os.write(in.getBytes());
                        os.flush();
                        if (conn.getResponseCode() != 200) {
                            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                        }
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                        (conn.getInputStream())));
                        String output;
                        System.out.println("Output from Server .... \n");
                        while ((output = br.readLine()) != null) {
                                System.out.println(output);
                        }
                        conn.disconnect();
                    } catch (MalformedURLException e) {
                    } catch (IOException e) {
                    }
                    break;
            }
        }
    }
}
