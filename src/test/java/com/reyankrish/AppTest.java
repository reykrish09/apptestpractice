package com.reyankrish;

import org.junit.jupiter.api.Test;

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
    void shouldContainKubernetesFooter() {
        String html = App.getHtml();

        assertTrue(html.contains("Running on Kubernetes"));
        assertTrue(html.contains("CI/CD with Jenkins"));
    }
}