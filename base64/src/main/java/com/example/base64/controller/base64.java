package com.example.base64.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@RestController
public class base64{

    @PostMapping("/encode")
    ResponseEntity Encode(@RequestBody Map<String, Object> requestBody) {
        String inputData = (String) requestBody.get("input");
        byte[] bytesEncoded = Base64.encodeBase64(inputData.getBytes());
        return ResponseEntity.status(200).body(new String(bytesEncoded));
    }
    @PostMapping("/encode-file")
    ResponseEntity handleEncodeFile(@RequestParam("filePath") String filePath) throws IOException {
        File file = new File(filePath);
        byte[] bytesEncoded = Base64.encodeBase64(Files.readAllBytes(file.toPath()));
        return ResponseEntity.status(200).body(new String(bytesEncoded));
    }

    @PostMapping("/decode")
    ResponseEntity Decode(@RequestBody Map<String, Object> requestBody){
        String inputData = (String) requestBody.get("input");
        byte[] valueDecoded = Base64.decodeBase64(inputData.getBytes());
        return ResponseEntity.status(200).body(new String(valueDecoded));
    }

}
