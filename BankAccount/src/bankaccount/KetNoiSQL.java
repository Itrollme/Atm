/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KetNoiSQL {

    private Connection con = null;

    public KetNoiSQL() {
        String url = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:sqlserver://ADMIN:1433;databaseName=Qnganhang;instance=SQLEXPRESS;user=sa;password=123456";
            try {
                con = DriverManager.getConnection(dbUrl);
            } catch (SQLException ex) {
                Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Tracuutaikhoan(int noAccount) throws SQLException {
        String sql = "Select noAccount from Table_1 where noAccount=" + noAccount;
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if (rs.next() == true) {
            System.out.println("Tim thấy tài khoản");
        } else {
            System.out.println("Tim không thấy tài khoản");
        }
    }

    public ResultSet GetResultSet(String tableName) throws SQLException {
        ResultSet rs = null;
        Statement stmt = con.createStatement();
        String sql = "select * from " + tableName;
        rs = stmt.executeQuery(sql);
        return rs;
    }
    NumberFormat df = new DecimalFormat("#,###");
    public void infoAll() throws SQLException {
        
        ResultSet rs = GetResultSet("Table_1");
        System.out.println("THONG TIN TAI KHOAN NGAN HANG");
        while (rs.next()) {
            System.out.print(rs.getString("noAccount"));
            System.out.print("\t - ");
            System.out.print(rs.getString("nameAccount"));
            System.out.print(" - ");
            System.out.println(df.format(Double.parseDouble(rs.getString("moneyAccount"))) + "Vnd");
        }
    }

    public void createAccount() throws SQLException {
        List<NguoiDung> listuser = new ArrayList<NguoiDung>();
        int n = ThuVien.getInt("Nhập số lượng người thêm vào");
        for (int i = 0; i < n; i++) {
            listuser.add(new NguoiDung(ThuVien.getInt("số tài lkhoản: "), ThuVien.getString("Họ tên"), ThuVien.getDouble("số tiền")));
        }
        Statement stmt = con.createStatement();
        String sql = "INSERT INTO Table_1 (noAccount, nameAccount, moneyAccount) VALUES (?, ?, ?);";
        PreparedStatement pstmt = con.prepareStatement(sql);
        for (NguoiDung user : listuser) {
            pstmt.setInt(1, user.getNoAccount());
            pstmt.setString(2, user.getNameAccount());
            pstmt.setDouble(3, user.getMoneyAccount());
            pstmt.execute();
//        for(NguoiDung user: listuser){
//            stmt.executeUpdate("INSERT INTO TABLE_1(noAccount,nameAccount,moneyAccount) VALUES("+user.getNoAccount()+","+user.getNameAccount()+","+user.getMoneyAccount()+"");
//        }
        }

    }
    public double testMoney(int noAccount) throws SQLException{
        double soTien = 0;
        String sql = "Select noAccount,moneyAccount from Table_1 where noAccount=" + noAccount;
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if (rs.next() == true) {
            soTien = Double.parseDouble(rs.getString("moneyAccount"));
        } 
        return soTien;
    }
    public void withdrawMoney(int noAccount, double totalWidthdrawMoney) throws SQLException{
        System.out.println("Số tiền trong tài khoản"+testMoney(noAccount));
        if(totalWidthdrawMoney > testMoney(noAccount)){
            System.out.println("số tiền đã vượt quá số dư trong tài khoản");
            return;
        }
        double soTien= testMoney(noAccount) - totalWidthdrawMoney;
        String sql = "UPDATE Table_1 SET moneyAccount= "+soTien+" where noAccount="+noAccount;
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        System.out.println("Số tiền sau khi rút "+testMoney(noAccount));
    
    }
    public void addMoney(int noAccount, double totalAddMoney) throws SQLException{
        System.out.println("Số tiền trong tai khoản"+  df.format(testMoney(noAccount)));

        double soTien= testMoney(noAccount) + totalAddMoney;
        String sql = "UPDATE Table_1 SET moneyAccount= "+soTien+" where noAccount="+noAccount;
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        System.out.println("Số tiền sau khi rút "+  df.format(testMoney(noAccount)));
    
    }
}