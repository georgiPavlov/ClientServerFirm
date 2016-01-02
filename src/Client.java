import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Socket socket ;

    public Client(int soc){
        try {
            socket = new Socket("localhost",soc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream printStream=null;
        Scanner scannerServer = null;
        try {
            printStream = new PrintStream(socket.getOutputStream());
            scannerServer = new Scanner(socket.getInputStream());


        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            try {
                printStream.print(scanner.nextLine());
                System.out.println(scannerServer.next());
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }
        try {
            printStream.close();
            socket.close();
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }
}
