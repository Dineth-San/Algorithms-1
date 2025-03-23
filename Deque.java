import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node{
        Item item;
        Node next;
        Node prev;
    }
    private Node head;
    private Node tail;
    private int size;

    public Deque(){
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty(){
        return (head == null && tail == null);
    }

    public int size(){
        return size;
    }

    public void addFirst(Item item){
        if (item == null){
            throw new IllegalArgumentException("null cannot be an argument");
        }
        Node newNode = new Node();
        size++;
        newNode.item = item;
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            Node oldHead = head;
            head.prev = newNode;
            head = newNode;
            head.next = oldHead;
        }
    }

    public void addLast(Item item){
        if (item == null){
            throw new IllegalArgumentException("null cannot be an argument");
        }
        Node newNode = new Node();
        size++;
        newNode.item = item;
        if (tail == null){
            tail = newNode;
            head = newNode;
        }
        else{
            Node oldTail = tail;
            tail.next = newNode;
            tail = newNode;
            tail.prev = oldTail;
        }
    }

    public Item removeFirst(){
        if (head == null){
            throw new NoSuchElementException();
        }
        Node oldHead = head;
        if (head.next == null){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
        }
        size--;
        return oldHead.item;
    }

    public Item removeLast(){
        if (tail == null){
            throw new NoSuchElementException();
        }
        Node oldTail = tail;
        if (tail.prev == null){
            tail = null;
            head = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return oldTail.item;
    }
    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = head;

        @Override
        public boolean hasNext(){
            return current != null;
        }

        @Override
        public void remove(){

        }

        @Override
        public Item next(){
            if (hasNext()){
                Item item = current.item;
                current = current.next;
                return item;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deck = new Deque<Integer>();
        deck.addFirst(2);
        deck.addLast(3);
        deck.addFirst(1);
        System.out.println(deck.size());
        System.out.println(deck.removeFirst());
        System.out.println(deck.removeLast());
        System.out.println(deck.isEmpty());
        System.out.println(deck.iterator());
    }
}
