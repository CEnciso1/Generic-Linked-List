/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project2;

/**
 *
 * @author CHRIS
 */
import java.util.*;
public class MyItem implements IDedObject{
    
    private int itemID;
    private int itemPrice;
    private List<Integer> itemDescription = new LinkedList<>();     //Holds item description as the item description is a list of integers
    
    public MyItem(int itemID, int itemPrice, List<Integer> itemDescription){
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        setItemDescription(itemDescription);
    }
    
    public int getID(){
        return itemID;
    }
    int getItemPrice(){
        return itemPrice;
    }
    List<Integer> getItemDescription(){
        return itemDescription;
    }
    
    public void setItemDescription(List<Integer> list){
        for(int i: list){
            itemDescription.add(i);
        }
    }
    
    public String printID(){
        String result = "";
        
        result += getID() + " " + getItemPrice()+ " ";
        
        for(int i: itemDescription){
            result += i + " ";
        }
        return result;
    }
    
}
