import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AthleteReaderTest {

    @Test
    void readerWorks(){
        List<Athlete> athletes = new ArrayList<>();
        String result ="";
        try {
            athletes = AthleteReader.readFromCSV(Paths.get("result.csv"));
            athletes.sort(new AthleteComparator());

            for (Athlete athlete: athletes) {
                result = result + athlete.getName();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assertions.assertTrue(athletes.size() != 0);
        Assertions.assertEquals("FrederikAntonPaul", result);
    }
}
