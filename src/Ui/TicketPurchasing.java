
package Ui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.lang.*;
import Ui.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import Ui.OrderTable;
public class TicketPurchasing extends JFrame{
    private Connection conn;
    private ResultSet rs;
    private ResultSet rs1;
    private ResultSet rs2;
    private PreparedStatement stmt;
    private ScheduleDomain scheduleDomain;
     String host = "jdbc:derby://localhost:1527/kkkldb3";
         String user = "nbuser";
         String password = "nbuser";
     String shortorigin;
     String shortdestination;
     private PaymentDomain paymentdomain;
//    private JButton jbtHome= new JButton("Home");
//    private JButton jbtStaff= new JButton("Staff");
//    private JButton jbtBusSchedule= new JButton("BusSchedule");
//    private JButton jbtTicketPurchasing= new JButton("TicketPurchasing");
//    private JButton jbtReport= new JButton("Report");
//    private JButton jbtLogin= new JButton("Login");
//    private JButton jbtOrder=new JButton("Order");
    private JButton jbtBackToHome=new JButton("Back to Home");
//    private JButton jbtRetrieve=new JButton("Retrive");
//    
    public JButton button1=new JButton("1");
    public JButton button2=new JButton("2");
    public JButton button3=new JButton("3");
    public JButton button4=new JButton("4");
    public JButton button5=new JButton("5");
    public JButton button6=new JButton("6");
    public JButton button7=new JButton("7");
    public JButton button8=new JButton("8");
    public JButton button9=new JButton("9");
    public JButton button10=new JButton("10");
    public JButton button11=new JButton("11");
    public JButton button12=new JButton("12");
    public JButton button13=new JButton("13");
    public JButton button14=new JButton("14");
    public JButton button15=new JButton("15");
    public JButton button16=new JButton("16");
    public JButton button17=new JButton("17");
    public JButton button18=new JButton("18");
    public JButton button19=new JButton("19");
    public JButton button20=new JButton("20");
    public JButton button21=new JButton("21");
    public JButton button22=new JButton("22");
    public JButton button23=new JButton("23");
    public JButton button24=new JButton("24");
    public JButton button25=new JButton("25");
    public JButton button26=new JButton("26");
    public JButton button27=new JButton("27");
    public JButton button28=new JButton("28");
    public JButton button29=new JButton("29");
    public JButton button30=new JButton("30");
    public JButton button31=new JButton("31");
    public JButton button32=new JButton("32");
    public JButton button33=new JButton("33");
    
//    private JTextField jtfTicketID=new JTextField();
//    private JTextField jtfPurchasedDate=new JTextField();
//    private JTextField jtfDepartDate=new JTextField();
//    private JTextField jtfDestination=new JTextField();
//    private JTextField jtfDepartTime=new JTextField();
//    private JTextField jtfBusScheduleID=new JTextField();
    private JTextField jtfBusScheduleID = new JTextField();
    private JTextField jtfBusScheduleDate = new JTextField();
    private JTextField jtfBusScheduleOrigin = new JTextField();
    private JTextField jtfBusScheduleDestination = new JTextField();
    private JTextField jtfBusScheduleTimeDepart = new JTextField();
    private JTextField jtfBusScheduleTimeArrive = new JTextField();
    private JTextField jtfBusSchedulePrice=new JTextField();
    private JTextField jtfBusScheduleBusID = new JTextField();
    private JTextField jtfUserType=new JTextField();
    private JTextField jtfUserType1=new JTextField();
            
