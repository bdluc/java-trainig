package com.tma.crud.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tma.crud.entity.Customer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CustomerHelper {
    
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "Id", "customerName", "customerEmail", "Phone"};
  static String SHEET = "Customers";


    /*
		read file excel
    */
  public static List<Customer> customerExcel(InputStream is) {

    try {
        
        Workbook workbook = new XSSFWorkbook(is);

        Sheet sheet = workbook.getSheet(SHEET);
        Iterator<Row> rows = sheet.iterator();

        List<Customer> customers = new ArrayList<Customer>();

        int rowNumber = 0;
        while (rows.hasNext()) {
            Row currentRow = rows.next();

            if (rowNumber == 0) {
                rowNumber ++;
                continue;
            }

            Iterator<Cell> cellsInRow = currentRow.iterator();

            Customer customer = new Customer();

            int cellIdx = 0;
            while (cellsInRow.hasNext()) {
                Cell currentCell = cellsInRow.next();

                switch (cellIdx) {
                    case 0:
                        customer.setId((long) currentCell.getNumericCellValue());
                        break;

                    case 1:
                        customer.setCustomerName(currentCell.getStringCellValue());
                        break;

                    case 2:
                        customer.setCustomerEmail(currentCell.getStringCellValue());
                        break;
                        
                    case 3:
                        customer.setPhone(currentCell.getStringCellValue());
                        break;
                        
                    default:
                        break;
                }

                cellIdx++;
            }

            customers.add(customer);
        }
        
        workbook.close();

        return customers;
    } catch (IOException e) {
        throw new RuntimeException("fail to Excel file:" + e.getMessage());
    }
  }
}
