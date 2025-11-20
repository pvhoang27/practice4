/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
import vn.medianews.*;
/**
 *
 * @author hoang
 */
public class ChuyenHe10SangHe8va16 {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN017", qCode= "RsNlugQq";
        DataService_Service service = new DataService_Service();
        DataService sv = service.getDataServicePort();
        
        List<Integer> a = sv.getData(studentCode, qCode);
        System.out.println(a);
        List<String> kq = new ArrayList<>();
        String chuoi = "";
        
        for(int x : a ){
            String oc = Integer.toOctalString(x);
            String hex = Integer.toHexString(x).toUpperCase();
            // đừng có nhầm là += nhé
            chuoi =  oc +"|"+hex;
            kq.add(chuoi);
        }
        System.out.println(kq);
        sv.submitDataStringArray(studentCode, qCode, kq);
        
    }
}
