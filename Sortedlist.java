/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author Ben
 */
public class Sortedlist <T>  implements PriorityQueue<T> {
    
    private ListNodes<T> top;

    private int size()
    {
        ListNodes<T> node = top;
        int result = 0;
        while(node != null)
        {
            result = result + 1;
            node = node.getNext();
        }
        return result;
    }
    
    public Sortedlist(int size)
    {
        top = null;

    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        top = new ListNodes<>(item,top);
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return top.getItem();
        }
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } 
        top = top.getNext();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
    @Override
    public String toString() {
        String result = "Sorted Linked list size =" + size();
        result += ", contents = [";
                for(ListNodes<T> node = top; node != null; node = node.getNext())
                {
                    if(node != top)
                    {
                    result += ", ";
                    }
                    result += node.getItem();
                }
        return result;
    }
    
    
}