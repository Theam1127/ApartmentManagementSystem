/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;
/**
 *
 * @author Yeap Theam
 */
public class RequestDLinkedQueue<T extends Comparable<T>> implements RequestQueueInterface <T> {
    private Node topNode;
    private Node lastNode;
    private int size = 0;
    
    public RequestDLinkedQueue(){
        topNode = null;
        lastNode = null;
    }
    
    public void addNewRequest(T newEntry) {
	Node newNode = new Node(newEntry);
        Node nodeBefore = null;
        Node endNode = lastNode;
        if(isEmpty()){
            topNode = newNode;
            lastNode = topNode;
        }
        else{
                while(endNode!=null && newEntry.compareTo(endNode.data)>0){
                    nodeBefore = endNode;
                    endNode = endNode.previous;
                }
               
               
               
               if(nodeBefore != null && endNode!=null){
                   newNode.previous = endNode;
                   endNode.next = newNode;
                   nodeBefore.previous = newNode;
                   newNode.next = nodeBefore;
                }
               
                
                else{
                   if(newEntry.compareTo(lastNode.data)==0 || newEntry.compareTo(lastNode.data)<0){
                       lastNode.next = newNode;
                       newNode.previous = lastNode;
                       lastNode = newNode;
                   }
                   else if(newEntry.compareTo(topNode.data)>0){
                       newNode.next = topNode;
                       topNode.previous = newNode;
                       topNode = newNode;
                   }
                }   
            }
        size++;
            
    }
    
    public boolean displayEntry(){
        Node currentNode = topNode;
        T result = null;
        int count = 1;
        if(currentNode==null){
            System.out.println("Currently no entries in the database.");
            return false;
        }
        else{
        while(currentNode!=null){
            result = currentNode.data;
            System.out.println(count+". \n"+result.toString());
            currentNode = currentNode.next;
            count++;
        }
        return true;
        }
    }
    
    public T getFront(){
        if(!isEmpty())
            return topNode.data;
        else
        {
            System.out.println("Currently no entries in the list.");
            return null;
        }
    }
    
    public void updateRequest(int position, T newEntry){
        Node tempNode = null;
        Node currentNode = topNode;
        if(position>size || position<1){
            System.out.println("Record not found. Please make sure you have selected the correct position");
        }
        else if(size == 1){
            topNode.data = newEntry;
            lastNode.data = newEntry;
        }
        else{
            if(position == 1){
                topNode = topNode.next;
                topNode.previous = null;
            }
            else if(position == size){
                lastNode = lastNode.previous;
                lastNode.next = null;
            }
            else{
                for(int a=1;a<position;a++){
                    tempNode = currentNode;
                    currentNode = currentNode.next;
                }
                tempNode.next = currentNode.next;
                currentNode.next.previous = tempNode;
                currentNode.previous = null;
                currentNode.next = null;
                currentNode = null;   
            }
            size --;
            addNewRequest(newEntry);
        }
        
    }
    
    public int getLength(){
        return this.size;
    }
    
    public T dequeue(){
        T result = null;
        result = topNode.data;
        if(size == 1){
           topNode = null;
           lastNode = null;
        }
        else{
            topNode = topNode.next;
            topNode.previous = null;
        }
        return result;
    }
    
    public void removeRequest(int position) {
        Node tempNode = null;
        Node currentNode = topNode;
        if(position>size || position<1){
            System.out.println("Record not found. Please make sure you have selected the correct position");
        }
        else if(size==1){
            topNode = null;
            lastNode = null;
        }
        else{
            if(position == 1){
                topNode = topNode.next;
                topNode.previous = null;
            }
            else if(position == size){
                lastNode = lastNode.previous;
                lastNode.next = null;
            }
            else{
                for(int a=1;a<position;a++){
                    tempNode = currentNode;
                    currentNode = currentNode.next;
                }
                tempNode.next = currentNode.next;
                currentNode.next.previous = tempNode;
                currentNode.previous = null;
                currentNode.next = null;
                currentNode = null;
                
                
                
            }
            size --;
        }
    }
    

    public boolean isEmpty() {
        return lastNode == null;
    }
    
    
    private class Node {

    private T data;
    private Node next;
    private Node previous;

    private Node(T data) {
      this.data = data;
      this.next = null;
      this.previous = null;
    }

    private Node(T data, Node next, Node previous) {
      this.data = data;
      this.next = next;
      this.previous = previous;
    }
  } 

}







/*
Node newNode = new Node(newEntry);
        Node nodeBefore = null;
        Node tempNode2 = null;
        Node startNode = topNode;
        Node endNode = lastNode;
        if(endNode==null||startNode==null){
            topNode = newNode;
            lastNode = topNode;
        }
        else{
                while(endNode!=null && newEntry.compareTo(endNode.data)>0){
                    nodeBefore = endNode;
                    endNode = endNode.previous;
                }
                while(startNode!=null && newEntry.compareTo(startNode.data)<0){
                    tempNode2 = startNode;
                    startNode = startNode.next;
                }
                if(nodeBefore==null||tempNode2==null){
                    if(nodeBefore == null){
                        newNode.previous = lastNode;
                        lastNode.next = newNode;
                        lastNode = newNode;
                    }
                    else if(tempNode2 == null){
                        newNode.next = topNode;
                        topNode.previous = newNode;
                        topNode = newNode;
                    }
                }
                else{
                    newNode.previous = endNode;
                    newNode.next = startNode;
                    nodeBefore.previous = newNode;
                    tempNode2.next = newNode;
                }
            }
*/

/*
Node newNode = new Node(newEntry);
        Node nodeBefore = null;
        Node currentNode = topNode;
        
        while(currentNode!= null && newEntry.compareTo(currentNode.data)>0){
            nodeBefore = currentNode;
            currentNode = currentNode.next;
        }
        if(nodeBefore == null){
            topNode = newNode;
            lastNode = topNode;
        }
        else{
            nodeBefore.next = newNode;
            newNode.next = currentNode;
        }

*/

/*
while(startNode!=null && newEntry.compareTo(startNode.data)<0){
                   tempNode2 = startNode;
                   startNode = startNode.next;
               }

else if(tempNode2 != null && startNode!=null){
                   newNode.next = startNode;
                   startNode.previous = newNode;
                   tempNode2.next = newNode;
                   newNode.previous = tempNode2;
                }

*/