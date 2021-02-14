package mvc.step1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
   public void printMap(List<Map<String, Object>> zipList) {
      for(Map<String, Object> rmap: zipList) {
         System.out.println(rmap.get("zipcode") + ", " + rmap.get("address"));
      }
   }
   public List<Map<String, Object>> getZipCodeList(String dong) {
      List<Map<String, Object>> zipList = null;
       zipList = new ArrayList<>();
        Map<String, Object> rMap= new HashMap<>();
        rMap.put("zipcode", 21516);
        rMap.put("address", "����� �������� ���77��");
        zipList.add(rMap);
        rMap= new HashMap<>();
        rMap.put("zipcode", 21517);
        rMap.put("address", "����� �������� ���78��");
        zipList.add(rMap);
        rMap= new HashMap<>();
        rMap.put("zipcode", 21518);
        rMap.put("address", "����� �������� ���79��");
        zipList.add(rMap);
      
       return zipList;
   }
   public static void main(String[] args) {
      List<Map<String, Object>> zipList = new ArrayList<>();
      Map<String,Object> rMap = new HashMap<>();
      rMap.put("zipcode", 21514);
      rMap.put("address", "����� �������� ���5��");
      zipList.add(rMap);
      //Ÿ���� ������ new�� ���� �ۼ��Ͽ����Ƿ� ���ο� �ּҹ����� ������.
      rMap = new HashMap<>();
      rMap.put("zipcode", 21515);
      rMap.put("address", "����� �������� ���6��");
      zipList.add(rMap);
      for(Map<String, Object> rmap :zipList) {
         System.out.println(rmap.get("zipcode") + ", " + rmap.get("address"));
      }
   
   }

}
