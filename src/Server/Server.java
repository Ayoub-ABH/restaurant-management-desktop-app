package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String args[]){

        try {
            ServerSocket server = new ServerSocket(3300);
            Socket client = null ;

            while(true) {
                System.out.println("listening on port 3000");
                client = server.accept();
                ExecutorService executorService = Executors.newFixedThreadPool(6);
                executorService.submit(new Manipulation(client));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

