package thigk2.huynhthanhphong.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thigk2.huynhthanhphong.models.TheLoaiTin;
import thigk2.huynhthanhphong.repositories.TheLoaiTinRepository;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TheLoaiController {
    @Autowired
    private TheLoaiTinRepository theLoaiRepo;

    @GetMapping("/theloai")
    public List<TheLoaiTin> getTheLoai() {
        return theLoaiRepo.findAll();
    }
}