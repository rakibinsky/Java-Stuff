import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleCalculatorServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/add", new AddHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server is listening on port 8080");
    }

    static class AddHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String query = exchange.getRequestURI().getQuery();
            String[] params = query.split("&");
            int num1 = Integer.parseInt(params[0].split("=")[1]);
            int num2 = Integer.parseInt(params[1].split("=")[1]);
            int result = num1 + num2;

            String response = String.valueOf(result);
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
