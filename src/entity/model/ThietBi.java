package entity.model;

public class ThietBi {
	
	private int id, idPhongTap;
	private String ten, ngayNhapVe, xuatXu, tinhTrang;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPhongTap() {
		return idPhongTap;
	}
	public void setIdPhongTap(int idPhongTap) {
		this.idPhongTap = idPhongTap;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNgayNhapVe() {
		return ngayNhapVe;
	}
	public void setNgayNhapVe(String ngayNhapVe) {
		this.ngayNhapVe = ngayNhapVe;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public ThietBi(int id, int idPhongTap, String ten, String ngayNhapVe, String xuatXu, String tinhTrang) {
		super();
		this.id = id;
		this.idPhongTap = idPhongTap;
		this.ten = ten;
		this.ngayNhapVe = ngayNhapVe;
		this.xuatXu = xuatXu;
		this.tinhTrang = tinhTrang;
	}
	
}
