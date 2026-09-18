package com.reyankrish;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class App {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {

            String html = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Reyansh - Good Boy Program</title>

                    <style>
                        body {
                            margin: 0;
                            font-family: Arial, sans-serif;
                            background: linear-gradient(135deg, #1e3c72, #2a5298);
                            color: white;
                            text-align: center;
                        }

                        .container {
                            width: 80%;
                            max-width: 800px;
                            margin: 60px auto;
                            background: rgba(255, 255, 255, 0.12);
                            padding: 40px;
                            border-radius: 20px;
                            box-shadow: 0 10px 30px rgba(0,0,0,0.3);
                        }

                        h1 {
                            font-size: 42px;
                            margin-bottom: 10px;
                        }

                        h2 {
                            color: #ffd166;
                        }

                        .card {
                            background: rgba(255,255,255,0.15);
                            margin: 20px 0;
                            padding: 20px;
                            border-radius: 15px;
                        }

                        .hobbies {
                            display: flex;
                            justify-content: center;
                            gap: 15px;
                            flex-wrap: wrap;
                            margin-top: 15px;
                        }

                        .hobby {
                            background: #ffd166;
                            color: #222;
                            padding: 10px 18px;
                            border-radius: 20px;
                            font-weight: bold;
                        }

                        .footer {
                            margin-top: 30px;
                            font-size: 14px;
                            opacity: 0.8;
                        }
                    </style>
                </head>

                <body>

                    <div class="container">

                        <h1>Reyansh is a Good Boy Today!</h1>

                        <p>Welcome to the Reyansh Good Boy Program</p>

                        <div class="card">
                            <h2>About Reyansh</h2>
                            <p><strong>Name:</strong> Reyansh</p>
                            <p><strong>Location:</strong> USA 🇺🇸</p>
                            <p><strong>Status:</strong> Happy, Smart and Awesome!</p>
                        </div>

                        <div class="card">
                            <h2>Reyansh's Hobbies</h2>

                            <div class="hobbies">
                                <span class="hobby">⚽ Soccer</span>
                                <span class="hobby">🎮 Video Games</span>
                                <span class="hobby">🚲 Bike Riding</span>
                                <span class="hobby">📚 Reading</span>
                                <span class="hobby">🧱 LEGO</span>
                                <span class="hobby">🏊 Swimming</span>
                            </div>
                        </div>

                        <div class="card">
                            <h2>Today's Message</h2>
                            <p>
                                Keep learning, keep playing,
                                and always be a good boy!
                            </p>
                        </div>

                        <div class="footer">
                            Reyansh App • Running on Kubernetes • CI/CD with Jenkins
                        </div>

                    </div>

                </body>
                </html>
                """;

            byte[] response = html.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders().set(
                    "Content-Type",
                    "text/html; charset=UTF-8"
            );

            exchange.sendResponseHeaders(200, response.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response);
            }
        });

        server.setExecutor(null);
        server.start();

        System.out.println("Reyansh application started on port 8080");
    }
}