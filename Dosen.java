package TUBESPP1;

public class Dosen {
    private String NRP;
    private String nama;

    public Dosen(String NRP, String nama) {
        this.NRP = NRP;
        this.nama = nama;
    }

    // Setter & Getter
    public String getNrp() {
        return NRP;
    }

    public void setNrp(String NRP) {
        this.NRP = NRP;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Dosen{NRP='" + NRP + "', nama='" + nama + "'}";
    }
}
