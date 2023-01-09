package Server;

import Dishes.Dish;
import Orders.Commande;
import Orders.History;
import Orders.HistoryManip;
import Orders.OrderManip;
import Persons.CustomerManip;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Manipulation implements Runnable{

    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Socket socket;
    private static int nbr = 0;

    public Manipulation(Socket socket) {

        this.socket = socket;
        if (socket!=null){
            try {
                nbr++;
                oos = new ObjectOutputStream(socket.getOutputStream());
                ois = new ObjectInputStream(socket.getInputStream());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        System.out.println("connected ...");
        Commande commande = null;

        try {
            commande = (Commande) ois.readObject();
            commande.setNbr(nbr);
                // add data to database
                new OrderManip().insert(commande.getOrder());
                new CustomerManip().insert(commande.getCustomer());
                int i = 0;
                for (Dish dish : commande.getDishes()) {
                    new HistoryManip().insert(new History(commande.getCustomer().getId(), commande.getOrder().getId(), dish.getId(), commande.getQuantities().get(i++)));
                }

                ObjectOutputStream coos;
                ObjectInputStream cois;
            Socket toCook = new Socket("localhost",2300);
                cois = new ObjectInputStream(toCook.getInputStream());
                coos = new ObjectOutputStream(toCook.getOutputStream());
            System.out.println("sending order from server to cooker");
                if (commande != null) {
                    coos.writeObject(commande);
                }
                String notify = (String) cois.readObject();
                nbr--;
                oos.writeObject(notify);
            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
