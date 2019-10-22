package com.yhm.microserviceclient.ssaln;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Date> resultList = new ArrayList<Date>();
        resultList.add(new Date());
        resultList.add(new Date());
        resultList.add(new Date(12313131));
        Collections.sort(resultList,
                new Comparator<Date>() {
                    @Override
                    public int compare(Date o1,
                                       Date o2) {
                        if ((o1.getTime() - o2.getTime()) > 0) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                });
    }
}
