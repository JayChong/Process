/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.lang.*;

/**
 *
 * @author alvin
 */
public class StaffPayment extends JFrame{
    private Connection conn;
    private ResultSet rs;
    private ResultSet rs1;
    private PreparedStatement stmt;
    private PreparedStatement stmt1;
    String host = "jdbc:derby://localhost:1527/kkkldb3";
    String user = "nbuser";
    String password = "nbuser";
    private StaffPaymentDomain staffpaymentdomain;
    private int i = 0;

    private JTextField jtfPaymentid=new JTextField();
    private JTextField jtfdate=new JTextField();
    private JTextField jtftimedepart=new JTextField();
    private JTextField jtftimearrive=new JTextField();
    private JTextField jtforigin=new JTextField();
    private JTextField jtfdestination=new JTextField();
    private JTextField jtfPrice=new JTextField();
    private JTextField jtfBusid=new JTextField();
    private JTextField jtfTicketAmount=new JTextField();
    private JTextField jtfTotalPayment=new JTextField();
    
    private JTextField jtfstaffid=new JTextField();
    private JTextField jtfPaymentDate=new JTextField();
    
    private JPanel PanelCenter=new JPanel(new GridLayout(1,1));
    private JButton jbtPayment=new JButton("Make Payment");
    private JPanel PanelCenterUp=new JPanel(new GridLayout(1,2));
    private JPanel PanelCenter1=new JPanel(new GridLayout(10,2));
    private JPanel PanelCenter2=new JPanel(new GridLayout(8,2));
    private JPanel PanelCenterDown=new JPanel();
    private JButton jbtHome=new JButton("Back To Homepage");
    private JButton jbtRecall=new JButton("Recall Payment and back to home page");
    private JButton jbthome=new JButton("Back to home page");
    public StaffPayment(StaffPaymentDomain staffpaymentdomain){
        System.out.println("here");
                 setConnection();
                 setTitle("Payment");
        setLayout(new BorderLayout());
        String id=staffpaymentdomain.getPaymentID();
        Date date=staffpaymentdomain.getDate();
        String timedepart=staffpaymentdomain.getTimeDepart();
        String timearrive=staffpaymentdomain.getArrive();
        String origin=staffpaymentdomain.getOrigin();
        String destination=staffpaymentdomain.getDestination();
        Double price=staffpaymentdomain.getPrice();
        String busid=staffpaymentdomain.getBusID();
        String staffid=staffpaymentdomain.getStaffID();
        jtfPaymentid.setText(id);
        jtfdate.setText(date+"");
        jtftimedepart.setText(timedepart);
        jtftimearrive.setText(timearrive);
        jtforigin.setText(origin);
        jtfdestination.setText(destination);
        jtfPrice.setText(price+"");
        jtfBusid.setText(busid);
        jtfstaffid.setText(staffid);
        
        jtfPaymentid.setEditable(false);
        jtfdate.setEditable(false);
        jtftimedepart.setEditable(false);
        jtftimearrive.setEditable(false);
        jtforigin.setEditable(false);
        jtfdestination.setEditable(false);
        jtfPrice.setEditable(false);
        jtfBusid.setEditable(false);
        jtfTicketAmount.setEditable(false);
        jtfstaffid.setEditable(false);
        jtfTotalPayment.setEditable(false);
        PanelCenter1.add(new JLabel("Payment ID:"));
        PanelCenter1.add(jtfPaymentid);
        PanelCenter1.add(new JLabel("Trip Date:"));
        PanelCenter1.add(jtfdate);
        PanelCenter1.add(new JLabel("Time Depart:"));
        PanelCenter1.add(jtftimedepart);
        PanelCenter1.add(new JLabel("Time Arrive:"));
        PanelCenter1.add(jtftimearrive);
        PanelCenter1.add(new JLabel("Origin:"));
        PanelCenter1.add(jtforigin);
        PanelCenter1.add(new JLabel("Destnation:"));
        PanelCenter1.add(jtfdestination);
        PanelCenter1.add(new JLabel("Price(RM):"));
        PanelCenter1.add(jtfPrice);
        PanelCenter1.add(new JLabel("Bus ID:"));
        PanelCenter1.add(jtfBusid);
        PanelCenter1.add(new JLabel("Total Ticket purchased:"));
        PanelCenter1.add(jtfTicketAmount);
        PanelCenter1.add(new JLabel("Total Payment:"));
        PanelCenter1.add(jtfTotalPayment);

        PanelCenter2.add(new JLabel("staff ID:"));
        PanelCenter2.add(jtfstaffid);
        PanelCenter2.add(new JLabel("Purchased Date:"));
        PanelCenter2.add(jtfPaymentDate);
//        PanelCenter2.add(new JLabel("Name:"));
//        PanelCenter2.add(jtfName);
//        PanelCenter2.add(new JLabel("Email:"));
//        PanelCenter2.add(jtfEmail);
//        PanelCenter2.add(new JLabel("Type of bank:"));
//        PanelCenter2.add(jtfBankType);
//        PanelCenter2.add(new JLabel("Card Number:"));
//        PanelCenter2.add(jtfCardNumber);
//        PanelCenter2.add(new JLabel("Expired date:"));
//        PanelCenter2.add(jtfExpiredDate);
//        PanelCenter2.add(new JLabel("Card Validation Code:"));
//        PanelCenter2.add(jtfCVC);
//        PanelCenter2.add(new JLabel("Purchased Date:"));
        PanelCenterUp.add(PanelCenter1);
        PanelCenterUp.add(PanelCenter2);
        PanelCenterDown.add(jbtPayment);
        PanelCenterDown.add(jbtRecall);
        PanelCenterDown.add(jbtHome);
        PanelCenter.add(PanelCenterUp);
        add(PanelCenter,BorderLayout.CENTER);
        add(PanelCenterDown,BorderLayout.SOUTH);
       try {
                
                ResultSet rs = CountTicket(id);
                while (rs.next())
                {
                             i++;
                             this.i=i;
//                    System.out.println("inside");
                    
                } 
                
                jtfTicketAmount.setText(i+"");
                double totalprice=i*price;
                jtfTotalPayment.setText(totalprice+"");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
//           jbtPayment.addActionListener(new UpdatePayment());
       jbtPayment.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent e){
                          updatePaymentRecord();
                          
                      
                      }
                  });
