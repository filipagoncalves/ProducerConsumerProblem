import java.util.ArrayDeque;
import java.util.Queue;

public class Container<I>{
    //private int counter = 0;
    private int maxCapacity;
    private Queue<String> queue;

    //private Data data;

    // true if producer should wait
    // false if consumer should wait
    private boolean listHasSpace = true;
    private boolean listIsEmpty = true;

    public Container(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.queue = new ArrayDeque<>();
    }

    public synchronized void producerWait() {
        while (!listHasSpace) {
            try {
                System.out.println("Container: Wait, the list is full!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }

    public synchronized void consumerWait() {
        while (listIsEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }



    public synchronized void addDishes(String plateName) {

        if(this.queue.size() < maxCapacity){
            this.queue.add(plateName);
            listHasSpace = true;
            listIsEmpty = false;
            System.out.println("Container: " + this.queue.toString());
            System.out.println("-".repeat(50));
        } else {
            listHasSpace = false;
        }
        producerWait();
    }

    public synchronized void consumeDish() {

        if(queue.size() > 0){
            removeDishes();
        } else {
            listIsEmpty = true;
            System.out.println("Container: Wait, the list is empty!");
        }
        consumerWait();

    }

    public synchronized void removeDishes(){
        if(this.queue.size() > 0){
            System.out.println("Container: You are taking this dish: " + this.queue.peek());
            this.queue.poll();
            System.out.println("Container: " + this.queue.toString());
        }
    }
}