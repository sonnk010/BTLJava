/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlthuvien.view;

import com.qlthuvien.model.GioHang;
import com.qlthuvien.model.SinhVien;
import com.qlthuvien.service.ChiTietMuonTraService;
import com.qlthuvien.service.PhieuMuonTraService;
import com.qlthuvien.service.SinhVienService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author son30
 */
public class XacNhanMuonJFrame extends javax.swing.JFrame {

    /**
     * Creates new form XacNhanMuonJFrame
     */
    DefaultTableModel defaultGioHangTable;
    private float tong =0;
    private SinhVienService svService;
    private PhieuMuonTraService pmtService;
    private ChiTietMuonTraService ctmtService;
    private static boolean ketqua = false;
    public XacNhanMuonJFrame() {
        initComponents();
        svService = new SinhVienService();
        ctmtService = new ChiTietMuonTraService();
        
        //Tao ma phieuMuonTra
        pmtService = new PhieuMuonTraService();
        txtMaPhieuMuon.setText(pmtService.taoMaPhieuMuonTra());
        //Tao ngay 
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        txtNgayMuon.setText(String.valueOf(f.format(date)));
        
        //khoi tao bang dsMuon
        defaultGioHangTable= new DefaultTableModel();
        dsMuonTable.setModel(defaultGioHangTable);
        defaultGioHangTable.addColumn("Mã sách");
        defaultGioHangTable.addColumn("Tên sách");
        defaultGioHangTable.addColumn("Số lượng");
        defaultGioHangTable.addColumn("Giá");
        dsMuonTable.setDefaultEditor(Object.class, null);
        //Hien thi sach muon vao bang dsMuon 
        Hashtable<String,GioHang> gh = QLMuonSachJPanel.getGioHang();
        Enumeration<String> enu=gh.keys();
        while(enu.hasMoreElements()){
            String key=enu.nextElement();
            GioHang sach=gh.get(key);
            
            defaultGioHangTable.addRow(new Object[]{ sach.getMasach(),sach.getTensach(),String.valueOf(sach.getSoluong()),String.valueOf(sach.getGia()) });
            
            tong+=sach.getSoluong()*sach.getGia();   
            
        }
        txtTongTien.setText("Tổng số tiền là :"+(long)tong);
    }
    public float getTong() {
        return tong;
    }

    public static boolean getKetqua() {
        return ketqua;
    }

    public static void setKetqua(boolean ketqua1) {
        ketqua = ketqua1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMasv = new javax.swing.JTextField();
        txtHoten = new javax.swing.JTextField();
        txtDienthoai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNgayMuon = new javax.swing.JTextField();
        btKiemTra = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtMaPhieuMuon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsMuonTable = new javax.swing.JTable();
        txtTongTien = new javax.swing.JLabel();
        btXong = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Phiếu Mượn");

        jLabel2.setText("Mã Sinh Viên");

        jLabel6.setText("Họ Tên");

        jLabel7.setText("Điện Thoại");

        jLabel8.setText("Email");

        jLabel3.setText("Ngày Mượn");

        txtMasv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMasvKeyTyped(evt);
            }
        });

        txtHoten.setEditable(false);

        txtDienthoai.setEditable(false);

        txtEmail.setEditable(false);

        txtNgayMuon.setEditable(false);

        btKiemTra.setText("Kiểm tra");
        btKiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKiemTraActionPerformed(evt);
            }
        });

        jLabel4.setText("Mã Phiếu Mượn");

        txtMaPhieuMuon.setEditable(false);

        jLabel5.setText("Danh Sách Mượn");

        dsMuonTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dsMuonTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(dsMuonTable);

        txtTongTien.setText("Tổng tiền :");

        btXong.setText("Xong");
        btXong.setEnabled(false);
        btXong.setPreferredSize(new java.awt.Dimension(79, 27));
        btXong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtMasv, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                            .addComponent(txtNgayMuon)))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btKiemTra))))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(txtTongTien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btXong, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btKiemTra))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btXong, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btKiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKiemTraActionPerformed
        // TODO add your handling code here:
        SinhVien sv = new SinhVien();
        sv = svService.getSinhVien(txtMasv.getText());
        if(sv.getMaSV()==null){
            btXong.setEnabled(false);
            txtHoten.setText("");
            txtDienthoai.setText("");
            txtEmail.setText("");
            JOptionPane.showMessageDialog(null,"Không tìm thấy sinh viên có mã : "+txtMasv.getText());
        }
        else{
            txtHoten.setText(sv.getTenSV());
            txtDienthoai.setText(sv.getDienthoaiSV());
            txtEmail.setText(sv.getEmailSV());
            
            btXong.setEnabled(true);
            
        }
    }//GEN-LAST:event_btKiemTraActionPerformed

    private void btXongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXongActionPerformed
        // TODO add your handling code here:
        int sl1 = pmtService.ThemPhieuMuonTra(txtMaPhieuMuon.getText(),txtMasv.getText(), getTong());
        int sl2 = ctmtService.themChiTietMuonTra(txtMaPhieuMuon.getText(),QLMuonSachJPanel.getGioHang());
        if(sl1==1&&sl2>0){
            JOptionPane.showMessageDialog(null,"Thành công");
            setKetqua(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"Có lỗi xảy ra");
            setKetqua(false);
        }
        this.dispose();
    }//GEN-LAST:event_btXongActionPerformed
    // khi txtMasv thay doi, disable btXong
    private void txtMasvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMasvKeyTyped
        // TODO add your handling code here:
        btXong.setEnabled(false);
    }//GEN-LAST:event_txtMasvKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        setKetqua(false);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(XacNhanMuonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(XacNhanMuonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(XacNhanMuonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(XacNhanMuonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new XacNhanMuonJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btKiemTra;
    private javax.swing.JButton btXong;
    private javax.swing.JTable dsMuonTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDienthoai;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtMaPhieuMuon;
    private javax.swing.JTextField txtMasv;
    private javax.swing.JTextField txtNgayMuon;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
