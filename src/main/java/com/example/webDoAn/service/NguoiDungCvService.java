package com.example.webDoAn.service;

import com.example.webDoAn.entity.NguoiDungChucVu;
import com.example.webDoAn.repository.NguoiDungCvRepoITF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NguoiDungCvService {
    private final NguoiDungCvRepoITF nguoiDungCvRepoITF;

    public NguoiDungCvService(NguoiDungCvRepoITF nguoiDungCvRepoITF) {
        this.nguoiDungCvRepoITF = nguoiDungCvRepoITF;
    }
    public Page<NguoiDungChucVu> pageNguoiDungCv(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return nguoiDungCvRepoITF.pageNguoiDungCv(pageable);
    }
}
