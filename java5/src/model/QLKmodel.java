package model;

import java.util.ArrayList;
import java.util.Vector;

public class QLKmodel {
	private ArrayList<Khohang> dsTonkho;
	private String Luachon;
	private String tenFile;
	private ArrayList<Khohang> dsKhohang;
	private Object tableModel;
	
	public QLKmodel() {
		this.dsTonkho = new ArrayList<Khohang>();
		this.Luachon = "";
		this.tenFile ="";
	}

	public QLKmodel(ArrayList<Khohang> dsTonkho) {
		super();
		this.dsTonkho = dsTonkho;
	}

	public ArrayList<Khohang> getDsTonkho() {
		return dsTonkho;
	}
	
	public void setDsTonkho(ArrayList<Khohang> dsTonkho) {
		this.dsTonkho = dsTonkho;
	}
	public ArrayList<Khohang> getDsKhohang() {
		return dsKhohang;
	}
	public void setDsKhohang(ArrayList<Khohang> dsKhohang) {
		this.dsKhohang = dsKhohang;
	}
	public void delete(Khohang Sanpham) {
		this.dsTonkho.remove(Sanpham);
	}
	
	public void insert(Khohang Sanpham) {
		this.dsTonkho.add(Sanpham);
	}
	public void save(Khohang Sanpham) {
		this.dsTonkho.add(Sanpham);
	}
	public String getLuachon() {
		return Luachon;
	}

	public void setLuachon(String luachon) {
		this.Luachon = luachon;
	}

	public String getTenFile() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public void addRow(Vector<String> vec) {
		tableModel = null;
		// TODO Auto-generated method stub
		if (vec != null && vec.size() == ( (QLKmodel) tableModel).getColumn()) {
		      // Check if the provided vector has the same size as the table's columns
		      ((QLKmodel) tableModel).addRow(vec);
		    } else {
		      System.err.println("Error: Vector size must match table column count.");
		    }
		
	}

	private int getColumn() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
