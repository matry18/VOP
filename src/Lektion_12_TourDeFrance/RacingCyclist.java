package Lektion_12_TourDeFrance;

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

    //En constructor der tager variable som parametre
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

    //compareTo-metode der sorterer rytterne stigende efter tidstab
    //Hvis flere ryttere har samme tidstab sorteres efter navn
    @Override
    public int compareTo(RacingCyclist o) {
        int compare = this.time.compareTo(o.getTime());

        if (compare == 0) {
            return this.name.compareTo(o.getName());

        } else {
            return compare;
        }

    }

    
    //Get-metoder til alle parametre
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
