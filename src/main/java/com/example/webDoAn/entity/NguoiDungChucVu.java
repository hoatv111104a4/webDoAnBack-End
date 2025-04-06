package com.example.webDoAn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nguoidung_chucvu")
public class NguoiDungChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_nguoi_dung")
    private NguoiDung nguoiDung;
    @ManyToOne
    @JoinColumn(name = "id_chuc_vu")
    private ChucVu chucVu;

    public NguoiDungChucVu() {
    }

    public NguoiDungChucVu(Long id, NguoiDung nguoiDung, ChucVu chucVu) {
        this.id = id;
        this.nguoiDung = nguoiDung;
        this.chucVu = chucVu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }
}
