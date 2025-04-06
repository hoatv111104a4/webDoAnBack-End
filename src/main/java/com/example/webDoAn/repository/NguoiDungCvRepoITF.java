package com.example.webDoAn.repository;

import com.example.webDoAn.entity.NguoiDungChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NguoiDungCvRepoITF extends JpaRepository<NguoiDungChucVu,Long> {
    @Query("SELECT ndcv FROM NguoiDungChucVu ndcv  ORDER BY ndcv.nguoiDung.ngayTao DESC")
    Page<NguoiDungChucVu> pageNguoiDungCv(Pageable pageable);
}
