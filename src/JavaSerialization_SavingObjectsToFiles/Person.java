/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSerialization_SavingObjectsToFiles;

import java.io.Serializable;

/**
 *
 * @author aalsc
 */
public class Person implements Serializable {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString(){
        return "Person [id="+id+", name ="+name+"].";
    }
}
