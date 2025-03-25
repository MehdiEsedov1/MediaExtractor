package org.example.mediaextractor.Extractors;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/url2mp4")
public class URL2MP4 {
    @GetMapping("/yt2mp4")
    public void url2mp4(@RequestParam String url) {
        try {
            String urlClean = url.replaceAll("[^a-zA-Z0-9]", "_");
            String outputDir = System.getProperty("user.home") + "/Desktop/mp4/";
            new java.io.File(outputDir).mkdirs();

            ProcessBuilder pb = new ProcessBuilder(
                    "src/main/resources/bin/yt-dlp_linux",
                    "-S", "ext:mp4",
                    "-f", "bv+ba",
                    "--merge-output-format", "mp4",
                    "-o", outputDir + urlClean + ".mp4",
                    url
            );

            Process process = pb.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
