package TUBESPP1;

public class Mahasiswa {
    private String NRP;
    private String nama;

    public Mahasiswa(String NRP, String nama) {
        this.NRP = NRP;
        this.nama = nama;
    }

    public String display() {
        return "NRP: " + NRP + ", " + nama;
    }

    // Setter & Getter
    public void setNrp(String NRP) {
        this.NRP = NRP;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNrp() {
        return NRP;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return "Mahasiswa{NRP='" + NRP + "', nama='" + nama + "'}";
    }
}