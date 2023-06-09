/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SanPhamDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.apache.commons.compress.utils.Lists.newArrayList;

/**
 *
 * @author wizardsc
 */
public class SanPhamDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<SanPhamDTO> dssp = new ArrayList<>();
    private Connection connection = mySQL.getConnection();

    public ArrayList<SanPhamDTO> getListSanPham() {
        try {
            ArrayList<SanPhamDTO> dssp = new ArrayList<>();
            String sql = "SELECT * FROM sanpham";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                SanPhamDTO sp = new SanPhamDTO(
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getString("DonViTinh"),
                        rs.getString("MaLoai"),
                        rs.getString("IMG")
                );
                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    public void insertSanPham(SanPhamDTO sp){
        
        
    }
    public void updateSanPham (SanPhamDTO sp){
        try {
            String sql = "UPDATE sanpham SET TenSP = ?, SoLuong = ?, DonGia = ?, DonViTinh = ?, MaLoai = ?, IMG = ? WHERE MaSP = ?";
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, sp.getTenSP());
            pstatement.setInt(2, sp.getSoLuong());
            pstatement.setInt(3, sp.getDonGia());
            pstatement.setString(4, sp.getDonViTinh());
            pstatement.setString(5, sp.getMaLoai());
            pstatement.setString(6, sp.getIMG());
            pstatement.setString(7, sp.getMaSP());
            pstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        
    }
    public void deleteSanPham(String MaSP){
        String queryDeleteSanPham = "DELETE FROM sanpham WHERE MaSP = ?";
        try {
            PreparedStatement pre=connection.prepareStatement(queryDeleteSanPham);
            
            pre.setString(1,MaSP);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Hàm này dùng cho trường hợp sau khi thêm sản phẩm vào giỏ hàng thì sản phẩm tự giảm đúng số lượng đã thêm
    public void capNhatSoLuongHD(String MaSP, int SoLuongMua, int SoLuongTrongKho) {
        try {
            String sql = "UPDATE sanpham SET SoLuong=? WHERE MaSP= ?" ;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (SoLuongMua+SoLuongTrongKho));
            statement.setString(2,MaSP);
            statement.executeUpdate();
        } catch (SQLException e) {
        } finally {
            mySQL.Disconnect();
        }

    }

}
