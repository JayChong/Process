package Ui;
import java.sql.*;
import javax.swing.table.*;
import java.awt.Cursor;
import java.awt.Toolkit;

public class Schedule2 extends AbstractTableModel{
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private String host = "jdbc:derby://localhost:1527/kkkldb3";
    private String user = "nbuser";
    private String password = "nbuser";
   private String[] columnHeaders = {"Schedule ID", "Date","Origin","Destination","TimeDepart","TimeArrive","Bus ID"};
    
    public Schedule2(){
        try{
            String query = "SELECT * FROM SCHEDULE";
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
    
    public void retrieveRecordsByCode(String Destination){
            try{
                String query = "SELECT * FROM BUSSCHEDULE WHERE BUSSCHEDULE_DESTINATION like ? ";
                pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, Destination+ '%' );
                rs = pstmt.executeQuery();
                metaData = rs.getMetaData();
                rs.last();
                numberOfRows = rs.getRow();
                fireTableStructureChanged();
                
                
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
            String query = "SELECT * FROM SCHEDULE";
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
}