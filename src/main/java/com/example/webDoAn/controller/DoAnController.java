package com.example.webDoAn.controller;

import com.example.webDoAn.entity.DoAn;
import com.example.webDoAn.entity.LoaiDoAn;
import com.example.webDoAn.service.DoAnService;
import com.example.webDoAn.service.LoaiDoAnService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/do-an")
public class DoAnController {
    private final DoAnService doAnService;
    private final LoaiDoAnService loaiDoAnService;

    public DoAnController(DoAnService doAnService, LoaiDoAnService loaiDoAnService) {
        this.doAnService = doAnService;
        this.loaiDoAnService = loaiDoAnService;
    }
    @GetMapping("/hien-thi")
    public ResponseEntity<Page<DoAn>> pageDoAn(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10" )int size){
        Page<DoAn> doAnPage= doAnService.pageDoAn(page,size);
        return ResponseEntity.ok(doAnPage) ;
    }

    @GetMapping("/show-form-them-do-an")
    public ResponseEntity<List<LoaiDoAn>> listLoaiDoAn(){
        List<LoaiDoAn> loaiDoAnList = loaiDoAnService.listLoaiDoAn();
        return ResponseEntity.ok(loaiDoAnList);
    }

    // Endpoint mới để lưu đồ ăn từ form
    @PostMapping(value = "/them-do-an", consumes = "multipart/form-data")
    public ResponseEntity<DoAn> addDoAn(
            @RequestParam("ten") String ten,
            @RequestParam("giaTien") String giaTien,
            @RequestParam("loaiDoAnId") Integer loaiDoAnId,
            @RequestParam(value = "moTa", required = false) String moTa,
            @RequestParam(value = "hinhAnh", required = false) MultipartFile hinhAnh) {
        DoAn doAn = new DoAn();
        doAn.setTen(ten);
        doAn.setGiaTien(giaTien);
        doAn.setMoTa(moTa);
        LoaiDoAn loaiDoAn = new LoaiDoAn();
        loaiDoAn.setId(loaiDoAnId);
        doAn.setLoaiDoAn(loaiDoAn);

        DoAn savedDoAn = doAnService.ThemMonAn(doAn, hinhAnh);
        return ResponseEntity.ok(savedDoAn);
    }

    // Endpoint mới để cập nhật món ăn
    @PutMapping(value = "/sua-do-an/{id}", consumes = "multipart/form-data")
    public ResponseEntity<?> updateDoAn(
            @PathVariable Long id,
            @RequestParam("ten") String ten,
            @RequestParam("giaTien") String giaTien,
            @RequestParam("loaiDoAnId") Integer loaiDoAnId,
            @RequestParam(value = "moTa", required = false) String moTa,
            @RequestParam(value = "hinhAnh", required = false) MultipartFile hinhAnh) {
        try {
            DoAn doAn = doAnService.findById(id);
            if (doAn == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Không tìm thấy món ăn với ID: " + id);
            }

            doAn.setTen(ten);
            doAn.setGiaTien(giaTien);
            doAn.setMoTa(moTa);
            LoaiDoAn loaiDoAn = new LoaiDoAn();
            loaiDoAn.setId(loaiDoAnId);
            doAn.setLoaiDoAn(loaiDoAn);

            DoAn updatedDoAn = doAnService.SuaMonAn(doAn, hinhAnh);
            return ResponseEntity.ok(updatedDoAn);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi cập nhật món ăn: " + e.getMessage());
        }
    }
    // Endpoint mới để xóa món ăn
    @DeleteMapping("/xoa-do-an/{id}")
    public ResponseEntity<?> deleteDoAn(@PathVariable Long id) {
        try {
            DoAn doAn = doAnService.findById(id);
            if (doAn == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Không tìm thấy món ăn với ID: " + id);
            }
            doAnService.xoaMonAn(id);
            return ResponseEntity.ok("Xóa món ăn thành công!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi xóa món ăn: " + e.getMessage());
        }
    }

    @GetMapping("/tim-kiem")
    public ResponseEntity<Page<DoAn>> searchDoAn(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String ten) {
        Page<DoAn> doAnPage = doAnService.searchDoAnByTen(ten, page, size);
        return ResponseEntity.ok(doAnPage);
    }

    @GetMapping("/hien-thi-do-an-man")
    public  ResponseEntity<Page<DoAn>> getAllDoAnMan(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "12" )int size){
        Page<DoAn> pageDoAnMan = doAnService.pageDoAnMan(page,size);
        return ResponseEntity.ok(pageDoAnMan);
    }

    @GetMapping("/hien-thi-do-chay")
    public ResponseEntity<Page<DoAn>> getAllDoChay(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "12") int size){
        Page<DoAn> pageDoChay = doAnService.pageDoAnChay(page,size);
        return ResponseEntity.ok(pageDoChay);
    }

    @GetMapping("/hien-thi-do-trang-mieng")
    public ResponseEntity<Page<DoAn>> getAllDoTrangMieng(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "12") int size){
        Page<DoAn> pageDoTrangMieng = doAnService.pageDoAnTrangMieng(page,size);
        return ResponseEntity.ok(pageDoTrangMieng);
    }

    @GetMapping("/hien-thi-do-an-vat")
    public ResponseEntity<Page<DoAn>> getAllDoAnVat(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "12") int size){
        Page<DoAn> pageDoAnVat = doAnService.pageDoAnVat(page,size);
        return ResponseEntity.ok(pageDoAnVat);
    }

    @GetMapping("/hien-thi-nuoc-uong")
    public ResponseEntity<Page<DoAn>> getAllNuocUong(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "12") int size){
        Page<DoAn> pageNuocUong = doAnService.pageNuocUong(page,size);
        return ResponseEntity.ok(pageNuocUong);
    }



}
