import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.SQLException;

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

            String searchguest="SELECT * FROM guests";
            PreparedStatement guestloginpst=com.prepareStatement(searchguest);
            ResultSet rs=guestloginpst.executeQuery();
        loginbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                String kodmeli=id.getText();
                String passlogguest=new String(pass.getPassword());
              try {


                  while (rs.next()) {
                      if (rs.getString(1).equals(kodmeli) && rs.getString(5).equals(passlogguest)) {
                          cardLayout.next(cardpanel);
                          cardLayout.next(cardpanel);
                          cardLayout.next(cardpanel);
                          cardLayout.next(cardpanel);
                          cardLayout.next(cardpanel);
                          cardLayout.next(cardpanel);

                      }
                  }

              }
              catch (SQLException exception)
              {
                  System.out.println("error");
              }
            }


        });










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

                        cardLayout.next(cardpanel);
                        cardLayout.next(cardpanel);
                        cardLayout.next(cardpanel);
                        cardLayout.next(cardpanel);
                        cardLayout.next(cardpanel);
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
            JTextField Mname = new JTextField();
            JLabel MlastnameLabel = new JLabel("Last Name:");
            JTextField Mlastname = new JTextField();
            JLabel MEmailLabel = new JLabel("Email:");
            JTextField MEmail = new JTextField();
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

            String Mpersoneli="2081177021";
            String Mnam="Maryam";
            String Mlast="Rahmani";
            String Maemail="Maryam.Rahmani@gmail.com";
            String Mpass="33323332Mr";

        Mlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                String managerpass=new String(MpasswordField.getPassword());

                if(Mid.getText().equals(Mpersoneli) && MEmail.getText().equals(Maemail) && managerpass.equals(Mpass))
                {
                    cardLayout.next(cardpanel);
                    cardLayout.next(cardpanel);
                    cardLayout.next(cardpanel);
                    cardLayout.next(cardpanel);
                    cardLayout.next(cardpanel);
                }

            }
        });



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

                    cardLayout.previous(cardpanel);
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


        String searchemployee="SELECT * FROM employees";
        PreparedStatement employeeloginpst=com.prepareStatement(searchemployee);
        ResultSet rs1 =employeeloginpst.executeQuery();
        emlog.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                String kodpersoneli =emid.getText();
                String passlogemployee =new String(empasswordField.getPassword());
                try {


                    while (rs1.next()) {
                        if (rs1.getString(1).equals(kodpersoneli) && rs1.getString(5).equals(passlogemployee)) {
                            cardLayout.next(cardpanel);
                            cardLayout.next(cardpanel);
                            cardLayout.next(cardpanel);

                        }
                    }

                }
                catch (SQLException exception)
                {
                    System.out.println("error");
                }
            }


        });




        cardpanel.add(panel9, "employeelogin");

                logemployee.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        cardLayout.next(cardpanel);
                        cardLayout.next(cardpanel);

                    }


                });



                JPanel panel10=new JPanel();
                panel10.setLayout(new GridLayout(2,1));

                JButton reserve=new JButton("Reserve");
                JButton returnroom=new JButton("Return");

                reserve.setBackground(new Color(202, 115, 177));
                returnroom.setBackground(new Color(234, 178, 218));

                panel10.add(reserve);
                panel10.add(returnroom);

                cardpanel.add(panel10,"guest abilitys");

                JPanel panel11=new JPanel();
                panel11.setLayout(new GridLayout(7,1));

                JButton seereservations=new JButton("See Reservations");
                JButton add_employee=new JButton("Add Employee");
                JButton fire_employee=new JButton("Fire A Employee");
                JButton changesalary=new JButton("Change The amount Of Salary");
                JButton changeprice=new JButton("Change price For A Room");
                JButton deactive=new JButton("Deactive A Room");
                JButton pay=new JButton("Pay A Employee");



                panel11.add(seereservations);
                panel11.add(add_employee);
                panel11.add(fire_employee);
                panel11.add(changesalary);
                panel11.add(changeprice);
                panel11.add(deactive);
                panel11.add(pay);

                cardpanel.add(panel11,"Manager abilitys");



                JPanel panel12=new JPanel();
                panel12.setLayout(new GridLayout(4,1));


                JButton confirmreservations=new JButton("Confirm Reservations");
                JButton confirmcancle=new JButton("Confirm Cancelations");
                JButton confirmed=new JButton("See Confirmed Reservations");
                JButton notconfirmed=new JButton("See Unconfirmed One's");


                panel12.add(confirmreservations);
                panel12.add(confirmcancle);
                panel12.add(confirmed);
                panel12.add(notconfirmed);


                cardpanel.add(panel12,"Employee abilitys");


                String searchreserve="SELECT * FROM reservations";
                PreparedStatement searchreservepst=com.prepareStatement(searchreserve);
                ResultSet rs2 =searchreservepst.executeQuery();

                JPanel panel13=new JPanel();
                cardpanel.add(panel13,"see reservations");

                seereservations.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
                            int i=0;
                            Object[][] data=new Object[60][6];
                            while (rs2.next())
                            {
                                data[i][0]=rs2.getDate(1);
                                data[i][1]=rs2.getString(2);
                                data[i][2]=rs2.getString(3);
                                data[i][3]=rs2.getString(4);
                                data[i][4]=rs2.getInt(5);
                                data[i][5]=rs2.getInt(6);
                                i++;

                            }

                            String[] cols={"Date","Guest National ID","Price","Employee ID","Time","Number Of The Room"};

                            JTable reservetable=new JTable(data,cols);

                            panel13.add(reservetable);

                            cardLayout.next(cardpanel);
                            cardLayout.next(cardpanel);

                        }catch (SQLException exception)
                        {
                            System.out.println(exception);
                        }

                    }


                });



                add_employee.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        cardLayout.previous(cardpanel);
                        cardLayout.previous(cardpanel);
                        cardLayout.previous(cardpanel);


                    }
                });


                String delete="DELETE FROM employees WHERE personeli = ?";
                PreparedStatement deletepst= com.prepareStatement(delete);
                JPanel panel14=new JPanel();
                panel14.setLayout(new GridLayout(3,1));
                JLabel kodpesonelikarmand=new JLabel("Employee ID:");
                JTextField textFieldkod=new JTextField();
                JButton deletebtn=new JButton("Delete");
                deletebtn.setBackground(new Color(161, 124, 238, 175));
                panel14.setBackground(new Color(218, 207, 240, 175));
                panel14.add(kodpesonelikarmand);
                panel14.add(textFieldkod);
                panel14.add(deletebtn);

                cardpanel.add(panel14,"Fire employee");

                deletebtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            deletepst.setString(1,textFieldkod.getText());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            deletepst.executeUpdate();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                        cardLayout.previous(cardpanel);
                        cardLayout.previous(cardpanel);
                        cardLayout.previous(cardpanel);
                    }
                });

                fire_employee.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        cardLayout.next(cardpanel);
                        cardLayout.next(cardpanel);
                        cardLayout.next(cardpanel);
                    }
                });

                String changeslry="UPDATE employees SET salary=? WHERE personeli = ?";
                PreparedStatement slrypst=com.prepareStatement(changeslry);
                JPanel pane15 =new JPanel();
                pane15.setLayout(new GridLayout(5,1));
                JLabel kodpesonelikarmand1 =new JLabel("Employee ID:");
                JTextField textFieldkod1 =new JTextField();
                JLabel newsly=new JLabel("New Salary:");
                JTextField newslrytxt=new JTextField();
                JButton changebtn=new JButton("Change");
                changebtn.setBackground(new Color(16, 124, 238, 175));
                pane15.add(kodpesonelikarmand1);
                pane15.add(textFieldkod1);
                pane15.add(newsly);
                pane15.add(newslrytxt);
                pane15.add(changebtn);

                changesalary.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
                            slrypst.setString(1,newslrytxt.getText());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            slrypst.setString(2,textFieldkod1.getText());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            slrypst.executeUpdate();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                        cardLayout.previous(cardpanel);
                        cardLayout.previous(cardpanel);
                        cardLayout.previous(cardpanel);
                        cardLayout.previous(cardpanel);
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













