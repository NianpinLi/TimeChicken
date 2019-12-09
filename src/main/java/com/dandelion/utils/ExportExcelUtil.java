package com.dandelion.utils;

import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author puyiliang
 * @date 2019-12-05
 */
public class ExportExcelUtil {
    /**
     * 单Sheet页最大数据条数
     */
    private static int sheetDataLength = 59999;



    /**
     * 导出workBookMap自定义路径
     * @param workBookMap Map 中有两个key workBook POI工作薄, counter计数器
     * @param fileName 文件名称
     */
    public static void exportExcel(Map<String, Object> workBookMap, String fileName, String path) throws Exception{
        FileOutputStream out=null;
        Workbook workBook = null;
        try {
            workBook = (Workbook)workBookMap.get("workBook");
            //判断导出文件名称
            if(ObjectUtil.isNull(fileName)){
                fileName = "导出excel"+DateUtil.getNowDateEn()+".xlsx";
            }
            out=new FileOutputStream(path+ File.separator + fileName);
            workBook.write(out);
            out.flush();
        }catch (Exception e){
            throw e;
        }finally {
            closeConnection(workBook, out);
        }
    }

    /**
     * 生成workBookMap 并导出(清除List缓存)
     * @param fileName 文件名称
     * @param data 需要导出的数据List
     * @param titleMap 表头Map
     * @param sheetName Sheet页文件名称
     */
    public static void exportExcel(String fileName, String path, List<Map<String, Object>> data, LinkedHashMap<String, String> titleMap, String sheetName) throws Exception{
        Map<String, Object> workbookMap = exportListExcelClearExcel(null, data, titleMap, sheetName);
        exportExcel(workbookMap, fileName, path);
    }

    /**
     * 生成workBookMap 并导出(清除List缓存)
     * @param fileName 文件名称
     * @param data 需要导出的数据List
     * @param title 表头Key
     * @param titleMap 表头Map
     * @param sheetName Sheet页文件名称
     */
    public static void exportExcel(String fileName, String path,List<Map<String, Object>> data, String[] title, Map<String, String> titleMap, String sheetName) throws Exception{
        Map<String, Object> workbookMap = exportListExcelClearExcel(null, data, title, titleMap, sheetName);
        exportExcel(workbookMap, fileName,  path);
    }

    /**
     * 获取List格式的导出的Workbook 并清除List空间
     * @param workBookMap Map 中有两个key workBook POI工作薄, counter计数器
     * @param data 需要导出的数据List
     * @param titleMap 表头Map
     * @param sheetName Sheet页文件名称
     * @return workBookMap Map 中有两个key workBook POI工作薄, counter计数器
     */
    public static Map<String, Object> exportListExcelClearExcel(Map<String, Object> workBookMap, List<Map<String, Object>> data, LinkedHashMap<String, String> titleMap, String sheetName) throws Exception{
        try {
            workBookMap = exportListExcel(workBookMap, data, titleMap, sheetName);
        } catch (Exception e) {
            throw e;
        }finally {
            if (data != null){
                data.clear();
            }
        }
        return workBookMap;
    }

    /**
     * 获取List格式的导出的Workbook 并清除List空间
     * @param workBookMap Map 中有两个key workBook POI工作薄, counter计数器
     * @param data 需要导出的数据List
     * @param title 表头Key
     * @param titleMap 表头Map
     * @param sheetName Sheet页文件名称
     * @return workBookMap Map 中有两个key workBook POI工作薄, counter计数器
     */
    public static Map<String, Object> exportListExcelClearExcel(Map<String, Object> workBookMap, List<Map<String, Object>> data, String[] title, Map<String, String> titleMap, String sheetName) throws Exception{
        try {
            workBookMap = exportListExcel(workBookMap, data, title, titleMap, sheetName);
        } catch (Exception e) {
            throw e;
        }finally {
            if (data != null){
                data.clear();
            }
        }
        return workBookMap;
    }

    /**
     * 获取List数据的导出的WorkbookMap
     * @param workBookMap Map 中有两个key workBook POI工作薄, counter计数器
     * @param data 需要导出的数据List
     * @param titleMap 表头Map
     * @param sheetName Sheet页文件名称
     * @return workBookMap Map 中有两个key workBook POI工作薄, counter计数器
     */
    public static Map<String, Object> exportListExcel(Map<String, Object> workBookMap, List<Map<String, Object>> data, LinkedHashMap<String, String> titleMap, String sheetName) throws Exception{
        workBookMap = workbookMapPlan(workBookMap, sheetName);
        Workbook workBook= (Workbook)workBookMap.get("workBook");
        sheetName = (String) workBookMap.get("sheetName");
        int counter = (int)workBookMap.get("counter");
        Map<String, CellStyle> styles = createStyles(workBook);
        //分割数据（按单sheet页支持最大数据分割）
        List<List<Map<String, Object>>> partition = Lists.partition(data, sheetDataLength);
        //循环分割之后的List(一次循环产生一个List)
        for(int i = 0; i < partition.size(); i++){
            List<Map<String, Object>> dataList = partition.get(i);
            //获取Sheet页名称
            String currentSheetName = getCurrentSheetName(sheetName, counter, i);
            //获取Sheet页
            Sheet sheet = createSheet(workBook, currentSheetName);
            //创建表头
            createHeadRow(sheet, titleMap, styles.get("titleStyle"));
            //创建数据
            createDataRow(sheet, dataList, titleMap, styles.get("dataStyle"));
            workBookMap.put("counter", counter + i);
        }
        return workBookMap;
    }

