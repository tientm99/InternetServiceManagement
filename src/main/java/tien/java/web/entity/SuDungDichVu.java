/**
 * 
 */
package tien.java.web.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 */
@Entity
public class SuDungDichVu {

	@EmbeddedId
	@Valid
	private PK_SuDungDV id;

	@ManyToOne
	@JoinColumn(name = "maKH")
	@MapsId("maKH")
	private KhachHang maKH;

	@ManyToOne
	@JoinColumn(name = "maDV")
	@MapsId("maDV")
	private DichVu maDV;

	@NotNull(message = "Không được để trống")
	private Integer soLuong;

	public SuDungDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuDungDichVu(PK_SuDungDV id, KhachHang maKH, DichVu maDV, Integer soLuong) {
		super();
		this.id = id;
		this.maKH = maKH;
		this.maDV = maDV;
		this.soLuong = soLuong;
	}

	public PK_SuDungDV getId() {
		return id;
	}

	public void setId(PK_SuDungDV id) {
		this.id = id;
	}

	public KhachHang getMaKH() {
		return maKH;
	}

	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}

	public DichVu getMaDV() {
		return maDV;
	}

	public void setMaDV(DichVu maDV) {
		this.maDV = maDV;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

}
