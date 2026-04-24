package thigk2.huynhthanhphong.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thigk2.huynhthanhphong.models.TheLoaiTin;

@Repository
public interface TheLoaiTinRepository extends JpaRepository<TheLoaiTin, Integer> {
}