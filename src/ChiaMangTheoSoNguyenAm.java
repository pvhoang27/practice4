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
public class ChiaMangTheoSoNguyenAm {
    public static int countVowels(String s) {
        int cnt = 0;
        String vowels = "ueoaiUEOAI";
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN132", qCode = "e36xPXlT";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService sv = service.getCharacterServicePort();
        
        List<String> a = sv.requestStringArray(studentCode, qCode);
        System.out.println(a);
        
        // xử lý bài toán 
        Map<Integer , List<String>> nhom = new HashMap<>();
        
        for(String word :  a){
            int dem = countVowels(word);
            if(!nhom.containsKey(dem)){
                nhom.put(dem, new ArrayList<>());
            }
            nhom.get(dem).add(word);
        }
        List<String> result = new ArrayList<>();  
        for (List<String> group : nhom.values()) {
            // Sắp xếp các từ theo thứ tự từ điển trong mỗi nhóm
            Collections.sort(group);
            
            // Tạo chuỗi liệt kê cách nhau bởi dấu phẩy
            String joinedString = String.join(", ", group);
            result.add(joinedString);
        }
        sv.submitCharacterStringArray(studentCode, qCode, result);
    }
}
