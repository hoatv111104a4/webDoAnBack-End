package com.example.webDoAn.service;

import com.example.webDoAn.repository.DonHangCTRepoITF;
import org.springframework.stereotype.Service;

@Service
public class DonHangChiTietService {
    private final DonHangCTRepoITF donHangCTRepoITF;

    public DonHangChiTietService(DonHangCTRepoITF donHangCTRepoITF) {
        this.donHangCTRepoITF = donHangCTRepoITF;
    }
}
