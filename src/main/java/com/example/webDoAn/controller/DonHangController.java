package com.example.webDoAn.controller;

import com.example.webDoAn.dto.DonHangRequestDTO;
import com.example.webDoAn.entity.DonHang;
import com.example.webDoAn.entity.DonHangChiTiet;
import com.example.webDoAn.service.DonHangChiTietService;
import com.example.webDoAn.service.DonHangService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/don-hang")
public class DonHangController {
    private final DonHangService donHangService;
    private final DonHangChiTietService donHangChiTietService;

    public DonHangController(DonHangService donHangService, DonHangChiTietService donHangChiTietService) {
        this.donHangService = donHangService;
        this.donHangChiTietService = donHangChiTietService;
    }

    @PostMapping("/dat-don-hang")
    public ResponseEntity<?> addDonHang(@RequestBody DonHangRequestDTO donHangRequestDTO){
        try {
            DonHang saveDonHang = donHangService.save(donHangRequestDTO.getDonHang(),donHangRequestDTO.getDonHangChiTiet());
            return ResponseEntity.status(HttpStatus.CREATED).body(saveDonHang);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Loi khi them dat don hang"+e.getMessage());
        }
    }
}
