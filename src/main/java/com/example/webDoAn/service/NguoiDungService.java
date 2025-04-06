package com.example.webDoAn.service;

import com.example.webDoAn.entity.ChucVu;
import com.example.webDoAn.entity.NguoiDung;
import com.example.webDoAn.entity.NguoiDungChucVu;
import com.example.webDoAn.repository.ChucVuRepoITF;
import com.example.webDoAn.repository.NguoiDungCvRepoITF;
import com.example.webDoAn.repository.NguoiDungRepoITF;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class NguoiDungService {
    private final NguoiDungRepoITF nguoiDungRepoITF;
    private final NguoiDungCvRepoITF nguoiDungCvRepoITF;
    private final ChucVuRepoITF chucVuRepoITF;

    public NguoiDungService(NguoiDungRepoITF nguoiDungRepoITF, NguoiDungCvRepoITF nguoiDungCvRepoITF, ChucVuRepoITF chucVuRepoITF) {
        this.nguoiDungRepoITF = nguoiDungRepoITF;
        this.nguoiDungCvRepoITF = nguoiDungCvRepoITF;
        this.chucVuRepoITF = chucVuRepoITF;
    }

    public NguoiDung dangKiThongTin(NguoiDung nguoiDung) {
        if (nguoiDung.getMaNguoiDung() == null || nguoiDung.getMaNguoiDung().trim().isEmpty()){
            nguoiDung.setMaNguoiDung("US"+ UUID.randomUUID().toString().substring(0,8));
        }
        nguoiDung.setNgayTao(new Date());
        nguoiDung.setTrangThai(1);
        NguoiDung saverNguoiDung = nguoiDungRepoITF.save(nguoiDung);
        NguoiDungChucVu nguoiDungChucVu = new NguoiDungChucVu();
        ChucVu chucVu = chucVuRepoITF.findById(3).orElseThrow(()->new RuntimeException("Không tìm thấy chức vụ với id = 3") );
        nguoiDungChucVu.setNguoiDung(saverNguoiDung);
        nguoiDungChucVu.setChucVu(chucVu);
        nguoiDungCvRepoITF.save(nguoiDungChucVu);
        return saverNguoiDung;
    }

    public NguoiDung dangNhap(String email, String matKhau) {
        return (NguoiDung) nguoiDungRepoITF.findByEmailAndMatKhau(email, matKhau)
                .orElse(null);
    }
}
