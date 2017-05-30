package com.develop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class ArraysSort {

	public static void main(String[] args) {
		Dog d1 = new Dog("Max", 2, 50);
		Dog d2 = new Dog("Rocky", 1, 30);
		Dog d3 = new Dog("Bear", 3, 40);
		Dog[] dogArray = {d1,d2,d3};
		printDogs(dogArray);
		
		//sorting
		Arrays.sort(dogArray,new Comparator<Dog>() {

			@Override
			public int compare(Dog o1, Dog o2) {
				return o1.getWeight() - o2.getWeight();
			}
		});
		System.out.println("After sorting");
		printDogs(dogArray);
		
		// sorting in java8 with lambdas expression
		
		Arrays.sort(dogArray,(Dog m, Dog n)-> m.getWeight() - n.getWeight());
		printDogs(dogArray);
		
		// Using Stream API to sort
		
		Stream<Dog> dogStream = Stream.of(dogArray);
		
		Stream<Dog> sortedDogStream = dogStream.sorted((Dog m, Dog n) -> Integer.compare(m.getWeight(), n.getWeight()));
		
		sortedDogStream.forEach(d-> System.out.println(d));
	}
	public static void printDogs(Dog[] dogs) {
		System.out.println("--Dog List--");
		for (Dog d : dogs)
			System.out.print(d);
		System.out.println();
	}
}
class Dog{
	String name;
	int height;
	int weight;
	public Dog(String n, int s, int w) {
		this.name = n;
		this.height = s;
		this.weight = w;
	}
 
	public String toString() {
		return getName() + ": size=" + getHeight() + " weight=" + getWeight()
				+ " \n";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}