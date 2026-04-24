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
                // Tạo 2 thể loại
                TheLoaiTin tl1 = new TheLoaiTin(); tl1.setTenTheLoai("Thời sự");
                tlRepo.save(tl1);
                TheLoaiTin tl2 = new TheLoaiTin(); tl2.setTenTheLoai("Thể thao");
                tlRepo.save(tl2);

                // Tin thuộc Thời sự
                Tin t1 = new Tin();
                t1.setTieuDe("Tin thế giới");
                t1.setNoiDung("Nội dung tin thời sự quốc tế...");
                t1.setTheLoaiTin(tl1);
                tinRepo.save(t1);

                // Tin thuộc Thể thao
                Tin t2 = new Tin();
                t2.setTieuDe("Kết quả bóng đá");
                t2.setNoiDung("Đội tuyển Việt Nam giành chiến thắng...");
                t2.setTheLoaiTin(tl2);
                tinRepo.save(t2);
                
                System.out.println(">>> ĐÃ KHỞI TẠO DỮ LIỆU ĐA DẠNG!");
            }
        };
    }
}