package GUI;

import BUS.CTHoaDonBUS;
import BUS.HoaDonBUS;
import DTO.CTHoaDonDTO;
import DTO.HoaDonDTO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wizardsc
 */
public class DSHoaDonGUI extends javax.swing.JPanel {

    private HoaDonBUS hdBUS = new HoaDonBUS();
    private CTHoaDonBUS cthdBUS = new CTHoaDonBUS();
    DefaultTableModel dtmDSHoaDon;
    DefaultTableModel dtmDSCTHoaDon;
    public DSHoaDonGUI() {
        initComponents();
        dtmDSHoaDon = (DefaultTableModel) tblDSHD.getModel();
        dtmDSCTHoaDon = (DefaultTableModel) tblDSCTHD.getModel();
        init();
        loadDataDSHD();
        
    }
    
    public void init(){
        //set giao diện cho Table
        //DSHD
        tblDSHD.setFocusable(false);
        tblDSHD.setIntercellSpacing(new Dimension(0, 0));
        tblDSHD.setRowHeight(25);
        tblDSHD.setFillsViewportHeight(true);
        tblDSHD.getTableHeader().setOpaque(false);
        tblDSHD.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSHD.getTableHeader().setForeground(Color.WHITE);
        tblDSHD.setSelectionBackground(new Color(188, 206, 248));
        tblDSHD.setSelectionForeground(Color.BLACK);
        tblDSHD.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSHD.getTableHeader().setReorderingAllowed(false);
        tblDSHD.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
        //DSCTHD
        tblDSCTHD.setFocusable(false);
        tblDSCTHD.setIntercellSpacing(new Dimension(0, 0));
        tblDSCTHD.setRowHeight(25);
        tblDSCTHD.setFillsViewportHeight(true);
        tblDSCTHD.getTableHeader().setOpaque(false);
        tblDSCTHD.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSCTHD.getTableHeader().setForeground(Color.WHITE);
        tblDSCTHD.setSelectionBackground(new Color(188, 206, 248));
        tblDSCTHD.setSelectionForeground(Color.BLACK);
        tblDSCTHD.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSCTHD.getTableHeader().setReorderingAllowed(false);
        tblDSCTHD.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
    }
    
    public void showAllDSHD(ArrayList<HoaDonDTO> dshd){
        dtmDSHoaDon.setRowCount(0);
        for(int i=0;i<dshd.size();i++){
            dtmDSHoaDon.addRow(new String[]{
                dshd.get(i).getMaHD(),
                dshd.get(i).getMaKH(),
                dshd.get(i).getMaNV(),
                dshd.get(i).getNgayLap(),
                String.valueOf(dshd.get(i).getTongTien())
            });
        }
        
    }
    public void loadDataDSHD(){
        hdBUS.docDanhSach();
        ArrayList<HoaDonDTO> dshd = hdBUS.getListHoaDon();
        showAllDSHD(dshd);
    }
    
    public void showAllDSCTHD(ArrayList<CTHoaDonDTO> dscthd){
        dtmDSCTHoaDon.setRowCount(0);
        for(int i=0;i<dscthd.size();i++){
            dtmDSCTHoaDon.addRow(new String[]{
                dscthd.get(i).getMaHD(),
                dscthd.get(i).getMaSP(),
                dscthd.get(i).getTenSP(),
                String.valueOf(dscthd.get(i).getSoLuong()),
                String.valueOf(dscthd.get(i).getDonGia()),
                String.valueOf(dscthd.get(i).getThanhTien())
            });
        }
    }
    public void loadDataDSCTHD(){
        cthdBUS.docListCTHoaDon();
        ArrayList<CTHoaDonDTO> dscthd = cthdBUS.getListCTHoaDon();
        showAllDSCTHD(dscthd);
    }
    
