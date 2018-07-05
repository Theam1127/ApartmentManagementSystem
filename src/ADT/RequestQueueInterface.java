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
public interface RequestQueueInterface<T extends Comparable<T>> {
    public void addNewRequest(T newEntry);
    public void updateRequest(int position, T newEntry);
    public void removeRequest(int position);
    public T dequeue();
    public boolean displayEntry();
    public int getLength();
    public T getFront();
    public boolean isEmpty();
}
