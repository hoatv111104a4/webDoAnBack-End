package com.example.webDoAn.service;

import com.example.webDoAn.entity.DonHang;
import com.example.webDoAn.entity.DonHangChiTiet;
import com.example.webDoAn.repository.DonHangCTRepoITF;
import com.example.webDoAn.repository.DonHangRepoITF;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class DonHangService {
    private final DonHangRepoITF donHangRepoITF;
    private final DonHangCTRepoITF donHangCTRepoITF;

    public DonHangService(DonHangRepoITF donHangRepoITF, DonHangCTRepoITF donHangCTRepoITF) {
        this.donHangRepoITF = donHangRepoITF;
        this.donHangCTRepoITF = donHangCTRepoITF;
    }

    public DonHang save(DonHang donHang, DonHangChiTiet donHangChiTiet) {
        if (donHang.getMaDonHang() == null || donHang.getMaDonHang().trim().isEmpty()){
            donHang.setMaDonHang("DH"+ UUID.randomUUID().toString().substring(0,8));
        }
        if (donHangChiTiet.getMaDonHangCt() == null || donHangChiTiet.getMaDonHangCt().trim().isEmpty()){
            donHangChiTiet.setMaDonHangCt("DHCT"+UUID.randomUUID().toString().substring(0,8));
        }
        donHang.setNgayTao(new Date());
        donHang.setTrangThai(0);
        DonHang saveDonHang = donHangRepoITF.save(donHang);
        donHangChiTiet.setDonHang(saveDonHang);
        donHangChiTiet.setTrangThai(0);
        donHangChiTiet.setNgayTao(new Date());
        donHangCTRepoITF.save(donHangChiTiet);
        return saveDonHang;
    }
}
