package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Khohang;

public class KhohangDAO {
	private static MyConnect conn = new MyConnect();

    public KhohangDAO() {
    	if (!conn.openConnectDB()) {
            System.err.println("Failed to connect to database. KhohangDAO operations might be affected.");
        }
    }
    
    public static ArrayList<Khohang> getListTonkho(){
        ArrayList<Khohang> arr = new ArrayList<>();
        String sql = "SELECT * FROM khohang.sanpham";
        if (conn.openConnectDB()) {
        	try { // Assuming getConnection() returns a Connection object
                PreparedStatement statement = conn.conn.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int maSP = resultSet.getInt("MaSP");
                    String tenSP = resultSet.getString("TenSP");
                    int Soluong = resultSet.getInt("Soluong");
                    String vitrikho  = resultSet.getString("Vitrikho");
                    Khohang kh = new Khohang(maSP, tenSP, Soluong, vitrikho); // Create Khohang object with retrieved data
                    arr.add(kh);
                }
                return arr;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
    		}
        }
        
        return null;
    }
                
	public static void main(String[] args) {
		KhohangDAO dao = new KhohangDAO();
		ArrayList<Khohang> listKhohang = null;
		try {
			listKhohang = KhohangDAO.getListTonkho();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (listKhohang != null) {
			System.out.println("yes");
			for (Khohang kh : listKhohang) {
				System.out.println(kh);
			}
		} else {
			System.out.println("no");
		}
	}
}