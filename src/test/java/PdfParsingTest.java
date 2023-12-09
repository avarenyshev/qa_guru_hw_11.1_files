import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;

public class PdfParsingTest {
    private ClassLoader cl = PdfParsingTest.class.getClassLoader();

    @Test
    void pdfParsingTest() throws Exception {
        InputStream is = cl.getResourceAsStream("index.pdf");
             PDF pdf = new PDF(is);
             Assertions.assertEquals( false, pdf.signed);
             Assertions.assertEquals( "JUnit 5 User Guide", pdf.title);
             System.out.println();
    }
    @Test
    void xlsParsingTest() throws Exception {
        InputStream is = cl.getResourceAsStream("example.xlsx");
        XLS xls  = new XLS(is);
        Cell actualValue = xls.excel.getSheetAt(0).getRow(13).getCell(7);
        Assertions.assertTrue(actualValue.contains("Биг Мак"));

        System.out.println("");



    }
}
//        InputStream stream = cl.getResourceAsStream("examplePDF.pdf");
//        PDF pdf = new PDF();
//        InputStream stream = getClass().getResourceAsStream("examplePDF.pdf");
