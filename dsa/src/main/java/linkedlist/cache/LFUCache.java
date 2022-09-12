package linkedlist.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class LFUCache {


    HashMap<Integer, Integer> map = null;
             //key,count
    HashMap<Integer, Integer> keyCount = new HashMap<>();
             //count,key
    TreeMap<Integer, List<Integer>> countKey = new TreeMap<>();

    int cap = 0;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(map.get(key)==null){
            return -1;
        }
        Integer value=map.get(key);
        if(keyCount.containsKey(key)){
            int count=keyCount.get(key);
            countKey.get(count).remove(key);
            keyCount.put(key,count+1);
            count=count+1;
            if(countKey.get(count)==null){
                List<Integer> list= new ArrayList<>();
                list.add(key);
                countKey.put(count,list);
            }else{
                countKey.get(count).add(key);
            }
        }
        else{
            keyCount.put(key,1);
            if(countKey.get(1)==null){
                List<Integer> list= new ArrayList<>();
                list.add(key);
                countKey.put(1,list);
            }else{
                countKey.get(1).add(key);
            }
        }

        return map.get(key);
    }

    public void put(int key, int value) {
        if(map.size()>cap){
            remove();
        }
        map.put(key,value);
    }

    private void remove() {
        List<Integer> list=new ArrayList<Integer>(countKey.keySet());
        Integer leastFreqKey=countKey.get(list.get(0)).get(0);
        map.remove(leastFreqKey);
        keyCount.remove(leastFreqKey);
        countKey.get(list.get(0)).remove(leastFreqKey);
    }
/*
* ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
    [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
* */
    public static void main(String [] args){
        LFUCache obj = new LFUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));

    }

}