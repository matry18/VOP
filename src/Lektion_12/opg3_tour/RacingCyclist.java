package Lektion_12.opg3_tour;

/**
 *
 * @author erso
 */
public class RacingCyclist implements Comparable<RacingCyclist> {

    private String name;
    private String team;
    private String country;

    private String time;
    private int mountains;
    private int points;

    public RacingCyclist(String name, String team, String country, String time, int mountains, int points) {
        this.name = name;
        this.team = team;
        this.country = country;
        this.time = time;
        this.mountains = mountains;
        this.points = points;
    }

    @Override
    public String toString() {
        return name + " " + team + " " + country + " " + time + " " + mountains + " " + points + "\n";
    }

    @Override
    public int compareTo(RacingCyclist o) {
        int compare = this.time.compareTo(o.getTime());

        if (compare == 0) {
            return this.name.compareTo(o.getName());

        } else {
            return compare;
        }

    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getCountry() {
        return country;
    }

    public String getTime() {
        return time;
    }

    public int getMountains() {
        return mountains;
    }

    public int getPoints() {
        return points;
    }

}
