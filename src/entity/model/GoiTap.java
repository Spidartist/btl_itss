package entity.model;

public class GoiTap {

	private int id, soTien;
	private String tenGoiTap, loaiGoiTap;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSoTien() {
		return soTien;
	}
	public void setSoTien(int soTien) {
		this.soTien = soTien;
	}
	public String getTenGoiTap() {
		return tenGoiTap;
	}
	public void setTenGoiTap(String tenGoiTap) {
		this.tenGoiTap = tenGoiTap;
	}
	public String getLoaiGoiTap() {
		return loaiGoiTap;
	}
	public void setLoaiGoiTap(String loaiGoiTap) {
		this.loaiGoiTap = loaiGoiTap;
	}
	public GoiTap(int id, int soTien, String tenGoiTap, String loaiGoiTap) {
		super();
		this.id = id;
		this.soTien = soTien;
		this.tenGoiTap = tenGoiTap;
		this.loaiGoiTap = loaiGoiTap;
	}
	

}
