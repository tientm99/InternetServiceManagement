/**
 * 
 */
package tien.java.web.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import tien.java.web.validate.KhachHangExist;
import tien.java.web.validate.MayExist;
import tien.java.web.validate.ValidatedData;

/**
 * 
 */
@Entity
public class May2 {
	@Id
	@Pattern(regexp = "M\\d{3}", message = "Mã máy phải có định dạng Mxxx(xxx là số)",
	groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class})
	@MayExist(groups = {ValidatedData.validSave.class}, create = true)
	private String maMay;

	@NotBlank(message = "Vị trí không được để trống",
			groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class}) 
	private String viTri;

	@NotBlank(message = "Vị trí không được để trống",
			groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class})
	private String trangThai;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "maMay")
	private List<SuDungMay> suDungMay;

	public May2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public May2(String maMay, String viTri, String trangThai) {
		super();
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
	}

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

}
