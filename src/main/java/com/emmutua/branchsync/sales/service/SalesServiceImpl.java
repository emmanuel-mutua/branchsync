package com.emmutua.branchsync.sales.service;

import com.emmutua.branchsync.util.CustomResponse;
import com.emmutua.branchsync.sales.model.Item;
import com.emmutua.branchsync.sales.repo.SalesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService{

    private final SalesRepository salesRepository;
    @Override
    @Transactional
    public CustomResponse submitDailySales(
            MultipartFile requestSales
    ) {
        try {
            // Use current date and time
            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();
            // Create a temporary Excel file
            File tempFile = File.createTempFile("tempFile", ".xlsx");

            // Write the content of the MultipartFile to the temporary file
            try (OutputStream os = new FileOutputStream(tempFile)) {
                os.write(requestSales.getBytes());
            }

            // Create a FileInputStream for the temporary file
            FileInputStream excelFile = new FileInputStream(tempFile);
            // create workbook instance
            XSSFWorkbook wb = new XSSFWorkbook(excelFile);
            // Get sheet 1
            XSSFSheet sheet = wb.getSheetAt(0);
            // Iterate through rows starting from the second row (index 1)
            Iterator<Row> iterator = sheet.iterator();
            //Skip the header
            iterator.next();
            while (iterator.hasNext()){
                Row row = iterator.next();
                // Read data from cells A2, B2, C2, D2
                String name = row.getCell(0).getStringCellValue();
                Double unitPrice =  row.getCell(1).getNumericCellValue();
                int itemsSold = (int) row.getCell(2).getNumericCellValue();
                float totalIncome = (float) row.getCell(3).getNumericCellValue();

                Item item = Item.builder()
                        .name(name)
                        .unitPrice(String.valueOf(unitPrice))
                        .itemsSold(itemsSold)
                        .totalIncome(totalIncome)
                        .localDate(localDate)
                        .localTime(localTime)
                        .build();
                salesRepository.save(item);
            }
            wb.close();
            return CustomResponse.success("Daily Sales Submitted");
        }catch (IOException e){
            return CustomResponse.error("Daily Sales Not Submitted, Try again");
        }
    }
}
