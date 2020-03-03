package com.hh.gf.springboot.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CompareTo {

    public static void main(String arg[]){
        SimpleDateFormat currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date  date = new Date();
        System.err.println(currentDate.format(date));

        StringBuffer buffer = new StringBuffer("ABC");
        System.err.println(buffer.reverse().toString());

    }
}


