package entity.model;

public class PhongTap {
	private int id;
	private String tenPhong, diaChi;
	
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public PhongTap() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public PhongTap(int id, String tenPhong, String diaChi) {
		super();
		this.id = id;
		this.tenPhong = tenPhong;
		this.diaChi = diaChi;
	}
	
	

}
