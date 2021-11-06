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
public class IDedLinkedList <AnyType extends IDedObject> {
   
    Node head = null;
    
    public IDedLinkedList(){
        head = null;
    }

    class Node{
        
        public Node( AnyType d, Node n )
        {
            data = d; next = n;
        }
        public AnyType data;
        public Node next;
    }
    
    public boolean isEmpty(){
        return ((head == null) ? true: false);
    }
    
    public boolean hasNext(Node n){
        return ((n.next == null) ? false: true);
    }
    
    public void makeEmpty(){
        head = null;
    }
    
    public AnyType findID(int ID){
        //Checks if IdedLinkedList is empty
        if(isEmpty()) return null;
        
        Node current = new Node(null, null);
        current = head;
        boolean result;
        //Iterates through IDedLinkedList checking if ID is found
        do{
            if(current.data.getID() == ID) return (AnyType) current.data;
            result = hasNext(current);
            current = current.next;
        }while (result == true);
        
        //returns null if IDedLinkedList does not contain ID
        return null;
    }
    
    public boolean insertAtFront(AnyType MyItem){
        //Inserts MyItem at front when LinkedList is already empty
        if(isEmpty()){
            Node newNode = new Node(MyItem, null);
            head = newNode;
            return true;
        }
        //Checks if ID already exists and returns false if it does
        if( findID(MyItem.getID()) != null){
            return false;
        }
        //Inserts Node with MItem to the front of IdedLinkedList
        else{
            Node temp = head;
            Node newNode = new Node(MyItem, temp);
            head = newNode;
            return true;
        }
        
    }
    
    public AnyType deleteFromFront(){
        if(isEmpty()) return null;
        
        //Deleting front Node
        AnyType temp = head.data;
        head = head.next;
        
        return temp;
    }
    
    public AnyType delete(int ID){
        //Checks if IdedLinkedList is empty
        if(isEmpty()) return null;
        
        Node current = new Node(null, null);
        current = head;
        //Case for when argument matches ID of first Node
        if(head.data.getID() == ID) return deleteFromFront();
        
        //Iterates through IDedLinkedList checking if ID is found
        do{
            if(current.next.data.getID() == ID){
                //Deleting front Node
                AnyType temp = current.next.data;
                current.next = current.next.next;
                return temp;
            }
            current = current.next;
            
        }while (hasNext(current) == true);
        
        //returns null if IDedLinkedList does not contain ID
        return null;
        
    }
    
    public int printTotal(){
        if(isEmpty()) return -1;
        
        Node current = head;
        int sum = 0;
        boolean result;
        do{
            sum += current.data.getID();
            result = hasNext(current);
            current = current.next;
        }while(result == true);
        return sum;
    }
    
}
