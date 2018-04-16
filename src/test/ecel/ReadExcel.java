package ecel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by ASUS on 2018/4/15.
 */
public class ReadExcel {
    public static void read() throws IOException {
        File file =new File("F:\\1\\f2.xls");
        //创建工作簿
        HSSFWorkbook workbook =new HSSFWorkbook(new FileInputStream(file));
        //创建工作表
        HSSFSheet sheet =workbook.getSheetAt(0);
        //定义开始行与尾行
        int fisrtRow = 0;
        int lastRow =sheet.getLastRowNum();
        for (int i = fisrtRow; i <lastRow ; i++) {
            //读取表格数据
            //读取当前行第一行
            HSSFRow row = sheet.getRow(i);
            //读取当前行最后一个单元格列号
            int lastCellNum =row.getLastCellNum();
            for (int j = 0; j <lastCellNum ; j++) {
                //取得第一个cell
                HSSFCell cell = row.getCell(j);
                //读取每一个cell中的内容
                String value = cell.getStringCellValue();
                String json = null;
                if (value != null) {
                    json = "{\"" + j + "\"" + ":" + "\"" + value + "\"}";
                }

                System.out.println(json);
            }
            System.out.println();
        }
    }
}
