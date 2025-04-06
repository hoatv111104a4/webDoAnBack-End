package com.example.webDoAn.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "do_an")
public class DoAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long id;
    @JoinColumn(name = "ma")
    private String ma;
    @JoinColumn(name = "ten")
    private String ten;
    @JoinColumn(name = "gia_tien")
    private String giaTien;
    @JoinColumn(name = "hinh_anh")
    private String hinhAnh;
    @JoinColumn(name = "ngay_tao")
    private Date ngayTao;
    @JoinColumn(name = "ngay_sua")
    private Date ngaySua;
    @JoinColumn(name = "ngay_xoa")
    private Date ngayXoa;
    @JoinColumn(name = "trang_thai")
    private Integer trangThai;
    @JoinColumn(name = "mo_ta")
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "id_loai_do_an")
    private LoaiDoAn loaiDoAn;

    public DoAn() {
    }

    public DoAn(Long id, String ma, String ten, String giaTien, String hinhAnh, Date ngayTao, Date ngaySua, Date ngayXoa, Integer trangThai, String moTa, LoaiDoAn loaiDoAn) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.giaTien = giaTien;
        this.hinhAnh = hinhAnh;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.loaiDoAn = loaiDoAn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public LoaiDoAn getLoaiDoAn() {
        return loaiDoAn;
    }

    public void setLoaiDoAn(LoaiDoAn loaiDoAn) {
        this.loaiDoAn = loaiDoAn;
    }
}
