package com.utils;

import com.entity.Performance;
import com.pojo.PerformanceInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderExeclUtil {
    public static List<Performance> getPerformancelInfoBySheet(String url, int sheetNum) throws IOException {
        FileInputStream fis=null;
        List<Performance> performanceList=null;
        Workbook wb=null;

        try {
            fis=new FileInputStream(url);
            //判断是什么格式
            try{
                //XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx
                wb=new XSSFWorkbook(fis);
            }catch (Exception e) {
                //HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls
                wb=new HSSFWorkbook(fis);
            }
            Sheet sheet=wb.getSheetAt(sheetNum);
            String testcaseName=wb.getSheetName(sheetNum);
            System.out.println("读取到的sheet是："+testcaseName);
            performanceList=new ArrayList<Performance>();
            //从第三行开始
            for(int i=0;i<sheet.getLastRowNum();i++){
                //规避空格与第一行
                Row row=sheet.getRow(i);
                if(row.getCell(0).getCellType() ==Cell.CELL_TYPE_BLANK){
                    System.out.println("[该行为空，直接跳过]");
                    continue;
                }
                Performance performance=new Performance();
                try{

                    Cell type0=row.getCell(0);//ID
                    performance.setPfe_user_id(Integer.parseInt(GetCellValue(type0)));

                    Cell type1=row.getCell(3);
                    performance.setPfe_rating(GetCellValue(type1));//'评级',

                    Cell type2=row.getCell(4);
                    performance.setPfe_totalScore(GetCellValue(type2));//'考核总分',

                    Cell type3=row.getCell(5);
                    performance.setPfe_tmComment(GetCellValue(type3));//'TM评语',

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
                    performanceList.add(performance);
                }catch(NullPointerException e){
                    System.out.println("[空指针异常]");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  performanceList;
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

    public static  void main(String []args)  {
        List<Performance> list= null;
        try {
            list = getPerformancelInfoBySheet("C:\\Users\\24431\\company\\coding\\AttendanceData\\src\\main\\resources\\file\\工作簿2.xlsx",2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Performance s:list){
            System.out.println(s.toString());
        }
    }
}
