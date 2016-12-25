package Ui;
import java.sql.*;
import javax.swing.table.*;

public class OrderTable extends AbstractTableModel{
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private String host = "jdbc:derby://localhost:1527/kkkldb3";
    private String user = "nbuser";
    private String password = "nbuser";
   private String[] columnHeaders = {"Ticket ID","Date","TimeDepart","TimeArrive","Origin","Destination","Price","Bus ID","Payment ID","Schedule ID","Seat Number"};
    
    public OrderTable(String id){
        try{
            String query = "SELECT * FROM TICKET WHERE PAYMENT_ID =? ";
            conn = DriverManager.getConnection(host, user, password);
            pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            metaData = rs.getMetaData();
            rs.last();
            numberOfRows = rs.getRow();
            fireTableStructureChanged();
            
        }catch(SQLException ex){
            ex.printStackTrace();   
        }
    }
    
    public void retrieveRecordsByCode(String id){
            try{
                String query = "SELECT * FROM TICKET WHERE PAYMENT_ID =? ";
                pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, id);
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
}