    JTextField jtfTicketID=new JTextField();
//    JTextField jtfTicketDate=new JTextField();
//    JTextField jtfPaymentID=new JTextField();
    
//    ImageIcon Bar1 = new ImageIcon(getClass().getResource("bus1.png"));
//    ImageIcon Bar2 = new ImageIcon(getClass().getResource("bus2.png"));
//    ImageIcon Promotion = new ImageIcon(getClass().getResource("Promotion.png"));
    
//    ImageIcon Facility= new ImageIcon(getClass().getResource("Facility.png"));
//    ImageIcon Image1= new ImageIcon(getClass().getResource("AirCond.png"));
//    ImageIcon Image2= new ImageIcon(getClass().getResource("LuggageRack.png"));
//    ImageIcon Image3= new ImageIcon(getClass().getResource("EmergencyToilet.png"));
//    ImageIcon Image4= new ImageIcon(getClass().getResource("Curtain.png"));
//    ImageIcon Image5= new ImageIcon(getClass().getResource("AirCond.png"));
//    ImageIcon Image6= new ImageIcon(getClass().getResource("FreeWifi.png"));
//    
//    ImageIcon Facilities = new ImageIcon(getClass().getResource("Facilities.png"));
//    JLabel LabelBar1=new JLabel();
//    JLabel LabelBar2=new JLabel();
//    JLabel LabelPromotion=new JLabel();
//    JLabel LabelFacilities=new JLabel();
//    JLabel Label1 = new JLabel(); 
//    JLabel Label2 = new JLabel(); 
//    JLabel Label3 = new JLabel(); 
//    JLabel Label4 = new JLabel(); 
//    JLabel Label5 = new JLabel();
//    JLabel Label6 = new JLabel(); 
    
//    private JPanel Panel1part1= new JPanel(new GridLayout(1,1));
//    private JPanel Panel1part2=new JPanel(new GridLayout(1,1));
//    private JPanel Panel1part3= new JPanel(new GridLayout(2,1));
//    private JPanel Panel1= new JPanel(new GridLayout(1,3));
//    private JPanel Panel2= new JPanel(new GridLayout(1,5));
//    private JPanel PanelNorth= new JPanel(new GridLayout(2,1));
//    
  //  private JPanel PanelCenter= new JPanel(new GridLayout(1,1));
    JLabel label=new JLabel();
    private JPanel PanelWest= new JPanel(new GridLayout(13,2));
    private JPanel PanelEast=new JPanel(new GridLayout(11,4));
    private JPanel PanelWest1=new JPanel(new GridLayout(1,1));
    private JPanel PanelEast1=new JPanel(new GridLayout(3,1));
    private JPanel PanelUp=new JPanel(new GridLayout(1,2));
    private JPanel PanelDown=new JPanel(new GridLayout(2,1));
    private JPanel PanelCombine =new JPanel(new GridLayout(2,1));
    private JPanel PanelDown1=new JPanel(new GridLayout(1,1));
    private JPanel PanelDown3=new JPanel();
    private JPanel PanelDown2=new JPanel(new GridLayout(2,1));
    private JPanel PanelDown4=new JPanel();
    private JLabel UserGuide=new JLabel("You can double click the ticket to delete the selected ticket.");
//    private JPanel PanelFacilities1=new JPanel(new GridLayout(1,1));
//    private JPanel PanelFacilities2=new JPanel(new GridLayout(2,3));
//    private JPanel PanelSouth=new JPanel(new GridLayout(1,1));
    private JButton jbAutoGenerate =new JButton();
    private JTextField jtfAutoGenerate =new JTextField(); 
    private JButton jbGetIc=new JButton("Make Order");
    private JButton jbtPayment=new JButton("Proceed to payment stage");
    private OrderTable ordertable;  
    private JTable jtable; 

