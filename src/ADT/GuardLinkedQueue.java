/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import EntityClass.GuardInterface;


/**
 *
 * @author JE
 */
public class GuardLinkedQueue <T extends Comparable<T>> implements GuardQueueInterface<T>{
    
    private Node lastNode = null;
    private Node firstNode = null;
    private int counter = 0;
    
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry);
        Node tempNode = firstNode;
        Node beforeTempNode = tempNode;
        int noOfMove = 0;
        
        
        if(isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
            tempNode = firstNode;
            counter++;
        }
        else{
            if(newEntry.compareTo(firstNode.data)>=0){   //add at to the front
                newNode.next = firstNode;
                firstNode = newNode;
                tempNode = firstNode;
                beforeTempNode = tempNode;
            }
            else if(newEntry.compareTo(lastNode.data)<=0){   //add at last
                lastNode.next = newNode;
                lastNode = newNode;
            }
            else{  //add at middle
                while(newEntry.compareTo(tempNode.data)<0){
                    tempNode = tempNode.next;
                    noOfMove++;
                }
                for(int i=0;i<noOfMove-1;i++){
                    beforeTempNode = beforeTempNode.next;
                }
                
                newNode.next = tempNode;
                beforeTempNode.next = newNode;
            }
            counter++;
        }
        
        
    }

    public T dequeue(int requestLv) {
        T result = null; 
        int guardLv;
        int noOfMove = 0;
        Node tempNode = firstNode;
        Node beforeTempNode = firstNode;
        
        
        
        if(!isEmpty()){
            for(int a = 0; a<counter;a++){  // finding request lv same with Guard lv
                noOfMove++;
                guardLv = ((GuardInterface)tempNode.data).getLv();  //getting tempNode data(first node) lv
                if(guardLv == requestLv){
                    result = tempNode.data;
                    counter--;
                    break;
                }
                else {  //no suitable lv Guard available
                    result = null;
                    if(tempNode.next != null)
                        tempNode = tempNode.next;
                }  
            }
            
            if(result == null){   //finding Guard lv > request lv
                noOfMove = 0;
                for(int a = 0 ; a<counter;a++){
                    noOfMove++;
                    guardLv = ((GuardInterface)tempNode.data).getLv();
                    if(guardLv > requestLv){
                    result = tempNode.data;
                    counter--;
                    break;
                }
                else {  //no suitable lv Guard available
                    result = null;
                    if(tempNode.next != null)
                        tempNode = tempNode.next;
                    }
                }
            }
            
            
            //connecting the node which have data
            if(noOfMove == 1){
                firstNode = firstNode.next;
            }
            else if (result != null){
                for(int a=1;a<noOfMove-1;a++){
                    beforeTempNode = beforeTempNode.next;
                }
                beforeTempNode.next = tempNode.next;
            }
            if(tempNode == lastNode){  //if dequeue the lastnode item
            lastNode = beforeTempNode;
            } 
        }
        
        if(counter == 0){
            firstNode = null;
            lastNode = null;
        }
        
        if(result == null){
            System.out.println();
            System.out.println("***No Suitable Guard Available***");
        }
            
        
        return result;
    }

    public boolean displayGuardList() {
        T result = null;
        Node tempNode = firstNode;
        int tempCounter = counter;
        int no = 0;
        
        System.out.println("Guard List");
        System.out.println("==========");
        if(!isEmpty()){
            while(tempCounter != 0){
            System.out.print((no+1)+") " + "Guard Name: "+((GuardInterface)tempNode.data).getGuardName()+"     " +
                    "Guard Experience: "+ ((GuardInterface)tempNode.data).getExp()+"    "+
                    "Guard Level: "+ ((GuardInterface)tempNode.data).getLv());
            System.out.println();
            no++;
            tempNode = tempNode.next;
            tempCounter--;
           }
            return true;
        }
        else{
            System.out.println("The Guard List is empty. All guard is on duty.");
            return false;
        }
        
    }
    public void deleteGuard(int position){
        Node tempNode = firstNode;
        Node beforeTempNode = firstNode;
        
        if(position>counter || position<1){
            System.out.println("Record not found. Please make sure you have selected the correct position.");
        }
        else if(counter == 1){
            firstNode = null;
            lastNode = null;
            counter--;
        }
        else{
            if(position == 1){
                firstNode = firstNode.next;
                counter--;
            }
            else {
                for(int a=1;a<position;a++)
                    tempNode = tempNode.next;
                for(int a=1;a<position-1;a++)
                    beforeTempNode = beforeTempNode.next;
                beforeTempNode.next = tempNode.next;
                counter--;
                if(tempNode == lastNode)
                    lastNode = beforeTempNode;
            }
        }
    }
    public void updateGuard(int position,T newEntry){
        Node tempNode = firstNode;
        Node beforeTempNode = firstNode;
        
        if(position>counter || position<1){
            System.out.println("Record not found. Please make sure you have selected the correct position.");
        }
        else{
            if(position == 1){
                deleteGuard(position);
                enqueue(newEntry);
            }
            else{
                for(int a=1;a<position;a++)
                    tempNode = tempNode.next;
                tempNode.data = newEntry;
                deleteGuard(position);
                enqueue((T) tempNode.data);
            }
        }
        
    }
    
    public boolean isEmpty() {
         return lastNode == null;
    }
    
    public int getCounter(){
        return this.counter;
    }
    
    
    
    private class Node{
        private T data;
        private Node next;
        
        private Node(T data){
            this.data = data;
            this.next = null;
        }
        private Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
        
    }
    
    
}
