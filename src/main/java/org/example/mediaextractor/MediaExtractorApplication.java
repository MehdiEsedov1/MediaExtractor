package org.example.mediaextractor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class MediaExtractorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediaExtractorApplication.class, args);
        try {
            Thread.sleep(2000);
            openSwaggerUI();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void openSwaggerUI(){
        String url = "http://localhost:8080/swagger-ui/index.html";
            try {
                ProcessBuilder pb = new ProcessBuilder("xdg-open", url);
                pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
