package com.ruoyi.web.anan;

import com.ruoyi.common.utils.poi.ExcelUtil;

import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class importa {
    public static void main(String[] args) throws Exception {
        InputStream is=new FileInputStream(new File("D:\\123.xlsx"));
        ExcelUtil<Entity> util =new ExcelUtil<Entity>(Entity.class);
        List<Entity> entities = util.importExcel(is);
        System.out.println("457464654");
        System.out.println(entities);
    }
}
