package Ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.text.*;
import Ui.*;

public class SearchBusSchedule extends JPanel{
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    
        private ScheduleDomain scheduleDomain;
        
    private String tableName = "BUSSCHEDULE";
    
    private ScheduleTable2 st;  
    private JTable aa=new JTable((TableModel)st); 
    
    private JTextField jtfDestination = new JTextField();

    
    private JButton jbtOK = new JButton("Retrieve");
    private JButton jbtCancel = new JButton("Clear");
    
   JPanel jpCenter = new JPanel(new GridLayout(2,1));
  
   JPanel jpRetrieve = new JPanel(new GridLayout(7,2));
   JPanel PanelInsideCard = new JPanel(new GridLayout(1,1));
   
//   private JTextField jtfBusScheduleID = new JTextField();
//    private JTextField jtfBusScheduleDate = new JTextField();
//     private JTextField jtfBusScheduleOrigin = new JTextField();
//    private JTextField jtfBusScheduleDestination = new JTextField();
//    private JTextField jtfBusScheduleTimeDepart = new JTextField();
//    private JTextField jtfBusScheduleTimeArrive = new JTextField();
//    private JTextField jtfBusScheduleBusID = new JTextField();
//    private JTextField jtfBusSchedulePrice=new JTextField();
    
   JPanel TestingRetrieve = new JPanel(new GridLayout(10,2));
    
     public SearchBusSchedule(){     
         setConnection();
         setLayout(new BorderLayout());
         
              jpRetrieve.add(new JLabel("Destination"));
              jpRetrieve.add(jtfDestination);

              
              
              
               jpRetrieve.add(jbtOK);
              jpRetrieve.add(jbtCancel);
              
              st= new ScheduleTable2();
              aa= new JTable((TableModel)st);
              PanelInsideCard.add(new JScrollPane(aa));
//               jpRetrieve.setBackground(Color.GRAY);
//                jpffood.setBackground(Color.GRAY);
//                 jpCenter.setBackground(Color.GRAY);

              
              
              
              add(jpRetrieve,BorderLayout.CENTER);
               add(PanelInsideCard,BorderLayout.CENTER);
         
       
                
        jpCenter.add(jpRetrieve);
         jpCenter.add(PanelInsideCard);
       
      
       // jpSouth.add(jp5);
        //jpSouth.add(jp6);
//              TestingRetrieve.add(new JLabel("ID:"));
//              TestingRetrieve.add(jtfBusScheduleID);             
//              TestingRetrieve.add(new JLabel("Date :"));
//              TestingRetrieve.add(jtfBusScheduleDate);              
//              TestingRetrieve.add(new JLabel("Time Depart:"));
//              TestingRetrieve.add(jtfBusScheduleTimeDepart);          
//              TestingRetrieve.add(new JLabel("Time Arrive:"));
//              TestingRetrieve.add(jtfBusScheduleTimeArrive);
//              TestingRetrieve.add(new JLabel("Origin:"));
//              TestingRetrieve.add(jtfBusScheduleOrigin);
//              TestingRetrieve.add(new JLabel("Destination"));
//              TestingRetrieve.add(jtfBusScheduleDestination);
//              TestingRetrieve.add(new JLabel("Bus ID"));
//              TestingRetrieve.add(jtfBusScheduleBusID);
//              TestingRetrieve.add(new JLabel("Bus Price"));
//              TestingRetrieve.add(jtfBusSchedulePrice);
//              jpCenter.add(TestingRetrieve);
        add(jpCenter, BorderLayout.CENTER);
        aa.addMouseListener(new JTableListener());
        jbtOK.addActionListener(new RetrieveListener());
        jbtCancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
               
                   jtfDestination.setText("");
                     
            }
            
        });
        
        
        
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
      public ResultSet selectRecord(String Destination) {
        String queryStr = "SELECT * FROM BUSSCHEDULE WHERE BUSSCHEDULE_DESTINATION= ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, Destination);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("GOT RETURN!"); 
        return rs;
    }

          public class RetrieveListener implements ActionListener{
              public void actionPerformed(ActionEvent e)
              {
//                  if(jtfDestination.getText() == null){
//                        JOptionPane.showMessageDialog(null, "Null Value.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
//              }
//              else{
                  try{
                      if((jtfDestination.getText()).equals("")){
                   JOptionPane.showMessageDialog(null, "Destination cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);      
                     }else if (!jtfDestination.getText().matches("[a-zA-Z ]+")) {
                       JOptionPane.showMessageDialog(null, "Destination must be string.", "Format error", JOptionPane.ERROR_MESSAGE);
                 }
                      else{
                      String destination = jtfDestination.getText();
                      rs = selectRecord(destination);
                      
                      if(rs.next()){
                      st.retrieveRecordsByCode2(jtfDestination.getText());  
                      }
                      else{
                      JOptionPane.showMessageDialog(null, "Info Not Found.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);}
                      }
                      }catch(SQLException ex){
                              System.err.println("No Info Found"+ex.toString());
                              }
                   
//                  }
               }
              }
          
         
     public void ClearText(){

     jtfDestination.setText("");

  
   
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
                    
//                    jtfBusScheduleID.setText(id);
//                    jtfBusScheduleDate.setText(date+""); 
//                    jtfBusScheduleTimeDepart.setText(timedepart);
//                    jtfBusScheduleTimeArrive.setText(timearrive);
//                    jtfBusScheduleOrigin.setText(origin);
//                    jtfBusScheduleDestination.setText(destination);
//                    jtfBusScheduleBusID.setText(busid);
//                    jtfBusSchedulePrice. setText(price);
                    scheduleDomain = new ScheduleDomain(id,date,timedepart,timearrive,origin,destination,price,busid);
//                    scheduleDomain.setBusScheduleID();
//                    scheduleDomain.setBusScheduleDate();
//                    scheduleDomain.setBusScheduleTimeDepart(timedepart);
//                    scheduleDomain.setBusScheduleArrive(timearrive);
//                    scheduleDomain.setBusScheduleOrigin(origin);
//                    scheduleDomain.setBusScheduleDestination(destination);
//                    scheduleDomain.setBusID(busid);
                    
                    TicketPurchasing ticketingpurchasing=new TicketPurchasing(scheduleDomain);
                   // st.shutDown();
               //     dispose();
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

}

