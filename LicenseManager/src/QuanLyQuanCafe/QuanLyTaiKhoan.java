/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyQuanCafe;

import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author namduong
 */
public class QuanLyTaiKhoan extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt =  null;
    public String ten_NV = "";
    int ID_NV;
    /**
     * Creates new form ChamCong
     */
    public QuanLyTaiKhoan() {
        initComponents();
        conn = ConnectDB.dbConnector();
        
        //Xoá nền của tất cả các nút cần bo tròn viền
        JPanel[] panel = {btnThemTK, btnThoat, btnSuaTK, btnXoaTK};
        for (int i = 0; i < panel.length; i++) {
            panel[i].setBackground(new Color(0,0,0,0));
        }
        taoTableTK();
        fillComboboxTenNV();
        selectTenNV.setSelectedItem(null);
        selectQuyen.setSelectedItem(null);
        txtTK.setText(null);
        txtMK.setText(null);
        JTable[] table = {tableTK};
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(32, 136, 203));
        headerRenderer.setForeground(new Color(250,250,250));
        
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].getModel().getColumnCount(); j++) {
                table[i].getColumnModel().getColumn(j).setHeaderRenderer(headerRenderer);
                table[i].setSelectionBackground(new Color(190,190,190));
                table[i].setBackground(Color.white);
                table[i].setFillsViewportHeight(true);
            }
        }
    }
    DefaultTableModel tblModelTK;
    
    public void taoTableTK() {
        tblModelTK = new DefaultTableModel();
        String tieuDe[] = {"ID", "Tên NV", "Tài khoản", "Mật khẩu", "Quyền"};
        tblModelTK.setColumnIdentifiers(tieuDe);
        loadDataTK();
        setVisible(true);
        tableTK.setDefaultEditor(Object.class, null);
    }
    
    public void loadDataTK() {
        DefaultTableModel tMOdel = (DefaultTableModel) tableTK.getModel();
        tMOdel.setRowCount(0);
        String sql = "select * from TAIKHOAN";
        String row[] = new String[5];
        try {
            Statement stmt  = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                row[0] = rs.getString(1);
                getTen_NV(rs.getInt(2));
                row[1] = ten_NV;
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                tblModelTK.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        tableTK.setModel(tblModelTK);
    }
    
    public void getID_NV(String ten) {
        String sql = "select ID_NV from NHANVIEN where ten_NV='" + ten + "'";
        try {
            Statement stmt  = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ID_NV = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void fillComboboxTenNV(){
        selectTenNV.removeAllItems();
        String sql = "select ten_NV from NHANVIEN";
        try {
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                selectTenNV.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void getTen_NV(int id){
        String sql = "select ten_NV from NHANVIEN where ID_NV = '" + id + "'";
        try {
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ten_NV = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean checkAccountExist(int id) {
        String sql="Select * from TAIKHOAN where id_NV = '"+ id +"'";
        try {
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();
            int count = 0;
            while(rs.next()) {
                count++;
            }
            if(count>=1) {
                return false;
            } else {
                return true;
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTK = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMK = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        selectQuyen = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        selectTenNV = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnThemTK = new QuanLyQuanCafe.RoundedDecoration(20);
        jLabel67 = new javax.swing.JLabel();
        btnXoaTK = new QuanLyQuanCafe.RoundedDecoration(20);
        jLabel71 = new javax.swing.JLabel();
        btnThoat = new QuanLyQuanCafe.RoundedDecoration(20);
        jLabel68 = new javax.swing.JLabel();
        btnSuaTK = new QuanLyQuanCafe.RoundedDecoration(20);
        jLabel73 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(241, 242, 249));

        jPanel5.setBackground(new java.awt.Color(241, 242, 249));

        jPanel3.setBackground(new java.awt.Color(241, 242, 249));

        tableTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên NV", "Tài khoản", "Mật khẩu", "Quyền"
            }
        ));
        tableTK.setRequestFocusEnabled(false);
        tableTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTK);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jLabel2.setText("Tài khoản");

        jLabel4.setText("Mật khẩu");

        jLabel3.setText("Quyền");

        selectQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        jLabel5.setText("Tên NV");

        selectTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTenNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMK)
                            .addComponent(selectQuyen, 0, 121, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTK)
                            .addComponent(selectTenNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(33, 38, 54));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Tài Khoản");
        jPanel1.add(jLabel1);

        jPanel6.setBackground(new java.awt.Color(241, 242, 249));

        btnThemTK.setBackground(new java.awt.Color(153, 0, 153));
        btnThemTK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnThemTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemTKMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThemTKMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThemTKMouseEntered(evt);
            }
        });
        btnThemTK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Thêm");
        btnThemTK.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        btnXoaTK.setBackground(new java.awt.Color(153, 0, 153));
        btnXoaTK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnXoaTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaTKMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnXoaTKMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnXoaTKMouseEntered(evt);
            }
        });
        btnXoaTK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("Xoá");
        btnXoaTK.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        btnThoat.setBackground(new java.awt.Color(153, 0, 153));
        btnThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMoubtnThoateClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThoatMoubtnThoateExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThoatMoubtnThoateEntered(evt);
            }
        });
        btnThoat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Thoát");
        btnThoat.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        btnSuaTK.setBackground(new java.awt.Color(153, 0, 153));
        btnSuaTK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSuaTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaTKMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSuaTKMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSuaTKMouseEntered(evt);
            }
        });
        btnSuaTK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Sửa");
        btnSuaTK.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnXoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 43, Short.MAX_VALUE)
                .addComponent(btnSuaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSuaTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(33, 38, 54));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatMoubtnThoateClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMoubtnThoateClicked
        this.dispose();
    }//GEN-LAST:event_btnThoatMoubtnThoateClicked

    private void btnThoatMoubtnThoateExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMoubtnThoateExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoatMoubtnThoateExited

    private void btnThoatMoubtnThoateEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMoubtnThoateEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoatMoubtnThoateEntered

    private void btnXoaTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaTKMouseClicked
        int indexTB = tableTK.getSelectedRow();
        String selected = tableTK.getValueAt(indexTB, 0).toString();
        int ret = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xoá?", "Xoá thông tin nguyên liệu", JOptionPane.YES_OPTION);
        if (ret == JOptionPane.YES_OPTION) {
            if (indexTB < tblModelTK.getRowCount() && indexTB >=0) {
                tblModelTK.removeRow(indexTB);
            }
            String sql = "DELETE FROM TAIKHOAN where ID_TK = ?";
            try {
                pstmt = conn.prepareStatement(sql);
                // set the corresponding param
                pstmt.setString(1, selected);
                // execute the delete statement
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        txtTK.setText(null);
        txtMK.setText(null); 
        selectQuyen.setSelectedItem(null); 
        selectTenNV.setSelectedItem(null); 
    }//GEN-LAST:event_btnXoaTKMouseClicked

    private void btnXoaTKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaTKMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaTKMouseExited

    private void btnXoaTKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaTKMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaTKMouseEntered

    private void btnSuaTKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaTKMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaTKMouseEntered

    private void btnSuaTKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaTKMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaTKMouseExited

    private void btnSuaTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaTKMouseClicked
        int indexTB = tableTK.getSelectedRow();
        String selected = tableTK.getValueAt(indexTB, 0).toString();
        String sql = "update TAIKHOAN set username = ?, pass = ?, perm = ? where id_TK =?";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, txtTK.getText());
                pstmt.setString(2, txtMK.getText());
                pstmt.setString(3, selectQuyen.getSelectedItem().toString());
                pstmt.setString(4, selected);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Sửa tài khoản thành công!");
                loadDataTK();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Sửa tài khoản không thành công!");
            }
            txtTK.setText(null);
            txtMK.setText(null);
            selectQuyen.setSelectedItem(null);
            selectTenNV.setSelectedItem(null);
    }//GEN-LAST:event_btnSuaTKMouseClicked

    private void btnThemTKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemTKMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemTKMouseEntered

    private void btnThemTKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemTKMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemTKMouseExited

    private void btnThemTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemTKMouseClicked
        getID_NV(selectTenNV.getSelectedItem().toString());
        if (txtTK.getText().equals("") || 
            txtMK.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin trước khi cập nhật!");
        } else if (checkAccountExist(ID_NV) == false) {
            JOptionPane.showMessageDialog(this, "Nhân viên này đã có tài khoản!");
            txtTK.setText(null);
            txtMK.setText(null); 
            selectTenNV.setSelectedItem(null);
            selectQuyen.setSelectedItem(null);
        } else {
            String sql = "insert into taikhoan(ID_NV, username, pass, perm) values(?,?,?,?)";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, ID_NV);
                pstmt.setString(2, txtTK.getText());
                pstmt.setString(3, txtMK.getText());
                pstmt.setString(4, selectQuyen.getSelectedItem().toString());
                pstmt.executeUpdate();
                loadDataTK();
                JOptionPane.showMessageDialog(null, "Thêm tài khoản thành công!");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Thêm tài khoản không thành công!");
            }
            txtTK.setText(null);
            txtMK.setText(null);
            selectQuyen.setSelectedItem(null);
        } 
    }//GEN-LAST:event_btnThemTKMouseClicked

    private void tableTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTKMouseClicked
        int index = tableTK.getSelectedRow();
        selectTenNV.setSelectedItem(tableTK.getValueAt(index , 1).toString());
        txtTK.setText(tableTK.getValueAt(index , 2).toString());
        txtMK.setText(tableTK.getValueAt(index , 3).toString());
        selectQuyen.setSelectedItem(tableTK.getValueAt(index , 4).toString());
    }//GEN-LAST:event_tableTKMouseClicked

    private void selectTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTenNVActionPerformed
        if (selectTenNV.getSelectedItem() != null) {
            getID_NV(selectTenNV.getSelectedItem().toString());
            String sql = "select * from TAIKHOAN where ID_NV = '" + ID_NV + "'";
            try {
                Statement stmt  = conn.createStatement();
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    count++;
                    txtTK.setText(rs.getString(3));
                    txtMK.setText(rs.getString(4));
                    selectQuyen.setSelectedItem(rs.getString(5));
                }
                if (count == 0) {
                    txtTK.setText(null);
                    txtMK.setText(null);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_selectTenNVActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyTaiKhoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnSuaTK;
    private javax.swing.JPanel btnThemTK;
    private javax.swing.JPanel btnThoat;
    private javax.swing.JPanel btnXoaTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> selectQuyen;
    private javax.swing.JComboBox<String> selectTenNV;
    private javax.swing.JTable tableTK;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables
}
