package TUBESPP1;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class GraphGUI extends JFrame {
    private Graph<Object> graph;
    private JTextArea displayArea;

    public GraphGUI() {
        graph = new Graph<>(20);

        // Nilai default
        graph.addVertex(new Mahasiswa("M01", "Dimas"));
        graph.addVertex(new Dosen("D01", "Ade Sukendar"));
        graph.addVertex(new Dosen("D02", "Erik"));
        graph.addVertex(new Matakuliah("MK01", "Praktikum Pemrograman 1", 3));
        graph.addVertex(new Matakuliah("MK02", "Praktikum Multimedia", 3));
        graph.addVertex(new Ruangan("R01"));
        graph.addVertex(new Ruangan("R02"));

        // Setup GUI
        setTitle("Graph Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        // Control panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(6, 2));

        JButton btnTambahMahasiswa = new JButton("Tambah Mahasiswa");
        JButton btnTambahDosen = new JButton("Tambah Dosen");
        JButton btnTambahMatakuliah = new JButton("Tambah Matakuliah");
        JButton btnTambahRuangan = new JButton("Tambah Ruangan");
        JButton btnAturJadwal = new JButton("Atur Jadwal Ruangan");
        JButton btnTampilkanJadwal = new JButton("Tampilkan Jadwal Ruangan");
        JButton btnTampilkanVertices = new JButton("Tampilkan Vertices");
        JButton btnTampilkanEdges = new JButton("Tampilkan Edges");
        JButton btnTampilkanMatrix = new JButton("Tampilkan Matriks Adjacency");
        JButton btnKeluar = new JButton("Keluar");
        JButton btnTambahEdge = new JButton("Tambah Edge");
        JButton btnClearDisplay = new JButton("Hapus Teks");

        controlPanel.add(btnTambahMahasiswa);
        controlPanel.add(btnAturJadwal);
        controlPanel.add(btnTambahDosen);
        controlPanel.add(btnTampilkanJadwal);
        controlPanel.add(btnTambahMatakuliah);
        controlPanel.add(btnTampilkanVertices);
        controlPanel.add(btnTambahRuangan);
        controlPanel.add(btnTampilkanEdges);
        controlPanel.add(btnTambahEdge);
        controlPanel.add(btnTampilkanMatrix);
        controlPanel.add(btnClearDisplay);
        controlPanel.add(btnKeluar);

        add(controlPanel, BorderLayout.NORTH);

        // Add ActionListeners
        btnTambahMahasiswa.addActionListener(e -> tambahMahasiswa());
        btnTambahDosen.addActionListener(e -> tambahDosen());
        btnTambahMatakuliah.addActionListener(e -> tambahMatakuliah());
        btnTambahRuangan.addActionListener(e -> tambahRuangan());
        btnAturJadwal.addActionListener(e -> aturJadwalRuangan());
        btnTampilkanJadwal.addActionListener(e -> tampilkanJadwalRuangan());
        btnTampilkanVertices.addActionListener(e -> displayVertices());
        btnTampilkanEdges.addActionListener(e -> displayEdges());
        btnTampilkanMatrix.addActionListener(e -> displayMatrix());
        btnKeluar.addActionListener(e -> System.exit(0));
        btnTambahEdge.addActionListener(e -> tambahEdge());
        btnClearDisplay.addActionListener(e -> clearDisplay());
    }

    private void tambahMahasiswa() {
        String nrpMahasiswa = JOptionPane.showInputDialog(this, "Masukkan NRP Mahasiswa:");
        String namaMahasiswa = JOptionPane.showInputDialog(this, "Masukkan Nama Mahasiswa:");
        graph.addVertex(new Mahasiswa(nrpMahasiswa, namaMahasiswa));
        JOptionPane.showMessageDialog(this, "Mahasiswa berhasil ditambahkan.");
    }

    private void tambahDosen() {
        String nrpDosen = JOptionPane.showInputDialog(this, "Masukkan NRP Dosen:");
        String namaDosen = JOptionPane.showInputDialog(this, "Masukkan Nama Dosen:");
        graph.addVertex(new Dosen(nrpDosen, namaDosen));
        JOptionPane.showMessageDialog(this, "Dosen berhasil ditambahkan.");
    }

    private void tambahMatakuliah() {
        String kodeMatakuliah = JOptionPane.showInputDialog(this, "Masukkan Kode Matakuliah:");
        String namaMatakuliah = JOptionPane.showInputDialog(this, "Masukkan Nama Matakuliah:");
        int sksMatakuliah = Integer.parseInt(JOptionPane.showInputDialog(this, "Masukkan SKS Matakuliah:"));
        graph.addVertex(new Matakuliah(kodeMatakuliah, namaMatakuliah, sksMatakuliah));
        JOptionPane.showMessageDialog(this, "Matakuliah berhasil ditambahkan.");
    }

    private void tambahRuangan() {
        String kodeRuangan = JOptionPane.showInputDialog(this, "Masukkan Kode Ruangan:");
        graph.addVertex(new Ruangan(kodeRuangan));
        JOptionPane.showMessageDialog(this, "Ruangan berhasil ditambahkan.");
    }

    private void aturJadwalRuangan() {
        String kodeRuangan = JOptionPane.showInputDialog(this, "Masukkan Kode Ruangan:");
        int indexRuangan = cariIndexVertex(graph, kodeRuangan);
        if (indexRuangan == -1) {
            JOptionPane.showMessageDialog(this, "Ruangan tidak ditemukan.");
            return;
        }
        Ruangan ruangan = (Ruangan) graph.getVertexList().get(indexRuangan).getData();

        String hari = JOptionPane.showInputDialog(this, "Masukkan hari:");
        LocalTime waktuMulai = LocalTime.parse(JOptionPane.showInputDialog(this, "Masukkan waktu mulai (hh:mm):"));
        LocalTime waktuSelesai = LocalTime.parse(JOptionPane.showInputDialog(this, "Masukkan waktu selesai (hh:mm):"));

        String kodeMatakuliah = JOptionPane.showInputDialog(this, "Masukkan Kode Matakuliah:");
        int indexMatakuliah = cariIndexVertex(graph, kodeMatakuliah);
        if (indexMatakuliah == -1) {
            JOptionPane.showMessageDialog(this, "Matakuliah tidak ditemukan.");
            return;
        }
        Matakuliah matakuliah = (Matakuliah) graph.getVertexList().get(indexMatakuliah).getData();

        String nrpDosen = JOptionPane.showInputDialog(this, "Masukkan NRP Dosen:");
        int indexDosen = cariIndexVertex(graph, nrpDosen);
        if (indexDosen == -1) {
            JOptionPane.showMessageDialog(this, "Dosen tidak ditemukan.");
            return;
        }
        Dosen dosen = (Dosen) graph.getVertexList().get(indexDosen).getData();

        Jadwal jadwalBaru = new Jadwal(hari, waktuMulai, waktuSelesai, matakuliah, dosen);

        boolean berhasil = ruangan.tambahkanJadwal(hari, waktuMulai, waktuSelesai, matakuliah, dosen);
        if (berhasil) {
            graph.addVertex(jadwalBaru);
            int indexJadwal = graph.getVertexList().size() - 1;

            // Add edges antara jadwal dengan vertex lain
            graph.addEdge(indexJadwal, indexRuangan);
            graph.addEdge(indexJadwal, indexMatakuliah);
            graph.addEdge(indexJadwal, indexDosen);
            JOptionPane.showMessageDialog(this, "Jadwal berhasil ditambahkan.");
        } else {
            JOptionPane.showMessageDialog(this, "Jadwal bentrok.");
        }
    }

    private void tambahEdge() {
        String namaVertexAwal = JOptionPane.showInputDialog(this, "Masukkan nama vertex awal:");
        String namaVertexAkhir = JOptionPane.showInputDialog(this, "Masukkan nama vertex akhir:");

        int indexAwal = cariIndexVertex(graph, namaVertexAwal);
        int indexAkhir = cariIndexVertex(graph, namaVertexAkhir);

        if (indexAwal != -1 && indexAkhir != -1) {
            graph.addEdge(indexAwal, indexAkhir);
            JOptionPane.showMessageDialog(this, "Edge antara " + namaVertexAwal + " dan " + namaVertexAkhir + " berhasil ditambahkan.");
        } else {
            JOptionPane.showMessageDialog(this, "Nama vertex tidak ditemukan.");
        }
    }

    private void tampilkanJadwalRuangan() {
        displayArea.append("Daftar Jadwal:\n");
        for (int i = 0; i < graph.getNVerts(); i++) {
            Object vertexData = graph.getVertexList().get(i).getData();
            if (vertexData instanceof Ruangan) {
                Ruangan ruangan = (Ruangan) vertexData;
                displayArea.append(ruangan.tampilkanJadwal() + "\n");
            }
        }
        displayArea.append("========================================\n");
    }

    private void displayVertices() {
        displayArea.append("Daftar Vertex:\n");
        for (int i = 0; i < graph.getVertexList().size(); i++) {
            displayArea.append(graph.getVertexList().get(i).getData().toString() + "\n");
        }
        displayArea.append("========================================\n");
    }

    private void displayEdges() {
        displayArea.append("Daftar Edges:\n");
        for (int i = 0; i < graph.getNVerts(); i++) {
            for (int j = 0; j < graph.getNVerts(); j++) {
                if (graph.getAdjMat()[i][j] == 1) {
                    displayArea.append(graph.getVertexList().get(i).getData() + " --> " +
                            graph.getVertexList().get(j).getData() + "\n");
                }
            }
        }
        displayArea.append("========================================\n");
    }

    private void displayMatrix() {
        displayArea.append("Matriks Adjacency:\n");
        int[][] adjMat = graph.getAdjMat();
        for (int i = 0; i < graph.getNVerts(); i++) {
            for (int j = 0; j < graph.getNVerts(); j++) {
                displayArea.append(adjMat[i][j] + " ");
            }
            displayArea.append("\n");
        }
        displayArea.append("========================================\n");
    }

    private void clearDisplay() {
        displayArea.setText("");
    }

    private int cariIndexVertex(Graph<Object> graph, String key) {
        for (int i = 0; i < graph.getVertexList().size(); i++) {
            Object data = graph.getVertexList().get(i).getData();
            String vertexKey = "";

            if (data instanceof Mahasiswa) {
                vertexKey = ((Mahasiswa) data).getNrp();
            } else if (data instanceof Dosen) {
                vertexKey = ((Dosen) data).getNrp();
            } else if (data instanceof Matakuliah) {
                vertexKey = ((Matakuliah) data).getKode();
            } else if (data instanceof Ruangan) {
                vertexKey = ((Ruangan) data).getKodeRuangan();
            } else if (data instanceof Jadwal) {
                // Jika diperlukan pencarian jadwal berdasarkan atribut lain
            }

            if (vertexKey.equalsIgnoreCase(key)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraphGUI gui = new GraphGUI();
            gui.setVisible(true);
        });
    }
}
