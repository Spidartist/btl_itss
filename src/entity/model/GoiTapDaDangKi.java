package entity.model;

public class GoiTapDaDangKi {
	private int id;

	private String hoTen, ngayDangKi, tenGoiTap, loaiGoiTap;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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
	public String getNgayDangKi() {
		return ngayDangKi;
	}
	public void setNgayDangKi(String ngaySinh) {
		this.ngayDangKi = ngaySinh;
	}
	public GoiTapDaDangKi(int id, String hoTen, String tenGoiTap, String loaiGoiTap, String ngayDangKi) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.tenGoiTap = tenGoiTap;
		this.loaiGoiTap = loaiGoiTap;
		this.ngayDangKi = ngayDangKi;
	}

}
