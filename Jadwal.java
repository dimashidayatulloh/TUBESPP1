package TUBESPP1;

import java.time.LocalTime;

public class Jadwal {
    private String hari;
    private LocalTime waktuMulai;
    private LocalTime waktuSelesai;
    private Matakuliah matakuliah;
    private Dosen dosen;

    public Jadwal(String hari, LocalTime waktuMulai, LocalTime waktuSelesai, Matakuliah matakuliah, Dosen dosen) {
        this.hari = hari;
        this.waktuMulai = waktuMulai;
        this.waktuSelesai = waktuSelesai;
        this.matakuliah = matakuliah;
        this.dosen = dosen;
    }

    public String getHari() {
        return hari;
    }

    public LocalTime getWaktuMulai() {
        return waktuMulai;
    }

    public LocalTime getWaktuSelesai() {
        return waktuSelesai;
    }

    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public Dosen getDosen() {
        return dosen;
    }

    @Override
    public String toString() {
        return matakuliah.getKode() + " - " + matakuliah.getNama() + " - "+ matakuliah.getSks()+ " - " + hari + " " + waktuMulai + "-" + waktuSelesai + " - " + dosen.getNama();
    }
}