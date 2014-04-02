package Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws JSONException {
        System.out.println("------convert Map to JSON string--------------------");
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("Name", "HandsomeBoy");
        map1.put("Price", 2000);
        map1.put("Author", "Alvin");

        JSONObject json_map1 = new JSONObject(map1);
        json_map1.put("Publisher", "Gotop");
        String json_map1_string = json_map1.toString();
        System.out.println("json_map1_string:" + json_map1_string);

        System.out.println("------convert JSON string to Map--------------------");
        JSONObject json2map = new JSONObject(json_map1_string);
        Map<String, Object> map2 = new HashMap<String, Object>();
        String[] keys = json2map.getNames(json2map);
        for (String key : keys) {
            map2.put(key, json2map.get(key));
            System.out.println("key=" + key + ",json2map.get(key)=" + json2map.get(key));
        }
        System.out.println("map2=" + map2);

        // convert Object to JSON string
        System.out.println("------convert Object to JSON string--------------------");
        Book book1 = new Book("Android", 500, "Susan");
        JSONObject obj2json = new JSONObject(book1);
        String obj2json_string = obj2json.toString();
        System.out.println(obj2json_string);

        // convert JSON string to Object
        System.out.println("------convert JSON string to Object--------------------");
        JSONObject jsonString2Object = new JSONObject(obj2json_string);
        String name = jsonString2Object.getString("name");
        //��JSON���X��쬰name��Value�A�`�N���W�٤j�p�g�A��������O�ܼƩR�W�@�P
        double price = jsonString2Object.getDouble("price");
        //��JSON���X��쬰price��Value�A�`�N���W�٤j�p�g�A��������O�ܼƩR�W�@�P
        String author = jsonString2Object.getString("author");
        //��JSON���X��쬰author��Value�A�`�N���W�٤j�p�g�A��������O�ܼƩR�W�@�P
        Book book2 = new Book(name, price, author);
        //���ͦW��book2��Book����A�è̷Ө�W�w����Ʈ榡�ǤJ���X���ѼơA�`�N���W�٤j�p�g�A��������O�ܼƩR�W�@�P
        book2.show();

        // convert List/array to JSONArray string
        System.out.println("------convert List/array to JSONArray string--------------------");
        ArrayList<Object> list1 = new ArrayList<Object>(); //�إ�ArrayList����
        list1.add("Java Book");
        list1.add(600);
        list1.add("John");
        JSONArray jsonArray_list1 = new JSONArray(list1);
        jsonArray_list1.put("Gotop");
        String jsonArray_list1_string = jsonArray_list1.toString();
        System.out.println("jsonArray_list1_string:" + jsonArray_list1_string);

        // convert JSONArray string to List/array
        System.out.println("------convert JSONArray string to List/array--------------------");
        ArrayList<Object> list2 = new ArrayList<Object>();
        JSONArray jsonArray_list2 = new JSONArray(jsonArray_list1_string);
        for (int i = 0; i < jsonArray_list2.length(); i++) {
            list2.add(jsonArray_list2.get(i));
        }
        System.out.println("list2:"+list2);

    }
}
