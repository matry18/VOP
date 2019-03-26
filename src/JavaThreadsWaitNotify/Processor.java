/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaThreadsWaitNotify;

import java.util.Scanner;

/**
 *
 * @author aalsc
 */
public class Processor {

    public void produce() throws InterruptedException {
        synchronized (this) { //der synkroniseres med dette objekt - derfor (this)
            System.out.println("Producer thread running...");
            wait();
            System.out.println("Resumed...");

        }
    }

    public void comsume() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("Waiting for return key (Enter) to be presed.");
            scan.nextLine();
            System.out.println("Return key pressed!");
            notify(); //vil notify andre tråde, der er låst på (this)
            Thread.sleep(5000);//notify bliver først sendt videre til en anden tråd, når kodeblokken er færdig (har ventet i 5 sek).

        }
    }

}
