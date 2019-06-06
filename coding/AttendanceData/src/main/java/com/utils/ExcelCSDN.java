package com.utils;

import com.entity.Performance;
import com.entity.TMPerformance;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.springframework.util.StringUtils;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelCSDN {
    private static Map<PicturePosition, String> pictureMap;
    public static List<Performance> getPerformancelInfoBySheet(String url, int sheetNum){
        //初始化图片容器
        pictureMap = new HashMap<>();
        Workbook workbook;
        List<Performance> performanceList=null;
        String filePath =url;
        String fileFormat = url.substring(url.indexOf(".")+1);

        try{
            if (ExcelFormatEnum.XLS.getValue().equals(fileFormat)) {
                workbook = new HSSFWorkbook(new FileInputStream(filePath));
            } else if (ExcelFormatEnum.XLSX.getValue().equals(fileFormat)) {
                workbook = new XSSFWorkbook(new FileInputStream(filePath));
            }else {
                workbook = null;
            }
        //读取excel所有图片
            if (ExcelFormatEnum.XLS.getValue().equals(fileFormat)) {
                getPicturesXLS(workbook);
            } else {
                getPicturesXLSX(workbook);
            }
            performanceList=new ArrayList<Performance>();
            Sheet sheet = workbook.getSheetAt(sheetNum);
            int rows = sheet.getLastRowNum()+1; //读取行数

            //从第三行开始
            for(int i=2;i<rows;i++){
                //规避空格与第一行
                Row row=sheet.getRow(i);
                if(row.getCell(0).getCellType() ==Cell.CELL_TYPE_BLANK){
                    System.out.println("[该行为空，直接跳过]");
                    continue;
                }
                Performance performance=new Performance();
                try{

                    Cell type0=row.getCell(0);//ID
                    String idStr=GetCellValue(type0).substring(GetCellValue(type0).toLowerCase().indexOf("p")+1);
                    performance.setPfe_user_id(Integer.parseInt(idStr));

                    Cell type1=row.getCell(3);
                    performance.setPfe_rating(GetCellValue(type1));//'评级',

                    Cell type2=row.getCell(4);
                    performance.setPfe_totalScore(GetCellValue(type2));//'考核总分',

                    Cell type3=row.getCell(5);

                    if(type3==null){
                        performance.setPfe_tmComment("无");//'TM评语',
                    }else {
                        performance.setPfe_tmComment(GetCellValue(type3));//'TM评语',
                    }
                    Cell type4=row.getCell(6);
                    performance.setPfe_tmScore(GetCellValue(type4));//'TM评分',

                    Cell type5=row.getCell(7);
                    performance.setPfe_tlScore(GetCellValue(type5));

                    //加分项
                    Cell type6=row.getCell(8);
                    Cell type7=row.getCell(9);
                    Cell type8=row.getCell(10);
                    Cell type9=row.getCell(11);
                    Cell type10=row.getCell(12);
                    Cell type11=row.getCell(13);
                    Cell type12=row.getCell(14);
                    String pfe_addPoint=GetCellValue(type6)+"/"+
                            GetCellValue(type7)+"/"+
                            GetCellValue(type8)+"/"+
                            GetCellValue(type9)+"/"+
                            GetCellValue(type10)+"/"+
                            GetCellValue(type11)+"/"+
                            GetCellValue(type12);
                    performance.setPfe_addPoint(pfe_addPoint);
                    //扣分项
                    Cell type13=row.getCell(15);
                    Cell type14=row.getCell(16);
                    Cell type15=row.getCell(17);
                    Cell type16=row.getCell(18);
                    Cell type17=row.getCell(19);
                    String pfe_minusPoint=GetCellValue(type13)+"/"+
                            GetCellValue(type14)+"/"+
                            GetCellValue(type15)+"/"+
                            GetCellValue(type16)+"/"+
                            GetCellValue(type17);
                    performance.setPfe_minusPoint(pfe_minusPoint);

                    //原始数据
                    Cell type18=row.getCell(20);
                    Cell type19=row.getCell(21);
                    Cell type20=row.getCell(22);
                    Cell type21=row.getCell(23);
                    Cell type22=row.getCell(24);
                    String  pfe_originalData=GetCellValue(type18)+"/"+
                            GetCellValue(type19)+"/"+
                            GetCellValue(type20)+"/"+
                            GetCellValue(type21)+"/"+
                            GetCellValue(type22);
                    performance.setPfe_originalData(pfe_originalData);
                    Cell type23=row.getCell(25);//季度
                    performance.setPfe_quarter(Integer.parseInt(GetCellValue(type23)));
                    if(row.getCell(26)==null){
                        performance.setPfe_tlComment("无");//备注
                    }else {
                        performance.setPfe_tlComment(GetCellValue(row.getCell(26)));//备注
                    }

                    performanceList.add(performance);
                }catch(NullPointerException e){
                    e.printStackTrace();
                    System.out.println("[空指针异常]");
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return performanceList;
    }


    public static List<TMPerformance> getTMPerformancelInfoBySheet(String url, int sheetNum){
        Workbook workbook;
        List<TMPerformance> tmPerformanceList=null;
        String filePath =url;
        String fileFormat = url.substring(url.indexOf(".")+1);

        try{
              if (ExcelFormatEnum.XLS.getValue().equals(fileFormat)) {
                    workbook = new HSSFWorkbook(new FileInputStream(filePath));
                } else if (ExcelFormatEnum.XLSX.getValue().equals(fileFormat)) {
                    workbook = new XSSFWorkbook(new FileInputStream(filePath));
                }else {
                    workbook = null;
                }
            tmPerformanceList=new ArrayList<TMPerformance>();
            Sheet sheet = workbook.getSheetAt(sheetNum);
            int rows = sheet.getLastRowNum()+1; //读取行数
            for(int i=2;i<rows;i++){
                //规避空格与第一行
                Row row=sheet.getRow(i);
                if(row.getCell(0).getCellType() ==Cell.CELL_TYPE_BLANK){
                    System.out.println("[该行为空，直接跳过]");
                    continue;
                }
                TMPerformance tmPerformance=new TMPerformance();
                Cell type0=row.getCell(0);//ID
                String idStr=GetCellValue(type0).toLowerCase();
                tmPerformance.setTmpfe_user_id(Integer.parseInt(idStr.substring(idStr.indexOf("p")+1)));
                Cell type1=row.getCell(3);//个人评级
                tmPerformance.setTmpfe_rating(GetCellValue(type1));
                Cell type2=row.getCell(4);//评语
                if(type2==null){
                    tmPerformance.setTmpfe_tlComment("无");
                }else {
                    tmPerformance.setTmpfe_tlComment(GetCellValue(type2));
                }
                Cell type3=row.getCell(5);//'考核总分',
                tmPerformance.setTmpfe_totalScore(GetCellValue(type3));
                Cell type4=row.getCell(6);//'TL评分',
                tmPerformance.setTmpfe_tlScore(GetCellValue(type4));

                Cell type5=row.getCell(7);//'cto评分',
                tmPerformance.setTmpfe_ctoScore(GetCellValue(type5));

                //加分项：
                Cell type6=row.getCell(8);//全勤
                Cell type7=row.getCell(9);//培训讲师
                Cell type8=row.getCell(10);//团队无漏测
                Cell type9=row.getCell(11);//团队个人日均有效BUG数 ≧ 3
                Cell type10=row.getCell(12);//团队有人获得个人有效BUG数排名奖励
                Cell type11=row.getCell(13);//获得团队人均有效BUG数排名奖励
                Cell type12=row.getCell(14);//对项目有较大贡献
                Cell type13=row.getCell(15);//客户表扬

                String addPoint=GetCellValue(type6)+"/"+
                        GetCellValue(type7)+"/"+ GetCellValue(type8)+"/"+
                        GetCellValue(type9)+"/"+ GetCellValue(type10)+"/"+
                        GetCellValue(type11)+"/"+ GetCellValue(type12)+"/"+
                        GetCellValue(type13);
                tmPerformance.setTmpfe_addPoint(addPoint);
                //扣分项：

                Cell type14=row.getCell(16);//个人迟到数>3
                Cell type15=row.getCell(17);//团队人均迟到数>3
                Cell type16=row.getCell(18);//团队个人日均有效BUG数<3
                Cell type17=row.getCell(19);//BUG漏测
                Cell type18=row.getCell(20);//客户投诉
                Cell type19=row.getCell(21);//信息安全
                Cell type22=row.getCell(24);//备注（特殊项加分/扣分）说明
                String minusPoint=GetCellValue(type14)+"/"+
                        GetCellValue(type15)+"/"+
                        GetCellValue(type16)+"/"+
                        GetCellValue(type17)+"/"+
                        GetCellValue(type18)+"/"+
                        GetCellValue(type19)+"/"+GetCellValue(type22);
                tmPerformance.setTmpfe_minusPoint(minusPoint);

                Cell type20=row.getCell(22);//个人迟到次数
                tmPerformance.setTmpfe_latenessNum(GetCellValue(type20));
                Cell type21=row.getCell(23);//是否漏测
                tmPerformance.setTmpfe_leakage(GetCellValue(type21));

                //团队数据
                Cell type23=row.getCell(25);//团队名称
                Cell type24=row.getCell(26);//有效BUG数
                Cell type25=row.getCell(27);//人数
                Cell type26=row.getCell(28);//自然工作日
                Cell type27=row.getCell(29);//自然工作人天
                Cell type28=row.getCell(30);//人平均有效BUG数
                Cell type29=row.getCell(31);//是否获得双月团队人均有效BUG数排名奖励
                Cell type30=row.getCell(32);//迟到总数
                Cell type31=row.getCell(33);//迟到人均数
                Cell type32=row.getCell(34);//团队漏测数
                Cell type33=row.getCell(35);//团队是否漏测
                Cell type34=row.getCell(36);//团队双月个人是否获得
                Cell type35=row.getCell(37); // 团队双月个人获得名单
                String originalData= GetCellValue(type23)+"/"+GetCellValue(type24)+"/"+
                        GetCellValue(type25)+"/"+GetCellValue(type26)+"/"+
                        GetCellValue(type27)+"/"+GetCellValue(type28)+"/"+
                        GetCellValue(type29)+"/"+GetCellValue(type30)+"/"+
                        GetCellValue(type31)+"/"+GetCellValue(type32)+"/"+
                        GetCellValue(type33)+"/"+GetCellValue(type34)+"/"+
                        GetCellValue(type35);
                tmPerformance.setTmpfe_originalData(originalData);
                Cell type36=row.getCell(38);//团队人姓名
                tmPerformance.setTmpfe_teamAllName(GetCellValue(type36));


                Cell type37=row.getCell(39);//季度
                tmPerformance.setTmpfe_quarter(Integer.parseInt(GetCellValue(type37)));
                Cell type38=row.getCell(40);
                if(type38==null){
                    tmPerformance.setTmpfe_ctoComment("无");
                }else {
                    tmPerformance.setTmpfe_ctoComment(GetCellValue(type38));
                }
                System.out.println("name:--------"+tmPerformance.toString());
                tmPerformanceList.add(tmPerformance);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return tmPerformanceList;
    }
    /**
     * * 枚举excel格式
     * */
    public enum ExcelFormatEnum {
        XLS(0, "xls"),
        XLSX(1, "xlsx");
        private Integer key;
        private String value;
        ExcelFormatEnum(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
        public Integer getKey() {
            return key;
        }
        public String getValue() {
            return value;
        }
    }
    /**
     *  读取表格数据时候，要校验表格中的数据类型
     * @param cellType
     * @return
     */
    private static String GetCellValue(Cell cellType){
        String temp="";
        //使用getCellType时候要确定的定位好哪一行的cell
        int cellc= cellType.getCellType();
        switch(cellc) {
            //这里需要手动引包 import org.apache.poi.ss.usermodel.Cell;
            case Cell.CELL_TYPE_STRING:
                temp = cellType.getStringCellValue().trim();
                temp = StringUtils.isEmpty(temp) ? "NULL" : temp;
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                temp = String.valueOf(cellType.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                temp = String.valueOf(cellType.getCellFormula().trim());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                /**
                 *  当需要存入INT类型时
                 需要将其转为DOUBLE在调用MATH.CEIL
                 Double f = Double.valueOf(s);
                 Int a = (int)Math.ceil(f);
                 */
                Double num=Double.valueOf(cellType.getNumericCellValue());
                temp =String.valueOf((int)Math.ceil(num));
                break;
            case Cell.CELL_TYPE_BLANK:
                temp = "NULL";
                break;
            case Cell.CELL_TYPE_ERROR:
                temp = "ERROR";
                break;
            default:
                temp = cellType.toString().trim();
                break;
        }
        return temp;
    }
    /**
     * * 获取Excel2003的图片
     * *
     * * @param workbook
     * */
    private static void getPicturesXLS(Workbook workbook) {
        List<HSSFPictureData> pictures = (List<HSSFPictureData>) workbook.getAllPictures();
        HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);
        if (pictures.size() != 0) {
            for (HSSFShape shape : sheet.getDrawingPatriarch().getChildren()) {
                HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();
                if (shape instanceof HSSFPicture) {
                    HSSFPicture pic = (HSSFPicture) shape;
                    int pictureIndex = pic.getPictureIndex() - 1;
                    HSSFPictureData picData = pictures.get(pictureIndex);
                    PicturePosition picturePosition = PicturePosition.newInstance(anchor.getRow1(), anchor.getCol1());
                    pictureMap.put(picturePosition, printImg(picData));
                }
            }
        }
    }


    /**
     *  * 获取Excel2007的图片
     * *     * @param workbook
     * */
    private static void getPicturesXLSX(Workbook workbook) {
        XSSFSheet xssfSheet = (XSSFSheet) workbook.getSheetAt(0);
        for (POIXMLDocumentPart dr : xssfSheet.getRelations()) {
            if (dr instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) dr;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    XSSFPicture pic = (XSSFPicture) shape;
                    XSSFClientAnchor anchor = pic.getPreferredSize();
                    CTMarker ctMarker = anchor.getFrom();
                    PicturePosition picturePosition = PicturePosition.newInstance(ctMarker.getRow(), ctMarker.getCol());
                    pictureMap.put(picturePosition, printImg(pic.getPictureData()));
                }
            }
        }
    }

    /**
     * * 图片位置
     * * 行row 列 col
     * */
    public static class PicturePosition {
        private int row;
        private int col;
        public static PicturePosition newInstance(int row, int col) {
            PicturePosition picturePosition = new PicturePosition();
            picturePosition.setRow(row);
            picturePosition.setCol(col);
            return picturePosition;
        }
        public int getRow() {
            return row;
        }
        public void setRow(int row) {
            this.row = row;
        }
        public int getCol() {
            return col;
        }
        public void setCol(int col) {
            this.col = col;
        }
    }

    /**
     * * 保存图片并返回存储地址
     * *
     * * @param pic
     * * @return
     * */
    public static String printImg(PictureData pic) {
        try {
            String ext = pic.suggestFileExtension(); //图片格式
             String filePath = "D:\\pic\\pic" + UUID.randomUUID().toString() + "." + ext;
             byte[] data = pic.getData();
             FileOutputStream out = new FileOutputStream(filePath);
             out.write(data);
             out.close();
             return filePath;
        } catch (Exception e) {
            return "";
        }
    }

    public static  void main(String []args)  {
        List<TMPerformance>  TM=getTMPerformancelInfoBySheet("C:\\Users\\24431\\company\\coding\\AttendanceData\\src\\main\\resources\\file\\工作簿2.xlsx",0);
//        List<Performance>  list = getPerformancelInfoBySheet("C:\\Users\\24431\\company\\coding\\AttendanceData\\src\\main\\resources\\file\\工作簿1.xlsx",0);
//        for (Performance s:list){
//            System.out.println(s.toString());
//        }
        for(TMPerformance tm:TM){
            System.out.println(tm.toString());
        }
    }

}
