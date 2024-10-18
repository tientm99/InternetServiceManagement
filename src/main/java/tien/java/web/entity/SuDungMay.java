/**
 * 
 */
package tien.java.web.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 
 */
@Entity
public class SuDungMay {

	@EmbeddedId
	@Valid
	private PK_SuDungMay id;

	@ManyToOne
	@JoinColumn(name = "maKH")
	@MapsId("maKH")
	private KhachHang maKH;

	@ManyToOne
	@JoinColumn(name = "maMay")
	@MapsId("maMay")
	private May maMay;

	@NotNull(message = "Không được null")
	private Integer thoiGianSD;

	public SuDungMay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuDungMay(PK_SuDungMay id, KhachHang maKH, May maMay, Integer thoiGianSD) {
		super();
		this.id = id;
		this.maKH = maKH;
		this.maMay = maMay;
		this.thoiGianSD = thoiGianSD;
	}

	public PK_SuDungMay getId() {
		return id;
	}

	public void setId(PK_SuDungMay id) {
		this.id = id;
	}

	public KhachHang getMaKH() {
		return maKH;
	}

	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}

	public May getMaMay() {
		return maMay;
	}

	public void setMaMay(May maMay) {
		this.maMay = maMay;
	}

	public Integer getThoiGianSD() {
		return thoiGianSD;
	}

	public void setThoiGianSD(Integer thoiGianSD) {
		this.thoiGianSD = thoiGianSD;
	}

}
