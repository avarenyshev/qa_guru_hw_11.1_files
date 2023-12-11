import com.fasterxml.jackson.databind.ObjectMapper;
import model.JData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;



public class CheckJson {
    ClassLoader cl = CheckJson.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void checkJsonTest() throws IOException {
        try (InputStream is = cl.getResourceAsStream("sample.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            JData sample = objectMapper.readValue(isr, JData.class);
            Assertions.assertEquals("Joe", sample.firstname);
            Assertions.assertEquals("Jackson", sample.lastname);
            Assertions.assertEquals("male", sample.gender);
            Assertions.assertEquals("28", sample.age);
            Assertions.assertEquals(List.of("Toyota","Subaru"), sample.cars);
            Assertions.assertEquals("Jeniffer", sample.wife);
        }
    }
}
