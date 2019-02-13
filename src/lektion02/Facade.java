
package lektion02søgogerstat;

/**
 *
 * @author aalsc
 */
public class Facade {
    public static String SearchAndReplace(String txtSearchField, String txtReplaceField, String txtArea) {
        return txtArea.replaceAll(txtSearchField, txtReplaceField);
                //String txtAre.setText();
    }
            
            
    
}
