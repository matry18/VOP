/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_07_Call_Back_Interface_Facade;

import java.io.File;

/**
 *
 * @author erso
 */
public interface CallBackInterface {
    
    void updateMessage(String message);
    void updateImages(File i1, File i2);
    
}
