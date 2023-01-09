package Frames;

import Dishes.Dish;
import Dishes.DishManip;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame implements ActionListener {

    private JPanel pnorth=new JPanel();
    private JPanel pwest=new JPanel();
    private JPanel pcenter=new JPanel();
    private JPanel peast =new JPanel();

    private JPanel p_id=new JPanel();
    private JPanel p_name=new JPanel();
    private JPanel p_price=new JPanel();
    private JPanel p_description=new JPanel();
    private JPanel p_time=new JPanel();
    private JPanel p_type=new JPanel();

    private JPanel p_l_id=new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel p_l_name=new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel p_l_price=new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel p_l_description=new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel p_l_time=new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel p_l_type=new JPanel(new FlowLayout(FlowLayout.LEFT));

    private JLabel l_id= new JLabel("ID :");
    private JLabel l_name= new JLabel("NAME :");
    private JLabel l_price= new JLabel("PRICE :");
    private JLabel l_description= new JLabel("DESCRIPTION :");
    private JLabel l_time= new JLabel("TIMETOCOOCK :");
    private JLabel l_type= new JLabel("TYPE :");

    private JTextField text_id = new JTextField(15);
    private JTextField text_name = new JTextField(15);
    private JTextField text_price = new JTextField(15);
    private JTextArea text_description = new JTextArea(2,15);
    private JScrollPane scrollPane = new JScrollPane(text_description);
    private JTextField text_time = new JTextField(15);
    private JTextField text_type = new JTextField(15);

    private JTable table;
    private JPanel ptable =new JPanel();
    private DefaultTableModel model=new DefaultTableModel();

    private JButton add=new JButton("ADD");
    private JButton delete=new JButton("DELETE");
    private JButton uppdate=new JButton("UPPDATE");
    private JPanel p_add=new JPanel();
    private JPanel p_delete=new JPanel();
    private JPanel p_uppdate=new JPanel();
    private JPanel p_buttons=new JPanel(new FlowLayout(FlowLayout.LEFT));


    private JPanel panel=new JPanel(new BorderLayout());

    private JTabbedPane onglets=new JTabbedPane();


    public AdminFrame(String user){
        setTitle("Admin");
        setBounds(280, 160, 1010, 640);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/imgs/logo.jpg");
        this.setIconImage(icon);
        this.setVisible(true);
        this.setResizable(false);
        Container gcp = getContentPane();
        Color blue = new Color(29, 12, 48);
        Color gold = new Color(220, 184, 94, 255);
        Color darkyellow = new Color(215, 155, 28, 255);
        Color dark = new Color(5, 5, 0, 255);

        l_id.setFont(new Font("Times New Roman", Font.BOLD, 16));
        l_name.setFont(new Font("Times New Roman", Font.BOLD, 16));
        l_price.setFont(new Font("Times New Roman", Font.BOLD, 16));
        l_description.setFont(new Font("Times New Roman", Font.BOLD, 16));
        l_time.setFont(new Font("Times New Roman", Font.BOLD, 16));
        l_type.setFont(new Font("Times New Roman", Font.BOLD, 16));
        l_id.setForeground(blue);
        l_name.setForeground(blue);
        l_price.setForeground(blue);
        l_description.setForeground(blue);
        l_time.setForeground(blue);
        l_type.setForeground(blue);

        p_l_id.add(l_id); p_l_id.setPreferredSize(new Dimension(138,30));
        p_l_name.add(l_name);p_l_name.setPreferredSize(new Dimension(138,30));
        p_l_price.add(l_price);p_l_price.setPreferredSize(new Dimension(138,30));
        p_l_description.add(l_description);p_l_description.setPreferredSize(new Dimension(138,30));
        p_l_time.add(l_time);p_l_time.setPreferredSize(new Dimension(138,30));
        p_l_type.add(l_type);p_l_type.setPreferredSize(new Dimension(138,30));

        p_id.add(p_l_id);p_id.add(text_id);p_id.setBackground(gold);p_l_id.setBackground(gold);
        p_name.add(p_l_name);p_name.add(text_name);p_name.setBackground(gold);p_l_name.setBackground(gold);
        p_price.add(p_l_price);p_price.add(text_price);p_price.setBackground(gold);p_l_price.setBackground(gold);
        p_description.add(p_l_description);p_description.add(scrollPane);p_description.setBackground(gold);p_l_description.setBackground(gold);
        p_time.add(p_l_time);p_time.add(text_time);p_time.setBackground(gold);p_l_time.setBackground(gold);
        p_type.add(p_l_type);p_type.add(text_type);p_type.setBackground(gold);p_l_type.setBackground(gold);

        DishManip M=new DishManip();
        M.getAll();
        table=new JTable(model);
        model.addColumn("id");
        model.addColumn("name");
        model.addColumn("price");
        model.addColumn("description");
        model.addColumn("timeToCoock");
        model.addColumn("type");

        for (Dish D: M.getAll()){
            Object [] data={(D.getId()),(D.getName()),(D.getPrice()),(D.getDescription()),(D.getTimeToCook()),(D.getType())};
            model.insertRow(0,data);
        }
        ptable.add(new JScrollPane(table));
        table.setBackground(blue);
        table.setForeground(gold);
        ptable.setBackground(blue);

        add.setPreferredSize(new Dimension(100,30));p_add.add(add);add.setBackground(blue);
        p_add.add(Box.createHorizontalStrut(24));p_add.setBackground(gold);
        delete.setPreferredSize(new Dimension(100,30));p_delete.add(delete);delete.setBackground(blue);
        p_delete.add(Box.createHorizontalStrut(24));p_delete.setBackground(gold);
        uppdate.setPreferredSize(new Dimension(100,30));p_uppdate.add(uppdate);uppdate.setBackground(blue);
        p_uppdate.add(Box.createHorizontalStrut(24));p_uppdate.setBackground(gold);
        add.setForeground(darkyellow);
        uppdate.setForeground(darkyellow);
        delete.setForeground(darkyellow);

        pwest.add(p_id);
        pwest.add(p_name);
        pwest.add(p_price);
        pwest.add(p_description);
        pwest.add(p_time);
        pwest.add(p_type);
        pwest.setLayout(new BoxLayout(pwest,BoxLayout.Y_AXIS));
        pwest.setBackground(gold);

        pnorth.add(new JLabel(new ImageIcon("src/imgs/logo3.jpg")));
        pnorth.setBackground(blue);

        pcenter.add(ptable);pcenter.setBackground(blue);
        pcenter.setBackground(gold);

        p_buttons.add(p_add);
        p_buttons.add(p_uppdate);
        p_buttons.add(p_delete);
        p_buttons.setLayout(new BoxLayout(p_buttons,BoxLayout.Y_AXIS));
        p_buttons.setBackground(gold);
        add.addActionListener(this);
        delete.addActionListener(this);
        uppdate.addActionListener(this);

        peast.add(p_buttons);
        peast.setBackground(gold);

        panel.add(pnorth,BorderLayout.NORTH);
        panel.add(pwest,BorderLayout.WEST);
        panel.add(pcenter,BorderLayout.CENTER);
        panel.add(peast,BorderLayout.EAST);

        this.onglets.addTab("mise a jure",panel);
        this.onglets.addTab("Menu",new MenuFrame("admin").getPan());
        gcp.add(onglets);
    }

    public void actionPerformed(ActionEvent e) {
        Dish D;
        DishManip DM =new DishManip();

        if(e.getSource().equals(add)){
            Object [] data={Integer.parseInt(text_id.getText()),
                    text_name.getText(),
                    Float.parseFloat(text_price.getText()),
                    text_description.getText(),
                    Integer.parseInt(text_time.getText()),
                    text_type.getText()};
            D=new Dish(Integer.parseInt(text_id.getText()),
                    text_name.getText(),
                    Float.parseFloat(text_price.getText()),
                    text_description.getText(),
                    Integer.parseInt(text_time.getText()),
                    text_type.getText());
            DM.insert(D);


            model.addRow(data);
        }
        if(e.getSource().equals(uppdate)){
            D=new Dish(Integer.parseInt(text_id.getText()),
                    text_name.getText(),
                    Float.parseFloat(text_price.getText()),
                    text_description.getText(),
                    Integer.parseInt(text_time.getText()),
                    text_type.getText());
            DM.update(D);
            model.setRowCount(0);
            for (Dish Di:DM.getAll()) {
                Object[] data1 = {(Di.getId()),(Di.getName()),(Di.getPrice()),(Di.getDescription()),(Di.getTimeToCook()),(Di.getType())};
                model.insertRow(0, data1);
            }

        }
        if(e.getSource().equals(delete)){
            int idp=Integer.parseInt(text_id.getText());
            DM.delete(idp);
            model.setRowCount(0);
            for (Dish Di:DM.getAll()) {
                Object[] data1 = {(Di.getId()),(Di.getName()),(Di.getPrice()),(Di.getDescription()),(Di.getTimeToCook()),(Di.getType())};
                model.insertRow(0, data1);
            }
        }
        onglets.remove(1);
        onglets.addTab("Menu",new MenuFrame("admin").getPan());

    }
}

