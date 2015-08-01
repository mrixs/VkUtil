package utils;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Mrixs on 01.Aug.2015 18:06
 * Project: vk_util
 * Package: utils
 */
public class MyMath {

    public static double median(List numbers){
        List data = numbers;
        if (data.size()==0){
            return 0;
        }
        java.util.Collections.sort(data);
        if (data.size()% 2 == 1){
           return Double.parseDouble(data.get(data.size() / 2 ).toString());
        }
        else {
            return (Double.parseDouble(data.get(data.size() / 2-1).toString()) + Double.parseDouble(data.get(data.size() / 2 ).toString())) /2;
        }
    }

    public static double medium(List numbers){
        List data = numbers;
        if (data.size()==0){
            return 0;
        }
        Iterator iterator = data.iterator();
        int sum = 0;
        while (iterator.hasNext()){
            sum = sum + Integer.parseInt(iterator.next().toString());
        }
        double result = (((double) sum) / (double)data.size());
        return result;
    }
}
