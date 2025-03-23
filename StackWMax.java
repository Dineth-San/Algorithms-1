public class StackWMax {
    double max;
    public static class Node{
        double value;
        Node next;
    }

    Node first = null;

    public void push(double val){
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.value = val;
        if (val > max){
            max = val;
        }
    }

    public void pop(){
        first = first.next;
    }

    public double returnMax(){
        return max;
    }
}
