package Frames;

import Dishes.Dish;
import Orders.Commande;
import Orders.History;
import Orders.HistoryManip;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class CookerFrame extends JFrame{

    private JPanel pcooker =new JPanel(new BorderLayout(8,8));
    private JPanel porder =new JPanel();

    private JPanel pgfood =new JPanel(new BorderLayout());
    private JPanel pgdrink =new JPanel(new BorderLayout());
    private JPanel pfoods =new JPanel();
    private JPanel pdrinks =new JPanel();
    private JPanel pcenter =new JPanel(new BorderLayout(8,8));
    private JPanel pimagelogo =new JPanel(new FlowLayout(FlowLayout.CENTER));

    private JPanel pdata=new JPanel();
    private JPanel pimagecoocker =new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pnom =new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pprenom =new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel page =new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pstars =new JPanel();
    private JLabel nom=new JLabel("Nom :");
    private JLabel prenom=new JLabel("Prenom :");
    private JLabel  age=new JLabel("Age :");
    private JLabel lcname =new JLabel("Bahmou");
    private JLabel lclname =new JLabel("Musstapha");
    private JLabel agee=new JLabel("22");

    private JPanel peast =new JPanel(new BorderLayout());



    private JButton button=new JButton("Order Treated");
    private JPanel plname =new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pllname =new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel plage =new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pimage=new JPanel(new FlowLayout(FlowLayout.CENTER));

    private JLabel image=new JLabel(new ImageIcon("src/imgs/moha.jpg"));
    private JLabel stars=new JLabel(new ImageIcon("src/imgs/stars.png"));
    private JLabel command_avaliable=new JLabel("No Orders to prepare");
    private JPanel pavaliable=new JPanel();
    private JPanel pca =new JPanel();

    private JLabel command_atraite =new JLabel("Order to prepare");
    private JPanel ptraite=new JPanel();

    private JLabel food =new JLabel("FOODS");
    private JPanel ptitre_food =new JPanel();

    private JLabel drink =new JLabel("DRINKS");
    private JPanel ptitre_drink=new JPanel();

    private JPanel pbutton= new JPanel();
    private JPanel psend_available=new JPanel();

    private JLabel nome=new JLabel("The Cooker");
    private JPanel ptitre_cooker= new JPanel();

    private JTextArea tafood = new JTextArea(9,18);
    private JScrollPane spfood = new JScrollPane(tafood);

    private JTextArea tadrink = new JTextArea(9,18);
    private JScrollPane spdrink = new JScrollPane(tadrink);


    public CookerFrame(){

        this.setTitle("Cooker");
        this.setBounds(180, 80, 880, 590);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/imgs/logo.jpg");
        this.setIconImage(icon);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container gcp = getContentPane();
        Color blue = new Color(29, 12, 48);
        Color gold = new Color(220, 184, 94, 255);
        Color darkyellow = new Color(215, 155, 28, 255);
        Color grayw = new Color(178, 178, 178);

        pimagelogo.add(new JLabel(new ImageIcon("src/imgs/logo3.jpg")));
        pimagelogo.setBackground(blue);
        pnom.setBackground(blue);
        nom.setForeground(gold);
        prenom.setForeground(gold);
        age.setForeground(gold);
        agee.setForeground(darkyellow);
        lcname.setForeground(darkyellow);
        lclname.setForeground(darkyellow);
        plname.add(nom);
        pllname.add(prenom);
        plage.add(age);
        plname.setBackground(blue);
        pllname.setBackground(blue);
        plage.setBackground(blue);
        plname.setPreferredSize(new Dimension(90,28));
        pllname.setPreferredSize(new Dimension(90,28));
        plage.setPreferredSize(new Dimension(90,28));
        nom.setFont(new Font("Times New Roman", Font.BOLD, 16));
        prenom.setFont(new Font("Times New Roman", Font.BOLD, 16));
        age.setFont(new Font("Times New Roman", Font.BOLD, 16));
        agee.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lcname.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lclname.setFont(new Font("Times New Roman", Font.BOLD, 16));
        pnom.add(plname);pnom.add(lcname);
        pprenom.add(pllname);pprenom.add(lclname);pprenom.setBackground(blue);
        page.add(plage);page.add(agee);page.setBackground(blue);
        pstars.add(stars);pstars.setBackground(blue);
        pimage.add(image);pimagecoocker.add(pimage);pimagecoocker.setBackground(blue);
        pdata.add(pimagecoocker);pdata.add(pstars);
        pdata.add(pnom);pdata.add(pprenom);pdata.add(page);
        pdata.setBackground(blue);
        pdata.setLayout(new BoxLayout(pdata, BoxLayout.Y_AXIS));
        pdata.setBorder(BorderFactory.createLineBorder(gold));

        ptitre_cooker.add(nome);
        nome.setFont(new Font("Times New Roman", Font.BOLD, 24));
        peast.add(ptitre_cooker,BorderLayout.NORTH);
        peast.add(pdata,BorderLayout.CENTER);


        tafood.setFont(new Font("Consolas", Font.BOLD, 20));
        tadrink.setFont(new Font("Consolas", Font.BOLD, 20));
        tafood.setBackground(grayw);
        tadrink.setBackground(grayw);
        tafood.setForeground(blue);
        tadrink.setForeground(blue);



        ptitre_food.add(food);
        food.setFont(new Font("Times New Roman", Font.BOLD, 16));

        pfoods.add(spfood);
        pfoods.setBackground(blue);
        pfoods.setLayout(new BoxLayout(pfoods,BoxLayout.Y_AXIS));
        pgfood.add(ptitre_food,BorderLayout.NORTH);
        pgfood.add(pfoods,BorderLayout.CENTER);
        pgfood.setBackground(blue);

        ptitre_drink.add(drink);
        drink.setFont(new Font("Times New Roman", Font.BOLD, 16));

        pdrinks.add(spdrink);
        pdrinks.setBackground(blue);
        pdrinks.setLayout(new BoxLayout(pdrinks,BoxLayout.Y_AXIS));
        pgdrink.add(ptitre_drink,BorderLayout.NORTH);
        pgdrink.add(pdrinks,BorderLayout.CENTER);
        pgdrink.setBackground(blue);

        porder.add(pgfood);
        porder.add(Box.createHorizontalStrut(10));
        porder.add(pgdrink);
        porder.setBackground(blue);

        porder.setLayout(new BoxLayout(porder,BoxLayout.X_AXIS));

        command_avaliable.setForeground(blue);
        command_avaliable.setFont(new Font("Times New Roman", Font.BOLD, 24));
        pavaliable.add(command_avaliable);
        pavaliable.setBorder(BorderFactory.createLineBorder(blue));
        pca.setBackground(gold);
        pavaliable.setBackground(gold);
        pca.add(pavaliable);

        command_atraite.setForeground(blue);
        command_atraite.setFont(new Font("Times New Roman", Font.BOLD, 24));

        ptraite.add(command_atraite);
        ptraite.setBackground(gold);

        button.setPreferredSize(new Dimension(230,38));
        button.setForeground(darkyellow);
        button.setFont(new Font("Times New Roman", Font.BOLD, 24));
        button.setBackground(blue);
        pbutton.add(button);pbutton.setBackground(gold);

        psend_available.add(pbutton);
        psend_available.add(pca);
        psend_available.setLayout( new BoxLayout(psend_available,BoxLayout.X_AXIS));

        pcenter.setBackground(blue);
        pcenter.add(ptraite,BorderLayout.NORTH);
        pcenter.add(porder,BorderLayout.CENTER);
        pcenter.add(psend_available,BorderLayout.SOUTH);

        pcenter.setBorder(BorderFactory.createLineBorder(gold));

        pcooker.add(pimagelogo,BorderLayout.NORTH);
        pcooker.add(Box.createHorizontalStrut(10));
        pcooker.add(pcenter,BorderLayout.CENTER);
        pcooker.add(peast,BorderLayout.EAST);
        pcooker.setBackground(blue);

        gcp.add(pcooker);
        ObjectInputStream ois;
        ObjectOutputStream oos;

        try{
            ServerSocket serverSocket = new ServerSocket(2300);
            Socket order = null;
            String message;
            Commande commande = null;

            while (true){
                System.out.println("Cooker is waiting");
                order = serverSocket.accept();
                int time = 0;
                System.out.println("Cooker received order");
                oos = new ObjectOutputStream(order.getOutputStream());
                ois = new ObjectInputStream(order.getInputStream());
                commande = (Commande) ois.readObject();
                if (commande != null){
                    String ofoods = "\n  Client "+commande.getCustomer().getId()+": "+commande.getCustomer().getName()+"\n";
                    String odrinks = "\n  Client "+commande.getCustomer().getId()+": "+commande.getCustomer().getName()+"\n\n";
                    ArrayList<History> histories = new ArrayList<>();
                    command_avaliable.setText("Available Orders : "+commande.getNbr());
                    for (Dish dish:commande.getDishes()) {
                        time += dish.getTimeToCook();

                        histories = new HistoryManip().getAllByDish(dish.getId(),commande.getOrder().getId(),commande.getCustomer().getId());
                        if (dish.getType().equals("food"))
                        {
                            for (History history:histories) {
                                ofoods += "\t"+dish.getName() +"  X"+ history.getQuantity()+"\n";
                        }
                            tafood.setText(ofoods);
                        }else
                            for (History history:histories) {
                                odrinks += "\t"+dish.getName() +"  X"+ history.getQuantity()+"\n";
                            }
                            tadrink.setText(odrinks);
                    }
                    TimeUnit.MINUTES.sleep(1);
                    System.out.println("the order will be ready after "+time+"min");
                    message = "The Order of the customer "+commande.getCustomer().getId()+": "+commande.getCustomer().getName()+" is Ready ...";
                    oos.writeObject(message);
                }
                order.close();
                tadrink.setText("");
                tafood.setText("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
