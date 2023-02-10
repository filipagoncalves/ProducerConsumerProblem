import java.util.Random;

public class Producer implements Runnable{
    private Container<Integer> queue;
    private int nrOfPlates;
    private int newDish;

    private int deleteThisVariable;

    public Producer(Container<Integer> queue, int nrOfPlates){
        this.queue = queue;
        this.nrOfPlates = nrOfPlates;
    }

    private int randomDishGenerator(){
        this.newDish = new Random().nextInt(5 - 1 + 1) + 1;
        return newDish;
    }

    public void newDishName(){
        randomDishGenerator();
        switch (newDish){
            case 1:
                System.out.println(Dishes.PLATE_1.getDish());
                break;
            case 2:
                System.out.println(Dishes.PLATE_2.getDish());
                break;
            case 3:
                System.out.println(Dishes.PLATE_3.getDish());
                break;
            case 4:
                System.out.println(Dishes.PLATE_4.getDish());
                break;
            case 5:
                System.out.println(Dishes.PLATE_5.getDish());
                break;
        }
    }

    @Override
    public void run() {

    }
}
