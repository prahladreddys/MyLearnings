package com.prahlad;

import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try{
        Class<TwoSum> obj = (Class<TwoSum>) Class.forName("com.prahlad.TwoSum");
        Method[] methods = obj.getMethods();
        for(Method m : methods){
        	System.out.println(m.getName());
        }
        } catch(Exception e){
        	e.printStackTrace();
        }
    }
}
