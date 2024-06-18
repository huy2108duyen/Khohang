package model;

import java.util.Objects;

public class Khohang {
	private int maSanpham;
	private  String tenSanpham;
	private int Soluong;
	private String kho;
	
	public Khohang(int maSanpham, String tenSanpham, int soluong, String kho) {
		super();
		this.maSanpham = maSanpham;
		this.tenSanpham = tenSanpham;
		Soluong = soluong;
		this.kho = kho;
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
        if (kho != null) {
            return kho;
        } else {
            return null;
        }
    }

    public void setKho(String kho) {
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
