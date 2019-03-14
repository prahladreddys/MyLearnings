package com.prahlad;
/**
 * Immutable class is one whose state can not be changed once created.
 * Benefits:
 * 1. are simple to construct 
 * 2. automatically thread safe and have no synchronization issues
 * do not need a copy constructor
 * do not need a clone implementation
 * hash code to use lazy initialization 
 * always failure atomicity : If an Immutable object throws an exception whose state never left in an undesirable or indeterminate state
 * 
 * 
 * Guidlines:
 * 1. never provide setter methods
 * 2. make all fields final and private
 * 3. Dont allow subclass to override
 * 4.  
 * 
 * @author CipherCloud
 *
 */
public final class ImmutableClass {
	private final Integer i;
	private final String s;
	
	private ImmutableClass(Integer i , String s){
		this.i = i;
		this.s = s;
	}
	
	public static ImmutableClass createInstance(Integer i , String s){
		return new ImmutableClass(i,s);
	}
	
	public Integer getInteger(){
		return i;
	}
	public String getString(){
		return s;
	}
	@Override
	public String toString(){
			return "Inter"+i+"\tString:"+s;
	}
}
