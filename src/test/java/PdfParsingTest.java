import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
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
        try (InputStream is = cl.getResourceAsStream("examplePDF.pdf");
             PDF pdf = new PDF(is);
             Assertions.assertEquals("Chromium",pdf.text());
    }
}
//        InputStream stream = cl.getResourceAsStream("examplePDF.pdf");
//        PDF pdf = new PDF();
//        InputStream stream = getClass().getResourceAsStream("examplePDF.pdf");
