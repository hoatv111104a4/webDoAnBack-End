package com.example.webDoAn.repository;

import com.example.webDoAn.entity.DoAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoAnRepoITF extends JpaRepository<DoAn,Long> {

    @Query(value = "SELECT * FROM do_an order by ngay_tao desc ",nativeQuery = true)
    Page<DoAn> pageDoAn(Pageable pageable);

    Page<DoAn> findByTenContainingIgnoreCase(String ten, Pageable pageable);

    @Query("SELECT da FROM DoAn da WHERE da.loaiDoAn.id = 26 ORDER BY da.ngayTao DESC")
    Page<DoAn> pageDoAnMan(Pageable pageable);

    @Query("SELECT da FROM DoAn da WHERE da.loaiDoAn.id = 27 ORDER BY da.ngayTao DESC")
    Page<DoAn> pageDoChay(Pageable pageable);

    @Query("SELECT da FROM DoAn da WHERE da.loaiDoAn.id = 28 ORDER BY da.ngayTao DESC")
    Page<DoAn> pageDoTrangMieng(Pageable pageable);

    @Query("SELECT da FROM DoAn da WHERE da.loaiDoAn.id = 29 ORDER BY da.ngayTao DESC")
    Page<DoAn> pageDoAnVat(Pageable pageable);


    @Query("SELECT da FROM DoAn da WHERE da.loaiDoAn.id = 30 ORDER BY da.ngayTao DESC")
    Page<DoAn> pageNuocUong(Pageable pageable);

}
