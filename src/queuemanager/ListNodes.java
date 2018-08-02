package queuemanager;

public class ListNodes<T>
{
    //this class is for setting up nodes, and their next node.
    //this class is used for sorted and unsorted linked list.
    private T item;
    public ListNodes<T> next;
    
    public ListNodes(T item, ListNodes<T> next)
    {
        this.item = item;
        this.next = next;
    }
    
    public T getItem()
    {
        return item;
    }
    
    public ListNodes<T> getNext()
    {
        return next;
    }
}
