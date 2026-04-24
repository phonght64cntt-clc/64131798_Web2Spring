package thigk2.huynhthanhphong.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import thigk2.huynhthanhphong.repositories.TheLoaiTinRepository;
import thigk2.huynhthanhphong.repositories.TinRepository;

@Controller
public class TinController {

    @Autowired
    private TinRepository tinRepo;

    @Autowired
    private TheLoaiTinRepository theLoaiRepo;

    // 1. Hiển thị trang danh sách thể loại
    @GetMapping("/danh-sach-the-loai")
    public String listTheLoai(Model model) {
        model.addAttribute("listTheLoai", theLoaiRepo.findAll());
        return "the_loai_list"; 
    }

    // 2. Hiển thị tin theo thể loại
    @GetMapping("/the-loai/{id}")
    public String listTinByTheLoai(@PathVariable Integer id, Model model) {
        model.addAttribute("listTin", tinRepo.findByTheLoaiTin_Id(id));
        return "tin_list"; 
    }
    // 3. Xem chi tiết một bài tin theo mã tin (ID)
    @GetMapping("/tin/{id}")
    public String getChiTietTin(@PathVariable Integer id, Model model) {       
        model.addAttribute("tin", tinRepo.findById(id).orElse(null));
        return "tin_detail"; 
    }
}