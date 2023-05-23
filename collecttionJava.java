import java.util.*;
public class collecttionJava {
    public static void main (String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("C");

        list.add("Java");
        list.add("Kotlin");
        list.add("Golang");
        list.add("JavaScript");
        list.addAll(list2);
        System.out.println(list);

        HashMap<String,Object> map = new HashMap<String,Object>();
        List<HashMap<String,Object>> result = new ArrayList<>();


        map.put("id", "789");
        map.put("name", "Sevasit");
        map.put("loc", "bangkok");
        result.add(map);

        map = new HashMap<String,Object>();
        map.put("id", "987");
        map.put("name", "Pluem");
        map.put("loc", "Udon");
        result.add(map);
        // System.out.println(result);

        for (HashMap<String,Object> hashMap : result) {
            System.out.println("id: " + hashMap.get("id"));
            System.out.println("name: " + hashMap.get("name"));
            System.out.println("loc: " + hashMap.get("loc"));
            System.out.println(">>>>>>>>>>>>>>>>>>>");
        }

        // System.out.println();
        // System.out.println("**************************************");
        // System.out.println();

        // for(int i = 0; i < result.size(); i++){
        //     System.out.println("id: " + result.get(i).get("id"));
        //     System.out.println("name: " + result.get(i).get("name"));
        //     System.out.println("loc: " + result.get(i).get("loc"));
        //     System.out.println(">>>>>>>>>>>>>>>>>>>");
        // }


        // String numStr = null;
        // Integer num = Integer.valueOf(numStr);
        // Float flotNum = Float.valueOf(num);
        // System.out.println(flotNum);
    }

}
