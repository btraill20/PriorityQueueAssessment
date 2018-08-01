package queuemanager;

/*
encase this doesnt work, the class is to work like a unorderedlist/array, find the max element given and have
element sit at the end of the array/list. to remove an element would be to remove the last element of the list/array
and to then check all elements for the biggest number to go into the end of the list/array.
*/
public class MaxHeap  <T>  implements PriorityQueue<T> {
    
    private ListNodes<T> top;
//    private ListNodes<T> left;
//    private ListNodes<T> right;
//    private ListNodes<T> priority;

    private final Object[] storage;
    private final int capacity;
    private int index;
    
    int arr[];
    
    public MaxHeap(int size){
        top = null;
        storage = new Object[size];
        capacity = size;
        index = -1;
    }
    
    public void sort(){
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    private void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
    //used to check parent node for size before adding
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (index >= capacity)
        {
            index = index - 1;
            throw new QueueOverflowException();
        }
 
        // First insert the new key at the end
        index++;
        int i = index - 1;
        storage[i] = priority;
       
    }

    @Override
    public void remove() throws QueueUnderflowException {
        
    }
    
    @Override
    public T head() throws QueueUnderflowException {
        return null;
    }
    
    private int size(){
        ListNodes<T> node = top;
        int result = 0;
        while(node != null){
            result = result + 1;
            node = node.getNext();
        }
        return result;
    }
    
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= index; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
    
    @Override
    public boolean isEmpty() {
        return index < 0;
    }
}