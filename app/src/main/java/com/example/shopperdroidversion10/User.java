package com.example.shopperdroidversion10;

import java.util.ArrayList;

public class User {
    //Name and Username
    private String name;
    private String usrn;
    //List for everything in the kitchen
    private ArrayList<Item> Klist;
    //List for everything on the grocery List
    private ArrayList<Item> Glist;
    public User(String name, String usrn){
        this.name = name;
        this.usrn = usrn;
        Klist = new ArrayList<Item>();
        Glist = new ArrayList<Item>();
    }
    public String getName(){
        return name;
    }
    public ArrayList<Item> getKlist(){
        return Klist;
    }
    public ArrayList<Item> getGlist(){
        return Glist;
    }
    public void addKL(Item item){
        Klist.add(item);
    }
    public void addGL(Item item){
        Glist.add(item);
    }
    public Item KLitem(int i){
        return Klist.get(i);
    }
    public Item GLitem(int i){
        return Glist.get(i);
    }
}
