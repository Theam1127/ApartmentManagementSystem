package ADT;

public interface ToolsQueueInterface<T extends Comparable<T>> {
    public void enqueue(T newEntry);
    public T dequeue();
    public T getFront();
    public boolean isEmpty();
    public boolean displayTools();
    public boolean displayToolsByLevel(int level);
    public int getTotalNodesBefore();
    public int getCountNodes();
    public T deleteTools(int toolPosition);
    public int getLength();
    public void updateTools(int toolPosition, T newEntry);
}
