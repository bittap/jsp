package mvc.step1;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class ZipListDemo {
	List<Map<String, Object>> zipList = null;
	
	public void toJson() {
		System.out.println(zipList.size());
		Gson g = new Gson();
		String result = g.toJson(g);
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		ZipListDemo zld = new ZipListDemo();
	    MapTest mt = new MapTest();
	    zld.zipList = mt.getZipCodeList("´ç»ê");
	    mt.printMap(zld.zipList);
	    zld.toJson();
	}

}
