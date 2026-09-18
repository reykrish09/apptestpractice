package com.reyankrish;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class App {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {

            String response = """
                    <!DOCTYPE html>
                    <html>
                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">

                        <title>Reyansh Good Boy Program</title>

                        <style>
                            * {
                                box-sizing: border-box;
                            }

                            html {
                                scroll-behavior: smooth;
                            }

                            body {
                                margin: 0;
                                font-family: Arial, Helvetica, sans-serif;
                                color: white;

                                background:
                                    radial-gradient(circle at top left, #ff9a9e, transparent 30%),
                                    radial-gradient(circle at top right, #fad0c4, transparent 30%),
                                    radial-gradient(circle at bottom left, #a18cd1, transparent 35%),
                                    radial-gradient(circle at bottom right, #fbc2eb, transparent 35%),
                                    linear-gradient(
                                        135deg,
                                        #667eea,
                                        #764ba2,
                                        #ff758c,
                                        #ff7eb3
                                    );

                                background-attachment: fixed;
                                min-height: 100vh;
                            }

                            nav {
                                position: sticky;
                                top: 0;
                                z-index: 10;

                                display: flex;
                                justify-content: space-between;
                                align-items: center;

                                padding: 18px 8%;

                                background: rgba(0, 0, 0, 0.25);
                                backdrop-filter: blur(12px);

                                box-shadow: 0 5px 20px rgba(0,0,0,0.2);
                            }

                            .logo {
                                font-size: 25px;
                                font-weight: bold;
                            }

                            .menu a {
                                color: white;
                                text-decoration: none;
                                margin: 0 15px;
                                font-weight: bold;
                                transition: 0.3s;
                            }

                            .menu a:hover {
                                color: #ffe66d;
                            }

                            .hero {
                                min-height: 80vh;

                                display: flex;
                                flex-direction: column;
                                align-items: center;
                                justify-content: center;

                                text-align: center;
                                padding: 40px 20px;
                            }

                            .hero h1 {
                                font-size: 65px;
                                margin: 0;

                                text-shadow:
                                    0 5px 20px rgba(0,0,0,0.35);
                            }

                            .hero h2 {
                                font-size: 32px;
                                color: #fff3a3;
                            }

                            .hero p {
                                font-size: 22px;
                                max-width: 700px;
                                line-height: 1.6;
                            }

                            .button {
                                display: inline-block;

                                margin-top: 20px;
                                padding: 15px 30px;

                                background:
                                    linear-gradient(
                                        90deg,
                                        #ffe259,
                                        #ffa751
                                    );

                                color: #222;
                                text-decoration: none;
                                font-weight: bold;

                                border-radius: 30px;

                                box-shadow:
                                    0 8px 20px rgba(0,0,0,0.25);

                                transition: 0.3s;
                            }

                            .button:hover {
                                transform: translateY(-5px) scale(1.03);
                            }

                            .section {
                                padding: 70px 8%;
                                text-align: center;
                            }

                            .section h2 {
                                font-size: 40px;
                                margin-bottom: 35px;
                            }

                            .cards {
                                display: grid;

                                grid-template-columns:
                                    repeat(
                                        auto-fit,
                                        minmax(230px, 1fr)
                                    );

                                gap: 25px;
                            }

                            .card {
                                background:
                                    rgba(255,255,255,0.18);

                                border:
                                    1px solid rgba(255,255,255,0.35);

                                border-radius: 22px;

                                padding: 35px 25px;

                                backdrop-filter: blur(15px);

                                box-shadow:
                                    0 10px 30px rgba(0,0,0,0.2);

                                transition: 0.3s;
                            }

                            .card:hover {
                                transform: translateY(-10px);
                                background: rgba(255,255,255,0.28);
                            }

                            .card .icon {
                                font-size: 55px;
                            }

                            .card h3 {
                                font-size: 24px;
                            }

                            .highlight {
                                background:
                                    linear-gradient(
                                        135deg,
                                        rgba(255, 81, 47, 0.85),
                                        rgba(221, 36, 118, 0.85)
                                    );

                                border-radius: 25px;

                                margin: 40px 8%;
                                padding: 60px 30px;

                                text-align: center;

                                box-shadow:
                                    0 10px 30px rgba(0,0,0,0.25);
                            }

                            .highlight h2 {
                                font-size: 45px;
                                margin-bottom: 15px;
                            }

                            .message-box {
                                max-width: 800px;
                                margin: auto;

                                background:
                                    rgba(0,0,0,0.20);

                                border-radius: 20px;

                                padding: 35px;

                                line-height: 1.8;
                                font-size: 20px;
                            }

                            footer {
                                margin-top: 60px;

                                background:
                                    rgba(0,0,0,0.30);

                                text-align: center;

                                padding: 30px;
                            }

                            @media(max-width: 750px) {

                                nav {
                                    flex-direction: column;
                                    gap: 15px;
                                }

                                .menu a {
                                    margin: 0 7px;
                                    font-size: 14px;
                                }

                                .hero h1 {
                                    font-size: 42px;
                                }

                                .hero h2 {
                                    font-size: 25px;
                                }
                            }
                        </style>
                    </head>

                    <body>

                        <nav>

                            <div class="logo">
                                🌟 Reyansh
                            </div>

                            <div class="menu">
                                <a href="#home">Home</a>
                                <a href="#goodboy">Good Boy</a>
                                <a href="#today">Today</a>
                                <a href="#rewards">Rewards</a>
                                <a href="#about">About</a>
                            </div>

                        </nav>


                        <section id="home" class="hero">

                            <h1>
                                🌈 Good Boy Program 🌈
                            </h1>

                            <h2>
                                ⭐ Reyansh is a Good Boy Today ⭐
                            </h2>

                            <p>
                                Welcome to Reyansh's special page.
                                Today is another wonderful day to learn,
                                listen, smile, help others and do great things.
                            </p>

                            <a class="button" href="#goodboy">
                                See Today's Stars
                            </a>

                        </section>


                        <section id="goodboy" class="section">

                            <h2>
                                ✨ Today's Good Boy Stars
                            </h2>

                            <div class="cards">

                                <div class="card">
                                    <div class="icon">😊</div>
                                    <h3>Good Behavior</h3>

                                    <p>
                                        Reyansh listened carefully
                                        and showed wonderful behavior today.
                                    </p>
                                </div>


                                <div class="card">
                                    <div class="icon">📚</div>
                                    <h3>Learning Star</h3>

                                    <p>
                                        Reyansh learned new things
                                        and completed his activities.
                                    </p>
                                </div>


                                <div class="card">
                                    <div class="icon">❤️</div>
                                    <h3>Kindness</h3>

                                    <p>
                                        Reyansh was kind,
                                        caring and helpful today.
                                    </p>
                                </div>


                                <div class="card">
                                    <div class="icon">🏆</div>
                                    <h3>Super Star</h3>

                                    <p>
                                        Great job Reyansh!
                                        Keep doing amazing things.
                                    </p>
                                </div>

                            </div>

                        </section>


                        <section id="today" class="highlight">

                            <h2>
                                🎉 Message of the Day
                            </h2>

                            <h1>
                                Reyansh is a Good Boy Today!
                            </h1>

                            <p>
                                Keep smiling, learning,
                                listening and being kind.
                            </p>

                        </section>


                        <section id="rewards" class="section">

                            <h2>
                                🎁 Today's Rewards
                            </h2>

                            <div class="cards">

                                <div class="card">
                                    <div class="icon">🎮</div>
                                    <h3>Play Time</h3>
                                    <p>Extra fun play time today.</p>
                                </div>

                                <div class="card">
                                    <div class="icon">🍦</div>
                                    <h3>Special Treat</h3>
                                    <p>A small special treat for a great day.</p>
                                </div>

                                <div class="card">
                                    <div class="icon">🤗</div>
                                    <h3>Big Hug</h3>
                                    <p>A big hug for doing such a great job.</p>
                                </div>

                            </div>

                        </section>


                        <section id="about" class="section">

                            <h2>
                                🚀 About This Website
                            </h2>

                            <div class="message-box">

                                <p>
                                    This colorful Reyansh Good Boy Program
                                    is running as a Java application.
                                </p>

                                <p>
                                    It is deployed on
                                    <strong>Google Kubernetes Engine</strong>.
                                </p>

                                <p>
                                    Traffic flows through
                                    Google Cloud Load Balancer,
                                    GKE Gateway,
                                    HTTPRoute,
                                    Kubernetes Service
                                    and finally reaches the application Pods.
                                </p>

                            </div>

                        </section>


                        <footer>

                            🌟 Reyansh Good Boy Program 🌟
                            <br><br>

                            Keep Learning • Keep Smiling • Keep Shining

                            <br><br>

                            Running on Google Kubernetes Engine 🚀

                        </footer>

                    </body>
                    </html>
                    """;

            byte[] data =
                    response.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders()
                    .set(
                        "Content-Type",
                        "text/html; charset=UTF-8"
                    );

            exchange.sendResponseHeaders(
                    200,
                    data.length
            );

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(data);
            }
        });

        server.start();

        System.out.println(
                "Server running on port 8080"
        );
    }
}