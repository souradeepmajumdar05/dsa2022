package dataStructure;

import java.util.PriorityQueue;

public class Test {

    int[] heap=new int[40];
    int size = -1;

    // retrieving the parent node of the child node
    int parent(int i) {

        return (i - 1) / 2;
    }

    // retrieving the left child of the parent node.
    int left_child(int i) {
        return i + 1;
    }
    // retrieving the right child of the parent
    int right_child(int i) {
        return i + 2;
    }
    // Returning the element having the highest priority
    int get_Max() {
        return heap[0];
    }
    //Returning the element having the minimum priority
    int get_Min() {
        return heap[size];
    }
    // function to move the node up the tree in order to restore the heap property.
    void moveUp(int i) {
        while (i > 0) {
            // swapping parent node with a child node
            if (heap[parent(i)] < heap[i]) {

                int temp;
                temp = heap[parent(i)];
                heap[parent(i)] = heap[i];
                heap[i] = temp;

            }
            // updating the value of i to i/2
            i = i / 2;
        }
    }

    //function to move the node down the tree in order to restore the heap property.
    void moveDown(int k) {
        int index = k;

        // getting the location of the Left Child
        int left = left_child(k);

        if (left <= size && heap[left] > heap[index]) {
            index = left;
        }

        // getting the location of the Right Child
        int right = right_child(k);

        if (right <= size && heap[right] > heap[index]) {
            index = right;
        }

        // If k is not equal to index
        if (k != index) {
            int temp;
            temp = heap[index];
            heap[index] = heap[k];
            heap[k] = temp;
            moveDown(index);
        }
    }

    // Removing the element of maximum priority
    void removeMax() {
        int r = heap[0];
        heap[0] = heap[size];
        size = size - 1;
        moveDown(0);
    }
    //inserting the element in a priority queue
    void insert(int p) {
        size = size + 1;
        heap[size] = p;

        // move Up to maintain heap property
        moveUp(size);
    }

    //Removing the element from the priority queue at a given index i.
    void delete(int i) {
        heap[i] = heap[0] + 1;

        // move the node stored at ith location is shifted to the root node
        moveUp(i);

        // Removing the node having maximum priority
        removeMax();
    }
    public static void main(String[]args){
        // Inserting the elements in a priority queue
        Test t=new Test();
        t.insert(20);
        t.insert(19);
        t.insert(16);
        t.insert(21);
        t.insert(18);
        t.insert(12);
        t.insert(17);
        t.insert(15);

        t.insert(14);
        //int i = 0;

        System.out.println("Elements in a priority queue are : ");
        for (int i = 0; i <= t.size; i++) {
            System.out.println( t.heap[i]);
        }
        t.delete(2); // deleting the element whose index is 2.
        System.out.println("\nElements in a priority queue after deleting the element are : ");
        for (int i = 0; i <= t.size; i++) {
            System.out.println( t.heap[i]);
        }
        int max = t.get_Max();
        System.out.println("The element which is having the highest priority is : "+ max);

        int min = t.get_Min();
        System.out.println("The element which is having the minimum priority is : " + min);

    }
//    public static void main(String[]args){
//        PriorityQueue<Integer> pq=new PriorityQueue();
//        pq.add(1);
//    }
}
