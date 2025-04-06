package com.example.webDoAn.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "loai_do_an")
public class LoaiDoAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Integer id;
    @JoinColumn(name = "ten")
    private String ten;
    @JoinColumn(name = "ngay_tao")
    private Date ngayTao;
    @JoinColumn(name = "ngay_sua")
    private Date ngaySua;
    @JoinColumn(name = "ngay_xoa")
    private Date ngayXoa;
    @JoinColumn(name = "trang_thai")
    private Integer trangThai;

    public LoaiDoAn() {
    }

    public LoaiDoAn(Integer id, String ten, Date ngayTao, Date ngaySua, Date ngayXoa, Integer trangThai) {
        this.id = id;
        this.ten = ten;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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
}
