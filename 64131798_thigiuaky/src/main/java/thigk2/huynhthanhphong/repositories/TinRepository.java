package thigk2.huynhthanhphong.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thigk2.huynhthanhphong.models.Tin;
import java.util.List;

@Repository
public interface TinRepository extends JpaRepository<Tin, Integer> {
    List<Tin> findByTheLoaiTin_Id(Integer idTheLoai);
}