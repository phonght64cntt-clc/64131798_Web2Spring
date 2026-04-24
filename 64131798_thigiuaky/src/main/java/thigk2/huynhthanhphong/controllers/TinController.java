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
        return "the_loai_list"; // Sẽ tạo file the_loai_list.html
    }

    // 2. Hiển thị tin theo thể loại
    @GetMapping("/the-loai/{id}")
    public String listTinByTheLoai(@PathVariable Integer id, Model model) {
        model.addAttribute("listTin", tinRepo.findByTheLoaiTin_Id(id));
        return "tin_list"; // Dùng lại file tin_list.html đã có
    }
}