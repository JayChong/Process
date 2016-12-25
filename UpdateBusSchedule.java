package Ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateBusSchedule extends JPanel{
    private Connection conn;
    private ResultSet rs;
    private ResultSet rs1;
    private ResultSet rs2;
    private PreparedStatement stmt;
   // private String tableName = "staff";
    
    private ScheduleTable st;  
    private JTable aa; 

    private JTextField jtfBusScheduleID = new JTextField();
    private JTextField jtfBusScheduleDate = new JTextField();
    private JTextField jtfBusScheduleOrigin = new JTextField();
    private JTextField jtfBusScheduleDestination = new JTextField();
    private JTextField jtfBusScheduleTimeDepart = new JTextField();
    private JTextField jtfBusScheduleTimeArrive = new JTextField();
    private JTextField jtfBusSchedulePrice = new JTextField();
    private JTextField jtfBusScheduleBusID = new JTextField();
    
   
   // private JButton jbtRetrieve = new JButton("Retrieve Schedule Details");
    private JButton jbtUpdate = new JButton("Update Schedule Details");
    private JButton jbtReset = new JButton("Reset");
    
    
   JPanel jpCenter = new JPanel(new GridLayout(2,1));
   JPanel PanelInsideCard = new JPanel(new GridLayout(1,1));
   JPanel PanelUpdate = new JPanel(new GridLayout(9,2));
   
    
     public UpdateBusSchedule(){     
         setConnection();
         setLayout(new BorderLayout());
              
              PanelUpdate.add(new JLabel("ID:"));
              PanelUpdate.add(jtfBusScheduleID);             
              PanelUpdate.add(new JLabel("Date :"));
              PanelUpdate.add(jtfBusScheduleDate);              
              PanelUpdate.add(new JLabel("Time Depart:"));
              PanelUpdate.add(jtfBusScheduleTimeDepart);          
              PanelUpdate.add(new JLabel("Time Arrive:"));
              PanelUpdate.add(jtfBusScheduleTimeArrive);
              PanelUpdate.add(new JLabel("Origin:"));
              PanelUpdate.add(jtfBusScheduleOrigin);
              PanelUpdate.add(new JLabel("Destination:"));
              PanelUpdate.add(jtfBusScheduleDestination);
              PanelUpdate.add(new JLabel("Price(RM):"));
              PanelUpdate.add(jtfBusSchedulePrice);
              PanelUpdate.add(new JLabel("Bus ID:"));
              PanelUpdate.add(jtfBusScheduleBusID);
    //          PanelUpdate.add(jbtRetrieve);
              PanelUpdate.add(jbtUpdate);
              PanelUpdate.add(jbtReset);
              
              st= new ScheduleTable();
              aa= new JTable(st);
              PanelInsideCard.add(new JScrollPane(aa));

              add(jpCenter,BorderLayout.CENTER);
//         jtffoodid.setEditable(false);
       
                jtfBusScheduleID.setEditable(false);
        jpCenter.add(PanelUpdate);
         jpCenter.add(PanelInsideCard);
       // jpSouth.add(jp5);
        //jpSouth.add(jp6);
        
        add(jpCenter, BorderLayout.CENTER);
        aa.addMouseListener(new JTableListener());
   //     jbtRetrieve.addActionListener(new RetrieveListener());
        jbtUpdate.addActionListener(new UpdateListener());
        jbtReset.addActionListener(new ResetListener());
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
     

          
  
      public ResultSet selectRecord(String ID) {
        String queryStr = "SELECT * FROM BUSSCHEDULE WHERE BUSSCHEDULE_ID= ?";
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

//          public class RetrieveListener implements ActionListener{
//              public void actionPerformed(ActionEvent e)
//              {
////                  if(jtfDestination.getText() == null){
////                        JOptionPane.showMessageDialog(null, "Null Value.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
////              }
////              else{
//                  try{
//                      String ID = jtfBusScheduleID.getText();
//                      rs = selectRecord(ID);
//               
//                      if(rs.next()){
//                      st.retrieveRecordsByCode(jtfBusScheduleID.getText());  
//                      }
//                      else{
//                      JOptionPane.showMessageDialog(null, "Info Not Found.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);}
//                      
//                      }catch(SQLException ex){
//                              System.err.println("No Info Found"+ex.toString());
//                              }
////                   
////                  }
//               }
//              }
//          
//          
//             public class RetrieveListener implements ActionListener{
//              public void actionPerformed(ActionEvent e){
//                  try{
//                      String id = jtfBusScheduleID.getText();
////                      String id1=jtffoodid.getText();
//                      rs = selectRecord(id);
//                      if(rs.next()){
//                        
//                           jtfBusScheduleID.setText(rs.getString("BUSSCHEDULE_ID"));
//                            jtfBusScheduleDate.setText(rs.getString("BUSSCHEDULE_DATE"));                          
//                              jtfBusScheduleTimeDepart.setText(rs.getString("BUSSCHEDULE_TIMEDEPART"));
//                          jtfBusScheduleTimeArrive.setText(rs.getString("BUSSCHEDULE_TIMEARRIVE"));
//                            jtfBusScheduleOrigin.setText(rs.getString("BUSSCHEDULE_ORIGIN"));
//                            jtfBusScheduleDestination.setText(rs.getString("BUSSCHEDULE_DESTINATION"));  
//                            jtfBusSchedulePrice.setText(rs.getString("BUSSCHEDULE_PRICE"));
//                              jtfBusScheduleBusID.setText(rs.getString("BUS_ID"));
//                         
//                      }
//                     //   st.retrieveRecordsByCode(jtfBusScheduleID.getText());
////                        ctc.retrieveRecordsByCode(jtforderID.getText());
//                      }catch(SQLException ex){
//                              System.err.println("No Info Found"+ex.toString());
//                              }
//                   if(jtfBusScheduleID.getText() == null){
//                        JOptionPane.showMessageDialog(null, "Info Not Found.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
//                    }
//                  }
//              }
          
          
  public class UpdateListener implements ActionListener{

         public void actionPerformed(ActionEvent e){
             try{
             //    rs1=selectRecord3(jtfBusScheduleID.getText());
                 rs2=selectRecord4(jtfBusScheduleBusID.getText());
                   if((jtfBusScheduleID.getText()).equals("")){
                   JOptionPane.showMessageDialog(null, "Schedule ID cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);
                     }else if (jtfBusScheduleID.getText().length()>8 || jtfBusScheduleID.getText().length()<8) {
                       JOptionPane.showMessageDialog(null, "Bus schedule ID must only have 8 digits", "Format error", JOptionPane.ERROR_MESSAGE);
                 }
                   else if((jtfBusScheduleDate.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "Date cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }else if (!jtfBusScheduleDate.getText(). matches("[0-9-]+")) {
                       JOptionPane.showMessageDialog(null, "Date only allow integer.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }else if (jtfBusScheduleDate.getText().length()>10 || jtfBusScheduleDate.getText().length()<10) {
                       JOptionPane.showMessageDialog(null, "Date Format must consists of 10 digits", "Format error", JOptionPane.ERROR_MESSAGE);         
                 }else if((jtfBusScheduleTimeDepart.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "Departure time cannot be empty.", "Format error", JOptionPane.ERROR_MESSAGE);    
                   }else if (!jtfBusScheduleTimeDepart.getText(). matches("[0-9]+")) {
                       JOptionPane.showMessageDialog(null, "Time depart must be number.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }
                   else if (jtfBusScheduleTimeDepart.getText().length()>4 || jtfBusScheduleTimeDepart.getText().length()<4) {
                       JOptionPane.showMessageDialog(null, "Time Depart only can input 4 digits", "Format error", JOptionPane.ERROR_MESSAGE);
                 }
                   else if((jtfBusScheduleTimeArrive.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "Time arrive cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }else if (!jtfBusScheduleTimeArrive.getText(). matches("[0-9]+")) {
                       JOptionPane.showMessageDialog(null, "Time Arrive must be number.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }else if (jtfBusScheduleTimeArrive.getText().length()>4 || jtfBusScheduleTimeArrive.getText().length()<4) {
                       JOptionPane.showMessageDialog(null, "Time Arrive only can input 4 digits", "Format error", JOptionPane.ERROR_MESSAGE);
                 }else if((jtfBusScheduleOrigin.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "Origin cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }
                   else if (!jtfBusScheduleOrigin.getText().matches("[a-zA-Z ]+")) {
                       JOptionPane.showMessageDialog(null, "Origin must be string.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }
                   else if((jtfBusScheduleDestination.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "Destination cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }
                   else if (!jtfBusScheduleDestination.getText().matches("[a-zA-Z_ ]+")) {
                       JOptionPane.showMessageDialog(null, "Destination must be string.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }
                   else if((jtfBusSchedulePrice.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "Price cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }else if (!jtfBusSchedulePrice.getText(). matches("[0-9.]+")) {
                       JOptionPane.showMessageDialog(null, "Price must be number.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }
                   else if((jtfBusScheduleBusID.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, "Bus cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);    
                   }
                   
                   else if (rs2.next()){
                 String ID =jtfBusScheduleID.getText();
                 String Date = jtfBusScheduleDate.getText();
                 String TimeDepart = jtfBusScheduleTimeDepart.getText();
                 String TimeArrive = jtfBusScheduleTimeArrive.getText();
                 String ORigin= jtfBusScheduleOrigin.getText();
                 String Destination =jtfBusScheduleDestination.getText();
                 String price=jtfBusSchedulePrice.getText();
                 String BusID = jtfBusScheduleBusID.getText();
                 Double price1=Double.parseDouble(price);
                 
                 String strSQL = "UPDATE BUSSCHEDULE SET BUSSCHEDULE_DATE=?,BUSSCHEDULE_TIMEDEPART=?,BUSSCHEDULE_TIMEARRIVE=?,BUSSCHEDULE_ORIGIN=?,BUSSCHEDULE_DESTINATION=?,BUSSCHEDULE_PRICE=?,BUS_ID=? WHERE BUSSCHEDULE_ID=? ";
                 stmt = conn.prepareStatement(strSQL);                
                
                 stmt.setString(1,Date);
                 stmt.setString(2,TimeDepart);
                 stmt.setString(3, TimeArrive);
                 stmt.setString(4, ORigin);
                 stmt.setString(5, Destination);
                 stmt.setDouble(6, price1);
                 stmt.setString(7,BusID);
                 stmt.setString(8, ID);
                 stmt.executeUpdate();
              JOptionPane.showMessageDialog(null, "Schedule info updated.");
                 st.retrieve();
                Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL);
              ClearText();
             //    if(result > 0 )
                     }else{
                       JOptionPane.showMessageDialog(null, "Not Existing Bus ID,Please input existing Bus ID", "Bus ID not found", JOptionPane.ERROR_MESSAGE);    
                   }
                   
             }catch(SQLException ex){
                 System.err.println("DB ERROR:"+ex.toString());
             }
             
         }}
          
     public void ClearText(){
       jtfBusScheduleID.setText("");  
     jtfBusScheduleDate.setText("");   
     jtfBusScheduleTimeDepart.setText("");
    jtfBusScheduleTimeArrive.setText("");
     jtfBusScheduleOrigin.setText("");  
     jtfBusScheduleDestination.setText(""); 
     jtfBusSchedulePrice.setText("");
     jtfBusScheduleBusID.setText("");
    
     }
     
     public class ResetListener implements ActionListener{
              public void actionPerformed(ActionEvent e){
                  ClearText();
              }
}
     private class JTableListener implements MouseListener{
        public void mouseClicked(MouseEvent e){
            if(e.getClickCount() == 2){
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();
                
                String value =(String)st.getValueAt(row, 0);
                 try {
                
                ResultSet rs = selectRecord2(value);
                if (rs.next()) {
                    String id=rs.getString("BUSSCHEDULE_ID");
                    Date date=Date.valueOf(rs.getString("BUSSCHEDULE_DATE"));
                    String timedepart=rs.getString("BUSSCHEDULE_TIMEDEPART");
                    String timearrive=rs.getString("BUSSCHEDULE_TIMEARRIVE");
                    String origin=rs.getString("BUSSCHEDULE_ORIGIN");
                    String destination=rs.getString("BUSSCHEDULE_DESTINATION");
                    String price=rs.getString("BUSSCHEDULE_PRICE");
                    String busid=rs.getString("BUS_ID");
                    
                    jtfBusScheduleID.setText(id);
                    jtfBusScheduleDate.setText(date+""); 
                    jtfBusScheduleTimeDepart.setText(timedepart);
                    jtfBusScheduleTimeArrive.setText(timearrive);
                    jtfBusScheduleOrigin.setText(origin);
                    jtfBusScheduleDestination.setText(destination);
                    jtfBusScheduleBusID.setText(busid);
                    jtfBusSchedulePrice. setText(price);
                  //  scheduleDomain = new ScheduleDomain(id,date,timedepart,timearrive,origin,destination,price,busid);
//                    scheduleDomain.setBusScheduleID();
//                    scheduleDomain.setBusScheduleDate();
//                    scheduleDomain.setBusScheduleTimeDepart(timedepart);
//                    scheduleDomain.setBusScheduleArrive(timearrive);
//                    scheduleDomain.setBusScheduleOrigin(origin);
//                    scheduleDomain.setBusScheduleDestination(destination);
//                    scheduleDomain.setBusID(busid);
                    
                   // TicketPurchasing ticketingpurchasing=new TicketPurchasing(scheduleDomain);
                   // st.shutDown();
                    
                    st.retrieve();
                    
                   // TicketPurchasing ticketingpurchasing=new TicketPurchasing();
                } else {
                    JOptionPane.showMessageDialog(null, "No such programme code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
                
                //JOptionPane.showMessageDialog(null, value);
            }
          
        }
        
        public void mouseExited(MouseEvent e) { } 
        public void mouseEntered(MouseEvent e) { }
        public void mouseReleased(MouseEvent e){ }
        public void mousePressed(MouseEvent e) { }
    }
     public ResultSet selectRecord2(String ID) {
        String queryStr = "SELECT * FROM BUSSCHEDULE WHERE BUSSCHEDULE_ID= ?";
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
     public ResultSet selectRecord3(String id) {
        String queryStr = "SELECT * FROM BUSSCHEDULE WHERE BUSSCHEDULE_ID= ?";
        ResultSet rs1 = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs1 = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs1;
    }
        
        public ResultSet selectRecord4(String id) {
        String queryStr = "SELECT * FROM BUS WHERE Bus_id= ?";
        ResultSet rs2 = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs2 = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs2;
    }
}




