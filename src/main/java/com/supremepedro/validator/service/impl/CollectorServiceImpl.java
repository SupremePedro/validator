package com.supremepedro.validator.service.impl;

import com.supremepedro.validator.model.Attribute;
import com.supremepedro.validator.model.AttributeValue;
import com.supremepedro.validator.model.Product;
import com.supremepedro.validator.model.Subcategory;
import com.supremepedro.validator.repository.ProductRepository;
import com.supremepedro.validator.service.CollectorService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectorServiceImpl implements CollectorService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> persistFromExcel(Long startAt, Long length) {
        List<Product> newProducts = new ArrayList<>();
        List<Attribute> newAttribute = new ArrayList<>();
        List<AttributeValue> newAttributeValue = new ArrayList<>();
        List<Subcategory> newSubcategory = new ArrayList<>();
        extractValueFromExcel(startAt,length);
        productRepository.saveAll(newProducts);
        return newProducts;
    }

    private void extractValueFromExcel(Long startAt,Long length) {
        File myFile = new File("allValues.xlsx");
        try (FileInputStream fis = new FileInputStream(myFile)) {
            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator<Row> rowIterator = mySheet.iterator();
            int counter = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (counter > startAt) {
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case STRING:
                                System.out.print(cell.getStringCellValue() + "\t");
                                break;
                            case NUMERIC:
                                System.out.print(cell.getNumericCellValue() + "\t");
                                break;
                        }
                    }
                    System.out.println("");

                }
                counter++;
                if (counter>startAt+length){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
