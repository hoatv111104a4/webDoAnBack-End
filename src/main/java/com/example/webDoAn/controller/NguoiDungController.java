package com.example.webDoAn.controller;

import com.example.webDoAn.entity.LoaiDoAn;
import com.example.webDoAn.entity.NguoiDung;
import com.example.webDoAn.entity.NguoiDungChucVu;
import com.example.webDoAn.service.NguoiDungCvService;
import com.example.webDoAn.service.NguoiDungService;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/nguoi-dung")
public class NguoiDungController {
    private final NguoiDungCvService nguoiDungCvService;
    private final NguoiDungService nguoiDungService;

    public NguoiDungController(NguoiDungCvService nguoiDungCvService, NguoiDungService nguoiDungService) {
        this.nguoiDungCvService = nguoiDungCvService;
        this.nguoiDungService = nguoiDungService;
    }
    @GetMapping("/hien-thi")
    public ResponseEntity<Page<NguoiDungChucVu>> pageNguoiDungCv(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size){
        Page<NguoiDungChucVu> dungChucVuPage = nguoiDungCvService.pageNguoiDungCv(page,size);
        return ResponseEntity.ok(dungChucVuPage);
    }

    @PostMapping(value = "/dang-ki")
    public ResponseEntity<NguoiDung> dangKiTaiKhoan(@RequestParam("ten") String ten,
                                                    @RequestParam("email") String email,
                                                    @RequestParam("matKhau")String matKhau,
                                                    @RequestParam("soDienThoai") String soDienThoai,
                                                    @RequestParam("gioiTinh") Boolean gioiTinh, HttpSession session){
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setTenNguoiDung(ten);
        nguoiDung.setEmail(email);
        nguoiDung.setMatKhau(matKhau);
        nguoiDung.setSoDienThoai(soDienThoai);
        nguoiDung.setGioiTinh(gioiTinh);

        NguoiDung saveNguoiDung = nguoiDungService.dangKiThongTin(nguoiDung);
        session.setAttribute("userId", saveNguoiDung.getId());
        session.setAttribute("tenDangNhap", saveNguoiDung.getTenDangNhap());
        return ResponseEntity.ok(saveNguoiDung);

    }
    @PostMapping(value = "/dang-nhap")
    public ResponseEntity<NguoiDung> dangNhap(
            @RequestParam("tenDangNhap") String email,
            @RequestParam("matKhau") String matKhau,
            HttpSession session) {

        // Giả sử bạn có phương thức kiểm tra đăng nhập trong service
        NguoiDung nguoiDung = nguoiDungService.dangNhap(email, matKhau);
        if (nguoiDung != null) {
            // Lưu id và tenDangNhap vào session
            session.setAttribute("userId", nguoiDung.getId());
            session.setAttribute("tenDangNhap", nguoiDung.getTenNguoiDung());
            return ResponseEntity.ok(nguoiDung);
        } else {
            return ResponseEntity.status(401).body(null); // Unauthorized
        }
    }


    @PostMapping("/dang-xuat")
    public ResponseEntity<String> dangXuat(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Đã đăng xuất");
    }


}
