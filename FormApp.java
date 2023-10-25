/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan7;

/**
 *
 * @author yudhi
 */
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class FormApp extends JFrame {

    private DefaultTableModel tableModel;
    private JTable table;

    public FormApp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label dan kotak teks untuk input Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 40, 150, 10);
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        // Label dan kotak teks untuk input Nomor Telepon
        JLabel labelNomorTelepon = new JLabel("Nomor Telepon:");
        labelNomorTelepon.setBounds(15, 100, 150, 10);
        JTextField textFieldNomorTelepon = new JTextField();
        textFieldNomorTelepon.setBounds(15, 120, 350, 30);

        // RadioButton untuk memilih jenis kelamin
        JRadioButton radioButtonLakiLaki = new JRadioButton("Laki-Laki");
        radioButtonLakiLaki.setBounds(15, 160, 100, 30);
        JRadioButton radioButtonPerempuan = new JRadioButton("Perempuan");
        radioButtonPerempuan.setBounds(125, 160, 100, 30);
        ButtonGroup radioGroupKelamin = new ButtonGroup();
        radioGroupKelamin.add(radioButtonLakiLaki);
        radioGroupKelamin.add(radioButtonPerempuan);

        // Label dan TextArea untuk Alamat
        JLabel labelAlamat = new JLabel("Alamat:");
        labelAlamat.setBounds(15, 200, 150, 10);
        JTextArea textAreaAlamat = new JTextArea();
        textAreaAlamat.setBounds(15, 220, 350, 80);

        // Tombol untuk menyimpan data
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 320, 100, 40);

        // Tabel untuk menampilkan data
        String[] columnNames = {"Nama", "Jenis Kelamin", "Nomor Telepon", "Alamat"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(15, 370, 450, 150);

        // Mendengarkan klik tombol "Simpan"
        buttonSimpan.addActionListener(e -> {
            String nama = textFieldNama.getText();
            String nomorTelepon = textFieldNomorTelepon.getText();
            String jenisKelamin = radioButtonLakiLaki.isSelected() ? "Laki-Laki" : "Perempuan";
            String alamat = textAreaAlamat.getText();

            if (nama.isEmpty() || nomorTelepon.isEmpty() || alamat.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ada field yang belum diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                tableModel.addRow(new Object[] {nama, jenisKelamin, nomorTelepon, alamat});
                textFieldNama.setText("");
                textFieldNomorTelepon.setText("");
                radioButtonLakiLaki.setSelected(false);
                radioButtonPerempuan.setSelected(false);
                textAreaAlamat.setText("");
            }
        });

        // Menambahkan komponen-komponen ke dalam frame
        this.add(buttonSimpan);
        this.add(textFieldNama);
        this.add(textFieldNomorTelepon);
        this.add(radioButtonLakiLaki);
        this.add(radioButtonPerempuan);
        this.add(labelNama);
        this.add(labelNomorTelepon);
        this.add(labelAlamat);
        this.add(textAreaAlamat);
        this.add(scrollPane);

        // Mengatur ukuran frame
        this.setSize(500, 600);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FormApp app = new FormApp();
                app.setVisible(true);
            }
        });
    }
}
