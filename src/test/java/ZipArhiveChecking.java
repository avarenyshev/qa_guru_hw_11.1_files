import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

//import static sun.jvm.hotspot.HelloWorld.e;

public class ZipArhiveChecking {
    private ClassLoader cl = ZipArhiveChecking.class.getClassLoader();
    String archive = "example.zip";

    @Test
    void zipTestPDF() throws Exception {
        try (ZipInputStream is = new ZipInputStream(
                cl.getResourceAsStream(archive))) {
            ZipEntry entry;
            while ((entry = is.getNextEntry()) != null) {
                if (entry.getName().equals("index.pdf")) {
                    PDF pdf = new PDF(is);
                    Assertions.assertEquals("JUnit 5 User Guide", pdf.title);

                }
            }
        }
    }

    @Test
    void zipTestXlsx() throws Exception {
        try (ZipInputStream is = new ZipInputStream(
                cl.getResourceAsStream(archive))) {
            ZipEntry entry;
            while ((entry = is.getNextEntry()) != null) {
                if (entry.getName().equals("example.xlsx")) {
                    XLS xls = new XLS(is);
                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(13).getCell(7).getStringCellValue(), "Биг Мак");
                }
            }
        }

    }
    @Test
    void zipTestCsv() throws Exception {
        try (ZipInputStream is = new ZipInputStream(
                cl.getResourceAsStream(archive))) {
            ZipEntry entry;
            while ((entry = is.getNextEntry()) != null) {
                if (entry.getName().equals("sportsSearch.csv")) {
                    CSVReader reader = new CSVReader(new InputStreamReader(is));
                    List<String[]> data = reader.readAll();
                    Assertions.assertEquals(2, data.size());
                    Assertions.assertArrayEquals(
                            new String[]{"Shinnik", "https://www.sports.ru/shinnik/"},
                            data.get(0)
                    );
                    Assertions.assertArrayEquals(
                            new String[]{"Osasuna", "https://www.sports.ru/osasuna/"},
                            data.get(1)
                    );
                }
            }
        }
    }
}
