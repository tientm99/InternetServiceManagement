/**
 * 
 */
package tien.java.web.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 */

public class ChiTietSuDung {
	private String maKH;
	private String tenKH;
	private String diaChi;
	private String maMay;
	private String viTri;
	private String trangThai;

	private LocalDate ngayBatDauSD;

	private LocalTime gioBatDauSD;
	private Integer thoiGianSD;
	private String maDV;

	private LocalDate ngaySD;

	private LocalTime gioSD;
	private Integer soLuong;
	private Integer tongTien;

	public ChiTietSuDung() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public ChiTietSuDung(String maKH, String tenKH, String diaChi, String maMay, String viTri, String trangThai,
			LocalDate ngayBatDauSD, LocalTime gioBatDauSD, Integer thoiGianSD, String maDV, LocalDate ngaySD,
			LocalTime gioSD, Integer soLuong) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
		this.ngayBatDauSD = ngayBatDauSD;
		this.gioBatDauSD = gioBatDauSD;
		this.thoiGianSD = thoiGianSD;
		this.maDV = maDV;
		this.ngaySD = ngaySD;
		this.gioSD = gioSD;
		this.soLuong = soLuong;
	}


	


	public ChiTietSuDung(String maKH, String tenKH, String diaChi, String maMay, String viTri, String trangThai,
			LocalDate ngayBatDauSD, LocalTime gioBatDauSD, Integer thoiGianSD, String maDV, LocalDate ngaySD,
			LocalTime gioSD, Integer soLuong, Integer tongTien) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
		this.ngayBatDauSD = ngayBatDauSD;
		this.gioBatDauSD = gioBatDauSD;
		this.thoiGianSD = thoiGianSD;
		this.maDV = maDV;
		this.ngaySD = ngaySD;
		this.gioSD = gioSD;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
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

	public Integer getThoiGianSD() {
		return thoiGianSD;
	}

	public void setThoiGianSD(Integer thoiGianSD) {
		this.thoiGianSD = thoiGianSD;
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

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Integer getTongTien() {
		return tongTien;
	}

	public void setTongTien(Integer tongTien) {
		this.tongTien = tongTien;
	}




	public String getDiaChi() {
		return diaChi;
	}




	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	

}
