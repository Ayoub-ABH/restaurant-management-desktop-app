package Frames;

import Default.Connect;
import Dishes.Dish;
import Dishes.DishManip;
import Orders.*;
import Persons.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class MenuFrame extends JFrame implements ActionListener {

    private static int id_order;
    private static int id_customer;
    private Commande commande = null;


    private static Connection con = Connect.getCon();
    private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
    private ArrayList<JSpinner> spinners = new ArrayList<>();
    private String fstart =
            "**************************************************\n" +
                    "                   \t                                         Hassan's Restaurant\n" +
                    "  *Waiter *   ED-DAMER \n" ;

    private String fend =
            "-----------------------------------------------------------------------------\n" +
            "\t            MERCI  RH\n" +
            "***************************************************";

    private JPanel pfood =new JPanel();
    private JPanel pdrink =new JPanel();
    private JPanel pmenu =new JPanel();
    private JPanel pclient =new JPanel();
    private JPanel pclient_manip =new JPanel();

    private JLabel Drink=new JLabel("DRINKS");
    private JLabel Food=new JLabel("FOODS");

    private JPanel ptitredrink=new JPanel();
    private JPanel ptitrefood=new JPanel();

    private JTextField totalfeild =new JTextField(10);
    private JTextField paymentfeild =new JTextField(10);
    private JTextField renderfeild =new JTextField(10);
    private JTextField num_table =new JTextField(10);
    private JTextField client_name =new JTextField(10);
    private JButton ajouter =new JButton("AJOUTER");
    private JButton facture =new JButton("FACTURE");
    private JButton actualiser =new JButton("ACTUALISER");
    private JButton print =new JButton("PRINT");

    private JTable table;
    private DefaultTableModel model=new DefaultTableModel();

    private JPanel pmanip =new JPanel();
    private JPanel ptable =new JPanel();
    private JPanel pprint=new JPanel();
    private JPanel porder =new JPanel(new BorderLayout(0,15));

    private JPanel panel1 =new JPanel();

    private JLabel resName =new JLabel("Mssemna Restaurant");
    private JLabel empName;

    private JTextArea factureFeild =new JTextArea(19,29);
    private JScrollPane scrollPane = new JScrollPane(factureFeild);


    private JPanel pimage =new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel presName =new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pempName =new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pimg =new JPanel();
    private JPanel pside =new JPanel();
    private JPanel panel2 =new JPanel();
    private JPanel pnum_table =new JPanel();
    private JPanel pclient_name =new JPanel();


    private JPanel pgeneral =new JPanel();



    static {
        try {
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery("SELECT max(id) FROM Customers");
            rs.next();
            id_customer = rs.getInt("max(id)");
            state.close();

            state = con.createStatement();
            rs = state.executeQuery("SELECT max(id) FROM Orders");
            rs.next();
            id_order = rs.getInt("max(id)");
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JPanel getPan(){
        return pgeneral;
    }

    public MenuFrame(String emp) {


        setTitle("JAVA RESTAURANT");
        setBounds(50, 50, 1280, 630);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/imgs/logo.jpg");
        this.setIconImage(icon);
        empName =new JLabel("Employee  : "+emp);
        Container gcp = getContentPane();


        Color blue = new Color(29, 12, 48);
        Color gold = new Color(220, 184, 94, 255);
        Color darkyellow = new Color(215, 155, 28, 255);
        Color dark = new Color(5, 5, 0, 255);
        Color green = new Color(16, 91, 0, 255);

        //////////////////////////////
        empName.setFont(new Font("consolas",Font.BOLD,16));
        resName.setFont(new Font("consolas",Font.BOLD,18));
        empName.setForeground(dark);
        resName.setForeground(blue);
        pfood.add(Box.createVerticalStrut(10));
        pdrink.add(Box.createVerticalStrut(10));
        ptitrefood.add(Food);
        ptitrefood.setBackground(darkyellow);
        ptitredrink.add(Drink);
        ptitredrink.setBackground(darkyellow);
        pfood.add(ptitrefood);
        pdrink.add(ptitredrink);
        pfood.add(Box.createVerticalStrut(5));
        pdrink.add(Box.createVerticalStrut(5));


        try {
            Statement state = con.createStatement();
            ResultSet resultSet = state.executeQuery("SELECT * FROM Dishes");

            while (resultSet.next()){
                if (resultSet.getString("type").equals("food"))
                {
                    JPanel pcheckbox= new JPanel(new FlowLayout(FlowLayout.LEFT));
                    JPanel test = new JPanel();
                    JCheckBox checkBox = new JCheckBox(resultSet.getString("name"));
                    checkBox.setBackground(gold);
                    checkBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
                    checkBox.setForeground(blue);
                    SpinnerModel smodel = new SpinnerNumberModel(0,0,10,1);
                    JSpinner jSpinner = new JSpinner(smodel);
                    jSpinner.setPreferredSize(new Dimension(35,24));
                    pcheckbox.setPreferredSize(new Dimension(150,35));
                    pcheckbox.setBackground(gold);
                    pcheckbox.add(checkBox);
                    test.add(pcheckbox);
                    JTextField textField = new JTextField((Integer.toString(resultSet.getInt("price"))+" $"));
                    textField.setPreferredSize(new Dimension(110,24));
                    textField.setHorizontalAlignment(JTextField.CENTER);
                    textField.setFont(new Font("", Font.BOLD,15));
                    textField.setEditable(false);
                    test.add(textField);
                    test.add(jSpinner);
                    test.setLayout(new FlowLayout(FlowLayout.LEFT));test.setBackground(gold);
                    pfood.add(test);
                    checkBoxes.add(checkBox);
                    spinners.add(jSpinner);
                }else{
                    JPanel pchechbox= new JPanel(new FlowLayout(FlowLayout.LEFT));
                    JPanel test = new JPanel();
                    JCheckBox checkBox = new JCheckBox(resultSet.getString("name"));
                    checkBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
                    checkBox.setBackground(gold);
                    checkBox.setForeground(blue);
                    SpinnerModel smodel = new SpinnerNumberModel(0,0,10,1);
                    JSpinner jSpinner = new JSpinner(smodel);
                    jSpinner.setPreferredSize(new Dimension(35,24));
                    pchechbox.setPreferredSize(new Dimension(150,35));
                    pchechbox.setBackground(gold);
                    pchechbox.add(checkBox);
                    test.add(pchechbox);
                    JTextField textField = new JTextField((Integer.toString(resultSet.getInt("price"))+" $"));
                    textField.setPreferredSize(new Dimension(110,24));
                    textField.setFont(new Font("", Font.BOLD,16));
                    textField.setHorizontalAlignment(JTextField.CENTER);
                    textField.setEditable(false);
                    test.add(textField);                    test.add(jSpinner);
                    test.setLayout(new FlowLayout(FlowLayout.LEFT));test.setBackground(gold);
                    pdrink.add(test);
                    checkBoxes.add(checkBox);
                    spinners.add(jSpinner);
                }
            }
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pfood.setBackground(blue);
        pdrink.setBackground(blue);
        pfood.setLayout(new BoxLayout(pfood,BoxLayout.Y_AXIS));
        pdrink.setLayout(new BoxLayout(pdrink,BoxLayout.Y_AXIS));

        table=new JTable(model);
        model.addColumn("Name");
        model.addColumn("Type");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("Total");
        pmanip.add(Box.createHorizontalStrut(8));
        ajouter.setBackground(Color.white);
        ajouter.setForeground(darkyellow);
        facture.setBackground(Color.white);
        facture.setForeground(darkyellow);
        actualiser.setBackground(Color.white);
        actualiser.setForeground(darkyellow);
        pmanip.add(ajouter);
        pmanip.add(Box.createHorizontalStrut(8));
        totalfeild.setHorizontalAlignment(JTextField.CENTER);
        totalfeild.setForeground(Color.RED);
        totalfeild.setBackground(dark);
        totalfeild.setText("0.0$");
        paymentfeild.setText("0.0");
        renderfeild.setText("0.0$");
        paymentfeild.setHorizontalAlignment(JTextField.CENTER);
        paymentfeild.setForeground(Color.GREEN);
        paymentfeild.setBackground(dark);
        renderfeild.setHorizontalAlignment(JTextField.CENTER);
        renderfeild.setForeground(Color.WHITE);
        renderfeild.setBackground(dark);
        num_table.setPreferredSize(new Dimension(0,30));
        client_name.setPreferredSize(new Dimension(0,30));
        num_table.setBackground(darkyellow);
        num_table.setForeground(blue);
        num_table.setHorizontalAlignment(JTextField.CENTER);
        num_table.setFont(new Font("Times New Roman", Font.BOLD, 14));
        num_table.setText("Table  01");

        client_name.setBackground(darkyellow);
        client_name.setForeground(blue);
        client_name.setHorizontalAlignment(JTextField.CENTER);
        client_name.setFont(new Font("Times New Roman", Font.BOLD, 14));
        client_name.setText("Client  hassan");

        pnum_table.add(num_table);pnum_table.setBackground(blue);
        pclient_name.add(client_name);pclient_name.setBackground(blue);
        pclient.add(pnum_table);
        pclient.add(pclient_name);pclient.setBackground(blue);
        pclient.setLayout(new  BoxLayout(pclient,BoxLayout.X_AXIS));
        pmanip.add(totalfeild);
        pmanip.add(Box.createHorizontalStrut(8));
        pmanip.add(paymentfeild);
        pmanip.add(Box.createHorizontalStrut(8));
        pmanip.add(renderfeild);
        pmanip.add(Box.createHorizontalStrut(8));
        pmanip.add(facture);
        pmanip.add(Box.createHorizontalStrut(8));
        pmanip.add(actualiser);
        pmanip.setLayout(new BoxLayout(pmanip,BoxLayout.X_AXIS));
        pmanip.setBackground(blue);
        ptable.add(new JScrollPane(table)); ptable.setBackground(blue);
        pclient_manip.add(pclient);
        pclient_manip.add(Box.createVerticalStrut(10));
        pclient_manip.add(pmanip);
        pclient_manip.setLayout(new BoxLayout(pclient_manip,BoxLayout.Y_AXIS));
        pclient_manip.setBackground(blue);

        print.setBackground(gold);
        print.setForeground(blue);

        pside.add(scrollPane);
        pimage.add(new JLabel(new ImageIcon("src/imgs/menulogo.jpg")));
        pimage.setBackground(blue);

        pimg.add(pimage);
        pimg.add(Box.createVerticalStrut(10));
        presName.setBackground(darkyellow);
        pempName.setBackground(darkyellow);
        presName.add(resName);
        pempName.add(empName);
        pimg.add(presName);pimg.add(Box.createVerticalStrut(10));
        pimg.add(pempName);pimg.add(Box.createVerticalStrut(10));
        pside.setBackground(blue);
        pside.setPreferredSize(new Dimension(370,200));
        pimg.setLayout(new BoxLayout(pimg,BoxLayout.Y_AXIS));
        pimg.setBackground(blue);


        //--------------------------------------------------------------------------------------------------------------
        pmenu.add(Box.createHorizontalStrut(10));
        pmenu.add(pfood);
        pmenu.add(Box.createHorizontalStrut(10));
        pmenu.add(pdrink);
        pmenu.add(Box.createHorizontalStrut(15));
        pmenu.setLayout(new BoxLayout(pmenu,BoxLayout.X_AXIS));
        pmenu.setBackground(blue);
        porder.add(pclient_manip,BorderLayout.NORTH);
        porder.add(Box.createHorizontalStrut(10));
        porder.add(ptable,BorderLayout.CENTER);
        print.setPreferredSize(new Dimension(100,200));
        pprint.add(print);
        pprint.setBackground(blue);
        porder.setBackground(blue);
        porder.add(pprint,BorderLayout.EAST);
        panel2.add(porder);
        panel2.add(pside);
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
        panel1.add(pmenu);
        panel1.add(pimg);
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));
        panel1.add(Box.createHorizontalStrut(10));
        panel1.setBackground(blue);
        panel2.add(porder);
        panel2.add(Box.createHorizontalStrut(20));
        panel2.add(pside);
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
        panel2.add(Box.createHorizontalStrut(10));
        panel2.setBackground(blue);


        pgeneral.add(panel1);
        pgeneral.add(Box.createVerticalStrut(10));
        pgeneral.add(panel2);
        pgeneral.setLayout(new BoxLayout(pgeneral,BoxLayout.Y_AXIS));
        pgeneral.add(Box.createHorizontalStrut(10));
        pgeneral.setBackground(blue);



        ajouter.addActionListener(this);
        facture.addActionListener(this);
        actualiser.addActionListener(this);
        print.addActionListener(this);

        gcp.add(pgeneral);
       // this.setResizable(false);
        this.validate();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dish dish;
        int qdish = 0;
        float total2 = 0;
        Order order;
        Customer customer;

        ArrayList<Dish> dishes = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        if (e.getSource()==ajouter){
            model.setRowCount(0);
            for (JCheckBox checkBox:checkBoxes) {
                if (checkBox.isSelected()){
                    int quantity = (Integer) spinners.get(qdish).getValue();
                    if (quantity != 0){

                        dish = new DishManip().getOne(checkBox.getText());
                        float price = dish.getPrice();
                        Object[] c = new Object[]{dish.getName(), dish.getType(), price,quantity,price*quantity};
                        model.addRow(c);
                        total2 += price*quantity;
                        quantities.add(quantity);
                        dishes.add(dish);
                        //History history = new History(++id_customer,id_order,dish.getId(),quantity);
                        //new HistoryManip().insert(history);
                    }
                }
                qdish++;
                totalfeild.setText(total2+"$");
            }
            ++id_customer;
            ++id_order;
            customer = new Customer(id_customer,client_name.getText());
            order = new Order(id_order,total2,id_customer,1,1,1,new Date(new java.util.Date().getTime()),null);
            //new OrderManip().insert(order);

            commande = new Commande(dishes,quantities,order,new Customer(id_customer,client_name.getText()),0);
        }
        else if (e.getSource() == actualiser){
            for(JCheckBox checkBox : checkBoxes){
                if (checkBox.isSelected())
                    checkBox.setSelected(false);
            }
            for (JSpinner spinner : spinners){
                spinner.setValue(0);
            }
            factureFeild.setText("");
            totalfeild.setText("0.0$");
            paymentfeild.setText("0.0");
            renderfeild.setText("0.0$");
            model.setRowCount(0);
        }

        else if (e.getSource() == facture){

            // display facture
            String factContent = ""+ fstart;
            float total = 0;

            if (!paymentfeild.getText().equals("0.0")&& model.getRowCount()!=0) {

                float payment = Float.parseFloat(paymentfeild.getText());
                factContent += "   * "+client_name.getText()+" *\t  * "+num_table.getText()+" *\n" +
                        "----------------------------------------------------------------------------\n" +
                        "\n" +
                        "          Dish\t      price\t  quantite\t    total    \n\n";
                factureFeild.setFont(new Font("Century Gothic", Font.LAYOUT_LEFT_TO_RIGHT, 11));

                for (int i = 0; i < model.getRowCount(); i++) {
                    int j = 0;
                    factContent += "            " + model.getValueAt(i, j++) + "\t       " + model.getValueAt(i, ++j) + "$             " +
                            model.getValueAt(i, ++j) + "x               " + model.getValueAt(i, ++j) + "$             \n";
                    total += (Float) model.getValueAt(i, j);
                }
                renderfeild.setText(payment - total + "$");
                factContent += "\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "    total : " + total + "$                                 payment : " + payment + "$\n" +
                        "\t           Render : " + (payment - total) + "$\n" +
                        "\n";
                factContent += fend;
                factureFeild.setText(factContent);

            }else{
                JOptionPane.showMessageDialog(this,"You need to chose at least one dish to continue ...","Warning",JOptionPane.WARNING_MESSAGE);
            }


        }

        else if (e.getSource() == print){

            ObjectOutputStream oos;
            ObjectInputStream ois;
            if (commande != null) {
                try {
                    Socket socket = new Socket("localhost", 3300);
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    ois = new ObjectInputStream(socket.getInputStream());
                    oos.writeObject(commande);
                    String message = (String) ois.readObject();
                    JOptionPane.showMessageDialog(this,message,"Order",JOptionPane.INFORMATION_MESSAGE );
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }

            try {
                factureFeild.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }

    }
}
