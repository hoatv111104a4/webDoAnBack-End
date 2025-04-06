package com.example.webDoAn.service;

import com.example.webDoAn.entity.DoAn;
import com.example.webDoAn.repository.DoAnRepoITF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service
public class DoAnService {
    private final DoAnRepoITF doAnRepoITF;
    private static final String UPLOAD_DIR = "D:/Java6/webDoAn/src/uploads/";

    public DoAnService(DoAnRepoITF doAnRepoITF) {
        this.doAnRepoITF = doAnRepoITF;
    }

    public Page<DoAn> pageDoAn(int page, int size) {
        return doAnRepoITF.pageDoAn(PageRequest.of(page, size));
    }

    public DoAn saveDoAn(DoAn doAn, MultipartFile hinhAnh) {
        // Tạo mã nếu chưa có
        if (doAn.getMa() == null || doAn.getMa().trim().isEmpty()) {
            doAn.setMa("DA" + UUID.randomUUID().toString().substring(0, 8));
        }
        doAn.setNgayTao(new Date());
        doAn.setTrangThai(1);

        // Xử lý upload ảnh
        if (hinhAnh != null && !hinhAnh.isEmpty()) {
            String fileName = saveImage(hinhAnh);
            doAn.setHinhAnh(fileName);
        }

        return doAnRepoITF.save(doAn);
    }

    // Gộp ThemMonAn và SuaMonAn thành một phương thức
    public DoAn ThemMonAn(DoAn doAn, MultipartFile hinhAnh) {
        return saveDoAn(doAn, hinhAnh);
    }

    public DoAn SuaMonAn(DoAn doAn, MultipartFile hinhAnh) {
        return saveDoAn(doAn, hinhAnh);
    }

    public DoAn findById(Long id) {
        return doAnRepoITF.findById(id).orElse(null);
    }

    public void xoaMonAn(Long id) {
        DoAn doAn = findById(id);
        if (doAn != null) {
            deleteImage(doAn.getHinhAnh());
            doAnRepoITF.deleteById(id);
        }
    }

    public Page<DoAn> searchDoAnByTen(String ten, int page, int size) {
        return doAnRepoITF.findByTenContainingIgnoreCase(ten, PageRequest.of(page - 1, size));
    }

    // Phương thức riêng để xử lý upload ảnh
    private String saveImage(MultipartFile hinhAnh) {
        try {
            String fileName = System.currentTimeMillis() + "_" + hinhAnh.getOriginalFilename();
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) uploadDir.mkdirs();
            File destFile = new File(UPLOAD_DIR + fileName);
            hinhAnh.transferTo(destFile);
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi lưu ảnh: " + e.getMessage());
        }
    }

    // Phương thức riêng để xóa ảnh
    private void deleteImage(String imagePath) {
        if (imagePath != null) {
            File imageFile = new File(UPLOAD_DIR + imagePath.replace("/uploads/", ""));
            if (imageFile.exists() && !imageFile.delete()) {
                System.err.println("Không thể xóa file ảnh: " + imageFile.getPath());
            }
        }
    }

    public Page<DoAn> pageDoAnMan(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return doAnRepoITF.pageDoAnMan(pageable);
    }

    public Page<DoAn> pageDoAnChay(int page , int size){
        Pageable pageable = PageRequest.of(page,size);
        return doAnRepoITF.pageDoChay(pageable);
    }

    public Page<DoAn> pageDoAnTrangMieng(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return doAnRepoITF.pageDoTrangMieng(pageable);
    }

    public Page<DoAn> pageDoAnVat(int page , int size){
        Pageable pageable = PageRequest.of(page,size);
        return doAnRepoITF.pageDoAnVat(pageable);
    }

    public Page<DoAn> pageNuocUong(int page , int size){
        Pageable pageable =PageRequest.of(page,size);
        return doAnRepoITF.pageNuocUong(pageable);
    }

}