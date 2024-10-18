/**
 * 
 */
package tien.java.web.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.GroupSequence;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import tien.java.web.validate.DichVuExist;
import tien.java.web.validate.ValidatedData;

/**
 * 
 */
@Entity
@GroupSequence({DichVu.class, ValidatedData.validSave.class, ValidatedData.validUpdate.class})
public class DichVu {
	@Id
	@Pattern(regexp = "DV\\d{3}", message = "Mã dịch vụ không được để trống và có định dạng DVxxx(xxx là số)",
			groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class})
	@DichVuExist(groups = {ValidatedData.validSave.class}, create = true)
	private String maDV;

	@NotBlank(message = "Không được để trống",
			groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class})
	private String tenDV;

	@NotBlank(message = "Không được để trống",
			groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class})
	private String donViTinh;

	@NotNull(message = "Đơn giá không được để trống",
			groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class})
	@Digits(integer = 10, fraction = 0, message = "Đơn giá chỉ được nhập số",
			groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class})
	@Min(value = 0, message = "Đơn giá phải lớn hơn hoặc bằng 0",
			groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class})
	private Integer donGia;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "maDV")
	private List<SuDungDichVu> suDungDichVu;

	public DichVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DichVu(String maDV, String tenDV, String donViTinh, Integer donGia) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public Integer getDonGia() {
		return donGia;
	}

	public void setDonGia(Integer donGia) {
		this.donGia = donGia;
	}

}
