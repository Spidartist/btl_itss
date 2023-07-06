package entity.model;

public class NhanVien {

	private int id, idPhongTap;
	private String hoVaTen;
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
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public NhanVien(int id, int idPhongTap, String hoVaTen) {
		super();
		this.id = id;
		this.idPhongTap = idPhongTap;
		this.hoVaTen = hoVaTen;
	}
	

}
