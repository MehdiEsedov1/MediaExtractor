package org.example.mediaextractor.Extractors;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/url2mp3")
public class URL2MP3 {
    @GetMapping("/yt2mp3")
    public void yt2mp3(@RequestParam String url) {
        try {
            String urlClean = url.replaceAll("[^a-zA-Z0-9]", "_");
            String outputDir = System.getProperty("user.home") + "/Desktop/mp3/";
            new java.io.File(outputDir).mkdirs();

            ProcessBuilder pb = new ProcessBuilder(
                    "src/main/resources/bin/yt-dlp_linux", "-f", "bestaudio", "--extract-audio", "--audio-format", "mp3", "-o", outputDir + urlClean + ".webm", url
            );
            Process process = pb.start();
            process.waitFor();

            ProcessBuilder pb0 = new ProcessBuilder(
                    "src/main/resources/bin/ffmpeg", "-i", outputDir + urlClean + ".webm", "-vn", "-acodec", "libmp3lame", outputDir + urlClean + ".mp3"
            );
            Process process0 = pb0.start();
            process0.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
