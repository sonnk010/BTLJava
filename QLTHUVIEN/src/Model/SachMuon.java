/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author son30
 */
public class SachMuon extends Sach {

    private int soLuong;

    public SachMuon() {
    }

    public SachMuon(String maSach, String tenSach, String maTacGia, String maNxb, float giaSach, String theLoai) {
        super(maSach, tenSach, maTacGia, maNxb, giaSach, theLoai);
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
