package com.flat_file.controller;

import com.flat_file.service.FlatDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class DataController {
    private final FlatDataService flatDataService;

    @GetMapping("/load")
    public ResponseEntity<String> populateData() throws IOException {
        return flatDataService.generateFlatData();
    }


}