    public TicketPurchasing(ScheduleDomain scheduleDomain){
         setConnection();
       this.scheduleDomain = scheduleDomain;
        String id=scheduleDomain.getBusScheduleID();
        Date date=scheduleDomain.getBusScheduleDate();
        String timedepart=scheduleDomain.getBusScheduleTimeDepart();
        String timearrive=scheduleDomain.getBusScheduleArrive();
        String origin=scheduleDomain.getBusScheduleOrigin();
        String destination=scheduleDomain.getBusScheduleDestination();
        String price=scheduleDomain.getBusSchedulePrice();
        String busid=scheduleDomain.getBusID();
        double price1= Double.parseDouble(price);
        jtfBusScheduleID.setText(id);
        jtfBusScheduleDate.setText(date+"");
        jtfBusScheduleTimeDepart.setText(timedepart);
        jtfBusScheduleTimeArrive.setText(timearrive);
        jtfBusScheduleOrigin.setText(origin);
        jtfBusScheduleDestination.setText(destination);
        jtfBusSchedulePrice.setText(price);
        jtfBusScheduleBusID.setText(busid);
        
        jtfBusScheduleID.setEditable(false);
        jtfBusScheduleDate.setEditable(false);
        jtfBusScheduleTimeDepart.setEditable(false);
        jtfBusScheduleTimeArrive.setEditable(false);
        jtfBusScheduleOrigin.setEditable(false);
        jtfBusScheduleDestination.setEditable(false);
        jtfBusSchedulePrice.setEditable(false);
        jtfBusScheduleBusID.setEditable(false);
        jtfAutoGenerate.setEditable(false);
        jtfTicketID.setEditable(false);
        jtfUserType.setEditable(false);
        jtfUserType1.setEditable(false);
     setTitle("TicketPurchasing");
     setLayout(new BorderLayout());
   //  LabelBar1.setIcon(Bar1);
  //   LabelBar1.setHorizontalAlignment(SwingConstants.CENTER);
   //  LabelBar2.setIcon(Bar2);
  //   LabelBar2.setHorizontalAlignment(SwingConstants.CENTER);
   //  Panel1part1.add(LabelBar1);
  //   Panel1part2.add(LabelBar2);
  //   Panel1part3.add(jbtLogin);
  //   Panel1part3.add(jbtOrder);
//     Panel1.add(Panel1part1);
//     Panel1.add(Panel1part2);
//     Panel1.add(Panel1part3);
//     PanelNorth.add(Panel1);     
//     Panel2.add(jbtHome);
//     Panel2.add(jbtStaff);
//     Panel2.add(jbtBusSchedule);
//     Panel2.add(jbtTicketPurchasing);
//     Panel2.add(jbtReport);
//     PanelNorth.add(Panel2);
//     add(PanelNorth,BorderLayout.NORTH);
    
     
              PanelWest.add(new JLabel("Schedule ID:"));
              PanelWest.add(jtfBusScheduleID);        
              PanelWest.add(new JLabel("Date :"));
              PanelWest.add(jtfBusScheduleDate);              
              PanelWest.add(new JLabel("Time Depart:"));
              PanelWest.add(jtfBusScheduleTimeDepart);          
              PanelWest.add(new JLabel("Time Arrive:"));
              PanelWest.add(jtfBusScheduleTimeArrive);
              PanelWest.add(new JLabel("Origin:"));
              PanelWest.add(jtfBusScheduleOrigin);
              PanelWest.add(new JLabel("Destination:"));
              PanelWest.add(jtfBusScheduleDestination);
              PanelWest.add(new JLabel("Price(RM):"));
              PanelWest.add(jtfBusSchedulePrice);
              PanelWest.add(new JLabel("Bus ID:"));
              PanelWest.add(jtfBusScheduleBusID);
              PanelWest.add(new JLabel("Ticket ID"));
              PanelWest.add(jtfTicketID);
//              PanelWest.add(new JLabel("Purchased Date:"));
//              PanelWest.add(jtfTicketDate);
//              PanelWest.add(new JLabel("Payment ID:"));
//              PanelWest.add(jtfPaymentID);
            //  PanelWest.add(jbtRetrieve);      

              

              
              
              
              PanelWest.add(new JLabel(""));
          //    PanelWest.add(jbAutoGenerate);
              PanelWest.add(new JLabel(""));
              PanelWest.add(jbGetIc);
              PanelWest.add(new JLabel(""));
              PanelWest.add(jtfUserType);
              PanelWest.add(jtfUserType1);
              PanelWest.add(new JLabel("PAYMENT ID:"));
              PanelWest.add(jtfAutoGenerate);
;         //     add(PanelWest,BorderLayout.WEST);
           //   jtfBusScheduleBusID.setEditable(false);
          //    button1.setEnabled(false);
        PanelEast.add(button1);
        PanelEast.add(new JLabel(""));
        PanelEast.add(button2);
        PanelEast.add(button3);
        PanelEast.add(button4);
        PanelEast.add(new JLabel(""));
        PanelEast.add(button5);
        PanelEast.add(button6);
        PanelEast.add(button7);
        PanelEast.add(new JLabel(""));
        PanelEast.add(button8);
        PanelEast.add(button9);
        PanelEast.add(button10);
        PanelEast.add(new JLabel(""));
        PanelEast.add(button11);
        PanelEast.add(button12);
        PanelEast.add(button13);
        PanelEast.add(new JLabel(""));
        PanelEast.add(button14);
        PanelEast.add(button15);
        PanelEast.add(button16);
        PanelEast.add(new JLabel(""));
        PanelEast.add(button17);
        PanelEast.add(button18);
        PanelEast.add(button19);
        PanelEast.add(new JLabel(""));
        PanelEast.add(button20);
        PanelEast.add(button21);
        PanelEast.add(button22);
        PanelEast.add(new JLabel(""));
        PanelEast.add(button23);
        PanelEast.add(button24);
        PanelEast.add(button25);
        PanelEast.add(new JLabel(""));
        PanelEast.add(button26);
        PanelEast.add(button27);
        PanelEast.add(button28);
        PanelEast.add(new JLabel(""));
        PanelEast.add(button29);
        PanelEast.add(button30);
        PanelEast.add(button31);
        PanelEast.add(new JLabel(""));
        PanelEast.add(button32);
        PanelEast.add(button33);
              
   //     add(PanelEast);
        PanelUp.add(PanelWest);
        PanelUp.add(PanelEast);
        
        
        
        ordertable= new OrderTable(jtfAutoGenerate.getText());
        jtable= new JTable(ordertable);
        PanelDown1.add(new JScrollPane(jtable));
        PanelDown3.add(UserGuide);
        PanelDown4.add(jbtBackToHome);
        PanelDown4.add(jbtPayment);
        PanelDown2.add(PanelDown3);
        PanelDown2.add(PanelDown4);
        PanelDown.add(PanelDown1);
        PanelDown.add(PanelDown2);
      //  PanelWest1.add(new JScrollPane(jtable));
        
//        PanelEast1.add(new JLabel(""));
//        PanelEast1.add(jbtBackToHome);
//        PanelEast1.add(jbtPayment);
//        PanelCombine.add(PanelUp);
//        PanelCombine.add(PanelEast1);
        PanelCombine.add(PanelUp);
        PanelCombine.add(PanelDown);
        add(PanelCombine);
//     for(int i=1;i<=20;i++)
//     {
//         try{
//       //  TicketPurchasing ticketpurchasing=new TicketPurchasing(ScheduleDomain scheduleDomain);
//         rs= selectRecord(scheduleDomain.getBusScheduleID());
//         if(rs.next())
//         {
//             
//             if (rs.getInt("SEAT_NUMBER")==1)
//             {
//                 button1.setEnabled(false);
//             }
//             
//             if (rs.getInt("SEAT_NUMBER")==2)
//             {
//                 button2.setEnabled(false);
//             }
//              
//             if (rs.getInt("SEAT_NUMBER")==11)
//             {
//                 button11.setEnabled(false);
//             }
//             
//             if (rs.getInt("SEAT_NUMBER")==21)
//             {
//                 button21.setEnabled(false);
//             }
//             
//         }
//         
//            }catch(SQLException ex) {
//                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//                                 }
//     }
        try{
        String query = "SELECT SEAT_NUMBER FROM TICKET";
            conn = DriverManager.getConnection(host, user, password);
            stmt = conn.prepareStatement(query);
        
         int[] arrayRefVar = new int[33];
        //     int i=0; 
             rs = stmt.executeQuery();
         try{
       //  TicketPurchasing ticketpurchasing=new TicketPurchasing(ScheduleDomain scheduleDomain);
         rs= selectRecord(scheduleDomain.getBusScheduleID());
         if(rs.next())
         {
             
            for(int a=0;a<arrayRefVar.length;a++){
             if (rs.next()) {   
             int s = rs.getInt("SEAT_NUMBER");
             arrayRefVar[a] = s;      
   
                 
          
          if(arrayRefVar[a]==1){   
             button1.setEnabled(false);
          }

          else if(arrayRefVar[a]==2){
             button2.setEnabled(false);
          }

         else if(arrayRefVar[a]==3){
             button3.setEnabled(false);
         }

         else if(arrayRefVar[a]==4){
             button4.setEnabled(false);
         }

         else if(arrayRefVar[a]==5){
             button5.setEnabled(false);
         }

         else if(arrayRefVar[a]==6){
             button6.setEnabled(false);
         }
         else if(arrayRefVar[a]==7){
             button7.setEnabled(false);
                 }

          else if(arrayRefVar[a]==8){
             button8.setEnabled(false);
          }

         else if(arrayRefVar[a]==9){
             button9.setEnabled(false);
         }
         
         else if(arrayRefVar[a]==10){
             button10.setEnabled(false);
         }
         
          else if(arrayRefVar[a]==11){
             button11.setEnabled(false);
         }
         else if(arrayRefVar[a]==12){
             button12.setEnabled(false);
         }
         else if(arrayRefVar[a]==13){
             button13.setEnabled(false);
         }
         else if(arrayRefVar[a]==14){
             button14.setEnabled(false);
         }
         else if(arrayRefVar[a]==15){
             button15.setEnabled(false);
         }
         else if(arrayRefVar[a]==16){
             button16.setEnabled(false);
         }
         else if(arrayRefVar[a]==17){
             button17.setEnabled(false);
         }
         else if(arrayRefVar[a]==18){
             button18.setEnabled(false);
         }
         else if(arrayRefVar[a]==19){
             button19.setEnabled(false);
         }
         else if(arrayRefVar[a]==20){
             button20.setEnabled(false);
         }
         else if(arrayRefVar[a]==21){
             button21.setEnabled(false);
         }
         else if(arrayRefVar[a]==22){
             button22.setEnabled(false);
         }
         else if(arrayRefVar[a]==23){
             button23.setEnabled(false);
         }
         else if(arrayRefVar[a]==24){
             button24.setEnabled(false);
         }
         else if(arrayRefVar[a]==25){
             button25.setEnabled(false);
         }
         else if(arrayRefVar[a]==26){
             button26.setEnabled(false);
         }
         else if(arrayRefVar[a]==27){
             button27.setEnabled(false);
         }
         else if(arrayRefVar[a]==28){
             button28.setEnabled(false);
         }
         else if(arrayRefVar[a]==29){
             button29.setEnabled(false);
         }
         else if(arrayRefVar[a]==30){
             button30.setEnabled(false);
         }
         else if(arrayRefVar[a]==31){
             button31.setEnabled(false);
         }
         else if(arrayRefVar[a]==32){
             button32.setEnabled(false);
             
         }else if(arrayRefVar[a]==33){
             button33.setEnabled(false);
         }
          }
             
         }
         
            }}catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                                 }
     } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
//     jbtLogin.addActionListener(new LoginListener());
//     jbtOrder.addActionListener(new OrderListener());
//     jbtHome.addActionListener(new HomeListener());
//     jbtStaff.addActionListener(new StaffListener());
//     jbtBusSchedule.addActionListener(new BusScheduleListener());
//     jbtTicketPurchasing.addActionListener(new TicketPurchasingListener());
//     jbtReport.addActionListener(new ReportListener());
        jtable.addMouseListener(new JTableListener());
     jbtBackToHome.addActionListener(new BackToHomeListener());
   //  jbtRetrieve.addActionListener(new RetrieveListener());
    
