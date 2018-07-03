package queuemanager;

/*
encase this doesnt work, the class is to work like a unorderedlist/array, find the max element given and have
element sit at the end of the array/list. to remove an element would be to remove the last element of the list/array
and to then check all elements for the biggest number to go into the end of the list/array.
*/
public class MaxHeap  <T>  implements PriorityQueue<T> {
    
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
    
    public MaxHeap(int size)
    {
        top = null;

    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {

        if (this.top == null) {
            ListNodes node = new ListNodes(item,top);
            this.top = node;
            this.top.next = null;
        } else {
            ListNodes current = this.top;
            while (current.next != null) {
                current = current.next;
            }
 
            ListNodes node = new ListNodes(item,top);
            current.next = node;
            current.next.next = null;
        }
 
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
        String result = "Binary max heap number of nodes =" + size();
        result += ", contents = [";
                for(ListNodes<T> node = top; node != null; node = node.getNext())
                {
                    if(node != top)
                    {
                    
                    result += ", [";
                    }
                    result += node.getItem();
                    result += "]";
                }
                
        return result;
    }
    
    
}