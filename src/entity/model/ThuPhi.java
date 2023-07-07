package entity.model;

public class ThuPhi {

	int id, idHoiVien, idGoiTap;

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

	public int getIdGoiTap() {
		return idGoiTap;
	}

	public void setIdGoiTap(int idGoiTap) {
		this.idGoiTap = idGoiTap;
	}

	public ThuPhi(int id, int idHoiVien, int idGoiTap) {
		super();
		this.id = id;
		this.idHoiVien = idHoiVien;
		this.idGoiTap = idGoiTap;
	}

}
