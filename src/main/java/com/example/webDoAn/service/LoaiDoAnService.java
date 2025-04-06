package com.example.webDoAn.service;

import com.example.webDoAn.entity.LoaiDoAn;
import com.example.webDoAn.repository.LoaiDoAnRepoITF;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiDoAnService {
    private final LoaiDoAnRepoITF loaiDoAnRepoITF;

    public LoaiDoAnService(LoaiDoAnRepoITF loaiDoAnRepoITF) {
        this.loaiDoAnRepoITF = loaiDoAnRepoITF;
    }

    public List<LoaiDoAn> listLoaiDoAn(){
        return loaiDoAnRepoITF.findAll(Sort.by("ngayTao").descending());
    }

}
