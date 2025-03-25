package org.example.mediaextractor.Extractors;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mp42mp3")
public class MP42MP3 {
    @Operation(
            requestBody = @RequestBody(
                    content = @Content(
                            mediaType = "multipart/form-data",
                            schema = @Schema(type = "string", format = "binary")
                    )
            )
    )
    @PostMapping("")
    public void mp42mp3(){
//        try {
//            ProcessBuilder pb = new ProcessBuilder();
//            Process process = pb.start();
//            process.waitFor();
//        } catch (IOException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
