package com.example.webDoAn.repository;

import com.example.webDoAn.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NguoiDungRepoITF extends JpaRepository<NguoiDung,Long> {

    Optional<Object> findByEmailAndMatKhau(String email, String matKhau);
}
