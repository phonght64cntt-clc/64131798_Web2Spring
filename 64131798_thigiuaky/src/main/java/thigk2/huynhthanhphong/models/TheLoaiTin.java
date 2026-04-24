package thigk2.huynhthanhphong.models;

import jakarta.persistence.*;

@Entity
@Table(name = "the_loai_tin")
public class TheLoaiTin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_the_loai", nullable = false)
    private String tenTheLoai;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTenTheLoai() { return tenTheLoai; }
    public void setTenTheLoai(String tenTheLoai) { this.tenTheLoai = tenTheLoai; }
}