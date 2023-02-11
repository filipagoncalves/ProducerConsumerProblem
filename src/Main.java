public class Main {

    public static void main(String[] args) {

        Container<Integer> queue = new Container<>(10);

        Producer p1 = new Producer("producer 1: ", queue, 80);
        Thread t1 = new Thread(p1);
        t1.setName("p1");

        Producer p2 = new Producer("producer 2: ",queue, 4);
        Thread t2 = new Thread(p2);
        t2.setName("p2");

        Consumer c1 = new Consumer("consumer 1: ",queue, 17);
        Thread t3 = new Thread(c1);
        t3.setName("c1");

        /*Consumer c2 = new Consumer("consumer 2: ",queue, 10);
        Thread t4 = new Thread(c2);
        t4.setName("c2");*/

        //t4.start();
        t2.start();

        t3.start();
        t1.start();
    }
}
