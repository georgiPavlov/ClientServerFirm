import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class Server implements Runnable {
    Socket socket;
    Scanner scanner;
    CarFirm carFirm;
    PrintStream writer;
    public Server(Socket socket,CarFirm carFirm){
        this.socket=socket;
        try {
            scanner = new Scanner(socket.getInputStream());
            writer = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.carFirm = carFirm;

    }


    @Override
    public void run() {
        String carMakeChange=null;
        Car car;
        String mark;
        double price;
        double fNum;
        boolean t = true;

        p:while(t){
            carMakeChange = scanner.nextLine();
            switch (carMakeChange){
                case "sold car":{
                    writer.print("Enter mark");
                    mark = scanner.nextLine();
                    writer.print("Enter price");
                    price = scanner.nextDouble();
                    writer.print("Enter fnum");
                    fNum = scanner.nextDouble();
                    car = new Car(mark,price,fNum);
                    try {
                        carFirm.soldCar(car);
                    } catch (MyExeption myExeption) {
                        myExeption.printStackTrace();
                    }
                    continue p;
                }
                case "add car":{
                    writer.print("Enter mark");
                    mark = scanner.nextLine();
                    writer.print("Enter price");
                    price = scanner.nextDouble();
                    writer.print("Enter fnum");
                    fNum = scanner.nextDouble();
                    car = new Car(mark,price,fNum);
                    carFirm.addCar(car);
                    continue p;
                }
                case "count":{
                    writer.print(carFirm.getCount());
                    continue p;
                }
                case "Total":{
                    try {
                        writer.print(carFirm.getTotalPrice());
                    } catch (MyExeption myExeption) {
                        myExeption.printStackTrace();
                    }
                    continue p;
                }
                case "exit":{
                    t=false;
                    continue p;
                }
                default:{
                    try {
                        throw new MyExeption("Error message");
                    } catch (MyExeption myExeption) {
                        myExeption.printStackTrace();
                    }
                }
            }

        }

        scanner.close();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
