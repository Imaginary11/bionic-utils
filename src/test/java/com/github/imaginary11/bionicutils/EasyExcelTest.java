package com.github.imaginary11.bionicutils;

import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.imaginary11.bionicutils.utils.EasyExcelUtil;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/4/22 11:13
 */
public class EasyExcelTest {
    //    @Test
    public void test() throws FileNotFoundException {
        List<DemoVo> list = Arrays.asList(new DemoVo("jack1", "1"), new DemoVo("jack2", "2"));

        OutputStream outputStream = new FileOutputStream("/Users/fengqingyang-/test.xlsx");
        TableStyle tableStyle = new TableStyle();
        tableStyle.setTableContentBackGroundColor(IndexedColors.WHITE);

        //定义Excel正文字体大小
        Font font = new Font();
        font.setFontHeightInPoints((short) 10);
        tableStyle.setTableContentFont(font);

        Table table = new Table(0);
        table.setTableStyle(tableStyle);
        EasyExcelUtil.writeExcelWithModel(outputStream, list, table, DemoVo.class, ExcelTypeEnum.XLSX);
    }
}
