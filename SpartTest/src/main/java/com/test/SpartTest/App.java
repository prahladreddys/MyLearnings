package com.test.SpartTest;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SparkSession spark = SparkSession.builder().appName("SparkApp").config("spark.master","local").getOrCreate();
        Dataset<String> textFile = spark.read().textFile(args[0]);
        
        System.out.println("No of lines : "+ textFile.count());
        spark.stop();
        
    }
}
