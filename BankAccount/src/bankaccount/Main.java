/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        KetNoiSQL kn = new KetNoiSQL();
        boolean flag = true;
        do{ 
        System.out.println("NGÂN HÀNG");
        System.out.println("1. Tra cứu tài khoản");
        System.out.println("2. Hiển thị tất cả tài khoản");
        System.out.println("3. Thêm tài khoản");
        int n = ThuVien.getInt("Mời Chọn Việc Cần Làm");
        switch (n) {
            case 1:
                int soTK = ThuVien.getInt("Mời Nhập Số Tài Khoản");
                kn.Tracuutaikhoan(soTK);
                System.out.println("1.Rút tiền");
                System.out.println("2.Thêm tiền");
                int click=ThuVien.getInt("Mời Chọn");
                switch(click){
                    case 1:
                        double soTienCanRut = ThuVien.getDouble("Nhập số tiền cần rút");
                        kn.withdrawMoney(soTK,soTienCanRut);
                        break;
                    case 2:
                        double soTienCanThem = ThuVien.getDouble("Nhập số tiền cần thêm");
                        kn.addMoney(soTK,soTienCanThem);
                }
                break;
            case 2:
                kn.infoAll();
                break;
            case 3:
                kn.createAccount();
                break;
                default:System.out.println("Chọn giá trị sai");
                break;
            }
        }while(flag);
    }
}