     if(origin.equals("KEDAH")){
                                String shortorigin="KD";
                                this.shortorigin=shortorigin;
                                
                                }
                                else if(origin.equals("PERAK")){
                                String shortorigin="PK";
                                this.shortorigin=shortorigin;
                                }
                                else if(origin.equals("PULAU PINANG")){
                                String shortorigin="PP";
                                this.shortorigin=shortorigin;
                                }
                                
                                if(destination.equals("PERLIS")){
                                    String shortdestination="PS";
                                    this.shortdestination=shortdestination;
                                            }
                                else if(destination.equals("KEDAH")){
                                    String shortdestination="KD";
                                    this.shortdestination=shortdestination;
                                    
                                            }
                                else if(destination.equals("PULAU PINANG")){
                                    String shortdestination="PG";
                                    this.shortdestination=shortdestination;
                                    
                                            }
                                else if(destination.equals("PERAK")){
                                    String shortdestination="PK";
                                    this.shortdestination=shortdestination;
                                    
                                            }
                                else if(destination.equals("KELANTAN")){
                                    String shortdestination="KLN";
                                    this.shortdestination=shortdestination;
                                    
                                            }
                                else if(destination.equals("TERENGGANU")){
                                    String shortdestination="TRGN";
                                    this.shortdestination=shortdestination;
                                    
                                            }
                                else if(destination.equals("PAHANG")){
                                    String shortdestination="PHG";
                                    this.shortdestination=shortdestination;
                                    
                                            }
                                else if(destination.equals("SELANGOR")){
                                    String shortdestination="SLG";
                                    this.shortdestination=shortdestination;
                                    
                                            }
                                else if(destination.equals("NEGERI SEMBILAN")){
                                    String shortdestination="N9";
                                    this.shortdestination=shortdestination;
                                    
                                            }
                                else if(destination.equals("MELAKA")){
                                    String shortdestination="MK";
                                    this.shortdestination=shortdestination;
                                    
                                            }
                                else if(destination.equals("JOHOR")){
                                    String shortdestination="JH";
                                    this.shortdestination=shortdestination;
                                    
                                            }
                                