//       jbtHome.addActionListener(new ActionListener(){
//                      public void actionPerformed(ActionEvent e){
//                          dispose();
//                          HomePage home=new HomePage();
//                      }
//                  });
       
       
        jbtRecall.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent e){
                          
                         int answer= JOptionPane.showConfirmDialog(null,"Are you sure you want to recall the payment?","Recall payment",JOptionPane.YES_NO_OPTION);
                          if(answer==JOptionPane.YES_OPTION){
                          deleteTicket(jtfPaymentid.getText());
                          deletePayment(jtfPaymentid.getText());
                          
                          }
                          else if (answer==JOptionPane.NO_OPTION){
                              remove(answer);
                          }
                          dispose();
                          HomePage home=new HomePage();
                      }
                  });
        jbthome.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent e){
                        
                          dispose();
                          HomePage home=new HomePage();
                      }
                  });
        pack();
        setSize(553,382);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
     private void setConnection(){
         String host = "jdbc:derby://localhost:1527/kkkldb3";
         String user = "nbuser";
         String password = "nbuser";
         
         try{
             conn = DriverManager.getConnection(host,user,password);
             
         }catch(Exception ex){
             System.err.println("DB ERROR: "+ex.toString());
         }
     }

     
      public ResultSet CountTicket(String paymentid) {
               int i=0;
        String queryStr = "SELECT * FROM TICKET WHERE PAYMENT_ID=?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, paymentid);
            rs = stmt.executeQuery();
           
            
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
        return rs;
    }
      public ResultSet selectRecord(String ID) {
        String queryStr = "SELECT * FROM PAYMENT WHERE PAYMENT_ID= ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("GOT RETURN!"); 
        return rs;
    }

        
        public void updatePaymentRecord() {
        try {
            if((jtfPaymentDate.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "Date cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }else if (!jtfPaymentDate.getText().matches("[0-9-]+")) {
                       JOptionPane.showMessageDialog(null, "Date only allow integer.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }else if (jtfPaymentDate.getText().length()>10 || jtfPaymentDate.getText().length()<10) {
                       JOptionPane.showMessageDialog(null, "Date Format must consists of 10 characters", "Format error", JOptionPane.ERROR_MESSAGE);         
                 }else{
                     int answer= JOptionPane.showConfirmDialog(null,"Are you sure you want to make payment?","Confirm payment",JOptionPane.YES_OPTION);
                          if(answer==JOptionPane.YES_OPTION){
                              String paymentid=jtfPaymentid.getText();
            double totalprice=Double.parseDouble(jtfTotalPayment.getText());
            Date paymentdate=Date.valueOf(jtfPaymentDate.getText());
            String StaffID=jtfstaffid.getText();
                 
                 String strSQL = "UPDATE PAYMENT SET TOTALPRICE=?,PAYMENT_DATE=? WHERE PAYMENT_ID=?";
                 stmt = conn.prepareStatement(strSQL);                
                

               //  stmt.setString(1, paymentid);
                 stmt.setDouble(1,totalprice);
                 stmt.setDate(2,paymentdate);
                // stmt.setString(4,"GUEST");
                 stmt.setString(3,paymentid);
                 

                 stmt.executeUpdate();
                 dispose();
                 new HomePage();
                Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL);
//                     dispose();
//                     HomePage home=new HomePage();
                          
                          }
            
                 }
        } catch (SQLException ex) {
           // JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
        
        public void deleteTicket(String PAYMENTID) {
        try {
            String deleteStr1 = "DELETE FROM TICKET WHERE PAYMENT_ID  = ?";
            stmt = conn.prepareStatement(deleteStr1);
            stmt.setString(1, PAYMENTID);
            stmt.executeUpdate();
        }
        catch (NullPointerException | ArrayIndexOutOfBoundsException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
        public void deletePayment(String PAYMENTID) {
        try {
            String deleteStr1 = "DELETE FROM PAYMENT WHERE PAYMENT_ID  = ?";
            stmt = conn.prepareStatement(deleteStr1);
            stmt.setString(1, PAYMENTID);
            stmt.executeUpdate();
        }
        catch (NullPointerException | ArrayIndexOutOfBoundsException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}