
package Ui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.lang.*;

public class BusSchedule extends JFrame{
    

    
    private JButton jbtHome= new JButton("Home");
    private JButton jbtStaff= new JButton("Staff");
    private JButton jbtBusSchedule= new JButton("BusSchedule");
    private JButton jbtTicketPurchasing= new JButton("TicketPurchasing");
    private JButton jbtReport= new JButton("Report");
    private JButton jbtLogin= new JButton("Login");
    private JButton jbtOrder=new JButton("Order");

    
    ImageIcon Bar1 = new ImageIcon(getClass().getResource("bus1.png"));
    ImageIcon Bar2 = new ImageIcon(getClass().getResource("bus2.png"));
    JLabel LabelBar1=new JLabel();
    JLabel LabelBar2=new JLabel();

    private JPanel Panel1part1= new JPanel(new GridLayout(1,1));
    private JPanel Panel1part2=new JPanel(new GridLayout(1,1));
    private JPanel Panel1part3= new JPanel(new GridLayout(2,1));
    private JPanel Panel1= new JPanel(new GridLayout(1,3));
    private JPanel Panel2= new JPanel(new GridLayout(1,5));
    private JPanel PanelNorth= new JPanel(new GridLayout(2,1));
    
    SearchBusSchedule searchbusschedule=new SearchBusSchedule();
    AddBusSchedule addbusschedule=new AddBusSchedule();
    UpdateBusSchedule updatebusschedule=new UpdateBusSchedule();
    
    JPanel PanelShow = new JPanel(new CardLayout());
    JPanel PanelEast = new JPanel(new GridLayout(4,1));
    private JButton jbtSearch=new JButton("Search Schedule");
    private JButton jbtAdd=new JButton("Add New Schedule");
    private JButton jbtUpdate=new JButton("Update Schedule");
    String[] constraints = {"Search Schedule","Add Schedule","Update Schedule"};
    
        

    
     
    
    
    public BusSchedule(){
     setTitle("BusSchedule");
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

     
     PanelEast.add(jbtSearch);
     PanelEast.add(jbtAdd);
     PanelEast.add(jbtUpdate);
     PanelEast.add(jbtHome);
     add(PanelEast,BorderLayout.WEST);
     
     PanelShow.add(searchbusschedule, constraints[0]);
     PanelShow.add(addbusschedule, constraints[1]);
     PanelShow.add(updatebusschedule, constraints[2]);
     add(PanelShow,BorderLayout.CENTER);
     
     jbtLogin.addActionListener(new LoginListener());
     jbtOrder.addActionListener(new OrderListener());
     jbtHome.addActionListener(new HomeListener());
     jbtStaff.addActionListener(new StaffListener());
     jbtBusSchedule.addActionListener(new BusScheduleListener());
     jbtTicketPurchasing.addActionListener(new TicketPurchasingListener());
     jbtReport.addActionListener(new ReportListener());
     
     jbtSearch.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
          
           CardLayout c1 = (CardLayout)(PanelShow.getLayout()); 
           c1.show(PanelShow, constraints[0]);
          
    }
    });
     jbtAdd.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
          
           CardLayout c1 = (CardLayout)(PanelShow.getLayout()); 
           c1.show(PanelShow, constraints[1]);
          
    }
    });
     
        jbtUpdate.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
          
           CardLayout c1 = (CardLayout)(PanelShow.getLayout()); 
           c1.show(PanelShow, constraints[2]);
          
    }
    });
     
     
     
     
     
        pack();
        setSize(705,753);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
//    private class SearchListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            
//           CardLayout c1 = (CardLayout)(PanelEast.getLayout()); 
//           c1.show(PanelEast, constraints[0]);
//           
//    }
//     }
//    private class AddListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//          
//           CardLayout c1 = (CardLayout)(PanelEast.getLayout()); 
//           c1.show(PanelEast, constraints[1]);
//          
//    }
//     }
//    private class UpdateListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            
//           CardLayout c1 = (CardLayout)(PanelEast.getLayout()); 
//           c1.show(PanelEast, constraints[2]);
//    }
//     }
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
          HomePage homepage=new HomePage();;
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
         BusSchedule busschedule=new BusSchedule();
     }
}