     button1.addActionListener(new ActionListener() {
                int seatnum = 1;
                    public void actionPerformed(ActionEvent e) {
                        {                                   
                            try{        
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"00"+seatnum;
                 jtfTicketID.setText(ticketid);
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
                 JOptionPane.showMessageDialog(null, "Seat selected .");
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button2.addActionListener(new ActionListener() {
                int seatnum = 2;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"00"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button3.addActionListener(new ActionListener() {
                int seatnum = 3;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"00"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button4.addActionListener(new ActionListener() {
                int seatnum = 4;
                    public void actionPerformed(ActionEvent e) {
                        {                                   
                            try{        
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"00"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 
                 
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button5.addActionListener(new ActionListener() {
                int seatnum = 5;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"00"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     
     button6.addActionListener(new ActionListener() {
                int seatnum = 6;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"00"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button7.addActionListener(new ActionListener() {
                int seatnum = 7;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"00"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button8.addActionListener(new ActionListener() {
                int seatnum = 8;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"00"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button9.addActionListener(new ActionListener() {
                int seatnum = 9;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"00"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button10.addActionListener(new ActionListener() {
                int seatnum = 10;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button11.addActionListener(new ActionListener() {
                int seatnum = 11;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button12.addActionListener(new ActionListener() {
                int seatnum = 12;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button13.addActionListener(new ActionListener() {
                int seatnum = 13;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button14.addActionListener(new ActionListener() {
                int seatnum = 14;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button15.addActionListener(new ActionListener() {
                int seatnum = 15;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button16.addActionListener(new ActionListener() {
                int seatnum = 16;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button17.addActionListener(new ActionListener() {
                int seatnum = 17;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button18.addActionListener(new ActionListener() {
                int seatnum = 18;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1,ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button19.addActionListener(new ActionListener() {
                int seatnum = 19;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button20.addActionListener(new ActionListener() {
                int seatnum = 20;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button21.addActionListener(new ActionListener() {
                int seatnum = 21;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,id);                       
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button22.addActionListener(new ActionListener() {
                int seatnum = 22;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button23.addActionListener(new ActionListener() {
                int seatnum = 23;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button24.addActionListener(new ActionListener() {
                int seatnum = 24;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button25.addActionListener(new ActionListener() {
                int seatnum = 25;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button26.addActionListener(new ActionListener() {
                int seatnum = 26;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button27.addActionListener(new ActionListener() {
                int seatnum = 27;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button28.addActionListener(new ActionListener() {
                int seatnum = 28;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button29.addActionListener(new ActionListener() {
                int seatnum = 29;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button30.addActionListener(new ActionListener() {
                int seatnum = 30;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button31.addActionListener(new ActionListener() {
                int seatnum = 31;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button32.addActionListener(new ActionListener() {
                int seatnum = 32;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
     button33.addActionListener(new ActionListener() {
                int seatnum = 33;
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        {           
                            try{
                                
                 String scheduleid=scheduleDomain.getBusScheduleID();
                 String ticketid=shortorigin+shortdestination+"0"+seatnum;
                 jtfTicketID.setText(ticketid);
                // String ticketid=shortdestinationdomain.getShortDestination()+shortorigindomain.getShortOrigin()+seatnum;
                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?,?)";
                 stmt = conn.prepareStatement(strSQL1);
                 stmt.setString(1, ticketid);
                 stmt.setDate(2,date);
                 stmt.setString(3,timedepart);
                 stmt.setString(4,timearrive);
                 stmt.setString(5,origin);
                 stmt.setString(6,destination);
                 stmt.setDouble(7,price1);
                 stmt.setString(8,busid);
                 stmt.setString(9,jtfAutoGenerate.getText());
                 stmt.setString(10,id);                       
                 stmt.setInt(11, seatnum);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Seat selected .");
                 ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
               //  JOptionPane.showMessageDialog(null,"Ticket ID generated:"+ticketid);
                 Statement stmtInsert = conn.createStatement();
                 stmtInsert.executeUpdate(strSQL1);
                 
                 
                 }catch(SQLException ex){
                     System.err.println("WRONG HERE");
                 System.err.println("DB ERROR:"+ex.toString());
             }
                }
                    }
                });
//     button5.addActionListener(new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        {           
//                            try{
//                 String scheduleid=scheduleDomain.getBusScheduleID();
//                 String strSQL1 = "insert into Ticket values (?,?,?,?,?,?,?,?,?,?)";
//                 stmt = conn.prepareStatement(strSQL1);
//                 stmt.setString(1, jtfTicketID.getText());
//                 stmt.setString(3,jtfBusScheduleDate.getText());
//                 stmt.setString(4,jtfBusScheduleTimeDepart.getText());
//                 stmt.setString(5, jtfBusScheduleTimeArrive.getText());
//                 stmt.setString(6, jtfBusScheduleOrigin.getText());
//                 stmt.setString(7,jtfBusScheduleDestination.getText());
//                 stmt.setString(8, jtfBusSchedulePrice.getText());
//                 stmt.setString(2,jtfBusScheduleBusID.getText());        
//                 stmt.setString(9, jtfBusScheduleID.getText());
//                 stmt.setInt(10, 5);
//                 
//                 stmt.setInt(10,1);
//                 stmt.executeUpdate();
//                 JOptionPane.showMessageDialog(null, "Seat selected .");
//                 Statement stmtInsert = conn.createStatement();
//                 stmtInsert.executeUpdate(strSQL1);
//                 button1.setEnabled(false);
//                 
//                 }catch(SQLException ex){
//                 System.err.println("DB ERROR:"+ex.toString());
//             }
//                }
//                    }
//                });
//    
     
     jbAutoGenerate.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent e){
                         
                          String str=displayAutomatedCode('P');
                          jtfAutoGenerate.setText(str);
                          
                      }
                  });
     jbGetIc.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent e){
     String[] choices= {"Customer","Staff"};
int response=JOptionPane.showOptionDialog(null, "Who are you?", "Select One", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
       if (response == 0){
           String ID=autoGenerateCustomerID('C');
           addCustomerID(ID); 
           jtfUserType.setText(("Customer ID:"));
           jtfUserType1.setText(ID);
           String str=displayAutomatedCode('P');
           addCustomerPaymentID(str,ID); 
           
           jtfAutoGenerate.setText(str);
           jbtPayment.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent e){
                          String paymentid=jtfAutoGenerate.getText();
                    CustomerPaymentDomain customerpaymentdomain = new CustomerPaymentDomain(paymentid,ID,date,timedepart,timearrive,origin,destination,price1,busid);
                          
                          CustomerPayment payment=new CustomerPayment(customerpaymentdomain);
                         dispose();
                      }
                  });
       }
       else if (response == 1){
           String STAFFID= JOptionPane.showInputDialog("Please input Staff ID",JOptionPane.OK_OPTION);
           if(STAFFID.equals("")){
                   JOptionPane.showMessageDialog(null, "Staff ID cannot be empty.", "Null Value Error", JOptionPane.ERROR_MESSAGE);
           } 
                   else{
           rs1 = FindStaffID(STAFFID);
           try{
           if(rs1.next())
           {
               String str=displayAutomatedCode('P');
               
                          jtfAutoGenerate.setText(str);
                          addStaffPaymentID(str, STAFFID); 
                          jtfUserType.setText(("Staff ID:"));
                          jtfUserType1.setText(STAFFID);
               jbtPayment.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent e){
                          String paymentid=jtfAutoGenerate.getText();
                    StaffPaymentDomain staffpaymentdomain = new StaffPaymentDomain(paymentid,STAFFID,date,timedepart,timearrive,origin,destination,price1,busid);
                          
                          StaffPayment staffpayment=new StaffPayment(staffpaymentdomain);
                          dispose();
                      }
                  });
           }
           else{
              JOptionPane.showMessageDialog(null,"Wrong Staff ID","Error",JOptionPane.OK_OPTION);
                         
                          
               
           }
           
           
           }catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                                 }
           }
                          
           
       }
//       
//       
//                          String IC= JOptionPane.showInputDialog("Please input ur IC");
//                          addCustomerIC(IC);
//                          String str=displayAutomatedCode('P');
//                          jtfAutoGenerate.setText(str);
//                          addPaymentID(str, IC); 
                          
                      }
                  });
     
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
//    public ResultSet selectRecord(String ID) {
//        String queryStr = "SELECT * FROM BUSSCHEDULE WHERE BUSSCHEDULE_ID= ?";
//        ResultSet rs = null;
//        try {
//            
//            stmt = conn.prepareStatement(queryStr);
//            stmt.setString(1, ID);
//            rs = stmt.executeQuery();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        } 
//        return rs;
//    }
//          
//          
//             public class RetrieveListener implements ActionListener{
//              public void actionPerformed(ActionEvent e){
//                  try{
//                      String id = jtfBusScheduleID.getText();
//                      rs = selectRecord(id);
//                      
//                          
//                           
//                            // jtfTicketID.setText(rs.getString("BUSSCHEDULE_ID"));
//                      if(rs.next()){
//                        jtfBusScheduleID.setText(rs.getString("BUSSCHEDULE_ID"));                          
//                          jtfBusScheduleDate.setText(rs.getString("BUSSCHEDULE_DATE"));
//                          jtfBusScheduleTimeDepart.setText(rs.getString("BUSSCHEDULE_TIMEDEPART"));
//                          jtfBusScheduleTimeArrive.setText(rs.getString("BUSSCHEDULE_TIMEARRIVE"));
//                          jtfBusScheduleOrigin.setText(rs.getString("BUSSCHEDULE_ORIGIN"));                          
//                          jtfBusScheduleDestination.setText(rs.getString("BUSSCHEDULE_DESTINATION"));
//                           jtfBusScheduleBusID.setText(rs.getString("BUS_ID"));
//                           
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
//          
//          
     private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
           Login login=new Login();
    }
     }
     
     private class OrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
           Order order=new Order();
    }
     }
     
     private class HomeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
           HomePage homepage=new HomePage();
    }
     }
     private class BackToHomeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
           HomePage homepage=new HomePage();
    }
     }
     
     
     private class StaffListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
           Staff staff=new Staff();
    }
     }
     
     private class BusScheduleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
           BusSchedule busschedule=new BusSchedule();
    }
     }
     
     private class TicketPurchasingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
//           TicketPurchasing ticketpurchasing=new TicketPurchasing();
    }
     }
     
     private class ReportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
           Report report=new Report();
    }
     }
     
     
     public static void main(String[] args){
//         new TicketPurchasing();
     }
     
     public ResultSet selectRecord(String ScheduleID) {
        String queryStr = "SELECT * FROM TICKET WHERE BUSSCHEDULE_ID= ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ScheduleID);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      //  System.out.println("GOT RETURN!"); 
        return rs;
    }
    
   public ResultSet addCustomerIC(String IC) {
       
        String queryStr = "insert into CUSTOMER values (?,?,?,?,?,?,?)";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, IC);
            stmt.setString(2, "");
            stmt.setString(3, "");
            stmt.setString(4, "");
            stmt.setInt(5, 0);
            stmt.setString(6, "");
            stmt.setInt(7, 0);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      //  System.out.println("GOT RETURN!"); 
        return rs;
    } 
   public ResultSet addCustomerID(String ID) {
       
        String queryStr = "insert into CUSTOMER values (?,?,?,?,?,?,?)";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            stmt.setString(2, "");
            stmt.setString(3, "");
            stmt.setString(4, "");
            stmt.setInt(5, 0);
            stmt.setString(6, "");
            stmt.setInt(7, 0);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      //  System.out.println("GOT RETURN!"); 
        return rs;
    } 
    public ResultSet addCustomerPaymentID(String paymentID,String IC) {
        String queryStr = "insert into PAYMENT values (?,?,?,?,?)";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, paymentID);
            stmt.setDouble(2, 0.0);
            stmt.setDate(3,null);
            stmt.setString(4, "NPC");
            stmt.setString(5, IC);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      //  System.out.println("GOT RETURN!"); 
        return rs;
    } 
    public ResultSet addStaffPaymentID(String paymentID,String STAFFID) {
        String queryStr = "insert into PAYMENT values (?,?,?,?,?)";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, paymentID);
            stmt.setDouble(2, 0.0);
            stmt.setDate(3,null);
            stmt.setString(4,STAFFID);
            stmt.setString(5,"GUEST");
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      //  System.out.println("GOT RETURN!"); 
        return rs;
    } 
    
    public String displayAutomatedCode(char type)
     {
        
         String lastRowCode="";
         String subString="";
         String newAutomatedCode="";
         
         try {
            ResultSet rs=getRecord();
            
            rs.afterLast();
            while(rs.previous())
            {
                
                lastRowCode=rs.getString("PAYMENT_ID");
                if(lastRowCode.charAt(0)==type)
                {
                break;
              
                }
                  System.out.println(lastRowCode);
            }
            subString=lastRowCode.substring(1,lastRowCode.length());
            int convertedSubString=Integer.parseInt(subString)+1;
            newAutomatedCode=type+String.format("%03d",convertedSubString);
          System.out.println(newAutomatedCode);
             
            } catch (SQLException ex) {
                ex.getMessage();
                
            }
         return newAutomatedCode;
     }
    public String autoGenerateCustomerID(char type)
     {
        
         String lastRowCode="";
         String subString="";
         String newAutomatedCode="";
         
         try {
            ResultSet rs=getRecordForCustomerID();
            
            rs.afterLast();
            while(rs.previous())
            {
                
                lastRowCode=rs.getString("CUSTOMER_ID");
                if(lastRowCode.charAt(0)==type)
                {
                break;
              
                }
                  System.out.println(lastRowCode);
            }
            subString=lastRowCode.substring(1,lastRowCode.length());
            int convertedSubString=Integer.parseInt(subString)+1;
            newAutomatedCode=type+String.format("%03d",convertedSubString);
          System.out.println(newAutomatedCode);
             
            } catch (SQLException ex) {
                ex.getMessage();
                
            }
         return newAutomatedCode;
     }
    public ResultSet getRecord()
    {
        
        String sql="SELECT * FROM PAYMENT";
        ResultSet rs=null;
        try
        {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           
            rs=stmt.executeQuery();
                
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs;
    }
    
    
    public ResultSet getRecordForCustomerID()
    {
        
        String sql="SELECT * FROM CUSTOMER";
        ResultSet rs=null;
        try
        {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           
            rs=stmt.executeQuery();
                
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs;
    }
    
    public ResultSet FindStaffID(String id) {
        String queryStr = "SELECT * FROM STAFF WHERE STAFF_ID= ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      //  System.out.println("GOT RETURN!"); 
        return rs;
    }
    
    private class JTableListener implements MouseListener{
        public void mouseClicked(MouseEvent e){
            if(e.getClickCount() == 2){
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();
                
                String value =(String)ordertable.getValueAt(row,0);
              //  int value1=Integer.parseInt(value);
            //    rs2 = deleteRecord(value1);
                
                try {
                
                ResultSet rs = selectRecord2(value);
                    
                    
                if (rs.next()) {
                    deleteTicket(value);
                    System.out.println("delete record liao");
                } else {
                    JOptionPane.showMessageDialog(null, "No such record", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        }
        public void mouseExited(MouseEvent e) { } 
        public void mouseEntered(MouseEvent e) { }
        public void mouseReleased(MouseEvent e){ }
        public void mousePressed(MouseEvent e) { }
    }



    public void deleteRecord(String ticketid) {
        try {
            String deleteStr1 = "DELETE FROM TICKET WHERE TICKET_ID=?";
            stmt = conn.prepareStatement(deleteStr1);
            stmt.setString(1, ticketid);
          //  ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
         //  ordertable.retrieve();
 
        }
        catch (NullPointerException | ArrayIndexOutOfBoundsException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ResultSet selectRecord2(String ticketid) {
        String queryStr = "SELECT * FROM TICKET WHERE TICKET_ID= ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ticketid);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("GOT RETURN!"); 
        return rs;
    }

 public void deleteTicket(String ticketid) {
        try {
            String deleteStr1 = "DELETE FROM TICKET WHERE TICKET_ID  = ?";
            stmt = conn.prepareStatement(deleteStr1);
            stmt.setString(1, ticketid);
            stmt.executeUpdate();
            ordertable.retrieveRecordsByCode(jtfAutoGenerate.getText());
        }
        catch (NullPointerException | ArrayIndexOutOfBoundsException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
