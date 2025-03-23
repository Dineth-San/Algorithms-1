import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node first;
    private int size;

    public RandomizedQueue(){
        first = null;
        size = 0;
    }

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public int size(){
        return size;
    }

    public void enqueue(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public Item dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        int n = size();
        int limit = StdRandom.uniformInt(n);
        int index = 0;
        Node temp = first;
        Node prev = null;
        while(index < limit){
            prev = temp;
            temp = temp.next;
            index++;
        }

        if (prev == null){
            first = first.next;
        }
        else{
            prev.next = temp.next;
        }

        size--;
        return temp.item;
    }

    public Item sample(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        int n = size();
        int limit = StdRandom.uniformInt(n);
        int index = 0;
        Node temp = first;

        while (index < limit){
            temp = temp.next;
            index++;
        }

        return temp.item;
    }

    @Override
    public Iterator<Item> iterator(){
        return new Iterator<Item>(){
            private Node current = first;

            @Override
            public boolean hasNext(){
                return current != null;
            }

            @Override
            public Item next(){
                if (!hasNext()){
                    throw new NoSuchElementException();
                }
                Item item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> Queue = new RandomizedQueue<Integer>();
        Queue.enqueue(3);
        Queue.enqueue(2);
        Queue.enqueue(1);
        Queue.enqueue(0);
        System.out.println(Queue.dequeue());
        System.out.println(Queue.sample());
        System.out.println(Queue.iterator());
    }
}
