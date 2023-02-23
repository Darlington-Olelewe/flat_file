package com.flat_file.service.impl;

import com.flat_file.model.FlatData;
import com.flat_file.repository.FlatDataRepo;
import com.flat_file.service.FlatDataService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class FlatDataServiceImpl implements FlatDataService {
    private final FlatDataRepo flatDataRepo;

    @Override
    public ResponseEntity<String> generateFlatData() throws IOException {
        FileInputStream file = new FileInputStream(new File("src/main/resources/data.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        Row headerRow = sheet.getRow(0);
        for(int j = 1; j <= 1500; j++){
            Row row = sheet.getRow(j);
            String fullPage = String.valueOf(row.getCell(0).getRichStringCellValue());
            String topic = fullPage.split("\\.")[0];
            String page = fullPage.substring(topic.length() + 1);
           for(int k = 1; k < row.getLastCellNum(); k++){
               Date d = headerRow.getCell(k).getDateCellValue();
               Integer visit = (int)row.getCell(k).getNumericCellValue();
               FlatData data = FlatData.builder()
                       .date(d)
                       .page(page)
                       .topic(topic)
                       .visit(visit)
                       .build();
               flatDataRepo.save(data);

           }
            System.out.println(fullPage+" completed item NO "+j);

        }

        return ResponseEntity.ok("Uploaded successfully");
    }

    @Override
    public ResponseEntity<String> createDept() throws IOException {
        FileInputStream file = new FileInputStream(new File("src/main/resources/department.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        Row headerRow = sheet.getRow(0);
        for(int j = 1; j <= 1500; j++){
            Row row = sheet.getRow(j);
            String fullPage = String.valueOf(row.getCell(0).getRichStringCellValue());
            String topic = fullPage.split("\\.")[0];
            String page = fullPage.substring(topic.length() + 1);
            for(int k = 1; k < row.getLastCellNum(); k++){
                Date d = headerRow.getCell(k).getDateCellValue();
                Integer visit = (int)row.getCell(k).getNumericCellValue();
                FlatData data = FlatData.builder()
                        .date(d)
                        .page(page)
                        .topic(topic)
                        .visit(visit)
                        .build();
                flatDataRepo.save(data);

            }
            System.out.println(fullPage+" completed item NO "+j);

        }

        return ResponseEntity.ok("Uploaded successfully");
    }
}
