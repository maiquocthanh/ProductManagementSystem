
package Model;

import Controller.Utility;


public class Product {
    private String pcode;
    private String pro_name;
    private int quantity;
    private int saled;
    private double price;

    public Product() {
    }
    

    public Product(String pcode, String pro_name, int quantity, int saled, double price) {
        this.pcode = pcode;
        this.pro_name = pro_name;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSaled() {
        return saled;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void inputBookInfor() {
        System.out.print("Enter pcode: ");
        this.setPcode(Utility.inputString());
        System.out.print("Enter Product Name: ");
        this.setPro_name(Utility.inputString());
        System.out.print("Enter quanity: ");
        this.setQuantity(Utility.inputInt());
        while (true) {
            System.out.print("Enter Sale: ");
            this.setSaled(Utility.inputInt());
            if (saled> quantity) {
                System.out.println("Lended must not be larger than quantity (" + quantity + ")");
                continue;
            }
            break;
        }
        System.out.print("Enter price:");
        this.setPrice(Utility.inputDouble());
    }
/*
    @Override
    public String toString() {
        return String.format("%-5s%-5s%-5s%5s%10d%5s%10d%5s%10.1f%5s",
                pcode,"|",pro_name,"|",quantity,"|",saled,"|",price,"|");
                       
    }
 */   
    
}
