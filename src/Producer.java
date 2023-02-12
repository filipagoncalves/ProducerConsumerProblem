import java.util.Random;

public class Producer implements Runnable{
    private Container<Integer> queue;
    private int nrOfPlates;
    private String name;

    public Producer(String name, Container<Integer> queue, int nrOfPlates){
        this.queue = queue;
        this.nrOfPlates = nrOfPlates;
        this.name = name;
    }

    public String newDishName(){
        int newDish = new Random().nextInt(5 - 1 + 1) + 1;
        String dishName = "";
        switch (newDish){
            case 1:
                dishName = Dishes.PLATE_1.getDish();
                break;
            case 2:
                dishName = Dishes.PLATE_2.getDish();
                break;
            case 3:
                dishName = Dishes.PLATE_3.getDish();
                break;
            case 4:
                dishName = Dishes.PLATE_4.getDish();
                break;
            case 5:
                dishName = Dishes.PLATE_5.getDish();
                break;
        }
        return dishName;
    }

    @Override
    public void run() {
        try {
            while(this.nrOfPlates > 0){
                this.queue.addDishes(newDishName());
                this.nrOfPlates--;
                System.out.println(name + " has been produced.");
                Thread.sleep(3000);
            }
            System.out.println(name + "You have all your dishes done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
