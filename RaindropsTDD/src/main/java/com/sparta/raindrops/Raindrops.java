package com.sparta.raindrops;

public class Raindrops {
        public static String plingPlangPlong(Integer i) {
            return new StringBuffer()
                    .append((i % 3 == 0)? "pling" : "")
                    .append((i % 5== 0)? "plang" : "").append((i % 7== 0)? "plong" : "")
                    .append((i%3 >0 && i%5 > 0 && i%7 > 0)? i.toString() : "")
                    .toString();
        }

    }
