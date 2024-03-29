package ui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.StokKart;
import service.StokKartService;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;

public class StokKartUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField stokKoduTextField;
    private JTextField stokAdiTextField;
    private JTextField birimiTextField;
    private JTextField barkodTextField;
    private JTextField stokKoduAramaTextField;
    private JComboBox<Integer> stokTipiComboBox;
    private JComboBox<Double> kdvTipiComboBox;
    private JTextArea aciklamaTextArea;
    private JFormattedTextField tarihFormattedTextField;
    private JTable table;

    private final StokKartService stokKartService;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StokKartUI frame = new StokKartUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StokKartUI() {
        setTitle("Stok Karti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 822, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        stokKoduTextField = new JTextField();
        stokKoduTextField.setBounds(212, 101, 140, 20);
        contentPane.add(stokKoduTextField);
        stokKoduTextField.setColumns(10);

        stokAdiTextField = new JTextField();
        stokAdiTextField.setBounds(212, 143, 140, 20);
        contentPane.add(stokAdiTextField);
        stokAdiTextField.setColumns(10);

        stokTipiComboBox = new JComboBox<>();
        stokTipiComboBox.setModel(new DefaultComboBoxModel(new String[] {"Lütfen Seçiniz"}));
        stokTipiComboBox.setBounds(212, 181, 140, 22);
        stokTipiComboBox.addItem(1);
        stokTipiComboBox.addItem(2);
        contentPane.add(stokTipiComboBox);

        birimiTextField = new JTextField();
        birimiTextField.setBounds(211, 222, 141, 22);
        contentPane.add(birimiTextField);

        barkodTextField = new JTextField();
        barkodTextField.setBounds(212, 267, 140, 20);
        contentPane.add(barkodTextField);
        barkodTextField.setColumns(10);

        kdvTipiComboBox = new JComboBox<>();
        kdvTipiComboBox.setModel(new DefaultComboBoxModel(new String[] {"Lütfen Seçiniz"}));
        kdvTipiComboBox.setBounds(212, 310, 140, 22);
        
        kdvTipiComboBox.addItem(18.5);
        kdvTipiComboBox.addItem(8.0);
        contentPane.add(kdvTipiComboBox);

        aciklamaTextArea = new JTextArea();
        aciklamaTextArea.setBounds(212, 356, 140, 16);
        contentPane.add(aciklamaTextArea);

        tarihFormattedTextField = new JFormattedTextField();
        tarihFormattedTextField.setBounds(212, 401, 140, 20);
        contentPane.add(tarihFormattedTextField);

        DefaultTableModel model = new DefaultTableModel(
                new Object[][] {},
                new String[] { "StokKodu", "StokAdi", "StokTipi", "Birimi", "Barkodu", "KDVTipi", "Aciklama", "Tarihi" }
        );

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(120, 433, 600, 450);
        contentPane.add(scrollPane);
        scrollPane.setViewportView(table);
//jtable da Seçtiğim satıra göre ilgili componentlere veri geitrme
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int seciliSatir = table.getSelectedRow();
                if (seciliSatir != -1) {
                    DefaultTableModel selectedModel = (DefaultTableModel) table.getModel();
                    String stokKodu = (String) selectedModel.getValueAt(seciliSatir, 0);
                    String stokAdi = (String) selectedModel.getValueAt(seciliSatir, 1);
                    int stokTipi = (int) selectedModel.getValueAt(seciliSatir, 2);
                    String birimi = (String) selectedModel.getValueAt(seciliSatir, 3);
                    String barkodu = (String) selectedModel.getValueAt(seciliSatir, 4);
                    double kdvTipi = (double) selectedModel.getValueAt(seciliSatir, 5);
                    String aciklama = (String) selectedModel.getValueAt(seciliSatir, 6);
                    String olusturmaZamani = (String) selectedModel.getValueAt(seciliSatir, 7);

                    stokKoduTextField.setText(stokKodu);
                    stokAdiTextField.setText(stokAdi);
                    stokTipiComboBox.setSelectedItem(stokTipi);
                    birimiTextField.setText(birimi);
                    barkodTextField.setText(barkodu);
                    kdvTipiComboBox.setSelectedItem(kdvTipi);
                    aciklamaTextArea.setText(aciklama);
                    tarihFormattedTextField.setText(olusturmaZamani);
                }
            }
        });
        
        //BUTONLARIM: EKLE SİL GÜNCELLE LİSTELE KOPYALA ARA

        JButton ekleButton = new JButton("Stok Ekle");
        ekleButton.setBounds(425, 147, 117, 30);
        ekleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stokEkleButtonActionPerformed(e);
            }
        });
        contentPane.add(ekleButton);

        
        
        
        JButton silButton = new JButton("Stok Sil");
        silButton.setBounds(425, 293, 117, 27);
        silButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stokSilButtonActionPerformed(e);
            }
        });
        contentPane.add(silButton);

        
        
        JButton guncelleButton = new JButton("Stok Güncelle");
        guncelleButton.setBounds(425, 218, 117, 30);
        guncelleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stokGuncelleButtonActionPerformed(e);
            }
        });
        
      
        contentPane.add(guncelleButton);
        
        
        
        stokKoduAramaTextField = new JTextField();
        stokKoduAramaTextField.setBounds(212, 53, 140, 20);
        contentPane.add(stokKoduAramaTextField);
        stokKoduAramaTextField.setColumns(10);

        JButton araButton = new JButton("Ara");
        araButton.setForeground(SystemColor.activeCaption);
        araButton.setBounds(362, 52, 89, 23);

        araButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String arananStokKodu = stokKoduAramaTextField.getText();
                if (!arananStokKodu.isEmpty()) {
                    StokKart arananStok = stokKartService.getStokKartByKodu(arananStokKodu);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setRowCount(0);

                    if (arananStok != null) {
                        model.addRow(new Object[]{
                                arananStok.getStokKodu(),
                                arananStok.getStokAdi(),
                                arananStok.getStokTipi(),
                                arananStok.getBirimi(),
                                arananStok.getBarkodu(),
                                arananStok.getKDVTipi(),
                                arananStok.getAciklama(),
                                new SimpleDateFormat("dd/MM/yyyy").format(arananStok.getOlusturmaZamani())
                        });

                        stokKoduTextField.setText(arananStok.getStokKodu());
                        stokAdiTextField.setText(arananStok.getStokAdi());
                        stokTipiComboBox.setSelectedItem(arananStok.getStokTipi());
                        birimiTextField.setText(arananStok.getBirimi());
                        barkodTextField.setText(arananStok.getBarkodu());
                        kdvTipiComboBox.setSelectedItem(arananStok.getKDVTipi());
                        aciklamaTextArea.setText(arananStok.getAciklama());
                        tarihFormattedTextField.setText(new SimpleDateFormat("dd/MM/yyyy").format(arananStok.getOlusturmaZamani()));
                    } else {
                        JOptionPane.showMessageDialog(StokKartUI.this, "Belirtilen stok koduyla eşleşen bir stok bulunamadı.");
                    }
                } else {
                    JOptionPane.showMessageDialog(StokKartUI.this, "Lütfen arama yapmak için stok kodu girin.");
                }
            }
        });

        contentPane.add(araButton);

        JButton kopyalaButton = new JButton("Kopyala");
        kopyalaButton.setBounds(600, 200, 100, 30);
        kopyalaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kopyalaButtonActionPerformed(e);
            }
        });
        contentPane.add(kopyalaButton);

        JButton listeleButton = new JButton("Listele");
        listeleButton.setBounds(600, 250, 100, 30);
        listeleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listeleButtonActionPerformed(e);
            }
        });
        contentPane.add(listeleButton);

        JLabel lblStokAdi = new JLabel("Stok Adi :");
        lblStokAdi.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblStokAdi.setBounds(102, 146, 100, 18);
        contentPane.add(lblStokAdi);

        JLabel lblStokTipi = new JLabel("Stok Tipi :");
        lblStokTipi.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblStokTipi.setBounds(102, 185, 100, 18);
        contentPane.add(lblStokTipi);

        JLabel lblBirimi = new JLabel("Birimi :");
        lblBirimi.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblBirimi.setBounds(101, 226, 100, 18);
        contentPane.add(lblBirimi);

        JLabel lblBarkodu = new JLabel("Barkodu :");
        lblBarkodu.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblBarkodu.setBounds(102, 270, 100, 18);
        contentPane.add(lblBarkodu);

        JLabel lblKdvTipi = new JLabel("KDV Tipi :");
        lblKdvTipi.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblKdvTipi.setBounds(102, 314, 100, 18);
        contentPane.add(lblKdvTipi);

        JLabel lblAklama = new JLabel("Açıklama :");
        lblAklama.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblAklama.setBounds(102, 356, 100, 18);
        contentPane.add(lblAklama);

        JLabel lblOluturmaZaman = new JLabel("Oluşturma Zamanı :");
        lblOluturmaZaman.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblOluturmaZaman.setBounds(81, 402, 150, 18);
        contentPane.add(lblOluturmaZaman);

        JLabel lblNewLabel = new JLabel("Stok Kodu :");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel.setBounds(102, 104, 100, 18);
        contentPane.add(lblNewLabel);
        
        JLabel lblStokKoduGiriniz = new JLabel("Stok Kodu Giriniz :");
        lblStokKoduGiriniz.setForeground(Color.RED);
        lblStokKoduGiriniz.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
        lblStokKoduGiriniz.setBounds(81, 52, 150, 18);
        contentPane.add(lblStokKoduGiriniz);

        stokKartService = new StokKartService();
    }

    private void stokEkleButtonActionPerformed(ActionEvent e) {
        String stokKodu = stokKoduTextField.getText();
        String stokAdi = stokAdiTextField.getText();
        int stokTipi = (int) stokTipiComboBox.getSelectedItem();
        String birimi = birimiTextField.getText();
        String barkodu = barkodTextField.getText();
        double kdvTipi = (double) kdvTipiComboBox.getSelectedItem();
        String aciklama = aciklamaTextArea.getText();
        
        // bunlar dolu olsun istiyorum
        if (stokKodu.isEmpty() || stokAdi.isEmpty() || birimi.isEmpty() || barkodu.isEmpty() || aciklama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen tüm gerekli bilgileri girin.");
            return; 
        }

        // Eğer tüm gerekli alanlar doldurulmuşsa, stok eklemeye devam et
        StokKart stokKart = new StokKart();
        stokKart.setStokKodu(stokKodu);
        stokKart.setStokAdi(stokAdi);
        stokKart.setStokTipi(stokTipi);
        stokKart.setBirimi(birimi);
        stokKart.setBarkodu(barkodu);
        stokKart.setKDVTipi(kdvTipi);
        stokKart.setAciklama(aciklama);

        try {
        	//TARİH Formatı ayarlama
            
            Date olusturmaZamani = new SimpleDateFormat("dd/MM/yyyy").parse(tarihFormattedTextField.getText());
           
            stokKart.setOlusturmaZamani(olusturmaZamani);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Geçersiz tarih formatı. (dd/MM/yyyy)");
            return; 
        }

        stokKartService.addStokKart(stokKart);

        refreshTable();
        clearInputFields();
        JOptionPane.showMessageDialog(this, "Stok başarıyla eklendi.");
    

    }

    private void stokSilButtonActionPerformed(ActionEvent e) {
        String stokKodu = stokKoduTextField.getText();
        if (!stokKodu.isEmpty()) {
            stokKartService.deleteStokKart(stokKodu);
            refreshTable();
            clearInputFields();
            JOptionPane.showMessageDialog(this, "Stok başarıyla silindi.");
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen silmek istediğiniz stok kodunu girin.");
        }
    }

    private void stokGuncelleButtonActionPerformed(ActionEvent e) {
        String stokKodu = stokKoduTextField.getText();
        if (stokKodu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen güncellemek istediğiniz stok kodunu girin.");
            return; // Güncelleme işlemini durdur ve metottan çık
        }

        StokKart stok = stokKartService.getStokKartByKodu(stokKodu);
        if (stok != null) {
        	
        	
            // Güncelleme 
            String stokAdi = stokAdiTextField.getText();
            int stokTipi = (int) stokTipiComboBox.getSelectedItem();
            String birimi = birimiTextField.getText();
            String barkodu = barkodTextField.getText();
            double kdvTipi = (double) kdvTipiComboBox.getSelectedItem();
            String aciklama = aciklamaTextArea.getText();

          
            if (stokAdi.isEmpty() || birimi.isEmpty() || barkodu.isEmpty() || aciklama.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lütfen tüm gerekli bilgileri girin.");
                return; 
            }

            //DOĞRUYSA GÜNCELLE
            stok.setStokAdi(stokAdi);
            stok.setStokTipi(stokTipi);
            stok.setBirimi(birimi);
            stok.setBarkodu(barkodu);
            stok.setKDVTipi(kdvTipi);
            stok.setAciklama(aciklama);

            try {
                Date tarih = new SimpleDateFormat("dd/MM/yyyy").parse(tarihFormattedTextField.getText());
                stok.setOlusturmaZamani(tarih);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Geçersiz tarih formatı. (dd/MM/yyyy)");
                return; 
            }

            // 
            stokKartService.updateStokKart(stok);
            refreshTable();
            clearInputFields();
            JOptionPane.showMessageDialog(this, "Stok başarıyla güncellendi.");
        } else {
            JOptionPane.showMessageDialog(this, "Belirtilen stok koduyla eşleşen bir stok bulunamadı.");
        }
    }


    private void kopyalaButtonActionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            String stokKodu = (String) model.getValueAt(selectedRow, 0);
            String stokAdi = (String) model.getValueAt(selectedRow, 1);
            int stokTipi = (int) model.getValueAt(selectedRow, 2);
            String birimi = (String) model.getValueAt(selectedRow, 3);
            String barkodu = (String) model.getValueAt(selectedRow, 4);
            double kdvTipi = (double) model.getValueAt(selectedRow, 5);
            String aciklama = (String) model.getValueAt(selectedRow, 6);

            stokAdiTextField.setText(stokAdi);
            stokTipiComboBox.setSelectedItem(stokTipi);
            birimiTextField.setText(birimi);
            barkodTextField.setText(barkodu);
            kdvTipiComboBox.setSelectedItem(kdvTipi);
            aciklamaTextArea.setText(aciklama);
            stokKoduTextField.setText(""); // Stok kodu alanını boşalt

            JOptionPane.showMessageDialog(this, "Seçili stok bilgileri kopyalandı.Yeni Stok Kodu Bilgisi Giriniz.");
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen bir stok seçin.");
        }
    }


    private void listeleButtonActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        List<StokKart> stoklar = stokKartService.getAllStokKartlar();

        for (StokKart stok : stoklar) {
            model.addRow(new Object[]{
                    stok.getStokKodu(),
                    stok.getStokAdi(),
                    stok.getStokTipi(),
                    stok.getBirimi(),
                    stok.getBarkodu(),
                    stok.getKDVTipi(),
                    stok.getAciklama(),
                    new SimpleDateFormat("dd/MM/yyyy").format(stok.getOlusturmaZamani())
            });
        }
    }

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        List<StokKart> stokList = stokKartService.getAllStokKartlar();

        for (StokKart stok : stokList) {
            Object[] row = {
                    stok.getStokKodu(),
                    stok.getStokAdi(),
                    stok.getStokTipi(),
                    stok.getBirimi(),
                    stok.getBarkodu(),
                    stok.getKDVTipi(),
                    stok.getAciklama(),
                    new SimpleDateFormat("dd/MM/yyyy").format(stok.getOlusturmaZamani())
            };
            model.addRow(row);
        }
    }

    private void clearInputFields() {
        stokKoduTextField.setText("");
        stokAdiTextField.setText("");
        stokTipiComboBox.setSelectedIndex(0);
        birimiTextField.setText("");
        barkodTextField.setText("");
        kdvTipiComboBox.setSelectedIndex(0);
        aciklamaTextArea.setText("");
        tarihFormattedTextField.setText("");
    }
}
