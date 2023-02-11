public class Consumer implements Runnable{

    private Container queue;
    private int dishesToBeConsumed;
    private String name;

    public Consumer(String name, Container queue, int dishesToBeConsumed) {
        this.queue = queue;
        this.dishesToBeConsumed = dishesToBeConsumed;
        this.name = name;
    }

    @Override
    public void run() {
        //Things to do
        try {
            System.out.println(name + "consumer is ON");
            while(this.dishesToBeConsumed > 0){
                this.queue.consumeDish();
                this.dishesToBeConsumed--;
                System.out.println(name + "I still have  " + this.dishesToBeConsumed);
                Thread.sleep(1000);
            }
            System.out.println(name + "You have all your orders!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
