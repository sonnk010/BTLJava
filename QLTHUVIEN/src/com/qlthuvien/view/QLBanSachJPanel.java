/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlthuvien.view;

import com.qlthuvien.model.Sach;
import com.qlthuvien.service.SachService;
import java.util.Hashtable;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.qlthuvien.model.GioHang;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Administrator
 */
public class QLBanSachJPanel extends javax.swing.JPanel {

    /**
     * Creates new form QLBanSachJPanel
     */
    private DefaultTableModel defaultSachTable, defaultGioHangTable;
    private SachService sachService;
    private int index,//chi so hang trong Sachtable
                count,//so luong hang trong gio
                indexGioHang;//chi so cua hang trong GioHangtable
    private static Hashtable<String, GioHang> dsGioHang;

    public static Hashtable<String, GioHang> getGioHang() {
        return dsGioHang;
    }

    public QLBanSachJPanel() {

        initComponents();
        lammoi();
        
        //Tao tien trinh tu dong lam moi jpanel sau khi click mua o ben xac nhan mua
        Thread tudonglammoi = new Thread() {
            @Override
            public void run() {
                do {

                    if (XacNhanMuaJFrame.getCheck() == true) {
                        lammoi();
                        XacNhanMuaJFrame.setCheck();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } while (1 == 1);
            }
        };
        tudonglammoi.start();

    }

    private void lammoi() {
        sachService = new SachService();
        dsGioHang = new Hashtable<String, GioHang>();
        index = -1;
        indexGioHang = -1;
        count = 0;
        HienThiSachTable();
        HienThiGioHangTable();
    }

    private void HienThiSachTable() {
        defaultSachTable = new DefaultTableModel();

        sachTable.setModel(defaultSachTable);

        defaultSachTable.addColumn("Mã sách");
        defaultSachTable.addColumn("Tên sách");
        defaultSachTable.addColumn("Tác giả");
        defaultSachTable.addColumn("Thể loại");
        defaultSachTable.addColumn("Nhà xuất bản");
        defaultSachTable.addColumn("Giá");
        defaultSachTable.addColumn("Số lượng");
        sachTable.setDefaultEditor(Object.class, null);//Khong cho chinh sua
        Display(sachService.getSachBan());
    }

    private void HienThiGioHangTable() {
        defaultGioHangTable = new DefaultTableModel() {
            //chi cho phep sua cot so luong
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 2;
            }
        };

        gioHangTable.setModel(defaultGioHangTable);

        defaultGioHangTable.addColumn("Mã sách");
        defaultGioHangTable.addColumn("Tên sách");
        defaultGioHangTable.addColumn("Số Lượng");
        defaultGioHangTable.addColumn("Giá");

    }

    //Hien thi len sachtable
    private void Display(List<Sach> list) {
        defaultSachTable.setRowCount(0);
        for (Sach sach : list) {
            if (sach.getSoluong() > 0) {
                defaultSachTable.addRow(new Object[]{sach.getMaSach(), sach.getTenSach(), sach.getTenTacGia(), sach.getTheLoai(), sach.getTenNxb(), sach.getGiaSach(), sach.getSoluong()});
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btThemVaoGio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sachTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gioHangTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btBoRa = new javax.swing.JButton();
        btMua = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTheLoai = new javax.swing.JTextField();
        txtNXB = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtMaSach = new javax.swing.JTextField();
        btTimMS = new javax.swing.JButton();
        btLamMoiText = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        btThemVaoGio.setText("Thêm vào giỏ");
        btThemVaoGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemVaoGioActionPerformed(evt);
            }
        });

        sachTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản", "Giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sachTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sachTable.getTableHeader().setReorderingAllowed(false);
        sachTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sachTableChonSach(evt);
            }
        });
        jScrollPane1.setViewportView(sachTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(btThemVaoGio)
                    .addContainerGap(892, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(btThemVaoGio)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        gioHangTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Số lượng", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gioHangTable.getTableHeader().setReorderingAllowed(false);
        gioHangTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gioHangTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(gioHangTable);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Giỏ");

        btBoRa.setText("Bỏ ra khỏi giỏ");
        btBoRa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBoRaActionPerformed(evt);
            }
        });

        btMua.setText("Mua");
        btMua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMuaActionPerformed(evt);
            }
        });

        btReset.setText("Tạo mới");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btBoRa)
                                .addComponent(btMua, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btReset, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(236, 236, 236)
                            .addComponent(jLabel7)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(btBoRa)
                            .addGap(42, 42, 42)
                            .addComponent(btMua)
                            .addGap(42, 42, 42)
                            .addComponent(btReset)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46)))))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Mã sách");
        jLabel1.setToolTipText("");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tên sách");
        jLabel2.setToolTipText("");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Tác giả");
        jLabel3.setToolTipText("");

        jLabel5.setText("Thể loại");

        jLabel6.setText("Nhà xuất bản");

        btTimMS.setText("Tìm");
        btTimMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimMSActionPerformed(evt);
            }
        });

        btLamMoiText.setText("Làm mới");
        btLamMoiText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLamMoiTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addGap(21, 21, 21)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaSach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenSach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btTimMS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLamMoiText, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(btTimMS, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(btLamMoiText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btThemVaoGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemVaoGioActionPerformed
        // TODO add your handling code here:
        if (index >= 0) {
            //Lay du lieu tu bang
            String masach = String.valueOf(sachTable.getValueAt(index, 0));
            String tensach = String.valueOf(sachTable.getValueAt(index, 1));
            String gia1 = String.valueOf(sachTable.getValueAt(index, 5));
            float gia = Float.parseFloat(gia1);

            //Them vao gio hang
            GioHang gh = new GioHang(masach, tensach, 1, gia);

            if (!dsGioHang.containsKey(masach)) {
                dsGioHang.put(masach, gh);
                count++;
                defaultGioHangTable.addRow(new Object[]{gh.getMasach(), gh.getTensach(), "1", gh.getGia()});
            }
        } else
            JOptionPane.showMessageDialog(null, "Chưa chọn sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btThemVaoGioActionPerformed

    private void sachTableChonSach(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sachTableChonSach
        // TODO add your handling code here:
        index = sachTable.getSelectedRow();

    }//GEN-LAST:event_sachTableChonSach

    private void btMuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMuaActionPerformed
        String tb = "";
        boolean kiemtra = true;
        if (count != 0) {
            dsGioHang.clear();
            //Luu lai danh sach san pham cung so luong 
            for (int i = 0; i < count; i++) {
                String masach = String.valueOf(gioHangTable.getValueAt(i, 0));
                String tensach = String.valueOf(gioHangTable.getValueAt(i, 1));

                if (Pattern.matches("[^0-9]", String.valueOf(gioHangTable.getValueAt(i, 2)))) {
                    tb += tensach + ", ";
                    kiemtra = false;
                } else {
                    int soluong = Integer.parseInt(String.valueOf(gioHangTable.getValueAt(i, 2)));
                    float gia = Float.parseFloat(String.valueOf(gioHangTable.getValueAt(i, 3)));
                    GioHang gh = new GioHang(masach, tensach, soluong, gia);
                    dsGioHang.put(masach, gh);
                }
            }
            if (!kiemtra) {
                JOptionPane.showMessageDialog(null, "Số lượng của " + tb + " phải là số nguyên", "Thông báo", JOptionPane.ERROR_MESSAGE);

            } else {
                //Kiem tra xem so luong mua co lon hon so luong con trong kho khong
                List<String> danhsachloi = Check(dsGioHang, sachService.getSachBan());
                if (danhsachloi.isEmpty()) {
                    XacNhanMuaJFrame xn = new XacNhanMuaJFrame();
                    xn.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    xn.setVisible(true);
                } else {
                    tb = "";
                    int size = danhsachloi.size();
                    for (int i = 0; i < size; i++) {
                        if (i == size - 1) {
                            tb += danhsachloi.get(i) + " : ";
                        } else {
                            tb += danhsachloi.get(i) + " , ";
                        }
                    }
                    tb = tb + " Khong du so luong ban";
                    JOptionPane.showMessageDialog(null, tb, "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chưa có gì trong giỏ hàng", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btMuaActionPerformed
    //Ham tra ve danh sach cac san pham khong du so luong
    private List<String> Check(Hashtable<String, GioHang> gh, List<Sach> sachban) {

        
        List<String> danhsachloi = new ArrayList<String>();
        danhsachloi.clear();
        int size = sachban.size();

        Hashtable<String, Sach> dsSachBan = new Hashtable<String, Sach>();

        for (int i = 0; i < size; i++) {
            String ms = sachban.get(i).getMaSach();
            dsSachBan.put(ms, sachban.get(i));
        }

        
        Enumeration<String> enu = gh.keys();
        while (enu.hasMoreElements()) {

            String key = enu.nextElement();//Lay ra key trong gio hang
            GioHang value = gh.get(key);//Lay ra gia tri tuong ung voi key trong gio hang
            
            String ms = value.getMasach();
            int soban = value.getSoluong();//lay ra so luong muon mua
            int soco = dsSachBan.get(ms).getSoluong();// lay ra so luong con trong kho
            
            if (soban > soco) {
                String tensach = dsSachBan.get(ms).getTenSach();
                danhsachloi.add(tensach);
            }

        }
        return danhsachloi;

    }


    private void btTimMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimMSActionPerformed
        // TODO add your handling code here:
        String masach = txtMaSach.getText();
        String tensach = txtTenSach.getText();
        String tentacgia = txtTacGia.getText();
        String theloai = txtTheLoai.getText();
        String tennxb = txtNXB.getText();
        Display(sachService.TimSachBan(masach, tensach, tentacgia, tennxb, theloai));
    }//GEN-LAST:event_btTimMSActionPerformed

    private void btBoRaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBoRaActionPerformed
        // TODO add your handling code here:
        if (indexGioHang >= 0) {
            String ms = String.valueOf(gioHangTable.getValueAt(indexGioHang, 0));
            dsGioHang.remove(ms);
            count--;
            HienThiGioHang(dsGioHang);
            indexGioHang = -1;
        }

    }//GEN-LAST:event_btBoRaActionPerformed

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        // TODO add your handling code here:
        dsGioHang.clear();
        count = 0;
        defaultGioHangTable.setRowCount(0);
        HienThiGioHang(dsGioHang);
    }//GEN-LAST:event_btResetActionPerformed

    private void btLamMoiTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLamMoiTextActionPerformed
        // TODO add your handling code here:
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtTacGia.setText("");
        txtNXB.setText("");
        txtTheLoai.setText("");
        Display(sachService.getSachBan());
    }//GEN-LAST:event_btLamMoiTextActionPerformed

    private void gioHangTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gioHangTableMouseClicked
        // TODO add your handling code here:
        indexGioHang = gioHangTable.getSelectedRow();
    }//GEN-LAST:event_gioHangTableMouseClicked

    private void HienThiGioHang(Hashtable<String, GioHang> list) {
        defaultGioHangTable.setRowCount(0);
        Enumeration<String> enu = dsGioHang.keys();
        while (enu.hasMoreElements()) {
            String key = enu.nextElement();
            GioHang gh = dsGioHang.get(key);
            defaultGioHangTable.addRow(new Object[]{gh.getMasach(), gh.getTensach(), gh.getSoluong(), gh.getGia()});
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBoRa;
    private javax.swing.JButton btLamMoiText;
    private javax.swing.JButton btMua;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btThemVaoGio;
    private javax.swing.JButton btTimMS;
    private javax.swing.JTable gioHangTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable sachTable;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTheLoai;
    // End of variables declaration//GEN-END:variables

}
