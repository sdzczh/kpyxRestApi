package com.zh.program.Common.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DrawUtils {
    /**
     * 根据起始数和数量 抽取一定个数的方法
     * @param number  抽取目标数量
     * @param size  个数
     * @param start 起始数
     * @return
     */
    public static Set<Integer> draw(Integer number, Integer size, Integer start){
        Integer rangeR = size + start - 1;
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < size + start; i++) {
            int index = random.nextInt(rangeR) % (rangeR - start + 1) + start;
            set.add(index);
            if(set.size() == number){
                break;
            }
        }
        return set;
    }
}
