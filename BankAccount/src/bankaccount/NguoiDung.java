/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

/**
 *
 * @author Admin
 */
public class NguoiDung {
    private int noAccount;
    private String nameAccount;
    private double moneyAccount;
    public NguoiDung(int no,String name,double money){
        noAccount=no;
        nameAccount=name;
        moneyAccount=money;
        
    }
    public int getNoAccount() {
        return noAccount;
    }
    public void setNoAccount(int noAccount) {
        this.noAccount = noAccount;
    }
    public String getNameAccount() {
        return nameAccount;
    }
    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }
    public double getMoneyAccount() {
        return moneyAccount;
    }
    public void setMoneyAccount(double moneyAccount) {
        this.moneyAccount = moneyAccount;
    }  

    @Override
    public String toString() {
        return "KhachHang{" + "noAccount=" + noAccount + ", nameAccount=" + nameAccount + ", moneyAccount=" + moneyAccount + '}';
    }
}
