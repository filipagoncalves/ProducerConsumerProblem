public class Producer implements Runnable{
    private Container<Integer> queue;
    private int nrOfPlates;

    public Producer(Container<Integer> queue, int nrOfPlates){
        this.queue = queue;
        this.nrOfPlates = nrOfPlates;
    }

    @Override
    public void run() {

    }
}
