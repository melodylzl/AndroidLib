package com.byvoid.lib.utils;

import java.util.List;

/**
 * @author melody
 * @date 2018/3/21
 */
public class ListUtils {

    private static <T> boolean isIllegal(List<T> list, int index){
        return list == null || index < 0 || index >= list.size();
    }

    public static <T> boolean isEmpty(List<T> list){
        return list == null || list.isEmpty();
    }

    public static <T> T getItem(List<T> list, int index){
        if (isIllegal(list,index)){
            return null;
        }
        return list.get(index);
    }

    public static <T> T getLastItem(List<T> list){
        if (isEmpty(list)){
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T> boolean removeItem(List<T> list,int index){
        if (isIllegal(list,index)){
            return false;
        }
        list.remove(index);
        return true;
    }

    public static <T> boolean addItem(List<T> list,T t,int index){
        if (isIllegal(list,index)){
            return false;
        }
        list.add(index,t);
        return true;
    }

}
