
package Ui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.lang.*;

public class HomePage extends JFrame{
    private JButton jbtHome= new JButton("Home");
    private JButton jbtStaff= new JButton("Staff");
    private JButton jbtBusSchedule= new JButton("BusSchedule");
    private JButton jbtTicketPurchasing= new JButton("TicketPurchasing");
    private JButton jbtReport= new JButton("Report");
    private JButton jbtLogin= new JButton("Login");
    private JButton jbtOrder=new JButton("Order");
    ImageIcon Bar1 = new ImageIcon(getClass().getResource("bus1.png"));
    ImageIcon Bar2 = new ImageIcon(getClass().getResource("bus2.png"));
    ImageIcon Promotion = new ImageIcon(getClass().getResource("Promotion.png"));
    
//    ImageIcon Facility= new ImageIcon(getClass().getResource("Facility.png"));
//    ImageIcon Image1= new ImageIcon(getClass().getResource("AirCond.png"));
//    ImageIcon Image2= new ImageIcon(getClass().getResource("LuggageRack.png"));
//    ImageIcon Image3= new ImageIcon(getClass().getResource("EmergencyToilet.png"));
//    ImageIcon Image4= new ImageIcon(getClass().getResource("Curtain.png"));
//    ImageIcon Image5= new ImageIcon(getClass().getResource("AirCond.png"));
//    ImageIcon Image6= new ImageIcon(getClass().getResource("FreeWifi.png"));
    
    ImageIcon Facilities = new ImageIcon(getClass().getResource("Facilities.png"));
    JLabel LabelBar1=new JLabel();
    JLabel LabelBar2=new JLabel();
    JLabel LabelPromotion=new JLabel();
    JLabel LabelFacilities=new JLabel();
//    JLabel Label1 = new JLabel(); 
//    JLabel Label2 = new JLabel(); 
//    JLabel Label3 = new JLabel(); 
//    JLabel Label4 = new JLabel(); 
//    JLabel Label5 = new JLabel();
//    JLabel Label6 = new JLabel(); 
    
    private JPanel Panel1part1= new JPanel(new GridLayout(1,1));
    private JPanel Panel1part2=new JPanel(new GridLayout(1,1));
    private JPanel Panel1part3= new JPanel(new GridLayout(2,1));
    private JPanel Panel1= new JPanel(new GridLayout(1,3));
    private JPanel Panel2= new JPanel(new GridLayout(1,5));
    private JPanel PanelNorth= new JPanel(new GridLayout(2,1));
    
    private JPanel PanelCenter= new JPanel(new GridLayout(1,1));
    
//    private JPanel PanelFacilities1=new JPanel(new GridLayout(1,1));
//    private JPanel PanelFacilities2=new JPanel(new GridLayout(2,3));
    private JPanel PanelSouth=new JPanel(new GridLayout(1,1));
    
    
    
    
    
    public HomePage(){
     setTitle("HomePage");
     setLayout(new BorderLayout());
     LabelBar1.setIcon(Bar1);
     LabelBar1.setHorizontalAlignment(SwingConstants.CENTER);
     LabelBar2.setIcon(Bar2);
     LabelBar2.setHorizontalAlignment(SwingConstants.CENTER);
     Panel1part1.add(LabelBar1);
     Panel1part2.add(LabelBar2);
     Panel1part3.add(jbtLogin);
     Panel1part3.add(jbtOrder);
     Panel1.add(Panel1part1);
     Panel1.add(Panel1part2);
     Panel1.add(Panel1part3);
     PanelNorth.add(Panel1);     
     Panel2.add(jbtHome);
     Panel2.add(jbtStaff);
     Panel2.add(jbtBusSchedule);
     Panel2.add(jbtTicketPurchasing);
     Panel2.add(jbtReport);
     PanelNorth.add(Panel2);
     add(PanelNorth,BorderLayout.NORTH);
     
     
     LabelPromotion.setIcon(Promotion);
     LabelPromotion.setHorizontalAlignment(SwingConstants.CENTER);
     PanelCenter.add(LabelPromotion);
     add(PanelCenter,BorderLayout.CENTER);
     
     LabelFacilities.setIcon(Facilities);
     LabelFacilities.setHorizontalAlignment(SwingConstants.CENTER);
//     PanelFacilities1.add(LabelFacilities);
//     Label1.setIcon(Image1);
//     Label2.setIcon(Image2);
//     Label3.setIcon(Image3);
//     Label4.setIcon(Image4);
//     Label5.setIcon(Image5);
//     Label6.setIcon(Image6);
//     Label1.setHorizontalAlignment(SwingConstants.CENTER);
//     Label2.setHorizontalAlignment(SwingConstants.CENTER);
//     Label3.setHorizontalAlignment(SwingConstants.CENTER);
//     Label4.setHorizontalAlignment(SwingConstants.CENTER);
//     Label5.setHorizontalAlignment(SwingConstants.CENTER);
//     Label6.setHorizontalAlignment(SwingConstants.CENTER);
//     PanelFacilities2.add(Label1);
//     PanelFacilities2.add(Label2);
//     PanelFacilities2.add(Label3);
//     PanelFacilities2.add(Label4);
//     PanelFacilities2.add(Label5);
//     PanelFacilities2.add(Label6);
//     PanelSouth.add(PanelFacilities1);
//     PanelSouth.add(PanelFacilities2);
     PanelSouth.add(LabelFacilities);
     add(PanelSouth,BorderLayout.SOUTH);
     
     jbtLogin.addActionListener(new LoginListener());
     jbtOrder.addActionListener(new OrderListener());
     jbtHome.addActionListener(new HomeListener());
     jbtStaff.addActionListener(new StaffListener());
     jbtBusSchedule.addActionListener(new BusScheduleListener());
     jbtTicketPurchasing.addActionListener(new TicketPurchasingListener());
     jbtReport.addActionListener(new ReportListener());
     
     
     
        pack();
        setSize(705,753);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
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
     //      TicketPurchasing ticketpurchasing=new TicketPurchasing();
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
         new HomePage();
     }
}
