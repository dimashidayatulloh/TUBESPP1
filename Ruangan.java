package TUBESPP1;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Ruangan {
    private String kodeRuangan;
    private List<Jadwal> jadwalList;

    public Ruangan(String kodeRuangan) {
        this.kodeRuangan = kodeRuangan;
        this.jadwalList = new ArrayList<>();
    }

    public String getKodeRuangan() {
        return kodeRuangan;
    }

    public boolean tambahkanJadwal(String hari, LocalTime waktuMulai, LocalTime waktuSelesai, Matakuliah matakuliah, Dosen dosen) {
        for (Jadwal jadwal : jadwalList) {
            if (jadwal.getHari().equalsIgnoreCase(hari) &&
                    ((waktuMulai.isBefore(jadwal.getWaktuSelesai()) && waktuSelesai.isAfter(jadwal.getWaktuMulai())) ||
                            waktuMulai.equals(jadwal.getWaktuMulai()) ||
                            waktuSelesai.equals(jadwal.getWaktuSelesai()))) {
                return false;
            }
        }
        jadwalList.add(new Jadwal(hari, waktuMulai, waktuSelesai, matakuliah, dosen));
        return true;
    }

    @Override
    public String toString() {
        return "Ruangan: " + kodeRuangan;
    }

    public String tampilkanJadwal() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jadwal Ruangan ").append(kodeRuangan).append(":\n");
        for (Jadwal jadwal : jadwalList) {
            sb.append(jadwal).append("\n");
        }
        return sb.toString().trim();
    }
}
