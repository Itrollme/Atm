/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ThuVien {
    public static int getInt(String mes)
        {
        Scanner sc = new Scanner(System.in);
        System.out.println(mes);
        return sc.nextInt();
        }
        public static double getDouble(String mes)
        {
        Scanner sc = new Scanner(System.in);
        System.out.println(mes);
        return sc.nextDouble();
        }
        public static float getFloat(String mes)
        {
        Scanner sc = new Scanner(System.in);
        System.out.println(mes);
        return sc.nextFloat();
        }
        public static String getString(String mes)
        {
        Scanner sc = new Scanner(System.in);
        System.out.println(mes);
        return sc.nextLine();
        }
}
