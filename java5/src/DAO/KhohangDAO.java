package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Khohang;

public class KhohangDAO {
	private static MyConnect conDB = new MyConnect();

    // Hàm khởi tạo để kết nối đến cơ sở dữ liệu
    public KhohangDAO() {
    	if (!conDB.openConnectDB()) {
            System.err.println("Failed to connect to database. KhohangDAO operations might be affected.");
        }
    }
    
    public static ArrayList<Khohang> getListKhohang(){
    	ArrayList<Khohang> arr = new ArrayList<>();
    	String sql = "SELECT * FROM Khohang";
    	
    	if(conDB.openConnectDB()) {
    		try {
        		PreparedStatement statement = conDB.conn.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int maSP = resultSet.getInt("MaSP");
                    String tenSP = resultSet.getString("TenSP");
                    int Soluong = resultSet.getInt("Soluong");
                    Object vitrikho  = resultSet.getString("Vitrikho");
                    Khohang tk = new Khohang();
                    tk.setMaSanpham(maSP);
                    tk.setTenSanpham(tenSP);
                    tk.setSoluong(Soluong);
                    model.vitrikho Kho = null;
					tk.setKho(Kho);
                    arr.add(tk);
                }
                return arr;
        	} catch (SQLException e) {
                e.printStackTrace();
            }
    	}
    	return null;
    }

	public ArrayList<Khohang> getListTonkho() {
		return null;
	}
}