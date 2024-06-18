package model;

import java.util.Objects;

public class Khohang {
	private int maSanpham;
	private  String tenSanpham;
	private vitrikho kho;
	private int Soluong;
	
	public Khohang(String maSanpham2, String tenSanpham2, String soluong2, int vitrikho) {
	}

	public Khohang(int maSanpham, String tenSanpham, vitrikho kho, int soluong) {
		this.maSanpham = maSanpham;
		this.tenSanpham = tenSanpham;
		this.kho = kho;
		this.Soluong = soluong;
	}

	public Khohang(int maSanpham2, String tenSanpham2, int soluong2, String vitrikho) {
		// TODO Auto-generated constructor stub
	}

	public int getMaSanpham() {
		return maSanpham;
	}

	public void setMaSanpham(int maSanpham) {
		this.maSanpham = maSanpham;
	}

	public String getTenSanpham() {
		return tenSanpham;
	}

	public void setTenSanpham(String tenSanpham) {
		this.tenSanpham = tenSanpham;
	}

	public String getKho() {
		return null;
	}

	public void setKho(vitrikho kho) {
		this.kho = kho;
	}

	public int getSoluong() {
		return Soluong;
	}

	public void setSoluong(int soluong) {
		Soluong = soluong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Soluong, kho, maSanpham, tenSanpham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Khohang other = (Khohang) obj;
		return Soluong == other.Soluong && Objects.equals(kho, other.kho) && maSanpham == other.maSanpham
				&& Objects.equals(tenSanpham, other.tenSanpham);
	}

}
