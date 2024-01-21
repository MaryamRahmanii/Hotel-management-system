import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Hotel extends JFrame{



    private CardLayout cardLayout;
    private JPanel cardpanel;

    public Hotel()
    {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hotel Management System");
        setSize(1700, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 2));



       panel1.setLayout(new BorderLayout());


       ImageIcon imageIcon=new ImageIcon("C:\\Users\\mehr\\Desktop\\HotelManagement\\src\\James-Gilleard-Grand-Budapest.jpg");
       Image image=imageIcon.getImage();
       Image newimage=image.getScaledInstance(1700,1000,Image.SCALE_SMOOTH);
        JLabel background=new JLabel(new ImageIcon(newimage));
        background.setBounds(0,0,1700,1000);
        panel1.add(background);

        background.setLayout(new FlowLayout());

        JButton button=new JButton("YOU'RE WELCOME");
        button.setBackground(new Color(234, 178, 218));
        cardLayout=new CardLayout();
        cardpanel=new JPanel(cardLayout);
        add(cardpanel);
        JPanel panel2=new JPanel();
        panel2.setBackground(new Color(233, 217, 234, 175));
        cardpanel.add(panel1,"welcome");

        panel2.setLayout(new GridLayout(3,3));

        JButton b1,b2,b3;

        b1=new JButton("Manager");
        b1.setBounds(100,100,30,10);
        b2=new JButton("employee");
        b2.setBounds(100,100,30,10);
        b3=new JButton("guests");
        b3.setBounds(100,100,30,10);

        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);

        JPanel panel3=new JPanel();

        panel3.setLayout(new GridLayout(2,2));

        panel3.setBackground(new Color(194, 238, 233));


        cardpanel.add(panel2,"position");
        cardpanel.add(panel3,"guests");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.next(cardpanel);
            }


        });


        background.add(button,BorderLayout.CENTER);


        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.next(cardpanel);
            }


        });


        JButton logguests=new JButton("LOG IN");
        JButton registerguests=new JButton("REGISTER");


        panel3.add(logguests);
        panel3.add(registerguests);

        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        panel4.setBackground(new Color(241, 179, 179));
        panel4.setBackground(new Color(241, 235, 179));
        cardpanel.add(panel4,"guestlogin");
        cardpanel.add(panel5,"guestregister");


        panel4.setLayout(new GridLayout(3,2));

        JLabel idlabel=new JLabel("National ID:");
        JTextField id=new JTextField();
        JLabel passlabel=new JLabel("Password:");
        JPasswordField pass=new JPasswordField();
        JButton loginbtn=new JButton("LOG IN");

        loginbtn.setBackground(new Color(146, 215, 212));

        panel4.add(idlabel);
        panel4.add(id);
        panel4.add(passlabel);
        panel4.add(pass);
        panel4.add(loginbtn);




        panel5.setLayout(new GridLayout(6, 2));

        JLabel nationalLabel = new JLabel("National ID:");
         JTextField nationalid = new JTextField();
        JLabel namedLabel = new JLabel("Name:");
        JTextField name = new JPasswordField();
        JLabel lastnameLabel = new JLabel("Last Name:");
        JTextField lastname = new JPasswordField();
        JLabel EmailLabel = new JLabel("Email:");
        JTextField Email = new JPasswordField();
        JLabel passwordlabel=new JLabel("Password:");
        JPasswordField passwordField=new JPasswordField();
        JButton registerButton = new JButton("Register");

        registerButton.setBackground(new Color(233, 217, 234, 175));



        panel5.add(nationalLabel);
        panel5.add(nationalid);
        panel5.add(namedLabel);
        panel5.add(name);
        panel5.add(lastnameLabel);
        panel5.add(lastname);
        panel5.add(EmailLabel);
        panel5.add(Email);
        panel5.add(passwordlabel);
        panel5.add(passwordField);
        panel5.add(registerButton);



        logguests.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.next(cardpanel);
            }


        });

        registerguests.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.next(cardpanel);
                cardLayout.next(cardpanel);
            }


        });




        setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        final String url="jdbc:mysql://localhost:3306/hotelsystem";
        final String user="root";

        Connection com;

        {
            try {
                com = DriverManager.getConnection(url,user,null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        String add="INSERT INTO guests(id,email,kodmeli,lastname,name,password)"+"VALUES(?,?,?,?,?,?)";

        PreparedStatement pst=com.prepareStatement(add);

//        pst.setInt(1,3);
//        pst.setString(2,"maryam@gmail.com");
//        pst.setString(3,"2081177020");
//        pst.setString(4,"cherati");
//        pst.setString(5,"nima");
//        pst.setString(6,"78910");
//        pst.executeUpdate();


}}
