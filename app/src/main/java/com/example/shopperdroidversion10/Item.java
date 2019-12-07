package com.example.shopperdroidversion10;

import java.text.SimpleDateFormat;

public class Item {
    private String Name;
    private int Quantity;
    private SimpleDateFormat ExpirDate;

    public Item(String Name, int Quantity, SimpleDateFormat ExpirDate){
        this.Name = Name;
        this.Quantity = Quantity;
        this.ExpirDate = ExpirDate;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public int getQuantity(){
        return Quantity;
    }
    public void setQuantity(int Quantity){
        this.Quantity = Quantity;
    }
    public SimpleDateFormat getExpirDate(){
        return ExpirDate;
    }
    public void setExpirDate(SimpleDateFormat ExpirDate){
        this.ExpirDate = ExpirDate;
    }

    public String toString(){
        String StrQ = Integer.toString(this.Quantity);
        String StrE = this.ExpirDate.toString();

        return this.Name + StrQ + StrE;
    }
}
