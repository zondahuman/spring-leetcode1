package com.abin.lee.algo.lc.hash.table;

import java.util.Objects;

public class MyHashMap<K ,V> {

    private Object[] table;

    public void put(K key, V value){
        int index = hash(key) ;
        table[index] = value ;
    }

    


    public int hash(K key){
        return Objects.hashCode(key);
    }


}
