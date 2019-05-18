package Lektion_04_Nummerplade;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * VOP eksamen F2014 Kodeskelet til opgave 2
 *
 * @author erso
 */
public class NumberPlates {

    public static final int LENGTH = 7;         // Noejagtig laengde paa nummerplade

    private Map<String, String> districtMap;    // Kendingsbogstaver -> Politikreds

    private VehicleType[] vehicleTypes = { // Intervaller for anvendelse
        new VehicleType("Motorcykel", 10000, 19999),
        new VehicleType("Privat personvogn", 20000, 45999),
        new VehicleType("Udlejningsvogn", 46000, 46999),
        new VehicleType("Hyrevogn", 47000, 48999),
        new VehicleType("Skolevogn", 49000, 49899),
        new VehicleType("Ambulance el. lign.", 49900, 49999),
        new VehicleType("Diverse andre ", 50000, 84999)
    };

    public NumberPlates() {
        // opg 2a) initialiser districtMap
        districtMap = new HashMap<>(); //
        readFile();
    }

    public void readFile() {
    String[] lineSplit = new String[2];
    File fileName = new File("Nummerplader.txt");
    Scanner readLine = null;
        try {
            readLine = new Scanner(fileName);
            while(readLine.hasNextLine()) {
                lineSplit = readLine.nextLine().split(":");
                districtMap.put(lineSplit[0], lineSplit[1]);
            
            }
            readLine.close();
            // opg 2a) Indlaes filen og put i mappen
        } catch (FileNotFoundException ex) {
            System.out.println("No file found!");
        }

    }

    public String validate(String plate) {
        if (plate.length() == LENGTH) {
        String district = validateDistrict(plate.substring(0,2));
        String type = validateVehicleType(Integer.parseInt(plate.substring(2, LENGTH)));
        // Opg 2b) Tjek nummerpladen og returner anvendelse og politidistrikt
        return type + " fra " + district;
    } else
        return "Inkorrekt længde";
    }
    private String validateDistrict(String districtCode) {
        districtCode = districtCode.toUpperCase();
        if (districtMap.containsKey(districtCode)) {
            return districtMap.get(districtCode);
        } else 
        // Opg 2b) Tjek kendingsbogstaver og returner politidistrikt
        return "Kreds findes ikke";
    }
    private String validateVehicleType(int number) {
        for (int i = 0; i < vehicleTypes.length-1; i++) {
            if (vehicleTypes[i].isA(number)) {
                return vehicleTypes[i].getVehicleType();
            }
        } 
        // Opg 2b) Tjek hvilket interval number ligger i og returner anvendelse
        return "Inkorrekt nummer"+number;
    }

    public static void main(String[] arg) {
        // Opg 2) Kan benyttes til test af opgave 2a og 2b
        NumberPlates pd = new NumberPlates();

        System.out.println("KC39078: " + pd.validate("KC39078"));
        System.out.println("kc49900: " + pd.validate("kc49900"));
        System.out.println("KO47078: " + pd.validate("KO47078"));
        System.out.println("EN19022: " + pd.validate("EN19022"));
        System.out.println("EN190220: " + pd.validate("EN190220"));
    }

}
