
package Lektion11_WashingMachine_numberArrays.laundry_facade;

import java.util.HashMap;
import java.util.Map;

/**
 * VOP Eksamen F15
 * Kodeskelet til WashingMachine-klassen i opgave 3.
 * @author erso
 */
public class WashingMachine implements LaundryMachine{
    
    private Map<Integer, WashProgram> progMap;
    private String model;
    
    public WashingMachine(String model)
    {
         this.model = model;
         progMap = new HashMap<>();
   }
    
    public void addProgram(int code, String name, double  price){
        progMap.put(code, new WashProgram(name, price));
   }

    @Override
    public String getModel()
    {
        return model;
   }

 
     @Override
    public double getPrice(int prog)
    {
        return progMap.get(prog).getPrice();
   }

    @Override
    public String getProgName(int prog)
    {
        return progMap.get(prog).getName();
   }

    @Override
    public String toString()
    {
        return getModel() + "\n" + progMap +"\n";
    }
    
   
}
