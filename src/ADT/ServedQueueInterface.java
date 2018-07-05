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
public interface ServedQueueInterface<T>{
    public void enqueue(T newEntry);
    public T dequeue();
    public boolean displayServed();
    public void updateServed(int position, T newEntry);
    public T getServed(int position);
    public int getSize();
    public boolean isEmpty();
    
}
