package com.flat_file.service;

import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FlatDataService {
    ResponseEntity<String> generateFlatData() throws IOException;
    ResponseEntity<String> createDept() throws IOException;
}
