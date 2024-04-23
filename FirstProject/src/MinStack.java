import java.util.ArrayList;
import java.util.Stack;

public class MinStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> minIndex;
    int minPtr;
    int top;

    public MinStack() {
        stack = new ArrayList<>();
        minIndex = new ArrayList<>();
        minPtr = -1;
        top = -1;
    }

    public void push(int val) {
        top++;
        if(top == 0) {
            minIndex.add(0);
            minPtr++;

        } else if(val <= stack.get(minIndex.get(minPtr))) {
            minIndex.add(top);
            minPtr++;
        }
        stack.add(val);
    }

    public void pop() {
        if(top == 0) {
            minPtr = -1;
            top = -1;
            stack = new ArrayList<>();
            minIndex = new ArrayList<>();
            return;
        } else if(stack.get(top) == stack.get(minIndex.get(minPtr))) {
            minIndex.remove(minPtr--);
        }
        stack.remove(top--);
    }

    public int top() {
        return stack.get(top);
    }

    public int getMin() {
        return stack.get(minIndex.get(minPtr));
    }
    public void print() {
        for(int i : stack) {
            System.out.print(i + " ");;
        }
        System.out.println();
        for(int i : minIndex) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] Args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}

