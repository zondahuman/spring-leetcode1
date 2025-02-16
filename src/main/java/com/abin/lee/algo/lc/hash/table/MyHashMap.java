package com.abin.lee.algo.lc.hash.table;

import java.util.Objects;

public class MyHashMap<K ,V> {

    private Object[] table;

    // 增/改，复杂度 O(1)
    public void put(K key, V value){
        int index = hash(key) ;
        table[index] = value ;
    }

    // 查，复杂度 O(1)
    public V get(K key){
        int index = hash(key);
        V value = (V)table[index];
        return value;
    }

    // 删，复杂度 O(1)
    public void remove(K key){
        int index = hash(key);
        table[index] = null;
    }


    // 哈希函数，把 key 转化成 table 中的合法索引
    // 时间复杂度必须是 O(1)，才能保证上述方法的复杂度都是 O(1)
    public int hash(K key){
        return Objects.hashCode(key);
    }


}
