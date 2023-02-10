import java.util.*;

public class Container<I>{
    private int counter = 0;
    private int maxCapacity;
    private Queue<String> queue;

    public Container(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.queue = new ArrayDeque<>();
    }

    public void addDishes(String plateName) throws InterruptedException {
        if(counter >= 0 && counter < maxCapacity){
            this.queue.add(plateName);
            counter++;
        } else {
            wait();
        }
    }

    public void removeDishes(){
        if(counter >= 0){
            this.queue.poll();
            counter--;
        }
    }
}
