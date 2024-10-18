/**
 * 
 */
package tien.java.web.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import tien.java.web.validate.KhachHangExist;
import tien.java.web.validate.MayExist;
import tien.java.web.validate.ValidatedData;

/**
 * 
 */
@Embeddable
public class PK_SuDungMay implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Pattern(regexp = "KH\\d{3}", message = "Mã khách hàng không được trống và có định dạng KHxxx(xxx là số)")
	@KhachHangExist(groups = {ValidatedData.validSave.class}, create = false)
	private String maKH;
	
	@Pattern(regexp = "M\\d{3}", message = "Mã máy phải có định dạng Mxxx(xxx là số)")
	@MayExist(groups = {ValidatedData.validSave.class}, create = false)
	private String maMay;
	
	@NotNull(message = "Không được để trống")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayBatDauSD;
	
	@NotNull(message = "Không được để trống")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime gioBatDauSD;

	public PK_SuDungMay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PK_SuDungMay(@NotNull(message = "Không được null") String maKH,@NotNull(message = "Không được null") String maMay, LocalDate ngayBatDauSD, LocalTime gioBatDauSD) {
		super();
		this.maKH = maKH;
		this.maMay = maMay;
		this.ngayBatDauSD = ngayBatDauSD;
		this.gioBatDauSD = gioBatDauSD;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public LocalDate getNgayBatDauSD() {
		return ngayBatDauSD;
	}

	public void setNgayBatDauSD(LocalDate ngayBatDauSD) {
		this.ngayBatDauSD = ngayBatDauSD;
	}

	public LocalTime getGioBatDauSD() {
		return gioBatDauSD;
	}

	public void setGioBatDauSD(LocalTime gioBatDauSD) {
		this.gioBatDauSD = gioBatDauSD;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gioBatDauSD, maKH, maMay, ngayBatDauSD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PK_SuDungMay other = (PK_SuDungMay) obj;
		return Objects.equals(gioBatDauSD, other.gioBatDauSD) && Objects.equals(maKH, other.maKH)
				&& Objects.equals(maMay, other.maMay) && Objects.equals(ngayBatDauSD, other.ngayBatDauSD);
	}

	@Override
	public String toString() {
		return "SuDungMayId [maKH=" + maKH + ", maMay=" + maMay + ", ngayBatDauSuDung=" + ngayBatDauSD
				+ ", gioBatDauSuDung=" + gioBatDauSD + "]";
	}
}
