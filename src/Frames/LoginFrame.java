package Frames;

import Users.User;
import Users.UserManip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

    private Container container = getContentPane();
    private JLabel userLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");
    private JTextField userTextField = new JTextField(8);
    private JPasswordField passwordField = new JPasswordField(8);
    private JButton loginButton = new JButton("LOGIN");
    private JButton resetButton = new JButton("RESET");
    private JCheckBox showPassword = new JCheckBox("Show Password");
    private JPanel pusern = new JPanel();
    private JPanel puserp = new JPanel();
    private JPanel pbutns = new JPanel();
    private JPanel pshowpas = new JPanel();
    private JPanel panel_in = new JPanel();
    private JPanel panel_gl = new JPanel();
    private JPanel panel_img = new JPanel();
    private JLabel label_img;
    private ImageIcon img = new ImageIcon("src/imgs/index.jpg");

    public LoginFrame() {
        this.setTitle("Login Form");
        this.setVisible(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/imgs/logo.jpg");
        this.setIconImage(icon);
        this.setBounds(300, 220, 470, 260);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        puserp.add(new JLabel("     "));
        pusern.add(new JLabel("     "));
        pusern.add(userLabel);
        puserp.add(passwordLabel);
        pusern.add(userTextField);
        puserp.add(passwordField);
        pshowpas.add(showPassword);
        pbutns.add(loginButton);
        pbutns.add(resetButton);


        Color yellow = new Color(220, 184, 94, 255);
        Color darkyellow = new Color(232, 181, 63, 255);
        Color mauve = new Color(41, 4, 77, 255);
        loginButton.setBackground(mauve);
        resetButton.setBackground(darkyellow);
        loginButton.setForeground(darkyellow);
        resetButton.setForeground(mauve);
        pusern.setBackground(yellow);
        puserp.setBackground(yellow);
        pbutns.setBackground(yellow);
        pshowpas.setBackground(yellow);
        panel_in.setBackground(yellow);
        showPassword.setBackground(yellow);
        panel_img.setBackground(mauve);

        panel_in.setPreferredSize(new Dimension(200,70));
        panel_in.setLayout(new BoxLayout(panel_in,BoxLayout.PAGE_AXIS));
        pusern.setLayout(new FlowLayout(FlowLayout.LEFT));
        puserp.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel_in.add(new JLabel(" "));   panel_in.add(pusern);    panel_in.add(puserp);
        panel_in.add(pshowpas); panel_in.add(pbutns);

        label_img =  new JLabel(img);
        panel_img.add(label_img);   panel_img.setPreferredSize(new Dimension(200,230));

        panel_gl.add(panel_img);panel_gl.add(panel_in);
        panel_gl.setLayout(new BoxLayout(panel_gl,BoxLayout.X_AXIS));

        container.add(panel_gl);
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);


        this.validate();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        boolean test = false;
        String type;
        if (e.getSource() == loginButton) {
            String userText = userTextField.getText();
            String pwdText = passwordField.getText();

            if (userText.contains("AD")||userText.contains("WT")||userText.contains("CK")){
                for (User user: new UserManip().getAll()) {
                    if (userText.equalsIgnoreCase(user.getUsername()) && pwdText.equalsIgnoreCase(user.getPassword())) {
                        test = true;
                        this.dispose();
                        if (userText.contains("AD")){
                            new AdminFrame(user.getUsername());
                        }else if (userText.contains("CK"))
                            new CookerFrame();
                        else
                            new MenuFrame(user.getUsername()).setVisible(true);
                    }
                }
            } if(test == false) {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password","Error",JOptionPane.WARNING_MESSAGE);
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

}

