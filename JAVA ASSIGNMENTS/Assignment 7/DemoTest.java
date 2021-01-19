package com;

import java.util.Arrays;
import java.util.Collections;
public class DemoTest
{
   public static void main(String[] args) 
   {
      String[] names = new String[4];
      names[0] = "RAJ";
      names[1] = "ravi";
      names[2] = "AkaSh";
      names[3] = "Ajay";
      
      Arrays.sort(names);
      Arrays.sort(names, String.CASE_INSENSITIVE_ORDER);
      System.out.println("CASE INSENSITIVE ASC ORDER : ");
      System.out.println(Arrays.toString(names));
      
      System.out.println("\n");
      
      Arrays.sort(names, Collections.reverseOrder());
      System.out.println("CASE INSENSITIVE DESC ORDER : ");
      System.out.println(Arrays.toString(names));
   }
}