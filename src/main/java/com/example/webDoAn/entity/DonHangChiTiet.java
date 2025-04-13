package com.example.webDoAn.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "don_hang_chi_tiet")
public class DonHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma")
    private String maDonHangCt;
    @Column(name = "ten_do_an")
    private String tenMonAn;
    @Column(name = "gia_tien")
    private Double giaTien;
    @Column(name = "so_luong")
    private Integer soLuong;
    @Column(name = "tong_tien")
    private Double tongTien;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @Column(name = "ngay_xoa")
    private Date ngayXoa;
    @Column(name = "trang_thai")
    private Integer trangThai;
    @ManyToOne
    @JoinColumn(name = "id_do_an")
    private DoAn doAn;
    @ManyToOne
    @JoinColumn(name = "id_don_hang")
    private DonHang donHang;

    public DonHangChiTiet() {
    }

    public DonHangChiTiet(Long id, String maDonHangCt, String tenMonAn, Double giaTien, Integer soLuong, Double tongTien, Date ngayTao, Date ngaySua, Date ngayXoa, Integer trangThai, DoAn doAn, DonHang donHang) {
        this.id = id;
        this.maDonHangCt = maDonHangCt;
        this.tenMonAn = tenMonAn;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.trangThai = trangThai;
        this.doAn = doAn;
        this.donHang = donHang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaDonHangCt() {
        return maDonHangCt;
    }

    public void setMaDonHangCt(String maDonHangCt) {
        this.maDonHangCt = maDonHangCt;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
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

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public DoAn getDoAn() {
        return doAn;
    }

    public void setDoAn(DoAn doAn) {
        this.doAn = doAn;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }
}
