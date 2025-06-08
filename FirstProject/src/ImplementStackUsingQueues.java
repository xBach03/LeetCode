import java.util.ArrayList;

public class ImplementStackUsingQueues {
    static class MyStack {

        ArrayList<Integer> queue1;
        ArrayList<Integer> queue2;
        int index;

        public MyStack() {
            queue1 = new ArrayList<>();
            queue2 = new ArrayList<>();
            index = 0;
        }

        public void push(int x) {
            queue1.add(x);
            queue2.add(index++);
        }

        public int pop() {
            return queue1.remove((int) queue2.get(--index));
        }

        public int top() {
            index--;
            return queue1.get(queue2.get(index++));
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack s1 = new MyStack();
        s1.push(1);
        s1.push(2);
        System.out.println(s1.top());
    }
}
