package entity.model;

public class PhanHoi {

	private int id, idHoiVien;
	private String noiDung;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdHoiVien() {
		return idHoiVien;
	}
	public void setIdHoiVien(int idHoiVien) {
		this.idHoiVien = idHoiVien;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public PhanHoi(int id, int idHoiVien, String noiDung) {
		super();
		this.id = id;
		this.idHoiVien = idHoiVien;
		this.noiDung = noiDung;
	}
	
}
