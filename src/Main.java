import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static void main(String[] args) {
        ServerSocket s=null;
        CarFirm carFirm= new CarFirm();
        try {
            s= new ServerSocket(6666);

        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            Socket socket=null;
            try {
                socket = s.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Thread(new Server(socket,carFirm)).start();
        }
    }
}

