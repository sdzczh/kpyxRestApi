package com.zh.program.Common.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DrawUtils {
    public static Set<Integer> draw(Integer number, Integer size){
        Random rdom = new Random();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int index = rdom.nextInt(size);
            set.add(index);
            if(set.size() == number){
                break;
            }
        }
        return set;
    }
}
