package queuemanager;

//@param <T>
public class Unsortedlist <T>  implements PriorityQueue<T>{
    
   private ListNodes<T> top;

   //function used to determine the size of the list
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
    
    public Unsortedlist(int size)
    {
        top = null;

    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        
        
        
        // if first node
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