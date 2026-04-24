package thigk2.huynhthanhphong.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Trả về file login.html
    }

    @PostMapping("/login")
    public String checkLogin(@RequestParam String username, @RequestParam String password, Model model) {
        if ("admin".equals(username) && "123".equals(password)) {
            return "redirect:/danh-sach-tin"; // Đăng nhập đúng thì vào trang danh sách
        }
        model.addAttribute("error", "Sai tài khoản hoặc mật khẩu!");
        return "login";
    }
}