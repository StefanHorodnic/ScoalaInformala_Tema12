import java.net.Inet4Address;
import java.time.Duration;
import java.time.LocalTime;

public class Athlete {

    private int number;
    private String name;
    private String countryCode;
    private Integer skiTimeResult;
    private String firstShooting;
    private String secondShooting;
    private String thirdShooting;

    public Athlete(int number,
                   String name,
                   String countryCode,
                   Integer skiTimeResult,
                   String firstShooting,
                   String secondShooting,
                   String thirdShooting) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShooting = firstShooting;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
    }

    public String getName() {
        return name;
    }

    public Integer getFinalTime() {
        return skiTimeResult + (numberOfMisses(firstShooting)+numberOfMisses(secondShooting)+numberOfMisses(thirdShooting))*10;
    }

    public static Athlete createAthlete(String[] metadata) throws Exception {
        try {
            int number = Integer.parseInt(metadata[0]);
            String name = metadata[1];
            String countryCode = metadata[2];

            int hours = Integer.parseInt(metadata[3].substring(0,2));
            int minutes = Integer.parseInt(metadata[3].substring(3,5));
            Integer skiTimeResult = hours * 60 + minutes;

            String first = metadata[4];
            String second = metadata[5];
            String third = metadata[6];

            return new Athlete(number, name, countryCode, skiTimeResult, first, second, third);
        } catch(Exception e){
            throw new Exception("Nu am putut crea atletul");
        }
    }

    private int numberOfMisses(String shooting) {
        int count = 0;
        for (int i = 0; i < shooting.length(); i++) {
            if (shooting.charAt(i) == 'o') {
                count++;
            }
        }
        return count;
    }
}
