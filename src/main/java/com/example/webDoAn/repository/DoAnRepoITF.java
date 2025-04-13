package com.example.webDoAn.repository;

import com.example.webDoAn.entity.DoAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface DoAnRepoITF extends JpaRepository<DoAn,Long> {

    @Query(value = "SELECT * FROM do_an order by ngay_tao desc ",nativeQuery = true)
    Page<DoAn> pageDoAn(Pageable pageable);

    Page<DoAn> findByTenContainingIgnoreCase(String ten, Pageable pageable);

    @Query("SELECT da FROM DoAn da WHERE da.loaiDoAn.id = 1 ORDER BY da.ngayTao DESC")
    Page<DoAn> pageDoAnMan(Pageable pageable);

    @Query("SELECT da FROM DoAn da WHERE da.loaiDoAn.id = 2 ORDER BY da.ngayTao DESC")
    Page<DoAn> pageDoChay(Pageable pageable);

    @Query("SELECT da FROM DoAn da WHERE da.loaiDoAn.id = 3 ORDER BY da.ngayTao DESC")
    Page<DoAn> pageDoTrangMieng(Pageable pageable);

    @Query("SELECT da FROM DoAn da WHERE da.loaiDoAn.id = 4 ORDER BY da.ngayTao DESC")
    Page<DoAn> pageDoAnVat(Pageable pageable);


    @Query("SELECT da FROM DoAn da WHERE da.loaiDoAn.id = 5 ORDER BY da.ngayTao DESC")
    Page<DoAn> pageNuocUong(Pageable pageable);

    @Query("SELECT da FROM DoAn da WHERE da.ten like %:tenMonAn% ORDER BY da.ngayTao DESC")
    Page<DoAn> pageTrangChu(@RequestParam("tenMonAn") String tenMonAn, Pageable pageable);
}
