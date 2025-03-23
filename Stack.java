public class Stack {
    private Node first = null;

    private static class Node{
        int name;
        Node next;
    }

    public void push(int newName){
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.name = newName;
    }

    public void pop(){
        first = first.next;
    }

    public static void main(String[] args) {
        Stack LLStack = new Stack();
        for (int i = 0; i < 6; i++){
            LLStack.push(i);
        }
        LLStack.pop();
        while(LLStack.first.next != null){
            System.out.println(LLStack.first.name);
            LLStack.first = LLStack.first.next;
        }
    }

}