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
public class Payment extends JFrame{
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    String host = "jdbc:derby://localhost:1527/kkkldb3";
    String user = "nbuser";
    String password = "nbuser";
    private PaymentDomain paymentdomain;
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
    
    private JTextField jtfIC=new JTextField();
    private JTextField jtfName=new JTextField();
    private JTextField jtfEmail=new JTextField();
    private JTextField jtfBankType=new JTextField();
    private JTextField jtfCardNumber=new JTextField();
    private JTextField jtfExpiredDate=new JTextField();
    private JTextField jtfCVC=new JTextField();
    
    private JPanel PanelCenter=new JPanel(new GridLayout(2,1));
    private JButton jbtPayment=new JButton();
    private JPanel PanelCenterUp=new JPanel(new GridLayout(1,2));
    private JPanel PanelCenter1=new JPanel(new GridLayout(10,2));
    private JPanel PanelCenter2=new JPanel(new GridLayout(8,2));
    private JPanel PanelCenterDown=new JPanel();
    public Payment(PaymentDomain paymentdomain){
        System.out.println("here");
                 setConnection();
                 setTitle("Payment");
        setLayout(new BorderLayout());
        String id=paymentdomain.getPaymentID();
        Date date=paymentdomain.getDate();
        String timedepart=paymentdomain.getTimeDepart();
        String timearrive=paymentdomain.getArrive();
        String origin=paymentdomain.getOrigin();
        String destination=paymentdomain.getDestination();
        Double price=paymentdomain.getPrice();
        String busid=paymentdomain.getBusID();
        
        jtfPaymentid.setText(id);
        jtfdate.setText(date+"");
        jtftimedepart.setText(timedepart);
        jtftimearrive.setText(timearrive);
        jtforigin.setText(origin);
        jtfdestination.setText(destination);
        jtfPrice.setText(price+"");
        jtfBusid.setText(busid);
        
        jtfPaymentid.setEditable(false);
        jtfdate.setEditable(false);
        jtftimedepart.setEditable(false);
        jtftimearrive.setEditable(false);
        jtforigin.setEditable(false);
        jtfdestination.setEditable(false);
        jtfPrice.setEditable(false);
        jtfBusid.setEditable(false);
        jtfTicketAmount.setEditable(false);
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
        PanelCenter1.add(new JLabel("Price:"));
        PanelCenter1.add(jtfPrice);
        PanelCenter1.add(new JLabel("Bus ID:"));
        PanelCenter1.add(jtfBusid);
        PanelCenter1.add(new JLabel("Total Ticket purchased:"));
        PanelCenter1.add(jtfTicketAmount);
        PanelCenter1.add(new JLabel("Total Payment:"));
        PanelCenter1.add(jtfTotalPayment);

        PanelCenter2.add(new JLabel("Customer ID:"));
        PanelCenter2.add(jtfIC);
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

        PanelCenterUp.add(PanelCenter1);
        PanelCenterUp.add(PanelCenter2);
        PanelCenterDown.add(jbtPayment);

        PanelCenter.add(PanelCenterUp);
        PanelCenter.add(PanelCenterDown);
        add(PanelCenter,BorderLayout.CENTER);
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
        pack();
        setSize(705,753);
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
}