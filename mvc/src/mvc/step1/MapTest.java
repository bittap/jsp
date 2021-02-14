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
        rMap.put("address", "서울시 영등포구 당산77가");
        zipList.add(rMap);
        rMap= new HashMap<>();
        rMap.put("zipcode", 21517);
        rMap.put("address", "서울시 영등포구 당산78가");
        zipList.add(rMap);
        rMap= new HashMap<>();
        rMap.put("zipcode", 21518);
        rMap.put("address", "서울시 영등포구 당산79가");
        zipList.add(rMap);
      
       return zipList;
   }
   public static void main(String[] args) {
      List<Map<String, Object>> zipList = new ArrayList<>();
      Map<String,Object> rMap = new HashMap<>();
      rMap.put("zipcode", 21514);
      rMap.put("address", "서울시 영등포구 당산5가");
      zipList.add(rMap);
      //타입은 같지만 new를 새로 작성하였으므로 새로운 주소번지가 생성됨.
      rMap = new HashMap<>();
      rMap.put("zipcode", 21515);
      rMap.put("address", "서울시 영등포구 당산6가");
      zipList.add(rMap);
      for(Map<String, Object> rmap :zipList) {
         System.out.println(rmap.get("zipcode") + ", " + rmap.get("address"));
      }
   
   }

}
