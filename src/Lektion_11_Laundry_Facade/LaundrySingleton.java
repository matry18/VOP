package Lektion_11_Laundry_Facade;

import java.util.Arrays;

/**
 * VOP Eksamen F15
 * Næsten færdig klasse, representerende et vaskeri til opgave 3
 * Kun mekanismerne der gør klassen til en singleton-klasse mangler at blive implementeret.
 * @author erso
 */
public class LaundrySingleton implements LaundryConstants
{
// Her implementeres constructor mm. så det bliver en singleton-klasse: Ved Singleton skal der kun være EN instans af klassen
    //Constructoren SKAL være privat!!!
    private static LaundrySingleton laundrySingleton = null;
    
    public static LaundrySingleton getInstance(){
        
       if(laundrySingleton == null) {
           laundrySingleton = new LaundrySingleton();
       }
       return laundrySingleton;
    }
    
// Resten er udleveret kode:   
    private LaundryMachine[] laundryMachines;


    @Override
    public String toString()
    {
        return "laundryMachines:\n" + Arrays.toString(laundryMachines);
    }
    
    public LaundryMachine getMachine(int index){
        if(index < laundryMachines.length)
            return laundryMachines[index];
        else{
            System.out.println("Maskine findes ikke!");
            return null;
        }
    }
    
    public double getPrice(int machine, int program){
        LaundryMachine lm = getMachine(machine);
        if (lm != null){
            return lm.getPrice(program);
        }
        return 0.0;
    }
    
    public String getProgName(int machine, int prog){
        LaundryMachine lm = getMachine(machine);
        if (lm != null){
            return lm.getProgName(prog);
        }
        return "Maskine findes ikke!";
        
    }
    
    // Hjælpe metode, som 'bygger' et vaskeri med 2 vaskemaskiner og 1 tørretumbler.
    public void buildLaundry(){
        laundryMachines = new LaundryMachine[3];
        
        WashingMachine w1 = new WashingMachine("Vaskemaskine max 6 kg");
        w1.addProgram(1, WASH_PROGRAM_1, WASH_PRICE_1);
        w1.addProgram(2, WASH_PROGRAM_2, WASH_PRICE_2);
        w1.addProgram(3, WASH_PROGRAM_3, WASH_PRICE_3);
        w1.addProgram(4, WASH_PROGRAM_4, WASH_PRICE_4);
        w1.addProgram(5, WASH_PROGRAM_5, WASH_PRICE_5);
        w1.addProgram(6, WASH_PROGRAM_6, WASH_PRICE_6);
        w1.addProgram(7, WASH_PROGRAM_7, WASH_PRICE_7);
        
        laundryMachines[0] = w1;

        WashingMachine w2 = new WashingMachine("Vaskemaskine max 12 kg");
        w2.addProgram(1, WASH_PROGRAM_1, WASH_PRICE_1 * FACTOR_12);
        w2.addProgram(2, WASH_PROGRAM_2, WASH_PRICE_2 * FACTOR_12);
        w2.addProgram(3, WASH_PROGRAM_3, WASH_PRICE_3 * FACTOR_12);
        w2.addProgram(4, WASH_PROGRAM_4, WASH_PRICE_4 * FACTOR_12);
        w2.addProgram(5, WASH_PROGRAM_5, WASH_PRICE_5 * FACTOR_12);
        w2.addProgram(6, WASH_PROGRAM_6, WASH_PRICE_6 * FACTOR_12);
        w2.addProgram(7, WASH_PROGRAM_7, WASH_PRICE_7 * FACTOR_12);
        
        laundryMachines[1] = w2;
        
        TumbleDryer t = new TumbleDryer("Tørre Tumbler");
        t.setPrice(TUMBLE_PRICE);
        
        laundryMachines[2] = t;
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       
        LaundrySingleton.getInstance().buildLaundry();
        
        System.out.println("Laundry:\n"+LaundrySingleton.getInstance());
        
        System.out.println("\n" + LaundrySingleton.getInstance().getMachine(0).getModel() +":");
        System.out.print (LaundrySingleton.getInstance().getProgName(0, 5) + "\t");
        System.out.println(String.format("%.2f", LaundrySingleton.getInstance().getPrice(0, 5)));

        System.out.println("\n" + LaundrySingleton.getInstance().getMachine(1).getModel() +":");
        System.out.print (LaundrySingleton.getInstance().getProgName(1, 5) + "\t");
        System.out.println(String.format("%.2f", LaundrySingleton.getInstance().getPrice(1, 5)));

        System.out.println("\n" + LaundrySingleton.getInstance().getMachine(2).getModel() +":");
        System.out.print (LaundrySingleton.getInstance().getProgName(2, 5) + "\t");
        System.out.println(String.format("%.2f", LaundrySingleton.getInstance().getPrice(2, 5)));

    }
    
}