    /**
     * 获取List数据的导出的WorkbookMap
     * @param workBookMap Map 中有两个key workBook POI工作薄, counter计数器
     * @param data 需要导出的数据List
     * @param title 表头Key
     * @param titleMap 表头Map
     * @param sheetName Sheet页文件名称
     * @return workBookMap Map 中有两个key workBook POI工作薄, counter计数器
     */
    public static Map<String, Object> exportListExcel(Map<String, Object> workBookMap, List<Map<String, Object>> data,String[] title, Map<String, String> titleMap, String sheetName) throws Exception{
        workBookMap = workbookMapPlan(workBookMap, sheetName);
        Workbook workBook= (Workbook)workBookMap.get("workBook");
        int counter = (int)workBookMap.get("counter");
        sheetName = (String) workBookMap.get("sheetName");
        Map<String, CellStyle> styles = createStyles(workBook);
        //分割数据（按单sheet页支持最大数据分割）
        List<List<Map<String, Object>>> partition = Lists.partition(data, sheetDataLength);
        //循环分割之后的List(一次循环产生一个List)
        for(int i = 0; i < partition.size(); i++){
            List<Map<String, Object>> dataList = partition.get(i);
            String currentSheetName = getCurrentSheetName(sheetName, counter, i);
            //获取Sheet页
            Sheet sheet = createSheet(workBook, currentSheetName);
            //创建表头
            createHeadRow(sheet, title, titleMap, styles.get("titleStyle"));
            //创建数据
            createDataRow(sheet, dataList, title, styles.get("dataStyle"));
            workBookMap.put("counter", counter + i);
        }
        return workBookMap;
    }

    /**
     * 初始化 workBookMap和 sheetName
     * @param workBookMap  workBookMap
     * @param sheetName sheetName
     * @return workBookMap
     */
    private static Map<String, Object> workbookMapPlan(Map<String, Object> workBookMap, String sheetName){
        Workbook workBook;
        if (workBookMap == null){
            workBookMap = new HashMap<>(2);
            workBook = new SXSSFWorkbook(100);
            workBookMap.put("workBook", workBook);
            workBookMap.put("counter", 0);
        }else{
            workBook = (Workbook) workBookMap.get("workBook");
        }

        if (workBook == null){
            //workBook格式设定为 SXSSF 支持大数据的导出，并且不占内存
            workBook = new SXSSFWorkbook(100);
            workBookMap.put("workBook", workBook);
        }
        if (ObjectUtil.isNull(sheetName)){
            sheetName = "sheet";
        }
        workBookMap.put("sheetName",sheetName);
        return workBookMap;
    }

    /**
     * 获取当前分页SheetName
     * @param sheetName String
     * @param counter 总计数器
     * @param loopCounter 循环计数器
     * @return String
     */
    private static String getCurrentSheetName(String sheetName, int counter, int loopCounter){
        //获取Sheet页名称
        String currentSheetName = sheetName;
        if (loopCounter > 0 || counter > 0){
            int currentCounter = loopCounter + counter;
            currentSheetName = sheetName + currentCounter;
        }
        return currentSheetName;
    }

    /**
     * 创建Sheet
     * @param workbook 工作薄
     * @param sheetName sheet页名称（非必须）
     * @return Sheet
     */
    private static Sheet createSheet(Workbook workbook, String sheetName){
        //添加判断
        if (workbook == null){
            return null;
        }
        Sheet sheet;
        //创建Sheet页
        if (ObjectUtil.isNull(sheetName)){
            sheet = workbook.createSheet();
        }else{
            sheet = workbook.createSheet(sheetName);
        }
        return sheet;
    }

    /**
     * 创建表头
     * @param sheet sheet页
     * @param titleMap 表头Map
     */
    private static void createHeadRow(Sheet sheet, LinkedHashMap<String, String> titleMap, CellStyle cellStyle){
        //创建表头
        Row row = sheet.createRow(0);
        //存放表头数据
        int i = 0;
        for (String titleKey : titleMap.keySet()) {
            Cell cell = row.createCell(i);
            //表头值
            cell.setCellValue(titleMap.get(titleKey));
            //风格
            if(cellStyle != null){
                cell.setCellStyle(cellStyle);
            }
            //设定单元格宽度
            sheet.setColumnWidth(i,30 * 256);
            i++;
        }
        //锁定表头
        sheet.createFreezePane(0,1, 0, 1 );
    }

