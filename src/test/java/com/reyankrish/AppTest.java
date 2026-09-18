package com.reyankrish;

import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void shouldGenerateHtmlPage() {
        String html = App.getHtml();

        assertNotNull(html);
        assertTrue(html.contains("<html"));
        assertTrue(html.contains("</html>"));
    }

    @Test
    void shouldReturnStartupMessage() {
        assertEquals(
                "Reyansh application started on port 8080",
                App.getStartupMessage()
        );
    }

    @Test
    void shouldContainReyanshProfile() {
        String html = App.getHtml();

        assertTrue(html.contains("Reyansh"));
        assertTrue(html.contains("USA"));
        assertTrue(html.contains("Happy, Smart and Awesome"));
    }

    @Test
    void shouldContainHobbies() {
        String html = App.getHtml();

        assertTrue(html.contains("Soccer"));
        assertTrue(html.contains("Video Games"));
        assertTrue(html.contains("Bike Riding"));
        assertTrue(html.contains("Reading"));
        assertTrue(html.contains("LEGO"));
        assertTrue(html.contains("Swimming"));
    }

    @Test
    void shouldStartServerSuccessfully() throws Exception {
        HttpServer server = App.startServer(0);

        try {
            assertTrue(server.getAddress().getPort() > 0);
        } finally {
            server.stop(0);
        }
    }

    @Test
    void shouldServeHtmlOverHttp() throws Exception {
        HttpServer server = App.createServer(0);
        server.start();

        try (HttpClient client = HttpClient.newHttpClient()) {
            int port = server.getAddress().getPort();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:" + port + "/"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            assertEquals(200, response.statusCode());
            assertTrue(response.body().contains("Reyansh"));
            assertTrue(response.body().contains("USA"));

            assertEquals(
                    "text/html; charset=UTF-8",
                    response.headers()
                            .firstValue("Content-Type")
                            .orElse("")
            );

        } finally {
            server.stop(0);
        }
    }
}