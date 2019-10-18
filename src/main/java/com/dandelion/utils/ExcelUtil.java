package com.dandelion.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className ExcelUtil
 * description Excel操作工具类
 *
 * @author puyiliang
 * @date 2019/10/17 17:45
 */
public class ExcelUtil {

    /** Excel2003版本后缀 */
    public final static String EXCEL_VERSION_2003 = ".xls";
    /** Excel2007版本后缀 */
    public final static String EXCEL_VERSION_2007 = ".xlsx";

    /** Excel2003版本 */
    public final static String V2003 = "V2003";
    /** Excel2007版本 */
    public final static String V2007 = "V2007";

    /**
     * 标题样式
     */
    private final static String STYLE_HEADER = "header";
    /**
     * 数据样式
     */
    private final static String STYLE_DATA = "data";

    /**
     * 存储样式
     */
    private static final HashMap<String, CellStyle> cellStyleMap = Maps.newHashMap();


    /**
     * 读取excel文件里面的内容 支持日期，数字，字符，函数公式，布尔类型
     * @author puyiliang
     *  @date 2019/10/17 17:50
     *  @param    file File 需要读取的文件
     *  @param    rowCount 读取行数 为null时读取全部
     *  @param    columnCount 读取列数 为null时读取全部
     *  @return   List
     *  @throws Exception e
     */ 
    public static List<Map<String, Object>> readExcel(File file, Integer rowCount, Integer columnCount) throws Exception {

        // 根据后缀名称判断excel的版本
        String fileName = file.getName();
        Workbook wb = null;
        try {
            if (fileName.endsWith(EXCEL_VERSION_2003)) {
                wb = new HSSFWorkbook(new FileInputStream(file));
            } else if (fileName.endsWith(EXCEL_VERSION_2007)) {
                wb = new XSSFWorkbook(new FileInputStream(file));
            } else {
                // 无效后缀名称，这里之能保证excel的后缀名称，不能保证文件类型正确，不过没关系，在创建Workbook的时候会校验文件格式
                throw new IllegalArgumentException("Invalid excel version");
            }
            // 开始读取数据
            List<Map<String, Object>> sheetPOs = Lists.newArrayList();
            // 解析sheet
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                Sheet sheet = wb.getSheetAt(i);
                List<List<Object>> dataList = new ArrayList<>();
                Map<String, Object> sheetMap = Maps.newHashMap();
                sheetMap.put("sheetName", sheet.getSheetName());
                sheetMap.put("dataList", dataList);
                int readRowCount = 0;
                if (rowCount == null || rowCount > sheet.getPhysicalNumberOfRows()) {
                    readRowCount = sheet.getPhysicalNumberOfRows();
                } else {
                    readRowCount = rowCount;
                }
                // 解析sheet 的行
                for (int j = sheet.getFirstRowNum(); j < readRowCount; j++) {
                    Row row = sheet.getRow(j);
                    if (row == null) {
                        continue;
                    }
                    if (row.getFirstCellNum() < 0) {
                        continue;
                    }
                    int readColumnCount = 0;
                    if (columnCount == null || columnCount > row.getLastCellNum()) {
                        readColumnCount = (int) row.getLastCellNum();
                    } else {
                        readColumnCount = columnCount;
                    }
                    List<Object> rowValue = Lists.newLinkedList();
                    // 解析sheet 的列
                    for (int k = 0; k < readColumnCount; k++) {
                        Cell cell = row.getCell(k);
                        rowValue.add(getCellValue(wb, cell));
                    }
                    dataList.add(rowValue);
                }
                sheetPOs.add(sheetMap);
            }
            return sheetPOs;
        }catch (Exception e){
            throw e;
        }finally {
            if (wb != null){
                wb.close();
            }
        }
    }



    /**
     * 把excel表格写入输出流中，输出流会被关闭
     * @param version String
     * @param excelSheets 输出内容 List(Map)
     * @param outStream 输出流
     * @throws Exception e
     */
    public static void createWorkbookAtOutStream(String version, List<Map<String,Object>> excelSheets, OutputStream outStream) throws Exception {
        createWorkbookAtOutStream(version, excelSheets, outStream, true);
    }

    /**
     * 把excel表格写入输出流中，输出流会被关闭
     * @param version String
     * @param excelSheets 输出内容 List(Map)
     * @param outStream 输出流
     * @param closeStream 是否关闭输出流
     * @throws Exception e
     */
    public static void createWorkbookAtOutStream(String version, List<Map<String,Object>> excelSheets, OutputStream outStream, boolean closeStream) throws Exception {
        Workbook wb = null;
        try {
            wb = createWorkBook(version, excelSheets);
            wb.write(outStream);
        }catch (Exception e){
            throw e;
        }finally {
            if (wb != null){
                wb.close();
            }
            if (closeStream){
                outStream.close();
            }
        }
    }

    private static Workbook createWorkBook(String version, List<Map<String,Object>> excelSheets) {
        Workbook wb = createWorkbook(version);
        for (int i = 0; i < excelSheets.size(); i++) {
            Map<String, Object> excelSheetPO = excelSheets.get(i);
            if (ObjectUtil.isNull(excelSheetPO.get("sheetName"))) {
                excelSheetPO.put("sheetName","sheet" + i);
            }
            // 过滤特殊字符
            Sheet tempSheet = wb.createSheet(WorkbookUtil.createSafeSheetName(String.valueOf(excelSheetPO.get("sheetName"))));
            buildSheetData(wb, tempSheet, excelSheetPO);
        }
        return wb;
    }

    private static void buildSheetData(Workbook wb, Sheet sheet, Map<String, Object> excelSheetPO) {
        sheet.setDefaultRowHeight((short) 400);
        sheet.setDefaultColumnWidth((short) 10);
        int rowCounter = 0;
        rowCounter = createHeader(sheet, excelSheetPO, wb, rowCounter);
        createBody(sheet, excelSheetPO, wb, rowCounter);
    }

    private static void createBody(Sheet sheet, Map<String, Object> excelSheetPO, Workbook wb, int rowCounter) {
        List<List<Object>> dataList = (List<List<Object>>)excelSheetPO.get("dataList");
        for (int i = 0; i < dataList.size(); i++) {
            List<Object> values = dataList.get(i);
            Row row = sheet.createRow(rowCounter + i);
            for (int j = 0; j < values.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellStyle(getStyle(STYLE_DATA, wb));
                cell.setCellValue(values.get(j).toString());
            }
        }

    }

    private static int createHeader(Sheet sheet, Map<String, Object> excelSheetPO, Workbook wb, int rowCounter) {
        String[] headers = (String[])excelSheetPO.get("head");
        Row row = sheet.createRow(rowCounter);
        for (int i = 0; i < headers.length; i++) {
            Cell cellHeader = row.createCell(i);
            cellHeader.setCellStyle(getStyle(STYLE_HEADER, wb));
            cellHeader.setCellValue(headers[i]);
        }
        return rowCounter+1;
    }


    private static CellStyle getStyle(String type, Workbook wb) {

        if (cellStyleMap.containsKey(type)) {
            return cellStyleMap.get(type);
        }
        // 生成一个样式
        CellStyle style = wb.createCellStyle();

        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setWrapText(true);

        if (STYLE_HEADER == type) {
            Font font = wb.createFont();
            font.setFontHeightInPoints((short) 16);
            style.setFont(font);
        } else if (STYLE_DATA == type) {
            Font font = wb.createFont();
            font.setFontHeightInPoints((short) 12);
            style.setFont(font);
        }
        cellStyleMap.put(type, style);
        return style;
    }

    private static Workbook createWorkbook(String version) {
        switch (version) {
            case V2003:
                return new HSSFWorkbook();
            case V2007:
                return new XSSFWorkbook();
        }
        return null;
    }

    private static Object getCellValue(Workbook wb, Cell cell) {
        Object columnValue = null;
        if (cell != null) {
            DecimalFormat df = new DecimalFormat("0");// 格式化 number
            // String
            // 字符
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
            DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字
            switch (cell.getCellType()) {
                case STRING:
                    columnValue = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                        columnValue = df.format(cell.getNumericCellValue());
                    } else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                        columnValue = nf.format(cell.getNumericCellValue());
                    } else {
                        columnValue = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                    }
                    break;
                case BOOLEAN:
                    columnValue = cell.getBooleanCellValue();
                    break;
                case BLANK:
                    columnValue = "";
                    break;
                case FORMULA:
                    // 格式单元格
                    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
                    evaluator.evaluateFormulaCell(cell);
                    CellValue cellValue = evaluator.evaluate(cell);
                    columnValue = cellValue.getNumberValue();
                    break;
                default:
                    columnValue = cell.toString();
            }
        }
        return columnValue;
    }

}
