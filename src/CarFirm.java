import java.util.ArrayList;

/**
 * Created by georgipavlov on 02.01.16.
 */
public class CarFirm {
    private static  int count = 0;
    private ArrayList<Car> cars;

    public CarFirm() {
        cars = new ArrayList<>();
    }

    public int getCount() {
        return count;
    }

    public synchronized void soldCar(Car car){
        for (int i = 0; i <cars.size() ; i++) {
            if(cars.get(i).equals(car)){
                cars.remove(i);
                count--;
                return;
            }
        }
        //exeption
    }

    public synchronized void addCar(Car car){
        cars.add(car);
        count++;
    }

    public synchronized double getTotalPrice(){
        double totalPrise =0;
        double tempPrise;
        for (int i = 0; i <cars.size() ; i++) {
            tempPrise = cars.get(i).getPrice();
            if(tempPrise != 0){
                totalPrise += tempPrise;
            }else {
                //exeption
            }
        }
        return totalPrise;
    }


}
