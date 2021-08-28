import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AthleteReader {

    public static List<Athlete> readFromCSV(Path path) throws Exception {

        List<Athlete> athletes = new ArrayList<>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(
                path, StandardCharsets.US_ASCII)){
            String line = bufferedReader.readLine();
            while(line != null){
                String[] ls =line.split(",");
                athletes.add(Athlete.createAthlete(ls));
                line = bufferedReader.readLine();
            }
        }
        catch (IOException e){
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return athletes;
    }
}
