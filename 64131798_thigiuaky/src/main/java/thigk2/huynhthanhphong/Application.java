package thigk2.huynhthanhphong;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import thigk2.huynhthanhphong.models.TheLoaiTin;
import thigk2.huynhthanhphong.repositories.TheLoaiTinRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initData(TheLoaiTinRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                TheLoaiTin tl1 = new TheLoaiTin();
                tl1.setTenTheLoai("Thời sự");
                repo.save(tl1);
                System.out.println(">>> DATABASE CONNECTED & INITIALIZED!");
            }
        };
    }
}