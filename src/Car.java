/**
 * Created by georgipavlov on 02.01.16.
 */
public class Car {
    private String mark;
    private double price;
    private double fNum;

    public Car(String mark, double price, double fNum) {
        this.mark = mark;
        this.price = price;
        this.fNum = fNum;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getfNum() {
        return fNum;
    }

    public void setfNum(double fNum) {
        this.fNum = fNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (Double.compare(car.getPrice(), getPrice()) != 0) return false;
        if (Double.compare(car.getfNum(), getfNum()) != 0) return false;
        return !(getMark() != null ? !getMark().equals(car.getMark()) : car.getMark() != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getMark() != null ? getMark().hashCode() : 0;
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getfNum());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
