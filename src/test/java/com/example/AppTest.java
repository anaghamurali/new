package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static void main(String[] args) {
        String a ="madam";
        AppTest o = new AppTest();
        List<String> l = new ArrayList<>();

        for(int i=0;i<=a.length();i++){
            for(int j=i+1;j<=a.length();j++){
               if(o.isPalin(a.substring(i, j))){
                l.add(a.substring(i,j));
                
               }

            }
        }


l.forEach(s->System.out.println(s));
       

        
    }

    public boolean isPalin(String a){
        String b="";
        for(int i=a.length()-1;i>=0;i--){
            b=b+a.charAt(i);
        }

        if(a.equalsIgnoreCase(b)){
         return true;
        }else
return false;
    }

}
