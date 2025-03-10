package latihankuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.*;

public class HalamanInputData extends JFrame implements ActionListener{
    JLabel dnama = new JLabel("Nama Depan    : ");
    JLabel bnama = new JLabel("Nama Belakang : ");
    JLabel ljenisKelamin = new JLabel("Jenis Kelamin :");
    
    JTextField dnamaTextField = new JTextField();
    JTextField bnamaTextField = new JTextField();
     
    JRadioButton rbPria = new JRadioButton("Pria");
    JRadioButton rbWanita = new JRadioButton("Wanita");
   
    JButton btnSimpan = new JButton("Simpan");
    JButton btnConvert = new JButton("Convert to .txt file");
    
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);
   
    ArrayList<String> dataList = new ArrayList<>();
    JLabel lblMessageSimpan = new JLabel("", SwingConstants.CENTER);
    JLabel lblMessageConvert = new JLabel("", SwingConstants.CENTER);
    
    
    public HalamanInputData(){
        setTitle("Halaman Input Data");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        setLayout(null);
        add(dnama);
        add(bnama);
        add(dnamaTextField);
        add(bnamaTextField);
        add(ljenisKelamin);
        add(rbPria);
        add(rbWanita);
        add(btnSimpan);
        add(lblMessageSimpan);
        add(textArea);
        add(scrollPane);
        add(btnConvert);
        add(lblMessageConvert);
        
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbPria);
        genderGroup.add(rbWanita);
       
        dnama.setBounds(20,10,100,20);
        bnama.setBounds(20,35,100,20);
        dnamaTextField.setBounds(150,10,200,20);
        bnamaTextField.setBounds(150,35,200,20);
        
        ljenisKelamin.setBounds(20,70,100,20);
        rbPria.setBounds(120,100,60,20);
        rbWanita.setBounds(190,100,80,20);
        
        btnSimpan.setBounds(20,125,400,25);
        btnSimpan.addActionListener(this);
        lblMessageSimpan.setBounds(20, 150, 150, 20); 
        lblMessageSimpan.setForeground(java.awt.Color.BLACK);
        
        textArea.setBounds(20,180,400,150);
        textArea.setEditable(false);
        scrollPane.setBounds(20,180,400,150);
        
        btnConvert.setBounds(20,350,400,30);
        btnConvert.addActionListener(this);
        lblMessageConvert.setBounds(20, 380, 200, 20); 
        lblMessageConvert.setForeground(java.awt.Color.BLACK);   
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSimpan){
            String namaDepan = dnamaTextField.getText();
            String namaBelakang = bnamaTextField.getText();
            String jenisKelamin = rbPria.isSelected() ? "Pria" : rbWanita.isSelected() ? "Wanita" : "";
            
            if(!namaDepan.isEmpty() && !namaBelakang.isEmpty() && !jenisKelamin.isEmpty()){
                String data = namaDepan + " " + namaBelakang + " | " + "Gender : " + jenisKelamin;
              
                dataList.add(data);
                textArea.append(data + "\n");
                lblMessageSimpan.setText("Data Berhasil Disimpan");   
            } else {
                lblMessageSimpan.setText("Data harus lengkap!");
            }
          }
        
        if(e.getSource() == btnConvert){
            if(dataList.isEmpty()){
                lblMessageConvert.setText("Tidak ada data yang tersedia.");
                return;
            }
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("data_123230002.txt",true))){
                for(String data : dataList) {
                    writer.write(data);
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke data_123230002.txt", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file!", "Error", JOptionPane.ERROR_MESSAGE);
                
            }
        }
    }
}   