    public void loadDataDSCTHDTheoMaHD(String MaHD){
        if (cthdBUS.getListCTHoaDon() == null) {
            cthdBUS.listCTHD();
        }
        ArrayList<CTHoaDonDTO> dscthd = cthdBUS.getListCTHDTheoMaHD(MaHD);
        dtmDSCTHoaDon.setRowCount(0);
        showAllDSCTHD(dscthd);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnRoot = new javax.swing.JPanel();
        pnDSSP = new javax.swing.JPanel();
        lblDSSP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSHD = new javax.swing.JTable();
        lblMaSP = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        lblHo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgayLap = new com.toedter.calendar.JDateChooser();
        pnGioHang = new javax.swing.JPanel();
        lblGioHang = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDSCTHD = new javax.swing.JTable();
        lblMaSP1 = new javax.swing.JLabel();
        txtMaHDinCTHD = new javax.swing.JTextField();

        pnRoot.setBackground(new java.awt.Color(250, 247, 240));

        pnDSSP.setBackground(new java.awt.Color(250, 247, 240));
        pnDSSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 4, new java.awt.Color(0, 0, 0)));
        pnDSSP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDSSP.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblDSSP.setForeground(new java.awt.Color(255, 51, 51));
        lblDSSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDSSP.setText("Danh sách hóa đơn");
        pnDSSP.add(lblDSSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 30));

        tblDSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã KH", "Mã NV", "Ngày lập", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSHD);
        if (tblDSHD.getColumnModel().getColumnCount() > 0) {
            tblDSHD.getColumnModel().getColumn(0).setResizable(false);
            tblDSHD.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblDSHD.getColumnModel().getColumn(1).setResizable(false);
            tblDSHD.getColumnModel().getColumn(1).setPreferredWidth(5);
            tblDSHD.getColumnModel().getColumn(2).setResizable(false);
            tblDSHD.getColumnModel().getColumn(2).setPreferredWidth(5);
            tblDSHD.getColumnModel().getColumn(3).setResizable(false);
            tblDSHD.getColumnModel().getColumn(3).setPreferredWidth(30);
            tblDSHD.getColumnModel().getColumn(4).setResizable(false);
            tblDSHD.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        pnDSSP.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 480, 430));

        lblMaSP.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP.setText("Mã HD");
        pnDSSP.add(lblMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        txtMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDActionPerformed(evt);
            }
        });
        pnDSSP.add(txtMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 160, 24));
        pnDSSP.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 160, 24));

        lblHo.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblHo.setText("Mã NV");
        pnDSSP.add(lblHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        jLabel3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel3.setText("Mã KH");
        pnDSSP.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        jLabel4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Ngày lập");
        pnDSSP.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, -1, -1));
        pnDSSP.add(txtMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 160, 24));
        pnDSSP.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 520, 160, 24));

        jLabel5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel5.setText("Tổng tiền");
        pnDSSP.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, -1, -1));

        txtNgayLap.setDateFormatString("dd/MM/yyyy");
        pnDSSP.add(txtNgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 160, 24));

        pnGioHang.setBackground(new java.awt.Color(250, 247, 240));

        lblGioHang.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblGioHang.setForeground(new java.awt.Color(255, 51, 51));
        lblGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioHang.setText("Chi tiết hóa đơn");

        tblDSCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSCTHDMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblDSCTHD);
        if (tblDSCTHD.getColumnModel().getColumnCount() > 0) {
            tblDSCTHD.getColumnModel().getColumn(0).setResizable(false);
            tblDSCTHD.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblDSCTHD.getColumnModel().getColumn(1).setResizable(false);
            tblDSCTHD.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblDSCTHD.getColumnModel().getColumn(2).setResizable(false);
            tblDSCTHD.getColumnModel().getColumn(2).setPreferredWidth(230);
            tblDSCTHD.getColumnModel().getColumn(3).setResizable(false);
            tblDSCTHD.getColumnModel().getColumn(3).setPreferredWidth(25);
            tblDSCTHD.getColumnModel().getColumn(4).setResizable(false);
            tblDSCTHD.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblDSCTHD.getColumnModel().getColumn(5).setResizable(false);
            tblDSCTHD.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        lblMaSP1.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP1.setText("Mã HD");

        javax.swing.GroupLayout pnGioHangLayout = new javax.swing.GroupLayout(pnGioHang);
        pnGioHang.setLayout(pnGioHangLayout);
        pnGioHangLayout.setHorizontalGroup(
            pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaSP1)
                .addGap(32, 32, 32)
                .addComponent(txtMaHDinCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addComponent(lblGioHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnGioHangLayout.setVerticalGroup(
            pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHDinCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaSP1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addComponent(pnDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1097, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>                        

    private void tblDSHDMouseClicked(java.awt.event.MouseEvent evt) {                                     
        int k = tblDSHD.getSelectedRow();
        //        int SoLuong = Integer.parseInt(tblDSHD.getModel().getValueAt(k, 2).toString());
        //        if (SoLuong < -100) {
            //            JOptionPane.showMessageDialog(pnRoot, "Sản phẩm đã hết hàng", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            //            return;
            //        }
        //        //-- setModel cho txtSoLuong, căn trái số,....
        //        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, -10, SoLuong, 1);
        //        txtSoLuong.setModel(modeSpinner);
        //        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) txtSoLuong.getEditor()).getTextField();
        //        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
        //        txtSpinner.setEditable(false);
        //        txtSpinner.setHorizontalAlignment(JTextField.LEFT);
        //--
        txtMaHD.setText(tblDSHD.getModel().getValueAt(k, 0).toString());
        txtMaNV.setText(tblDSHD.getModel().getValueAt(k, 2).toString());
        txtMaKH.setText(tblDSHD.getModel().getValueAt(k, 1).toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date NgayLap = new Date();
        try {
            NgayLap = sdf.parse(tblDSHD.getModel().getValueAt(k, 3).toString());
        } catch (ParseException ex) {
            System.out.println("Sai thgian");
            Logger.getLogger(HoaDonGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNgayLap.setDate(NgayLap);
        txtTongTien.setText(tblDSHD.getModel().getValueAt(k,4).toString());

        txtMaHD.setEnabled(false);
        txtMaNV.setEnabled(false);
        txtMaKH.setEnabled(false);
        txtNgayLap.setEnabled(false);
        txtTongTien.setEnabled(false);
        String MaHD = txtMaHD.getText();
        loadDataDSCTHDTheoMaHD(MaHD);
    }                                    

    private void tblDSCTHDMouseClicked(java.awt.event.MouseEvent evt) {                                       
        
    }                                      

    private void txtMaHDActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblDSSP;
    private javax.swing.JLabel lblGioHang;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblMaSP1;
    private javax.swing.JPanel pnDSSP;
    private javax.swing.JPanel pnGioHang;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JTable tblDSCTHD;
    private javax.swing.JTable tblDSHD;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHDinCTHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private com.toedter.calendar.JDateChooser txtNgayLap;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration                   
}
