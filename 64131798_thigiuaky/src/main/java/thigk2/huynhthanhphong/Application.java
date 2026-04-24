package thigk2.huynhthanhphong;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import thigk2.huynhthanhphong.models.TheLoaiTin;
import thigk2.huynhthanhphong.models.Tin;
import thigk2.huynhthanhphong.repositories.TheLoaiTinRepository;
import thigk2.huynhthanhphong.repositories.TinRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initData(TheLoaiTinRepository tlRepo, TinRepository tinRepo) {
        return args -> {
            if (tlRepo.count() == 0) {
                // 1. Tạo thể loại
                TheLoaiTin tl1 = new TheLoaiTin();
                tl1.setTenTheLoai("Thời sự");
                tlRepo.save(tl1);

                // 2. Tạo tin thuộc thể loại trên
                Tin t1 = new Tin();
                t1.setTieuDe("Chào mừng kỳ thi giữa kỳ");
                t1.setNoiDung("Đây là nội dung tin tức mẫu để kiểm tra giao diện.");
                t1.setTheLoaiTin(tl1); // Gắn tin vào thể loại 1
                tinRepo.save(t1);

                System.out.println(">>> ĐÃ CÓ DỮ LIỆU TIN MẪU!");
            }
        };
    }
}