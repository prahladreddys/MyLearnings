package com.develop;

public class Test {
	
	//private int i =j;
	private int j = 10;
	
	public static void main(String[] args) {
		System.out.println("starting..");
		Test t = new Test();
		t.method(null);
		t.aMethod();
		System.out.println("done test");
		recursion obj = new recursion() ;
        System.out.print(obj.func(12));
        
        try{
        	boolean flag = false;
        	if(flag) {
        		while(true){
        			
        		}
        	} else {
        		System.exit(1);
        	}
        } finally{
        	System.out.println("in finally");
        }
        
	}
	
	public  void method(Object sb){
		System.out.println("String buffer");
	}
	public  void method(String s){
		System.out.println("String version");
	}
	public void aMethod(){
		int i = 017;
		System.out.println(i);
	}
}
class recursion {
    int func (int n) {
        int result;
        System.out.println(n);
        if(n==0){
        	System.exit(0);
        }
        result = func (n - 1);
        
        return result;
    }
} 