package thigk2.huynhthanhphong;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import thigk2.huynhthanhphong.models.*;
import thigk2.huynhthanhphong.repositories.*;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initData(TheLoaiTinRepository tlRepo, TinRepository tinRepo) {
        return args -> {
            if (tlRepo.count() == 0) {
                TheLoaiTin tl1 = new TheLoaiTin(); tl1.setTenTheLoai("Thời sự");
                tlRepo.save(tl1);
                
                Tin t1 = new Tin();
                t1.setTieuDe("Tin khẩn cấp");
                t1.setNoiDung("Nội dung tin thi giữa kỳ...");
                t1.setTheLoaiTin(tl1);
                tinRepo.save(t1);
                
                System.out.println(">>> ĐÃ TỰ ĐỘNG NẠP DỮ LIỆU THÀNH CÔNG!");
            }
        };
    }
}