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
        //data = new Data();
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
        //System.out.println("Chef, let's fill the queue!");
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
        //System.out.println("The list has plates :)");
    }



    public synchronized void addDishes(String plateName) {

        if(this.queue.size() < maxCapacity){
            this.queue.add(plateName);
            //counter++;
            listHasSpace = true;
            listIsEmpty = false;
            System.out.println("Container: " + this.queue.toString());
            System.out.println("-".repeat(50));
        } else {
            listHasSpace = false;
            //System.out.println("Container: Wait, the list is full!");
            //producerWait();
        }
        producerWait();
    }

    public synchronized void consumeDish() {

        if(queue.size() > 0){
            //System.out.println("You are taking this dish: " + this.queue.peek());
            removeDishes();
            //listHasSpace = true;
            //return;
        } else {
            listIsEmpty = true;
            System.out.println("Container: Wait, the list is empty!");
            //consumerWait();
        }
        consumerWait();

        //System.out.println(this.queue.toString());
        //System.out.println("-".repeat(30));
    }

    public synchronized void removeDishes(){
        if(this.queue.size() > 0){
            System.out.println("Container: You are taking this dish: " + this.queue.peek());
            this.queue.poll();
            //counter--;
            System.out.println("Container: " + this.queue.toString());
        }
    }
}