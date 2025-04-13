package com.example.webDoAn.dto;

import com.example.webDoAn.entity.DonHang;
import com.example.webDoAn.entity.DonHangChiTiet;

public class DonHangRequestDTO {
    private DonHang donHang;
    private DonHangChiTiet donHangChiTiet;

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public DonHangChiTiet getDonHangChiTiet() {
        return donHangChiTiet;
    }

    public void setDonHangChiTiet(DonHangChiTiet donHangChiTiet) {
        this.donHangChiTiet = donHangChiTiet;
    }
}
