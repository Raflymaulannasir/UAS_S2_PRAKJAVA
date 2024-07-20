package form;

import Koneksi.KoneksiDatabase;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FrmData extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    Connection cn = Koneksi.KoneksiDatabase.getConnection();
    
    private void insertData() {
        String sql = "INSERT INTO datakendaraan (PlatNomor, NamaPemilik, AlamatPemilik, MerkKendaraan, JenisKendaraan, WarnaKendaraan) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection cn = KoneksiDatabase.getConnection(); 
             PreparedStatement pstmt = cn.prepareStatement(sql)) {
            
            pstmt.setString(1, txtPlatNomor.getText());
            pstmt.setString(2, txtNamaPemilik.getText());
            pstmt.setString(3, txtAlamatPemilik.getText());
            pstmt.setString(4, txtMerkKendaraan.getText());
            pstmt.setString(5, txtJenisKendaraan.getText());
            pstmt.setString(6, txtWarnaKendaraan.getText());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data berhasil disimpan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public FrmData() {
        initComponents();
        TampilData();
    }
    
    
    
    private void Bersih(){
        txtPlatNomor.setText("");
        txtNamaPemilik.setText("");
        txtAlamatPemilik.setText("");
        txtMerkKendaraan.setText("");
        txtJenisKendaraan.setText("");
        txtWarnaKendaraan.setText("");
        
        btnSimpan.setText("Simpan");
        txtPlatNomor.setEditable(true);
    }
    
    private void CariData(){
    try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM datakendaraan WHERE " 
                    + cmbCari.getSelectedItem() + 
                    " LIKE '%" + txtCari.getText() + "%'");
            
            DefaultTableModel model = new DefaultTableModel();
            //model.addColumn("No.");
            model.addColumn("PlatNomor");
            model.addColumn("Nama Pemilik");
            model.addColumn("Alamat Pemilik");
            model.addColumn("Merk Kendaraan");
            model.addColumn("Jenis Kendaraan");
            model.addColumn("Warna Kendaraan");
            
            //int No = 1;
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setNumRows(0);
            
            while (rs.next()){
              Object[] data = {
                 //No ++,
                rs.getString("PlatNomor"),
                rs.getString("Nama Pemilik"),
                rs.getString("Alamat Pemilik"),
                rs.getString("Merk Kendaraan"),
                rs.getString("Jenis Kendaraan"),
                rs.getString("Warna Kendaraan")
            };
             model.addRow(data);
             tblData.setModel(model);              
            }
        }catch (Exception e) {
        }
    }
    
    private void TampilData(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM datakendaraan");
            
            DefaultTableModel model = new DefaultTableModel(
            new Object[]{"PlatNomor", "Nama Pemilik", "Alamat Pemilik", "Merk Kendaraan", "Jenis Kendaraan", "Warna Kendaraan"}, 0);
            //model.addColumn("No.");
            /*model.addColumn("");
            model.addColumn("");
            model.addColumn("");
            model.addColumn("");
            model.addColumn("");
            model.addColumn("");*/
            
            //int No = 1;
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setNumRows(0);
            
            while (rs.next()){
              Object[] data = {
                 //No ++,
                rs.getString("PlatNomor"),
                rs.getString("Nama Pemilik"),
                rs.getString("Alamat Pemilik"),
                rs.getString("Merk Kendaraan"),
                rs.getString("Jenis Kendaraan"),
                rs.getString("Warna Kendaraan")
            };
             model.addRow(data);
             tblData.setModel(model);
             
            }
        }catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlatNomor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPlatNomor = new javax.swing.JTextField();
        txtAlamatPemilik = new javax.swing.JTextField();
        txtNamaPemilik = new javax.swing.JTextField();
        txtMerkKendaraan = new javax.swing.JTextField();
        txtJenisKendaraan = new javax.swing.JTextField();
        txtWarnaKendaraan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbCari = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PlatNomor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PlatNomor.setText("PlatNomor");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nama Pemilik");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Alamat Pemilik");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Merk Kendaraan");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Jenis Kendaraan");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Warna Kendaraan");

        txtPlatNomor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlatNomorActionPerformed(evt);
            }
        });

        txtNamaPemilik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPemilikActionPerformed(evt);
            }
        });

        txtJenisKendaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJenisKendaraanActionPerformed(evt);
            }
        });

        txtWarnaKendaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWarnaKendaraanActionPerformed(evt);
            }
        });

        btnSimpan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tblData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "PlatNomor", "Nama Pemilik", "Alamat Pemilik", "Merk Kendaraan", "Jenis Kendaraan", "Warna Kendaraan"
            }
        ));
        tblData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblData.setMinimumSize(new java.awt.Dimension(95, 85));
        tblData.setRowHeight(27);
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Cari Data");

        cmbCari.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PlatNomor", "Nama Pemilik", "Merk Kendaraan", " " }));
        cmbCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCariActionPerformed(evt);
            }
        });

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCari))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnSimpan)
                        .addGap(0, 288, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PlatNomor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJenisKendaraan)
                            .addComponent(txtAlamatPemilik)
                            .addComponent(txtMerkKendaraan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtWarnaKendaraan)
                            .addComponent(txtNamaPemilik, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPlatNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PlatNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlatNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNamaPemilik))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlamatPemilik, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMerkKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWarnaKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUpdate)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaPemilikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPemilikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPemilikActionPerformed

    private void txtJenisKendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJenisKendaraanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJenisKendaraanActionPerformed

    private void txtWarnaKendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWarnaKendaraanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWarnaKendaraanActionPerformed

    private void txtPlatNomorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlatNomorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlatNomorActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    String Update = "UPDATE datakendaraan SET PlatNomor = '" + txtPlatNomor.getText() +
            "', Nama Pemilik '" + txtNamaPemilik.getText()
            + "', Alamat Pemilik '" + txtAlamatPemilik.getText()
            + "', Merk Kendaraan '" + txtMerkKendaraan.getText()
            + "', Jenis Kendaraan '" + txtJenisKendaraan.getText()
            + "', Warna Kendaraan '" + txtWarnaKendaraan.getText() + "')";
        try {
            st.executeUpdate(Update);
        
    JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
    Bersih();
    TampilData();
     
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }//GEN-LAST:event_btnUpdateActionPerformed

    }
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            st = cn.createStatement();
            if (txtPlatNomor.getText().equals("")||
                txtNamaPemilik.getText().equals("")||
                txtAlamatPemilik.getText().equals("")||
                txtMerkKendaraan.getText().equals("")||
                txtJenisKendaraan.getText().equals("")||
                txtWarnaKendaraan.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Validasi Data", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
            if (btnSimpan.getText() == "Simpan"){
                   String cek = "SELECT * FROM datakendaraan WHERE PlatNomor = '" + txtPlatNomor.getText() + "'";
                   rs = st.executeQuery(cek);
                   if (rs.next()) {
                       JOptionPane.showMessageDialog(null, "Ups....PlatNomor ini sudah ada");
            }else{
                String sql = "INSERT INTO datakendaraan VALUES ('" + txtPlatNomor.getText() + 
                        "', '" + txtNamaPemilik.getText() +
                        "', '" + txtAlamatPemilik.getText() +
                        "', '" + txtMerkKendaraan.getText() +
                        "', '" + txtJenisKendaraan.getText() +
                        "', '" + txtWarnaKendaraan.getText() + "')";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "data berhasil disimpan");
                Bersih();
                TampilData();
            }
            }else{//aksi ubah data
            String update = "UPDATE datakendaraan SET Nama Pemilik = '" + txtNamaPemilik.getText() +
                    "', Alamt Pemilik = '" + txtAlamatPemilik.getText() +
                    "', Merk Kendaraan = '" + txtMerkKendaraan.getText() +
                    "', Jenis Kendaraan '" + txtJenisKendaraan.getText() +
                    "', Warna Kendaraan '" + txtWarnaKendaraan.getText() +
                    "' + WHERE PlatNomor = '" + txtPlatNomor.getText() + "'";
            st.executeUpdate(update);
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            Bersih();
            TampilData();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:                                    
    int selectedRow = tblData.getSelectedRow();
    int columnCount = tblData.getColumnCount();

    if (selectedRow != -1) {
        if (columnCount > 1) {
            txtPlatNomor.setText(tblData.getValueAt(selectedRow, 1).toString());
        }
        if (columnCount > 2) {
            txtNamaPemilik.setText(tblData.getValueAt(selectedRow, 2).toString());
        }
        if (columnCount > 3) {
            txtAlamatPemilik.setText(tblData.getValueAt(selectedRow, 3).toString());
        }
        if (columnCount > 4) {
            txtMerkKendaraan.setText(tblData.getValueAt(selectedRow, 4).toString());
        }
        if (columnCount > 5) {
            txtJenisKendaraan.setText(tblData.getValueAt(selectedRow, 5).toString());
        }
        if (columnCount > 6) {
            txtWarnaKendaraan.setText(tblData.getValueAt(selectedRow, 6).toString());
        }

        txtPlatNomor.setEditable(false);
        btnUpdate.setText("Update");
   
}

    }//GEN-LAST:event_tblDataMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if (txtPlatNomor.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan dihapus !");
        }else{
        int jawab = JOptionPane.showConfirmDialog(null, "Data ini alan dihapus, Lanjutkan ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (jawab == 0){
            try {
                st = cn.createStatement();
                String sql;
                sql = "DELET FROM datakendaraan WHERE PlatNomor = '" + txtPlatNomor.getText() + "'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                TampilData();
                Bersih();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void cmbCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCariActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:
        CariData();
    }//GEN-LAST:event_txtCariKeyPressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(()-> {
            
                new FrmData().setVisible(true);
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PlatNomor;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtAlamatPemilik;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJenisKendaraan;
    private javax.swing.JTextField txtMerkKendaraan;
    private javax.swing.JTextField txtNamaPemilik;
    private javax.swing.JTextField txtPlatNomor;
    private javax.swing.JTextField txtWarnaKendaraan;
    // End of variables declaration//GEN-END:variables
}
