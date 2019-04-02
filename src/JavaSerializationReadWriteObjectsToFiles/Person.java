/*Serialization betyder at konvertere binær data fra en fil til læsbar data,
eller konvertere læsbar data til binær data og gemme det i en fil
 */
package JavaSerializationReadWriteObjectsToFiles;

import java.io.Serializable;

/**
 *
 * @author aalsc
 */
//importer interface osb. der er ikke nogle metoder i interfacet
public class Person implements Serializable {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person [id=" + id + ", name="+name +"]";
    }
    
}
