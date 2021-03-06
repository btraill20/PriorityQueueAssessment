package queuemanager;

//current issue is getting the heap methods to work, as im having issues with 
//autoboxing and such, i think if i used a linked list i wouldnt have this issue.
public class MaxHeap  <T>  implements PriorityQueue<T> {
        

    private final Object[] storage;
    private final int capacity;
    private int index;
    
    
    public MaxHeap(int size){
        storage = new Object[size];
        capacity = size;
        index = -1;
    }
    
    //method to sort the array into a max heap but making the largest priority number sit in the root.
    private void sort() {
        int length = storage.length;
        buildMaxHeap(storage, length);
        Integer[] c = new Integer[storage.length];
        for(int i = 0; i < storage.length; i++)
        {
            c[i] = (Integer) storage[i];
        }
        //this loop checks each node for size.
        for(int i = length - 1; i > 0; i--) {
            int temp = c[0];
            c[0] = c[i];
            c[i] = temp;
            buildMaxHeap(c, i);
        }
    }
    
    //this is to build the Max heap
    private void buildMaxHeap(Object[] storage, int heapSize) {
        if(storage == null) {
            throw new NullPointerException("null");
        }
        if(storage.length <=0 || heapSize <= 0) {
            throw new IllegalArgumentException("illegal");
        }
        if(heapSize > storage.length) {
            heapSize = storage.length;
        }

        for(int i = heapSize/2; i > 0; i--) {
            heapify(storage, i, heapSize);
        }
    }
    
    //this is to check each node for size and swap nodes from left to right so the largest is always top.
    private void heapify(Object[] storage, int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
        
        // If left child is larger than root
        if (l <= n) {
            if (l >= largest) {
                largest = l;
            }
        }
 
        // If right child is larger than largest so far
        if (r <= n) {
            if (r > largest) {
                largest = r;
            }
        }
 
        // If largest is not root
        if (largest != i)
        {
            int swap = (int) storage[i];
            storage[i] = storage[largest];
            storage[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(storage,n, largest);
        }
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        index = index + 1;
        if (index >= capacity)
        {
            index = index - 1;
            throw new QueueOverflowException();
        }else {
            /* Scan backwards looking for insertion point */
            int i = index;
            storage[i] = new PriorityItem<>(item, priority);
            sort();
        }      
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            for (int i = 0; i < index; i++) {
                storage[i] = storage[i + 1];
            }
            index = index - 1;
        }
    }
    
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>) storage[0]).getItem();
        }
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