import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public class Zip implements Comparable<Zip> {
        public int pos;
        public int speed;
        public Zip(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        @Override
        public int compareTo(Zip o) {
            return this.pos - o.pos;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 1) return 1;
        Zip[] zip = new Zip[position.length];
        for(int i = 0; i < position.length; i++) {
            zip[i] = new Zip(position[i], speed[i]);
        }
        Arrays.sort(zip);
        Stack<Float> stack = new Stack<>();
        stack.push((float) (target - zip[position.length - 1].pos) / zip[position.length - 1].speed);
        for(int i = position.length - 1; i >= 0; i--) {
            float time = (float) (target - zip[i].pos) / zip[i].speed;
            if(time > stack.peek()){
                stack.push(time);
            }
        }
        return stack.size();
    }
    public static void main(String[] Args) {
        CarFleet test = new CarFleet();
        System.out.println(test.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
    }
}
