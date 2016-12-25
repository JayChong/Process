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
public class CustomerPayment extends JFrame{
    private Connection conn;
    private ResultSet rs;
    private ResultSet rs1;
    private PreparedStatement stmt;
    private PreparedStatement stmt1;
    String host = "jdbc:derby://localhost:1527/kkkldb3";
    String user = "nbuser";
    String password = "nbuser";
    private CustomerPaymentDomain customerpaymentdomain;
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
    
    private JTextField jtfCustID=new JTextField();
    private JTextField jtfName=new JTextField();
    private JTextField jtfEmail=new JTextField();
    private JTextField jtfBankType=new JTextField();
    private JTextField jtfCardNumber=new JTextField();
    private JTextField jtfExpiredDate=new JTextField();
    private JTextField jtfCVC=new JTextField();
    private JTextField jtfPaymentDate=new JTextField();
    
    private JPanel PanelCenter=new JPanel(new GridLayout(1,1));
    private JButton jbtPayment=new JButton("Make Payment");
    private JPanel PanelCenterUp=new JPanel(new GridLayout(1,2));
    private JPanel PanelCenter1=new JPanel(new GridLayout(10,2));
    private JPanel PanelCenter2=new JPanel(new GridLayout(8,2));
    private JPanel PanelCenterDown=new JPanel();
    private JButton jbtRecall=new JButton("Recall payment and back to homepage");
    private JButton jbthome=new JButton("Back to home page");
    public CustomerPayment(CustomerPaymentDomain customerpaymentdomain){
        System.out.println("here");
                 setConnection();
                 setTitle(" Customer Payment");
        setLayout(new BorderLayout());
        String id=customerpaymentdomain.getPaymentID();
        Date date=customerpaymentdomain.getDate();
        String timedepart=customerpaymentdomain.getTimeDepart();
        String timearrive=customerpaymentdomain.getArrive();
        String origin=customerpaymentdomain.getOrigin();
        String destination=customerpaymentdomain.getDestination();
        Double price=customerpaymentdomain.getPrice();
        String busid=customerpaymentdomain.getBusID();
        String custid=customerpaymentdomain.getCustID();
        jtfPaymentid.setText(id);
        jtfdate.setText(date+"");
        jtftimedepart.setText(timedepart);
        jtftimearrive.setText(timearrive);
        jtforigin.setText(origin);
        jtfdestination.setText(destination);
        jtfPrice.setText(price+"");
        jtfBusid.setText(busid);
        jtfCustID.setText(custid);
        
        jtfPaymentid.setEditable(false);
        jtfdate.setEditable(false);
        jtftimedepart.setEditable(false);
        jtftimearrive.setEditable(false);
        jtforigin.setEditable(false);
        jtfdestination.setEditable(false);
        jtfPrice.setEditable(false);
        jtfBusid.setEditable(false);
        jtfTicketAmount.setEditable(false);
        jtfCustID.setEditable(false);
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

        PanelCenter2.add(new JLabel("Customer ID:"));
        PanelCenter2.add(jtfCustID);
        PanelCenter2.add(new JLabel("Name:"));
        PanelCenter2.add(jtfName);
        PanelCenter2.add(new JLabel("Email:"));
        PanelCenter2.add(jtfEmail);
        PanelCenter2.add(new JLabel("Type of bank:"));
        PanelCenter2.add(jtfBankType);
        PanelCenter2.add(new JLabel("Card Number:"));
        PanelCenter2.add(jtfCardNumber);
        PanelCenter2.add(new JLabel("Expired date:"));
        PanelCenter2.add(jtfExpiredDate);
        PanelCenter2.add(new JLabel("Card Validation Code:"));
        PanelCenter2.add(jtfCVC);
        PanelCenter2.add(new JLabel("Purchased Date:"));
        PanelCenter2.add(jtfPaymentDate);
        PanelCenterUp.add(PanelCenter1);
        PanelCenterUp.add(PanelCenter2);
        PanelCenterDown.add(jbtPayment);
        PanelCenterDown.add(jbtRecall);
        PanelCenterDown.add(jbthome);
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
                          updateCustomerRecord();
                         

                    //      updatePaymentRecord();
                      }
                  });
       jbtRecall.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent e){
                          int answer= JOptionPane.showConfirmDialog(null,"Are you sure you want to recall the payment?","Recall payment",JOptionPane.YES_NO_OPTION);
                          if(answer==JOptionPane.YES_OPTION){
                          deleteTicket(jtfPaymentid.getText());
                          deletePayment(jtfPaymentid.getText());
                              deleteCustomer(jtfCustID.getText());
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
      
//public class UpdatePayment implements ActionListener{
//
//         public void actionPerformed(ActionEvent e){
//             try{
//                 String id=jtfPaymentid.getText();
//                 String paymentdate=jtf
//                if(jtfPaymentid!=null){
//                 String strSQL = "UPDATE PAYMENT SET PAYMENT_ID=?,TOTALPRICE=?,PAYMENT_DATE=?,STAFF_ID=?,CUSTOMER_IC=? WHERE BUSSCHEDULE_ID=? ";
//                 stmt = conn.prepareStatement(strSQL);                
//                
//                 stmt.setString(1,id);
//                 stmt.setString(2,TimeDepart);
//                 stmt.setString(3, TimeArrive);
//                 stmt.setString(4, ORigin);
//                 stmt.setString(5, Destination);
//                 stmt.setDouble(6, price1);
//                 stmt.setString(7,BusID);
//                 stmt.setString(8, ID);
//                 stmt.executeUpdate();
//              JOptionPane.showMessageDialog(null, "Schedule nnfo updated.");
//                 st.retrieveRecordsByCode(jtfBusScheduleID.getText());
//                Statement stmtInsert = conn.createStatement();
//                 stmtInsert.executeUpdate(strSQL);
//              
//             //    if(result > 0 )
//                     }
//                else
//                     JOptionPane.showMessageDialog(null, "Info Not Found.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
//                  
//             }catch(SQLException ex){
//                 System.err.println("DB ERROR:"+ex.toString());
//             }
//             ClearText();
//         }}
//       public class UpdateListener implements ActionListener{
//
//         public void actionPerformed(ActionEvent e){
//             try{
//                 
//                 String custid =jtfCustID.getText();
//                 String name = jtfName.getText();
//                 String email = jtfEmail.getText();
//                 String banktype = jtfBankType.getText();
//                 String cardnum= jtfCardNumber.getText();
//                 int cardnumber=Integer.parseInt(cardnum);
//                 String expireddate =jtfExpiredDate.getText();
//                 String cvc=jtfCVC.getText();
//                 int CardValidationCode=Integer.parseInt(cvc);
//                 
//                 String strSQL = "UPDATE CUSTOMER SET CUSTOMER_NAME=?,CUSTOMER_EMAIL=?,CUSTOMER_BANKTYPE=?,CUSTOMER_CARDNUM=?,CUSTOMER_EXPDATE=?,CUSTOMER_CVC=? WHERE CUSTOMER_ID=? ";
//                 stmt = conn.prepareStatement(strSQL);                
//                
//                 stmt.setString(1,name);
//                 stmt.setString(2,email);
//                 stmt.setString(3, banktype);
//                 stmt.setInt(4, cardnumber);
//                 stmt.setString(5, expireddate);
//                 stmt.setInt(6, CardValidationCode);
//                 stmt.setString(7,custid);
//                 stmt.executeUpdate();
//              JOptionPane.showMessageDialog(null, "Payment made successfully!");
//                Statement stmtInsert = conn.createStatement();
//                 stmtInsert.executeUpdate(strSQL);
//                  
//             }catch(SQLException ex){
//                 System.err.println("DB ERROR:"+ex.toString());
//             }
//         }}
//       
//       
//        public void updateRecord() {
//        String queryStr = "SELECT * FROM PAYMENT WHERE PAYMENT_ID= ?";
//        ResultSet rs = null;
//        try {
//                 String custid =jtfCustID.getText();
//                 String name = jtfName.getText();
//                 String email = jtfEmail.getText();
//                 String banktype = jtfBankType.getText();
//                 String cardnum= jtfCardNumber.getText();
//                 int cardnumber=Integer.parseInt(cardnum);
//                 String expireddate =jtfExpiredDate.getText();
//                 String cvc=jtfCVC.getText();
//                 int CardValidationCode=Integer.parseInt(cvc);
//                 
//                 String strSQL = "UPDATE CUSTOMER SET CUSTOMER_NAME=?,CUSTOMER_EMAIL=?,CUSTOMER_BANKTYPE=?,CUSTOMER_CARDNUM=?,CUSTOMER_EXPDATE=?,CUSTOMER_CVC=? WHERE CUSTOMER_ID=? ";
//                 stmt = conn.prepareStatement(strSQL);                
//                
//                 stmt.setString(1,name);
//                 stmt.setString(2,email);
//                 stmt.setString(3, banktype);
//                 stmt.setInt(4, cardnumber);
//                 stmt.setString(5, expireddate);
//                 stmt.setInt(6, CardValidationCode);
//                 stmt.setString(7,custid);
//                 stmt.executeUpdate();
//              JOptionPane.showMessageDialog(null, "Payment made successfully!");
//                Statement stmtInsert = conn.createStatement();
//                 stmtInsert.executeUpdate(strSQL);
//              
//        } catch (SQLException ex) {
//           // JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//    }
        
        public void updateCustomerRecord() {
        try {
                   if((jtfName.getText()).equals("")){
                   JOptionPane.showMessageDialog(null, "Name cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);      
                     }
                   else if (!jtfName.getText().matches("[a-zA-Z ]+")) {
                       JOptionPane.showMessageDialog(null, "Name must be string.", "Format error", JOptionPane.ERROR_MESSAGE);
                   }
                   else if((jtfEmail.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "Email cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }
                   else if((jtfBankType.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "bank Type cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }else if (!jtfBankType.getText().matches("[a-zA-Z ]+")) {
                       JOptionPane.showMessageDialog(null, "Type of bank must be string.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }
                   else if((jtfCardNumber.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "Card Number cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }else if (!jtfCardNumber.getText(). matches("[0-9.]+")) {
                       JOptionPane.showMessageDialog(null, "Card Number must be number.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }else if (jtfCardNumber.getText().length()>16 || jtfCardNumber.getText().length()<16) {
                       JOptionPane.showMessageDialog(null, "Card number must have 16 digits", "Format error", JOptionPane.ERROR_MESSAGE);
                 }
                   else if((jtfExpiredDate.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "Expired Date cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }else if (jtfExpiredDate.getText().length()>5 || jtfExpiredDate.getText().length()<5) {
                       JOptionPane.showMessageDialog(null, "Expired date can only be 5 digits", "Format error", JOptionPane.ERROR_MESSAGE);
                 }else if (!jtfExpiredDate.getText(). matches("[0-9/]+")) {
                       JOptionPane.showMessageDialog(null, "CVC must be number.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }
                   else if((jtfCVC.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "CVC cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }else if (jtfCVC.getText().length()>3 || jtfCVC.getText().length()<3) {
                       JOptionPane.showMessageDialog(null, "CVV can only be 3 digits", "Format error", JOptionPane.ERROR_MESSAGE);
                 }else if (!jtfCVC.getText(). matches("[0-9]+")) {
                       JOptionPane.showMessageDialog(null, "CVC must be number.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }else if((jtfPaymentDate.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "Date cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }else if (!jtfPaymentDate.getText().matches("[0-9-]+")) {
                       JOptionPane.showMessageDialog(null, "Date only allow integer.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }else if (jtfPaymentDate.getText().length()>10 || jtfPaymentDate.getText().length()<10) {
                       JOptionPane.showMessageDialog(null, "Date Format must consists of 10 characers", "Format error", JOptionPane.ERROR_MESSAGE);         
                 }
                   else{
                     int answer= JOptionPane.showConfirmDialog(null,"Are you sure you want to make payment?","Confirm payment",JOptionPane.YES_OPTION);
                          if(answer==JOptionPane.YES_OPTION){
                              String custid =jtfCustID.getText();
                 String name = jtfName.getText();
                 String email = jtfEmail.getText();
                 String banktype = jtfBankType.getText();
                 String cardnum= jtfCardNumber.getText();
                // int cardnumber=Integer.parseInt(cardnum);
                 String expireddate =jtfExpiredDate.getText();
                 String cvc=jtfCVC.getText();
                 int CardValidationCode=Integer.parseInt(cvc);
                 
                 String strSQL = "UPDATE CUSTOMER SET CUSTOMER_NAME=?,CUSTOMER_EMAIL=?,CUSTOMER_BANKTYPE=?,CUSTOMER_CARDNUM=?,CUSTOMER_EXPDATE=?,CUSTOMER_CVC=? WHERE CUSTOMER_ID=? ";
                 stmt1 = conn.prepareStatement(strSQL);                
                
                 stmt1.setString(1,name);
                 stmt1.setString(2,email);
                 stmt1.setString(3, banktype);
                 stmt1.setString(4, cardnum);
                 stmt1.setString(5, expireddate);
                 stmt1.setInt(6, CardValidationCode);
                 stmt1.setString(7,custid);
                 stmt1.executeUpdate();
                  updatePaymentRecord();
                  dispose();
                 new HomePage();
                Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL);
                
                         
                          }
                 
                 
                     
                 
          }
        } catch (SQLException ex) {
           // JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
        
        public void updatePaymentRecord() {
        try {
            
            String paymentid=jtfPaymentid.getText();
            double totalprice=Double.parseDouble(jtfTotalPayment.getText());
            Date paymentdate=Date.valueOf(jtfPaymentDate.getText());
            String CustomerID=jtfCustID.getText();
                 
                 String strSQL = "UPDATE PAYMENT SET TOTALPRICE=?,PAYMENT_DATE=? WHERE PAYMENT_ID=?";
                 stmt = conn.prepareStatement(strSQL);                
                

                 stmt.setDouble(1,totalprice);
                 stmt.setDate(2,paymentdate);
                // stmt.setString(4,"GUEST");
                 stmt.setString(3,paymentid);

                 stmt.executeUpdate();

                Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL);        
              
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
        public void deleteCustomer(String CUSTOMERID) {
        try {
            String deleteStr1 = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID  = ?";
            stmt = conn.prepareStatement(deleteStr1);
            stmt.setString(1, CUSTOMERID);
            stmt.executeUpdate();
        }
        catch (NullPointerException | ArrayIndexOutOfBoundsException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
        
}