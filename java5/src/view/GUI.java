package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.QLKController;
import javax.swing.JScrollPane;



public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JLabel labelTK;
    public QLKmodel Model;
    QLKController dhCon = new QLKController();
    public JTextField textField_Masp;
    private JTable table;
	private JComboBox comboBox_vitrikho;
	
	static final String url = "jdbc:mysql://localhost:3306/Khohang";
	static final String nameUser = "root";
	static final String pass = "19092004";
	protected static Connection c = null;
	private QLKController khDAO;
	

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
	public boolean openConnectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url, nameUser, pass);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
		
		JLabel lblNewLabel = new JLabel("Vị trí kho");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(150, 11, 75, 47);
		contentPane.add(lblNewLabel);
		
		comboBox_vitrikho = new JComboBox();
		ArrayList<vitrikho> listtenKho = vitrikho.getDSKho();
		for (vitrikho tenKho : listtenKho) {
		    comboBox_vitrikho.addItem(tenKho.getVitrikho());
		}
		comboBox_vitrikho.setBounds(239, 11, 118, 47);
		contentPane.add(comboBox_vitrikho);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(384, 5, 104, 53);
		contentPane.add(lblNewLabel_1);
		
		textField_Masp = new JTextField();
		textField_Masp.setBounds(498, 11, 146, 53);
		contentPane.add(textField_Masp);
		textField_Masp.setColumns(10);
		
		JButton btnSearch = new JButton("Tìm");
		btnSearch.addActionListener(action);
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSearch.setBounds(668, 18, 90, 33);
        contentPane.add(btnSearch);
		contentPane.add(btnSearch);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(150, 69, 620, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách sản phẩm");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(150, 82, 166, 33);
		contentPane.add(lblNewLabel_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "V\u1ECB tr\u00ED kho"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "V\u1ECB tr\u00ED kho"
			}
		));
		table.setBounds(150, 126, 620, 330);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 126, 620, 330);
		contentPane.add(scrollPane);

		
		this.setVisible(true);
		if (openConnectDB()) {
            loadKhohangData();
            }
		
	}
		private void loadKhohangData() {
	        try {
	            Statement statement = c.createStatement();
	            ResultSet result = statement.executeQuery("SELECT * FROM Khohang");

	            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	            tableModel.setRowCount(0); // Clear existing rows

	            while (result.next()) {
	                int maSanpham = result.getInt("MaSanPham");
	                String tenSanpham = result.getString("TenSanPham");
	                int Soluong = result.getInt("Soluong");
	                String vitrikho = result.getString("ViTriKho");

	                Khohang sp = new Khohang(maSanpham, tenSanpham, Soluong, vitrikho);
	                Object[] rowData = {maSanpham, tenSanpham, Soluong, vitrikho};
	                tableModel.addRow(rowData);
	            }

	            result.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		
	}
	public void xoaForm() {
		comboBox_vitrikho.setSelectedIndex(-1);
		textField_Masp.setText("");
		// TODO Auto-generated method stub
	}
	public void loadDataToTableKhohang() {
		ArrayList<Khohang> arr = new ArrayList<>();
		arr = khDAO.getListKhohangConTroller();
		if(arr != null) {
			for(Khohang x : arr) {
				Vector<String> vec = new Vector<String>();
				vec.add(x.getMaSanpham()+"");
				vec.add(x.getTenSanpham());
				vec.add(x.getSoluong() + "");
				vec.add(x.getKho());
				QLKmodel modelKhohang = null;
				modelKhohang.addRow(vec);
			}
		}
	}
}