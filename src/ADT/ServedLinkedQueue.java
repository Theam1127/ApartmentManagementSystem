/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import EntityClass.User;
import EntityClass.UserInterface;

/**
 *
 * @author Yeap Theam
 */
public class ServedLinkedQueue<T> implements ServedQueueInterface<T> {
    private Node topNode = null;
    private Node lastNode = null;
    private int size = 0;
    UserInterface user = new User();
    
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry);
        if(isEmpty()){
            topNode = newNode;
            lastNode = topNode;
        }
        else if(topNode == lastNode){
            lastNode = newNode;
            topNode.next = lastNode;
        }
        else{
            lastNode.next = newNode;
            lastNode = newNode;
        }
        size++;
    }
    public T dequeue() {
        T result = null;
        if(!isEmpty()){
            if(topNode == lastNode){
               result  = topNode.data;
               topNode = null;
               lastNode = null;
            }
            else{
                result = topNode.data;
                topNode = topNode.next;
            }
            size--;
        }
        return result;
    }
    
    public T getServed(int position){
        Node currentNode = topNode;
        T result = null;
        if(!isEmpty()){
            if(position == 1)
                result = topNode.data;
            else{
                for(int a=1;a<position-1;a++){
                    currentNode = currentNode.next;
                }
                result = currentNode.next.data;
            }
        }
        else{
            System.out.println("Record not found. Please make sure you have selected the correct position. ");
        }
        return result;
    }
    
    public void updateServed(int position, T newEntry){
        Node currentNode = topNode;
        T result = null;
            if(position == 1)
                topNode.data = newEntry;
            else{
                for(int a = 1; a < position - 1; a++){
                    currentNode = currentNode.next;
                }
                currentNode.next.data = newEntry;
            }
    }
    
    
    public boolean displayServed() {
	int countLevel1=0;
   	int countLevel2=0;
    	int countLevel3=0;
        Node tempNode = topNode;
        T result = null;
        int count = 1;
        if(isEmpty()){
            System.out.println("Currently no entries in served list.");
            return false;
        }
        else{
            while(tempNode != null){
                result = tempNode.data;
                user = new User((UserInterface)result);
                System.out.println("Report");
                System.out.println("=======");
                System.out.println(count+".\n"+user.toString());
                if(user.getRequest().getLevel()==3)
                    countLevel3++;
                else if(user.getRequest().getLevel()==2)
                    countLevel2++;
                else
                    countLevel1++;
                tempNode = tempNode.next;
                count++;
            }
            System.out.println("Total level 3 served requests > "+countLevel3);
            System.out.println("Total level 2 served requests > "+countLevel2);
            System.out.println("Total level 1 served requests > "+countLevel1);
            return true;
        }
    }
    
    public int getSize(){
        return this.size;
    }
    
    public boolean isEmpty() {
        return topNode==null;
    }
    
    
    private class Node {

    private T data;
    private Node next;

    private Node(T dataPortion) {
      data = dataPortion;
      next = null;
    }

    private Node(T dataPortion, Node nextNode) {
      data = dataPortion;
      next = nextNode;
    }
  }
}

