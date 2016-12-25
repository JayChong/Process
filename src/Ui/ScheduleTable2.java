package Ui;
import java.sql.*;
import javax.swing.table.*;

public class ScheduleTable2 extends AbstractTableModel{
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private String host = "jdbc:derby://localhost:1527/kkkldb3";
    private String user = "nbuser";
    private String password = "nbuser";
    private String[] columnHeaders = {"Schedule ID", "Date","TimeDepart","TimeArrive","Origin","Destination","Price","Bus ID"};
    
    public ScheduleTable2(){
        try{
            String query = "SELECT * FROM BUSSCHEDULE";
            conn = DriverManager.getConnection(host, user, password);
            pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
            rs = pstmt.executeQuery();
            metaData = rs.getMetaData();
            rs.last();
            numberOfRows = rs.getRow();
            fireTableStructureChanged();
            
        }catch(SQLException ex){
            ex.printStackTrace();   
        }
    }
    
    public void retrieveRecordsByCode2(String Destination){
            try{
                String query = "SELECT * FROM busschedule WHERE BUSSCHEDULE_DESTINATION =? ";
                pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, Destination);
                rs = pstmt.executeQuery();
                metaData = rs.getMetaData();
                rs.last();
                numberOfRows = rs.getRow();
                fireTableStructureChanged();
                
                System.out.println("RETRIEVE HERE!"); 
            }catch(SQLException ex){
                ex.printStackTrace();
            }        
        }
       
   
    
    @Override
    public String getColumnName(int columnIndex){
        return columnHeaders[columnIndex];
    }
    
        @Override
        public int getRowCount(){
            return numberOfRows;
        
        }
   
        @Override
        public int getColumnCount(){
            try{
                return metaData.getColumnCount();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            return 0;
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex){
            try{
                rs.absolute(rowIndex+1);
                return rs.getObject(columnIndex+1);
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            return "";
        }


   public void retrieve(){
        try{
            String query = "SELECT * FROM BUSSCHEDULE";
            pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
            rs = pstmt.executeQuery();
            metaData = rs.getMetaData();
            rs.last();
            numberOfRows = rs.getRow();
            fireTableStructureChanged();
            
        }catch(SQLException ex){
            ex.printStackTrace();   
        }
    }
   public void shutDown(){
            try{
                if(rs != null){ rs.close(); }
                
                if(pstmt != null){ rs.close(); }
                
                if(conn != null) {conn.close();}
            
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
}