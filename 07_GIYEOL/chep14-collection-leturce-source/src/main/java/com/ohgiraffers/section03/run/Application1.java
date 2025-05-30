package com.ohgiraffers.section03.run;

import com.ohgiraffers.section01.list.dto.BookDTO;
import com.ohgiraffers.section01.list.dto.PersonDTO;

import java.time.LocalDateTime;
import java.util.*;

public class Application1 {
    public static void main(String[] args) {
        HashMap hmap = new HashMap();

        hmap.put("one",new Date());
        hmap.put(12,"red apple");
        hmap.put(33,123);

        System.out.println(hmap);
        hmap.put(12,"yellow banana");
        System.out.println(hmap); //동일한 키 값으로 다른값을 대입하면 수정한다
        hmap.put(11,"yello banana");
        System.out.println(hmap);

        System.out.println(hmap.get(11));
        System.out.println("==============================================================");
        HashMap<Object, Object> hMap = new HashMap<>();

        hMap.put("one",new Date());
        hMap.put(12,"red apple");
        hMap.put(33,123);

        System.out.println(hMap.get("one"));
        System.out.println(hMap.toString());
        hMap.put(new BookDTO(1,"홍길동전","허균",5000),"허균의 홍길동전임");
        System.out.println("map의 키 값으로 활용되는 객체 이용 : " +
                hMap.get(new BookDTO(1,"홍길동전","허균",5000)));

        System.out.println("map 이 가지고 있는 entry 의 수 : " + hMap.size());
        System.out.println("\"one\"이라는 키값을 가진 요소 삭제 entry 삭제 : " + hMap.remove("one"));
        System.out.println(hMap);

        Map<String, String > hMap2 = new HashMap<>();
        hMap2.put("one","java 17");
        hMap2.put("two","mysql");
        hMap2.put("three","servlet/jsp");
        hMap2.put("four","sprintboot 3.0");
        hMap2.put("five","react.js");

        //1.keySet()을 이용해서 키만 따로 set으로 만들고, iterator()로 키에 대한 목록 만듬
        hMap2.keySet().iterator();
        Iterator<String> key = hMap2.keySet().iterator();
        while (key.hasNext()) {
            String k = key.next();
            String value = hMap2.get(k);
            System.out.println(k + ":" + value);
        }
        //2.저장된 value 객체들만 values()로 collection으로 만듬
        Collection<String> values = hMap2.values();
        Iterator<String> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Object[] array = values.toArray();
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        //Map의 내부클래스인 EntrySet을 이용 : entrySet()
        Set<Map.Entry<String, String>> entries = hMap2.entrySet();
        Iterator<Map.Entry<String, String>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        Map<String,Object>hMap3 = new HashMap<>();
        hMap3.put("book", new BookDTO());
        hMap3.put("person", new PersonDTO());
  //     System.out.println(hMap3.get("book"));
  //     System.out.println(hMap3.get("person"));

        ArrayList<BookDTO> bookDTOList = new ArrayList<>();
        hMap3.put("bList",bookDTOList);
        ArrayList<PersonDTO> personDTOList = new ArrayList<>();
        hMap3.put("pList",personDTOList);
    }
}
