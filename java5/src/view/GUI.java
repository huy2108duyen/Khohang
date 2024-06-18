package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;
import model.Khohang;
import model.QLKmodel;
import model.vitrikho;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.QLKController;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.border.BevelBorder;



public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JLabel labelTK;
    public QLKmodel Model;
    QLKController dhCon = new QLKController();
	
	static final String url = "jdbc:mysql://localhost:3306/query1";
	static final String nameUser = "root";
	static final String pass = "19092004";
	protected static Connection c = null;
	private DefaultTableModel modelKhohang;
	private JTable table;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public GUI() {
		this.Model = new QLKmodel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ActionListener action = new QLKController(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RoundedPanel jPanelMenu = new RoundedPanel(50, Color.WHITE);
		jPanelMenu.setBounds(5, 5, 135, 451);
		jPanelMenu.setLayout(new BorderLayout(0, 0));
		contentPane.add(jPanelMenu);

        setVisible(true);
        
		
		JLabel labelHouse = new JLabel("");
		labelHouse.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/House.png")).getImage();
		labelHouse.setIcon(new ImageIcon(img));
		jPanelMenu.add(labelHouse);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalGlue());

		
		JLabel labelDH = new JLabel("Đơn Hàng");
		labelDH.setHorizontalAlignment(SwingConstants.CENTER);
		labelDH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgDH = new ImageIcon(this.getClass().getResource("/icon_DonHang.png")).getImage();
		Image sacledImgDH = imgDH.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelDH.setIcon(new ImageIcon(sacledImgDH));
		labelDH.setBounds(29, 88, 140, 50);
		panel.add(labelDH);
		
		labelDH.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		labelTK = new JLabel("Tồn Kho");
		labelTK.setHorizontalAlignment(SwingConstants.CENTER);
		labelTK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgTK = new ImageIcon(this.getClass().getResource("/icon_TonKho.png")).getImage();
		Image sacledImgTK = imgTK.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelTK.setIcon(new ImageIcon(sacledImgTK));
		labelTK.setBounds(29, 149, 140, 50);
		panel.add(labelTK);
		
		labelTK.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelNX = new JLabel("Nhập/Xuất");
		labelNX.setHorizontalAlignment(SwingConstants.CENTER);
		labelNX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgNX = new ImageIcon(this.getClass().getResource("/icon_NhapXuat.png")).getImage();
		Image sacledImgNX = imgNX.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelNX.setIcon(new ImageIcon(sacledImgNX));
		labelNX.setBounds(29, 197, 140, 50);
		panel.add(labelNX);
		
		labelNX.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelVT = new JLabel("Vị Trí Kho");
		labelVT.setHorizontalAlignment(SwingConstants.CENTER);
		labelVT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgVT = new ImageIcon(this.getClass().getResource("/icon_ViTri.png")).getImage();
		Image sacledImgVT = imgVT.getScaledInstance(40, 36, Image.SCALE_SMOOTH);
		labelVT.setIcon(new ImageIcon(sacledImgVT));
		labelVT.setBounds(29, 258, 140, 50);
		panel.add(labelVT);
		
		labelVT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelQT = new JLabel("Quản Trị");
		labelQT.setHorizontalAlignment(SwingConstants.CENTER);
		labelQT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgQT = new ImageIcon(this.getClass().getResource("/icon_QuanTri.png")).getImage();
		Image sacledImgQT = imgQT.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelQT.setIcon(new ImageIcon(sacledImgQT));
		labelQT.setBounds(29, 319, 140, 50);
		panel.add(labelQT);
		
		labelQT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelTKe = new JLabel("Thống kê");
		labelTKe.setHorizontalAlignment(SwingConstants.CENTER);
		labelTKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgTKe = new ImageIcon(this.getClass().getResource("/icon_ThongKe.png")).getImage();
		Image sacledImgTKe = imgTKe.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelTKe.setIcon(new ImageIcon(sacledImgTKe));
		labelTKe.setBounds(29, 376, 140, 50);
		panel.add(labelTKe);
		
		labelTKe.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		panel.add(Box.createVerticalStrut(10));
		panel.add(Box.createVerticalGlue());
		
		jPanelMenu.add(labelHouse, BorderLayout.NORTH);
		jPanelMenu.add(panel, BorderLayout.CENTER);
		
		
//		modelKhohang = new DefaultTableModel();
//		modelKhohang.addColumn("Mã sản phẩm");
//        modelKhohang.addColumn("Tên sản phẩm");
//        modelKhohang.addColumn("Số lượng");
//        modelKhohang.addColumn("Vị trí kho");
////		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "V\u1ECB tr\u00ED kho"
//			}
//		));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(150, 11, 630, 450);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách sản phẩm");
		lblNewLabel_2.setBounds(0, 11, 166, 33);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 55, 610, 384);
		panel_1.add(scrollPane);
		
		modelKhohang = new DefaultTableModel();
		modelKhohang.addColumn("Mã sản phẩm");
        modelKhohang.addColumn("Tên sản phẩm");
        modelKhohang.addColumn("Số lượng");
        modelKhohang.addColumn("Vị trí kho");
		table = new JTable(modelKhohang);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Vị trí kho"
//			}
//		));
		loadDataToTableKhoHang();
		scrollPane.setViewportView(table);
		contentPane.add(panel_1, BorderLayout.CENTER);
//		scrollPane.setViewportView(table);

		
		this.setVisible(true);
            }
		
	public void loadDataToTableKhoHang() {
		ArrayList<Khohang> arr = new ArrayList<>();
		arr = dhCon.getListKhohangConTroller();
		modelKhohang.setRowCount(0);
		if(arr != null) {
			for(Khohang x : arr) {
				Vector<String> vec = new Vector<String>();
				vec.add(x.getMaSanpham()+"");
				vec.add(x.getTenSanpham());
				vec.add(x.getSoluong()+"");
				vec.add(x.getKho());
				modelKhohang.addRow(vec);
				System.out.print("yes");
			}
		}
			
    }
	public void pushDataToTable() {
	    // Establish connection
	    Connection connection = null;
	    try {
	        connection = DriverManager.getConnection(url, nameUser, pass);

	        // Prepare statement
	        PreparedStatement statement = connection.prepareStatement("SELECT * FROM khohang.khohang12");

	        // Execute query and retrieve results
	        ResultSet resultSet = statement.executeQuery();
	        ArrayList<Khohang> arr = new ArrayList<>();
	        while (resultSet.next()) {
	            int maSanpham = resultSet.getInt("maSanpham");
	            String tenSanpham = resultSet.getString("tenSanpham");
	            int soluong = resultSet.getInt("soluong");
	            String kho = resultSet.getString("kho");
	            arr.add(new Khohang(maSanpham, tenSanpham, soluong, kho));
	        }

	        // Update table model
	        modelKhohang.setRowCount(0);
	        if (arr != null) {
	            for (Khohang x : arr) {
	                Vector<String> vec = new Vector<>();
	                vec.add(x.getMaSanpham() + "");
	                vec.add(x.getTenSanpham());
	                vec.add(x.getSoluong() + "");
	                vec.add(x.getKho());
	                modelKhohang.addRow(vec);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close connection
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	                // Handle connection closing error (optional)
	            }
	        }
	    }
	}
}