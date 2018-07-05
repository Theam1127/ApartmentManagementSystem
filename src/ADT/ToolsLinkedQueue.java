package ADT;

import EntityClass.Tools;
import EntityClass.ToolsInterface;

public class ToolsLinkedQueue<T extends Comparable<T>> implements ToolsQueueInterface<T> {
    
    private Node firstNode = null; // references node at front of queue
    private Node lastNode = null;  // references node at back of queue
    private int counter = 0;
    ToolsInterface tools = new Tools();
    
    public T deleteTools(int toolPosition){
        Node tempNode = null;
        Node currentNode = firstNode;
        T result = null;
        if(toolPosition > counter || toolPosition < 1){
            System.out.println("Record not found. Please make sure you have selected the correct position.");
        }
        else if(counter == 1){
            result = firstNode.data;
            firstNode = null;
            lastNode = null;
        }
        else{
            if(toolPosition == 1){
                result = firstNode.data;
                firstNode = firstNode.next;
            }
            else{
                for(int a = 1; a < toolPosition - 1; a++){
                    currentNode = currentNode.next;
                }
                if(currentNode.next == lastNode){
                    result = lastNode.data;
                    currentNode.next = null;
                    lastNode = currentNode;
                    
                }
                else{
                    result=currentNode.next.data;
                    currentNode.next = currentNode.next.next;
                }
            }
            counter--;
        }
        return result;
    }
    
    public void updateTools(int toolPosition, T newEntry){
        Node currentNode = firstNode;
        
        if(toolPosition > counter || toolPosition < 1){
            System.out.println("Record not found. Please make sure you have selected the correct position.");
        }
        else if(counter == 1){
            firstNode.data = newEntry;
            lastNode.data = newEntry;
        }
        else{
            if(toolPosition == 1)
                firstNode = firstNode.next;
            else{
                for(int a = 1; a < toolPosition - 1; a++){
                    currentNode = currentNode.next;
                }
                if(currentNode.next == lastNode){
                    currentNode.next = null;
                    lastNode = currentNode;
                    
                }
                else
                    currentNode.next = currentNode.next.next;
            }
            counter--;
            enqueue(newEntry);
        }
    }
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry);
        Node tempNode = firstNode;
        Node beforeTempNode = tempNode;
        
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
            counter++;
        } 
        else {
            if(newEntry.compareTo(firstNode.data) >= 0){
                newNode.next = firstNode;
                firstNode = newNode;
                
            }
            else if(newEntry.compareTo(lastNode.data) <= 0){
                lastNode.next = newNode;
                lastNode = newNode;
            }
            else{
                while(newEntry.compareTo(tempNode.data) < 0){
                    beforeTempNode = tempNode;
                    tempNode = tempNode.next;
                }
                newNode.next = tempNode;
                beforeTempNode.next = newNode;
            }
            counter++;
        }
    } // end enqueue

    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = firstNode.data;
        }

        return front;
    } // end getFront

    public T dequeue() {
        T result = null;

        if (!isEmpty()) {
            result = firstNode.data;
            
            if (firstNode == lastNode) {
                firstNode = null;
                lastNode = null;
            }
            else{
                firstNode = firstNode.next;
            }
    } // end if

        return result;
    } // end dequeue

    public boolean isEmpty() {
        return lastNode == null;
    } // end isEmpty
    
    public boolean displayTools() {
        Node tempNode = firstNode;
        T result = null;
        int count = 1;
        if(isEmpty()){
            System.out.println("Currently no tools in tools list.");
            return false;
        }
        else{
            while(tempNode != null){
                result = tempNode.data;
                System.out.println(count+".\n"+result.toString());
                tempNode = tempNode.next;
                count++;
            }
        return true;
        }
    }
    
    int countNodesBefore = 0;
    int countNodes;
    public boolean displayToolsByLevel(int level){
        Node tempNode = firstNode;
        T result = null;
        countNodesBefore = 0;
        int count = 1;
        if(isEmpty()){
            System.out.println("Currently no tools in tools list.");
            return false;
        }
        else{
            System.out.println("Tools Available: ");
            while(tempNode!=null){
                result = tempNode.data;
                tools = new Tools((ToolsInterface)result);
                if(tools.getEmergencyLevel()==level){
                    System.out.println(count+".\n"+tools.toString());
                    count++;
                }
                else if(level == 3)
                    countNodesBefore = 0;
                else if(level == 2 && tools.getEmergencyLevel()==3){
                    countNodesBefore++;
                }
                else if(level==1 && tools.getEmergencyLevel()==2||tools.getEmergencyLevel()==3)
                    countNodesBefore++;
                tempNode = tempNode.next;
            }
            if(count == 1){
                System.out.println("Currently no tools available for this request");
            }
            countNodes = count-1;
            return true;
        }
    }
    
    public int getCountNodes(){
        return this.countNodes;
    }
    
    public int getTotalNodesBefore(){
        return this.countNodesBefore;
    }
    
    public int getLength(){
        return this.counter;
    }
    
    private class Node {
        private T data; // entry in queue
        private Node next; // link to next node

        private Node(T data) {
            this.data = data;
            this.next = null;
        } // end constructor

        private Node(T data, Node next){
            this.data = data;
            this.next = next;
        } // end constructor
    } // end Node
}
