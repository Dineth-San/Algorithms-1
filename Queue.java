public class Queue {
    public static enStack pushStack;
    public static deStack delStack;

    public static class Stack {

        public static class Node{
            String name;
            Node next;
        }
        Node first = null;

        public boolean isEmpty(){
            return (first == null);
        }
        public void push(String newName){
            Node oldFirst = first;
            first = new Node();
            first.name = newName;
            first.next = oldFirst;
        }
    }
    public static class enStack extends Stack{
        public Node pop(){
            Node returnFirst = first;
            first = first.next;
            return returnFirst;
        }
    }

    public static class deStack extends Stack{
        public Node pop(){
            if (delStack.isEmpty()){
                while(!pushStack.isEmpty()){
                    delStack.push(pushStack.pop().name);
                }
            }
            return delStack.first;
        }
    }

    public Queue() {
        pushStack = new enStack();
        delStack = new deStack();
    }


}
