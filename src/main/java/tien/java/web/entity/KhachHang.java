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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import tien.java.web.validate.KhachHangExist;
import tien.java.web.validate.ValidatedData;

/**
 * 
 */
@Entity
@GroupSequence({KhachHang.class,ValidatedData.validSave.class,ValidatedData.validUpdate.class})
public class KhachHang {
	
	@Id
	@Pattern(regexp = "KH\\d{3}", message = "Mã khách hàng không được trống và có định dạng KHxxx(xxx là số)",
			groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class})
	@KhachHangExist(groups = {ValidatedData.validSave.class}, create = true)
	private String maKH;

	@NotBlank(message = "Không được để trống",
			groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class})
	private String tenKH;

	private String diaChi;

	@Pattern(regexp = "0\\d{9}", message = "Số điện thoại không được trống và có định dạng 0xxxxxxxxx",
			groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class})
	private String sdt;

	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email sai định dạng",
			groups = {ValidatedData.validSave.class, ValidatedData.validUpdate.class})
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "maKH")
	private List<SuDungDichVu> suDungDichVu;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "maKH")
	private List<SuDungMay> suDungMay;

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String maKH, String tenKH, String diaChi, String sdt, String email) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", sdt=" + sdt + ", email="
				+ email + "]";
	}
	
	

}
