package com.prahlad.list;
// Implementor of list, acting as one of the player for list 
// Indexed container of elements with contiguous memory allocation
// No Size limit, grows exponentially
// allocated default size and once it filles up , it will double the size 
public class ArrayList implements List {
	private Integer[] list;
	private int size;
	ArrayList(){
		list = new Integer[10];
		size =0;		
	}
	//TC : O(1)
	// Amortized value to 1, because of doubling the size of array when it filled up
	@Override
	public void add(Integer e) {
		if(size == list.length){
			System.out.println("Doubline the size of array");
			Integer[] newArr = new Integer[2*list.length];
			for(int i=0;i<list.length;i++){
				newArr[i] = list[i];
			}
			list = newArr;
		}
		list[size++] = e;
	}
	// TC : O(n)
	@Override
	public void display() {
		for(int i =0;i<list.length;i++){
			System.out.print(list[i] + " ");
		}
	}

}
