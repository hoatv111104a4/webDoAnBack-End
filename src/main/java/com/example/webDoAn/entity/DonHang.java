package com.example.webDoAn.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "don_hang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma")
    private String maDonHang;
    @Column(name = "nguoi_dat_hang")
    private String nguoiDatHang;
    @Column(name = "nguoi_nhan_hang")
    private String nguoiNhanHang;
    @Column(name = "tong_tien")
    private Double tongTien;
    @Column(name = "phi_ship")
    private Double phiShip;
    @Column(name = "thue_don_hang")
    private Double thueDonHang;
    @Column(name = "dia_chi_nhan_hang")
    private String diaChiNhanHang;
    @Column(name = "khung_gio_nhan_hang")
    private String khungGioNhanHang;
    @Column(name = "ngay_nhan_hang")

    private Date ngayMuonNhanHang;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @Column(name = "ngay_xoa")
    private Date ngayXoa;
    @Column(name = "ngay_giao")
    private Date ngayGiao;
    @Column(name = "trang_thai")
    private Integer trangThai;
    @ManyToOne
    @JoinColumn(name = "id_nguoidung_chucvu")
    private NguoiDungChucVu nguoiDungChucVu;

    public DonHang() {
    }

    public DonHang(Long id, String maDonHang, String nguoiDatHang, String nguoiNhanHang, Double tongTien, Double phiShip, Double thueDonHang, String diaChiNhanHang, String khungGioNhanHang, Date ngayMuonNhanHang, Date ngayTao, Date ngaySua, Date ngayXoa, Date ngayGiao, Integer trangThai, NguoiDungChucVu nguoiDungChucVu) {
        this.id = id;
        this.maDonHang = maDonHang;
        this.nguoiDatHang = nguoiDatHang;
        this.nguoiNhanHang = nguoiNhanHang;
        this.tongTien = tongTien;
        this.phiShip = phiShip;
        this.thueDonHang = thueDonHang;
        this.diaChiNhanHang = diaChiNhanHang;
        this.khungGioNhanHang = khungGioNhanHang;
        this.ngayMuonNhanHang = ngayMuonNhanHang;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.ngayGiao = ngayGiao;
        this.trangThai = trangThai;
        this.nguoiDungChucVu = nguoiDungChucVu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getNguoiDatHang() {
        return nguoiDatHang;
    }

    public void setNguoiDatHang(String nguoiDatHang) {
        this.nguoiDatHang = nguoiDatHang;
    }

    public String getNguoiNhanHang() {
        return nguoiNhanHang;
    }

    public void setNguoiNhanHang(String nguoiNhanHang) {
        this.nguoiNhanHang = nguoiNhanHang;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Double getPhiShip() {
        return phiShip;
    }

    public void setPhiShip(Double phiShip) {
        this.phiShip = phiShip;
    }

    public Double getThueDonHang() {
        return thueDonHang;
    }

    public void setThueDonHang(Double thueDonHang) {
        this.thueDonHang = thueDonHang;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public String getKhungGioNhanHang() {
        return khungGioNhanHang;
    }

    public void setKhungGioNhanHang(String khungGioNhanHang) {
        this.khungGioNhanHang = khungGioNhanHang;
    }

    public Date getNgayMuonNhanHang() {
        return ngayMuonNhanHang;
    }

    public void setNgayMuonNhanHang(Date ngayMuonNhanHang) {
        this.ngayMuonNhanHang = ngayMuonNhanHang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public Date getNgayXoa() {
        return ngayXoa;
    }

    public void setNgayXoa(Date ngayXoa) {
        this.ngayXoa = ngayXoa;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public NguoiDungChucVu getNguoiDungChucVu() {
        return nguoiDungChucVu;
    }

    public void setNguoiDungChucVu(NguoiDungChucVu nguoiDungChucVu) {
        this.nguoiDungChucVu = nguoiDungChucVu;
    }
}
