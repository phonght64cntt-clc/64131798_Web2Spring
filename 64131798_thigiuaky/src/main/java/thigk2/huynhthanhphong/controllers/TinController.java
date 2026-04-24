package thigk2.huynhthanhphong.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import thigk2.huynhthanhphong.repositories.TinRepository;

@Controller
public class TinController {
    @Autowired
    private TinRepository tinRepo;

    @GetMapping("/danh-sach-tin")
    public String hienThiTin(Model model) {
        // Gửi danh sách tin sang giao diện tin_list.html
        model.addAttribute("listTin", tinRepo.findAll());
        return "tin_list";
    }
}