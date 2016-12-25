package Ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddBusSchedule extends JPanel{
   
    private Connection conn;
    private ResultSet rs;
    private ResultSet rs1;
    private ResultSet rs2;
    private PreparedStatement stmt;

    
    private ScheduleTable st;  
    private JTable aa; 

    private JTextField jtfBusScheduleID = new JTextField();
    private JTextField jtfBusScheduleDate = new JTextField();
    private JTextField jtfBusScheduleOrigin = new JTextField();
    private JTextField jtfBusScheduleDestination = new JTextField();
    private JTextField jtfBusScheduleTimeDepart = new JTextField();
    private JTextField jtfBusScheduleTimeArrive = new JTextField();
    private JTextField jtfBusScheduleBusID = new JTextField();
    private JTextField jtfBusSchedulePrice=new JTextField();
    private JButton jbtOK = new JButton("Add Schedule");
    private JButton jbtCancel = new JButton("Clear");
   
    
   JPanel jpCenter = new JPanel(new GridLayout(2,1));
   JPanel PanelInsideCard = new JPanel(new GridLayout(1,1));
   JPanel PanelAdd = new JPanel(new GridLayout(9,2));
   
    
     public AddBusSchedule(){     
         setConnection();
         setLayout(new BorderLayout());
              
              PanelAdd.add(new JLabel("ID:"));
              PanelAdd.add(jtfBusScheduleID);             
              PanelAdd.add(new JLabel("Date :"));
              PanelAdd.add(jtfBusScheduleDate);              
              PanelAdd.add(new JLabel("Time Depart:"));
              PanelAdd.add(jtfBusScheduleTimeDepart);          
              PanelAdd.add(new JLabel("Time Arrive:"));
              PanelAdd.add(jtfBusScheduleTimeArrive);
              PanelAdd.add(new JLabel("Origin:"));
              PanelAdd.add(jtfBusScheduleOrigin);
              PanelAdd.add(new JLabel("Destination:"));
              PanelAdd.add(jtfBusScheduleDestination);
              PanelAdd.add(new JLabel("Price(RM):"));
              PanelAdd.add(jtfBusSchedulePrice);
              PanelAdd.add(new JLabel("Bus ID:"));
              PanelAdd.add(jtfBusScheduleBusID);
             
              
              PanelAdd.add(jbtOK);     
              PanelAdd.add(jbtCancel);
              
               st= new ScheduleTable();
              aa= new JTable(st);
              PanelInsideCard.add(new JScrollPane(aa));
//               PanelAdd.setBackground(Color.GRAY);
//                jpffood.setBackground(Color.GRAY);
//                 jpCenter.setBackground(Color.GRAY);
              add(PanelAdd,BorderLayout.CENTER);
         
       
                
        jpCenter.add(PanelAdd);
        jpCenter.add(PanelInsideCard);
//        jpCenter.setBackground(Color.GRAY);
      
        
        add(jpCenter, BorderLayout.CENTER);
        
        jbtOK.addActionListener(new AddListener());     
        jbtCancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
              ClearText();
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
     
          public class AddListener implements ActionListener{
         public void actionPerformed(ActionEvent e){
             try{
                 rs1=selectRecord(jtfBusScheduleID.getText());
                 rs2=selectRecord2(jtfBusScheduleBusID.getText());
                   if((jtfBusScheduleID.getText()).equals("")){
                   JOptionPane.showMessageDialog(null, "Schedule ID cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);
                     }else if (jtfBusScheduleID.getText().length()>8 || jtfBusScheduleID.getText().length()<8) {
                       JOptionPane.showMessageDialog(null, "Bus schedule ID must only have 8 digits", "Format error", JOptionPane.ERROR_MESSAGE);
                 }
                   else if(rs1.next()){
                        JOptionPane.showMessageDialog(null, "Duplicate Bus Schedule ID", "Existing Data", JOptionPane.ERROR_MESSAGE);
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
                       String BusScheduleID = jtfBusScheduleID.getText();
               Date BusScheduleDate = (Date.valueOf(jtfBusScheduleDate.getText()));
               String BusScheduleOrigin = jtfBusScheduleOrigin.getText();
               String BusScheduleDestination = jtfBusScheduleDestination.getText();
               String BusScheduleTimeDepart= jtfBusScheduleTimeDepart.getText();
               String BusScheduleTimeArrive =jtfBusScheduleTimeArrive.getText();
               String BusSchedulePrice=jtfBusSchedulePrice.getText();
               String BusScheduleBusID = jtfBusScheduleBusID.getText();
                 
               
                 String strSQL1 = "insert into BUSSCHEDULE values (?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1,BusScheduleID);
                 stmt.setDate(2,BusScheduleDate);
                 stmt.setString(3, BusScheduleTimeDepart);
                 stmt.setString(4, BusScheduleTimeArrive);
                 stmt.setString(5,BusScheduleOrigin);
                 stmt.setString(6, BusScheduleDestination);
                 stmt.setString(7,BusSchedulePrice);
                 stmt.setString(8,BusScheduleBusID);
                 stmt.executeUpdate();
              JOptionPane.showMessageDialog(null, "New Schedule Info added.");
                 st.retrieve();
                Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 ClearText();
                 BusSchedule schedule=new BusSchedule();
                   }
                   else{
                       JOptionPane.showMessageDialog(null, "Not Existing Bus ID,Please input existing Bus ID", "Bus ID not found", JOptionPane.ERROR_MESSAGE);    
                   }
                   
                   
             
             //    if(result > 0 )
             } catch(NullPointerException ex){
                 System.err.println("NUll value"+ex.toString());
             }catch(SQLException ex){
                 System.err.println("DB ERROR:"+ex.toString());
             }
             
         }
          }
          
         
//          public class AddFoodListener implements ActionListener{
//         public void actionPerformed(ActionEvent e){
//              try{
//                 
//               String staffid = jtfstaffid.getText();
//                 String staffname = jtfstaffname.getText();
//                 String staffic = jtfstaffic.getText();
//                 int staffage = Integer.parseInt(jtfstaffage.getText());
//                String staffDOB= jtfstaffDOB.getText();
//                 int staffphonenumber = Integer.parseInt(jtfstaffphonenumber.getText());
//                 String staffemail = jtfstaffemail.getText();
//                 String staffaddress= jtfstaffaddress.getText();
//                 
//                 if(staffid!=null){
//                 
//                 String strSQL1 = "insert into staff values (?,?,?,?,?,?,?,?)";
//                 stmt = conn.prepareStatement(strSQL1);
//                 stmt.setString(1, staffid);
//                 stmt.setString(2,staffname);
//                 stmt.setString(3,staffic);
//                 stmt.setInt(4, staffage);
//                 stmt.setString(5, staffDOB);
//                 stmt.setInt(6, staffphonenumber);
//                 stmt.setString(7,staffemail);
//                 stmt.setString(8, staffaddress);
//                 stmt.executeUpdate();
//              JOptionPane.showMessageDialog(null, "New staff Info added.");
//                 ct.retrieve();
//                Statement stmtInsert = conn.createStatement();
//                 stmtInsert.executeUpdate(strSQL1);
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
          
        public ResultSet selectRecord(String id) {
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
        
        public ResultSet selectRecord2(String id) {
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
     public void ClearText(){
    jtfBusScheduleID.setText("");  
     jtfBusScheduleOrigin.setText("");   
     jtfBusScheduleDestination.setText("");
    jtfBusScheduleTimeDepart.setText("");
     jtfBusScheduleTimeArrive.setText("");  
     jtfBusScheduleDate.setText("");   
     jtfBusSchedulePrice.setText("");
     jtfBusScheduleBusID.setText("");
    
    
     }
     
      
}


