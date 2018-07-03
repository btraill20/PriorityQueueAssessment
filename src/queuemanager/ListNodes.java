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
public class ListNodes<T>
{
    //this class is for setting up nodes, and their next node.
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
