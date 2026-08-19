import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

/** Serveur local Java 8 pour l'application de gestion de boutique. */
public class App {
    public static void main(String[] args) throws Exception {
        // Render fournit le port via PORT ; 8080 reste pratique en local.
        String portValue = System.getenv("PORT");
        final int port = portValue == null ? 8080 : Integer.parseInt(portValue);
        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", port), 0);
        server.createContext("/", new StaticFileHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Boutique Stock demarre : http://localhost:" + port);
        System.out.println("Appuyez sur Ctrl+C pour arreter le serveur.");
    }

    static class StaticFileHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String route = exchange.getRequestURI().getPath();
            if ("/".equals(route)) route = "/index.html";
            if (route.contains("..")) { exchange.sendResponseHeaders(403, -1); return; }
            String file = route.substring(1);
            if (!Files.exists(Paths.get(file))) { exchange.sendResponseHeaders(404, -1); return; }
            byte[] body = Files.readAllBytes(Paths.get(file));
            String type = file.endsWith(".css") ? "text/css; charset=utf-8" : file.endsWith(".js") ? "application/javascript; charset=utf-8" : "text/html; charset=utf-8";
            exchange.getResponseHeaders().set("Content-Type", type);
            exchange.sendResponseHeaders(200, body.length);
            OutputStream out = exchange.getResponseBody(); out.write(body); out.close();
        }
    }
}
