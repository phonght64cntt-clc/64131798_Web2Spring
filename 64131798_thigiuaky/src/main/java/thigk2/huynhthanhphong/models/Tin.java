package thigk2.huynhthanhphong.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tin")
public class Tin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tieu_de", nullable = false)
    private String tieuDe;

    @Column(name = "noi_dung", columnDefinition = "TEXT")
    private String noiDung;

    // Tạo khóa ngoại liên kết với bảng TheLoaiTin
    @ManyToOne
    @JoinColumn(name = "id_the_loai", nullable = false)
    private TheLoaiTin theLoaiTin;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTieuDe() { return tieuDe; }
    public void setTieuDe(String tieuDe) { this.tieuDe = tieuDe; }
    public String getNoiDung() { return noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }
    public TheLoaiTin getTheLoaiTin() { return theLoaiTin; }
    public void setTheLoaiTin(TheLoaiTin theLoaiTin) { this.theLoaiTin = theLoaiTin; }
}