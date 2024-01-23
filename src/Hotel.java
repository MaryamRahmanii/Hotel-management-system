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

        JPanel panel6=new JPanel();
        panel6.setLayout(new GridLayout(6,2));

        JLabel MidLabel = new JLabel("ID:");
        JTextField Mid = new JTextField();
        JLabel MnameLabel = new JLabel("Name:");
        JTextField Mname = new JPasswordField();
        JLabel MlastnameLabel = new JLabel("Last Name:");
        JTextField Mlastname = new JPasswordField();
        JLabel MEmailLabel = new JLabel("Email:");
        JTextField MEmail = new JPasswordField();
        JLabel Mpasswordlabel=new JLabel("Password:");
        JPasswordField MpasswordField=new JPasswordField();
        JButton Mlogin = new JButton("LOG IN");

       panel6.setBackground(new Color(218, 207, 240, 175));
       Mlogin.setBackground(new Color(161, 124, 238, 175));



        panel6.add(MidLabel);
        panel6.add(Mid);
        panel6.add(MnameLabel);
        panel6.add(Mname);
        panel6.add(MlastnameLabel);
        panel6.add(Mlastname);
        panel6.add(MEmailLabel);
        panel6.add(MEmail);
        panel6.add(Mpasswordlabel);
        panel6.add(MpasswordField);
        panel6.add(Mlogin);


        cardpanel.add(panel6,"Managerlogin");


        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.next(cardpanel);
                cardLayout.next(cardpanel);
                cardLayout.next(cardpanel);
                cardLayout.next(cardpanel);
            }


        });

       JPanel panel7=new JPanel();

        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.next(cardpanel);
                cardLayout.next(cardpanel);
                cardLayout.next(cardpanel);
                cardLayout.next(cardpanel);
                cardLayout.next(cardpanel);
            }


        });

        panel7.setLayout(new GridLayout(2,1));




        JButton logemployee=new JButton("LOG IN");
        JButton registeremployee=new JButton("REGISTER");




        panel7.add(logemployee,BorderLayout.CENTER);
        panel7.add(registeremployee,BorderLayout.CENTER);

        cardpanel.add(panel7,"employee section");















        JPanel panel8 =new JPanel();
        panel8.setLayout(new GridLayout(8,2));

        JLabel eidLabel = new JLabel("ID:");
        JTextField eid = new JTextField();
        JLabel enameLabel = new JLabel("Name:");
        JTextField ename = new JPasswordField();
        JLabel elastnameLabel = new JLabel("Last Name:");
        JTextField elastname = new JPasswordField();
        JLabel eEmailLabel = new JLabel("Email:");
        JTextField eEmail = new JPasswordField();
        JLabel epasswordlabel =new JLabel("Password:");
        JPasswordField epasswordField =new JPasswordField();
        JLabel salarylabel = new JLabel("Salary:");
        JTextField salary = new JPasswordField();
        JLabel banklabel = new JLabel("Bank account:");
        JTextField bank = new JPasswordField();
        JButton eregister = new JButton("Register");

        panel8.setBackground(new Color(218, 207, 240, 175));
        Mlogin.setBackground(new Color(218, 249, 249, 175));



        panel8.add(eidLabel);
        panel8.add(eid);
        panel8.add(enameLabel);
        panel8.add(ename);
        panel8.add(elastnameLabel);
        panel8.add(elastname);
        panel8.add(eEmailLabel);
        panel8.add(eEmail);
        panel8.add(epasswordlabel);
        panel8.add(epasswordField);
        panel8.add(salarylabel);
        panel8.add(salary);
        panel8.add(banklabel);
        panel8.add(bank);
        panel8.add(eregister);


        cardpanel.add(panel8,"Managerlogin");





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
