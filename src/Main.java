import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.org.apache.xerces.internal.util.DOMUtil.setVisible;

public class Main {
    public static void main(String[] args) throws SQLException {
//
         CardLayout cardLayout;
         JPanel cardpanel;

         JFrame frame=new JFrame("Hotel Management System");


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
            frame.add(cardpanel);
            JPanel panel2=new JPanel();
            panel2.setBackground(new Color(233, 217, 234, 175));
            cardpanel.add(panel1,"welcome");

            panel2.setLayout(new GridLayout(4,1));

            JButton b1,b2,b3;

            b1=new JButton("Manager");
            b1.setBounds(100,100,30,10);
            b2=new JButton("employee");
            b2.setBounds(100,100,30,10);
            b3=new JButton("guests");
            b3.setBounds(100,100,30,10);
            JButton previous1 =new JButton("PREVIOUS PAGE");
            previous1.setBackground(new Color(169, 166, 166));

            panel2.add(b1);
            panel2.add(b2);
            panel2.add(b3);
            panel2.add(previous1);

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

            previous1.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    cardLayout.previous(cardpanel);
                }


            });


            JButton logguests=new JButton("LOG IN");
            JButton registerguests=new JButton("REGISTER");
            JButton previous2 =new JButton("PREVIOUS PAGE");
            previous2.setBackground(new Color(169, 166, 166));


            panel3.add(logguests);
            panel3.add(registerguests);
            panel3.add(previous2);

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
            JButton previous3 =new JButton("PREVIOUS PAGE");
            previous3.setBackground(new Color(169, 166, 166));

            loginbtn.setBackground(new Color(146, 215, 212));

            panel4.add(idlabel);
            panel4.add(id);
            panel4.add(passlabel);
            panel4.add(pass);
            panel4.add(loginbtn);
            panel4.add(previous3);




            panel5.setLayout(new GridLayout(6, 2));

            JLabel nationalLabel = new JLabel("National ID:");
            JTextField nationalid = new JTextField();
            JLabel namedLabel = new JLabel("Name:");
            JTextField name = new JTextField();
            JLabel lastnameLabel = new JLabel("Last Name:");
            JTextField lastname = new JTextField();
            JLabel EmailLabel = new JLabel("Email:");
            JTextField Email = new JTextField();
            JLabel passwordlabel=new JLabel("Password:");
            JPasswordField passwordField=new JPasswordField();
            JButton registerButton = new JButton("Register");
            JButton previous4 =new JButton("PREVIOUS PAGE");
            previous4.setBackground(new Color(169, 166, 166));

            registerButton.setBackground(new Color(233, 217, 234, 175));

            String addguest="INSERT INTO guests(id,name,lastname,email,password)"+"VALUES(?,?,?,?,?)";
            PreparedStatement guestpst=com.prepareStatement(addguest);

            registerButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    String em=Email.getText();
                    String pas = new String(passwordField.getPassword());

                    if( emailisvalid(em) && Passwordisvalid(pas))
                    {
                        String kod = nationalid.getText();
                        String nam = name.getText();
                        String khanevadegi = lastname.getText();


                        try {
                            guestpst.setString(1, kod);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                        try {
                            guestpst.setString(2, nam);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            guestpst.setString(3, khanevadegi);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            guestpst.setString(4, em);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            guestpst.setString(5, pas);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            guestpst.executeUpdate();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }



                }


            });



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
            panel5.add(previous4);



            logguests.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    cardLayout.next(cardpanel);
                }


            });

            previous2.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    cardLayout.previous(cardpanel);
                }


            });

            registerguests.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    cardLayout.next(cardpanel);
                    cardLayout.next(cardpanel);
                }


            });

            previous3.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    cardLayout.previous(cardpanel);
                    cardLayout.previous(cardpanel);
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
            JButton previous5 =new JButton("PREVIOUS PAGE");
            previous5.setBackground(new Color(169, 166, 166));

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

            previous4.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    cardLayout.previous(cardpanel);
                    cardLayout.previous(cardpanel);
                    cardLayout.previous(cardpanel);
                    cardLayout.previous(cardpanel);
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
            JButton previous6 =new JButton("PREVIOUS PAGE");
            previous6.setBackground(new Color(169, 166, 166));




            panel7.add(logemployee,BorderLayout.CENTER);
            panel7.add(registeremployee,BorderLayout.CENTER);

            cardpanel.add(panel7,"employee section");

            registeremployee.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    cardLayout.next(cardpanel);

                }


            });















            JPanel panel8 =new JPanel();
            panel8.setLayout(new GridLayout(8,2));

            JLabel eidLabel = new JLabel("ID:");
            JTextField eid = new JTextField();
            JLabel enameLabel = new JLabel("Name:");
            JTextField ename = new JTextField();
            JLabel elastnameLabel = new JLabel("Last Name:");
            JTextField elastname = new JTextField();
            JLabel eEmailLabel = new JLabel("Email:");
            JTextField eEmail = new JTextField();
            JLabel epasswordlabel =new JLabel("Password:");
            JPasswordField epasswordField =new JPasswordField();
            JLabel salarylabel = new JLabel("Salary:");
            JTextField salary = new JTextField();
            JLabel banklabel = new JLabel("Bank account:");
            JTextField bank = new JTextField();
            JButton eregister = new JButton("Register");
            JButton previous7 =new JButton("PREVIOUS PAGE");
            previous7.setBackground(new Color(169, 166, 166));

        String addemployee="INSERT INTO employees(personeli,name,lastname,email,password,salary,bankaccount)"+"VALUES(?,?,?,?,?,?,?)";
        PreparedStatement employeepst=com.prepareStatement(addemployee);
        eregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String emailTextem = eEmail.getText();
                String epas = new String(epasswordField.getPassword());

                if (emailisvalid(emailTextem) && Passwordisvalid(epas)) {
                    String personelikod = eid.getText();
                    String enam = ename.getText();
                    String ekhanevadegi = elastname.getText();
                    String esalary = salary.getText();
                    String ebank = bank.getText();


                    try {
                        employeepst.setString(1, personelikod);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        employeepst.setString(2, enam);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        employeepst.setString(3, ekhanevadegi);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        employeepst.setString(4, emailTextem);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        employeepst.setString(5, epas);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        employeepst.setString(6,esalary);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        employeepst.setString(7,ebank);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        employeepst.executeUpdate();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }});


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


                cardpanel.add(panel8, "employeeregister");


                JPanel panel9 = new JPanel();
                panel9.setLayout(new GridLayout(3, 2));

                JLabel emidLabel = new JLabel("ID:");
                JTextField emid = new JTextField();
                JLabel empasswordlabel = new JLabel("Password:");
                JPasswordField empasswordField = new JPasswordField();
                JButton emlog = new JButton("LOG IN");
                JButton previous8 = new JButton("PREVIOUS PAGE");
                previous8.setBackground(new Color(169, 166, 166));

                panel9.setBackground(new Color(242, 154, 154));
                emlog.setBackground(new Color(238, 98, 98));

                panel9.add(emidLabel);
                panel9.add(emid);
                panel9.add(empasswordlabel);
                panel9.add(empasswordField);
                panel9.add(emlog);

                cardpanel.add(panel9, "employeelogin");

                logemployee.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        cardLayout.next(cardpanel);
                        cardLayout.next(cardpanel);

                    }


                });


                frame.setVisible(true);
            }


            public static boolean emailisvalid(String email) {

                boolean check;
                Pattern pattern = Pattern.compile("^([_A-Za-z0-9-\\+])+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher matcher = pattern.matcher(email);
                if (matcher.matches()) {
                    check = true;
                } else {
                    check = false;
                }
                return check;
            }


            public static boolean pass1(String password) {
                boolean check;
                Pattern pattern1 = Pattern.compile("([a-z])+");
                Matcher matcher1 = pattern1.matcher(password);
                if (matcher1.find()) {
                    check = true;
                } else {
                    check = false;
                }
                return check;
            }

            public static boolean pass2(String password) {
                boolean check;
                Pattern pattern2 = Pattern.compile("([A-Z])+");
                Matcher matcher2 = pattern2.matcher(password);
                if (matcher2.find()) {
                    check = true;
                } else {
                    check = false;
                }
                return check;
            }

            public static boolean pass3(String password) {
                boolean check;
                Pattern pattern3 = Pattern.compile("([0-9])+");
                Matcher matcher3 = pattern3.matcher(password);
                if (matcher3.find()) {
                    check = true;
                } else {
                    check = false;
                }
                return check;
            }

            public static boolean pass4(String password) {
                boolean check;
                Pattern pattern3 = Pattern.compile("([@#_!])+");
                Matcher matcher3 = pattern3.matcher(password);
                if (matcher3.find()) {
                    check = true;
                } else {
                    check = false;
                }
                return check;
            }


            private static boolean Passwordisvalid(String password) {

                int counter = 0;
                boolean isvalid = false;
                int count = 0;
                boolean check1 = pass1(password);
                boolean check2 = pass2(password);
                boolean check3 = pass3(password);
                boolean check4 = pass4(password);
                if (check1 || check2 || check3) {
                    counter++;
                }
                if (check1 && check2) {
                    counter++;
                }
                if (check1 || check2 && check3) {
                    counter++;
                }
                if (check1 || check2 && check4) {
                    counter++;
                }

                for (int i = 0; i < password.length(); i++) {
                    count++;

                }
                if (count > 8) {
                    counter++;
                }
                if (counter > 3) {
                    isvalid = true;
                }
                return isvalid;
            }
}













