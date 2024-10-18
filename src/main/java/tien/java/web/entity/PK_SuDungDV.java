/**
 * 
 */
package tien.java.web.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Embeddable;
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
public class PK_SuDungDV implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Pattern(regexp = "KH\\d{3}", message = "Mã khách hàng không được trống và có định dạng KHxxx(xxx là số)")
	@KhachHangExist(groups = {ValidatedData.validSave.class}, create = false)
	private String maKH;
	
	@Pattern(regexp = "DV\\d{3}", message = "Mã dịch vụ phải có định dạng DVxxx(xxx là số)")
	@MayExist(groups = {ValidatedData.validSave.class}, create = false)
	private String maDV;
	
	@NotNull(message = "Không được để trống")
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private LocalDate ngaySD;
	
	@NotNull(message = "Không được để trống")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime gioSD;

	public PK_SuDungDV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PK_SuDungDV(String maKH, String maDV, LocalDate ngaySD, LocalTime gioSD) {
		super();
		this.maKH = maKH;
		this.maDV = maDV;
		this.ngaySD = ngaySD;
		this.gioSD = gioSD;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public LocalDate getNgaySD() {
		return ngaySD;
	}

	public void setNgaySD(LocalDate ngaySD) {
		this.ngaySD = ngaySD;
	}

	public LocalTime getGioSD() {
		return gioSD;
	}

	public void setGioSD(LocalTime gioSD) {
		this.gioSD = gioSD;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(gioSD, maDV, maKH, ngaySD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PK_SuDungDV other = (PK_SuDungDV) obj;
		return Objects.equals(gioSD, other.gioSD) && Objects.equals(maDV, other.maDV)
				&& Objects.equals(maKH, other.maKH) && Objects.equals(ngaySD, other.ngaySD);
	}

}
