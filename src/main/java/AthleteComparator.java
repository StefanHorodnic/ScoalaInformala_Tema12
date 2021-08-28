import java.util.Comparator;

public class AthleteComparator implements Comparator<Athlete> {
    @Override
    public int compare(Athlete o1, Athlete o2) {
        return o2.getFinalTime() - o1.getFinalTime();
    }
}
