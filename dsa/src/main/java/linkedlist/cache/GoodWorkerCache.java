package linkedlist.cache;
import java.io.*;
import java.util.*;
public class GoodWorkerCache {
    public static void main(String[] args) {
        Cache cache=new MVPCache(10);
        cache.put("1",1);
        cache.put("2",2);
        cache.put("3",3);
        cache.put("3",3);
        cache.put("4",4);
        cache.put("5",5);
        cache.put("6",6);
        cache.put("7",7);
        cache.put("8",8);
        cache.put("9",9);
        cache.put("10",10);
        //cache.print();
        System.out.println(cache.get("1"));
        cache.put("11",11);

        cache.put("12",12);
       // cache.print();
        System.out.println(cache.get("1"));
        System.out.println(cache.get("2"));
        System.out.println(cache.get("11"));
        System.out.println(cache.get("4"));
    }
}
/// debug this why is it not working??????
interface Cache{
    public void put(String key,int value);
    public int get(String key);
    public void print();
}

class MVPCache implements Cache{

    Map<String,Integer> map= new HashMap<>();
    List<String> list = new ArrayList<>();
    int size;

    public MVPCache(int size){
        this.size=size;
    }
    public void put(String key,int value){
        //System.out.println("size"+map.size());
        if(map.size()>=10){
            //remove leaset recently used
            // System.out.println("size"+map.size());
            String storedKey=list.get(0);
            map.remove(storedKey);
            list.remove(storedKey);
        }
        // System.out.println("size"+map.size());
        map.put(key,value);
        list.add(key);
    }
    public int get(String key){
        if(!map.containsKey(key)){
            return -1;
        }
        int value=map.get(key);
        //update the ordering here
        int index=list.indexOf(key);
        list.remove(index);
        list.add(key);
        return value;
    }
    public void print(){
        for(String key:map.keySet()){
            System.out.println(key+" "+map.get(key));
        }
    }
}


/**
 * Linkedin
 * Functional requirement
 *   Connection
 *
 *
 *   A B C
 *
 *
 *
 *   A->B
 *   B->A->C
 *
 *
 *
 *   Connection Table
 *
 *   userId - conection
 *   A    -  B
 *   A    -  C
 *   B    -  A
 *   C    -  C
 *
 * ***/