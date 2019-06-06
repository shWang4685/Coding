package com.utils;

import com.alibaba.fastjson.JSON;
import com.dao.CompanyUserDao;
import com.entity.AttPersonnel;
import com.entity.CompanyUser;
import com.entity.Performance;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InsertUser {

    @Autowired
    private CompanyUserDao companyUserDao;


    @RequestMapping(value = "/insertUserByExcel",method = RequestMethod.GET)
    @ResponseBody
    public String getAllAttPersonnel(){
        System.out.println("进来了啦");
        String str="";
        List<CompanyUser> companyUsers=readerUserExel("C:\\Users\\24431\\company\\coding\\AttendanceData\\src\\main\\resources\\file\\账号-最新.xlsx",0);
        System.out.println(companyUsers.size());
        for(CompanyUser c:companyUsers){
            int num=companyUserDao.insertCompanyUser(c);
            if(num<0){
                str="fail";
                System.out.println(c.toString());
            }
        }
        return str;

    }
    public static  List<CompanyUser>  readerUserExel(String url, int sheetNum){
        Workbook workbook;
        List<CompanyUser> companyUsers=null;
        String filePath =url;
        System.out.println(filePath);
        String fileFormat = url.substring(url.indexOf(".")+1);
        try{
            if (ExcelCSDN.ExcelFormatEnum.XLS.getValue().equals(fileFormat)) {
                workbook = new HSSFWorkbook(new FileInputStream(filePath));
            } else if (ExcelCSDN.ExcelFormatEnum.XLSX.getValue().equals(fileFormat)) {
                workbook = new XSSFWorkbook(new FileInputStream(filePath));
            }else {
                workbook = null;
            }

            companyUsers=new ArrayList<CompanyUser>();
            Sheet sheet = workbook.getSheetAt(sheetNum);
            int rows = sheet.getLastRowNum()+1; //读取行数

            //从第三行开始
            for(int i=1;i<rows;i++){
                //规避空格与第一行
                Row row=sheet.getRow(i);
                if(row.getCell(0).getCellType() ==Cell.CELL_TYPE_BLANK){
                    System.out.println("[该行为空，直接跳过]");
                    continue;
                }
                CompanyUser companyUser=new CompanyUser();
                try{

                    Cell type0=row.getCell(0);//ID
                    companyUser.setUser_name(GetCellValue(type0));

                    Cell type1=row.getCell(1);
                    String idStr=GetCellValue(type1).toLowerCase();
                    companyUser.setUser_id(Integer.parseInt(idStr.substring(idStr.indexOf("p")+1)));


                    Cell type2=row.getCell(2);
                    companyUser.setUser_email(GetCellValue(type2));


                    Cell type3=row.getCell(3);
                    companyUser.setUser_account(GetCellValue(type3));

                    Cell type4=row.getCell(4);
                    companyUser.setUser_TM(GetCellValue(type4));


                    Cell type5=row.getCell(5);
                    companyUser.setUser_TL(GetCellValue(type5));

                    Cell type6=row.getCell(6);
                    companyUser.setUser_permission(Integer.parseInt(GetCellValue(type6)));

                    Cell type7=row.getCell(7);
                    companyUser.setUser_state(Integer.parseInt(GetCellValue(type7)));

                    Cell type8=row.getCell(8);
                    companyUser.setUser_password(GetCellValue(type8));

                    companyUsers.add(companyUser);
                }catch(NullPointerException e){
                    e.printStackTrace();
                    System.out.println("[空指针异常]");
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return companyUsers;

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
}
