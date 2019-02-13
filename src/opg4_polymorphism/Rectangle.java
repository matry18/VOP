/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opg4_polymorphism;

/**
 *
 * @author aalsc
 */
public class Rectangle extends AbstractShape {

    double l1;
    double l2;
    
    Rectangle(double l1, double l2) {
        this.l1=l1;
        this.l2=l2;
    }
    @Override
    public double getArea() {
        double area = l1*l2;
        return area;
    }

    @Override
    public double getCircumference() {
        double circumference = 2*(l1+l2);
        return circumference;
    }
    
}
