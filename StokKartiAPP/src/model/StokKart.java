package model;
import java.util.Date;

public class StokKart {
        private int id;
        private String StokKodu;
        private String StokAdi;
        private int StokTipi;
        private String Birimi;
        private String Barkodu;
        private double KDVTipi;
        private String Aciklama;
        private Date OlusturmaZamani;


    public StokKart(int id, String stokKodu, String stokAdi, int stokTipi, String birimi, String barkodu, double KDVTipi, String aciklama, Date olusturmaZamani) {
        this.id = id;
        StokKodu = stokKodu;
        StokAdi = stokAdi;
        StokTipi = stokTipi;
        Birimi = birimi;
        Barkodu = barkodu;
        this.KDVTipi = KDVTipi;
        Aciklama = aciklama;
        OlusturmaZamani = olusturmaZamani;
    }

    public StokKart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStokKodu() {
        return StokKodu;
    }

    public void setStokKodu(String stokKodu) {
        StokKodu = stokKodu;
    }

    public String getStokAdi() {
        return StokAdi;
    }

    public void setStokAdi(String stokAdi) {
        StokAdi = stokAdi;
    }

    public int getStokTipi() {
        return StokTipi;
    }

    public void setStokTipi(int stokTipi) {
        StokTipi = stokTipi;
    }

    public String getBirimi() {
        return Birimi;
    }

    public void setBirimi(String birimi) {
        Birimi = birimi;
    }

    public String getBarkodu() {
        return Barkodu;
    }

    public void setBarkodu(String barkodu) {
        Barkodu = barkodu;
    }

    public double getKDVTipi() {
        return KDVTipi;
    }

    public void setKDVTipi(double KDVTipi) {
        this.KDVTipi = KDVTipi;
    }

    public String getAciklama() {
        return Aciklama;
    }

    public void setAciklama(String aciklama) {
        Aciklama = aciklama;
    }

    public Date getOlusturmaZamani() {
        return OlusturmaZamani;
    }

    public void setOlusturmaZamani(Date olusturmaZamani) {
        OlusturmaZamani = olusturmaZamani;
    }

    @Override
    public String toString() {
        return "StokKart{" +
                "id=" + id +
                ", StokKodu='" + StokKodu + '\'' +
                ", StokAdi='" + StokAdi + '\'' +
                ", StokTipi=" + StokTipi +
                ", Birimi='" + Birimi + '\'' +
                ", Barkodu='" + Barkodu + '\'' +
                ", KDVTipi=" + KDVTipi +
                ", Aciklama='" + Aciklama + '\'' +
                ", OlusturmaZamani=" + OlusturmaZamani +
                '}';
    }
}