    /**
     * 创建表头
     * @param sheet sheet页
     * @param titleMap 表头Map
     */
    private static void createHeadRow(Sheet sheet, String[] title , Map<String, String> titleMap, CellStyle cellStyle){
        //创建表头
        Row row = sheet.createRow(0);
        //存放表头数据
        for(int i = 0; i < title.length; i++){
            String titleKey = title[i];
            Cell cell = row.createCell(i);
            //表头值
            cell.setCellValue(titleMap.get(titleKey));
            //风格
            if(cellStyle != null){
                cell.setCellStyle(cellStyle);
            }
            //设定单元格宽度
            sheet.setColumnWidth(i,30 * 256);
        }
        //锁定表头
        sheet.createFreezePane(0,1, 0, 1 );
    }


    /**
     * 创建表格数据
     * @param sheet sheet页
     * @param titleMap 表头Map
     * @param dataList 数据列表
     * @param cellStyle 单元格风格
     */
    private static void createDataRow(Sheet sheet, List<Map<String, Object>> dataList, LinkedHashMap<String, String> titleMap, CellStyle cellStyle) {
        for(int i = 1; i <= dataList.size(); i++){
            Map<String, Object> data = dataList.get(i - 1);
            Row row = sheet.createRow(i);
            //存放表格数据
            int k = 0;
            for (String titleKey : titleMap.keySet()) {
                Cell cell = row.createCell(k);
                setCellValue(cell, data.get(titleKey), cellStyle);
                k++;
            }
        }
    }

    /**
     * 创建表格数据
     * @param sheet sheet页
     * @param title 数据Key
     * @param dataList 数据列表
     * @param cellStyle 单元格风格
     */
    private static void createDataRow(Sheet sheet, List<Map<String, Object>> dataList, String[] title, CellStyle cellStyle) {
        for(int i = 1; i <= dataList.size(); i++){
            Map<String, Object> data = dataList.get(i - 1);
            Row row = sheet.createRow(i);
            //存放表格数据
            for(int k =0; k < title.length; k++){
                String titleKey = title[k];
                Cell cell = row.createCell(k);
                setCellValue(cell, data.get(titleKey), cellStyle);
            }
        }
    }

    /**
     * 创建表格样式
     * @param wb Workbook
     * @return Map key['titleStyle','dataStyle'] titleStyle表头样式 dataStyle数据样式
     */
    private static Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<>(2);
        //----------------------标题样式---------------------------
        CellStyle cellHeaderTitle = wb.createCellStyle();
        setCellStyle(wb, cellHeaderTitle, 0);
        //-----------------------字体样式---------------------------
        CellStyle cellDataDefault = wb.createCellStyle();
        setCellStyle(wb, cellDataDefault, 1);
        styles.put("titleStyle", cellHeaderTitle);
        styles.put("dataStyle", cellDataDefault);
        return styles;
    }

    /**
     * 设置CellStyle风格
     * @param cellStyle CellStyle
     * @param type 类型 0代表表头 1代表内容
     */
    private static void setCellStyle(Workbook workbook, CellStyle cellStyle, int type){
        //创建字体
        Font font = workbook.createFont();
        font.setFontName("宋体");
        if(type == 0){
            font.setFontHeightInPoints((short) 13);
            font.setBold(true);
        }else{
            font.setFontHeightInPoints((short) 11);
        }
        cellStyle.setFont(font);
        //内容居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //下边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        //左边框
        cellStyle.setBorderLeft(BorderStyle.THIN);
        //上边框
        cellStyle.setBorderTop(BorderStyle.THIN);
        //右边框
        cellStyle.setBorderRight(BorderStyle.THIN);
    }

    /**
     * 设定单元格的风格和值
     * @param cell Cell单元格对象
     * @param value Object 存入的值
     * @param cellStyle 单元格风格
     */
    private static void setCellValue(Cell cell, Object value, CellStyle cellStyle){

        if (ObjectUtil.isNumber(value) && String.valueOf(value).length() <= 12){
            //当数据为数字类型 且 长度小于12位（非科学计数法）
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue(Double.parseDouble(String.valueOf(value)));
        }else{
            //当数据为非数字类型
            cell.setCellType(CellType.STRING);
            cell.setCellValue(StringUtil.castStringNullToEmpty(String.valueOf(value)));
        }
        //风格
        if(cellStyle != null){
            cell.setCellStyle(cellStyle);
        }
    }

    /**
     * 释放资源
     * @param workbook Workbook
     * @param outputStream OutputStream
     * @throws Exception e
     */
    private static void closeConnection(Workbook workbook, OutputStream outputStream) throws Exception{
        if (workbook != null){
            workbook.close();
        }
        if (outputStream != null){
            outputStream.close();
        }
    }
}
