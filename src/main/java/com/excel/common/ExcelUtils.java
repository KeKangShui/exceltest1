package com.excel.common;

/**
 * Created by ASUS on 2018/4/15.
 */

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel导入导出工具类
 */
public class ExcelUtils {
    private static Logger logger = Logger.getLogger(ExcelUtils.class);
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";

    /**
     * 读入excel文件，解析后返回
     */

    public static List<String[]> readExcel(@RequestParam MultipartFile file)
            throws IOException {
        //检查文件
        checkFile(file);
        //获得工作簿对象
        Workbook workbook = getWorkBook(file);
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<String[]> list = new ArrayList<String[]>();
        if (workbook != null) {
            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                //获得当前sheet工作表
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if (sheet == null) {
                    continue;
                }
                //获得当前sheet的开始行
                int firstRowNum = sheet.getFirstRowNum();
                //获得当前sheet结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                int firstColumn = 0;
                for (int rowNum = firstRowNum; rowNum < lastRowNum; rowNum++) {
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if (row == null) {
                        continue;
                    }
                    int firstCellNum = 0;

                    //获得当前行的列数
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    if (rowNum == firstRowNum) {
                        firstColumn = lastCellNum;
                    }
                    String[] cells = new String[firstColumn];
                    //循环当前行
                    for (int cellNum = firstCellNum; cellNum < firstColumn; cellNum++) {
                        //一个一个地取得单元格
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
            }
            workbook.close();
        }
        return list;
    }

    public static void checkFile(@RequestParam MultipartFile file) throws IOException {
        //判断文件是否存在
        if (null == file) {
            logger.error("文件不存在");
            throw new FileNotFoundException("文件不存在");
        }
        //获得文件名
        String filename = file.getOriginalFilename();
        //判断文件是否是Excel文件
        if (!filename.endsWith(xls) && !filename.endsWith(xlsx)) {
            logger.error(filename + "不是Excel文件");
            throw new IOException("不是Excel文件");
        }
    }

    public static Workbook getWorkBook(@RequestParam MultipartFile file) {
        //获得文件名
        String filename = file.getOriginalFilename();
        //创建workbook工作簿对象，表示整个Excel
        Workbook workbook = null;
        try {
            //获取Excel文件的IO流
            InputStream is = file.getInputStream();
            if (filename.endsWith(xls)) {
                workbook = new HSSFWorkbook(is);
            } else if (filename.endsWith(xlsx)) {
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    public static String getCellValue(Cell cell) {
        DecimalFormat df = new DecimalFormat("#");
        String cellValue = " ";
        if (null == cell) {
            return "";
        }
        //把数字当成String来读
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC://数字
                double c = cell.getNumericCellValue();
                cellValue = df.format(c);
                break;
            case Cell.CELL_TYPE_STRING:
                cellValue = cell.getStringCellValue().toString();
                break;
            case Cell.CELL_TYPE_BLANK:
                cellValue = " ";
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_ERROR:
                cellValue = "非法字符";
                break;
            case Cell.CELL_TYPE_FORMULA://公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
        }
        return cellValue;
    }


}
