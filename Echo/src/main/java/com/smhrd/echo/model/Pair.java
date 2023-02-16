package com.smhrd.echo.model;

public class Pair implements Comparable<Pair>{     
   double first;
   double second;
   
   public Pair(double first, double second) {    // 생성자
      super();
      this.first = first;
      this.second = second;
   }
   
   // number 기준으로 오름차순
   @Override
   public int compareTo(Pair p) {
      return Double.compare(this.first, p.second);
   }  

}