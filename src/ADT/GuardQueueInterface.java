/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author JE
 */
public interface GuardQueueInterface<T extends Comparable<T>>  {
    public void enqueue(T newEntry);
    public T dequeue(int requestLv);
    public boolean displayGuardList();
    public int getCounter();
    public boolean isEmpty();
    public void updateGuard(int position , T newEntry);
    public void deleteGuard(int position);
    
}
