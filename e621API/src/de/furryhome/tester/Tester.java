package de.furryhome.tester;

import de.furryhome.e621api.List;

public class Tester {
	private static final int FETCH_COUNT = 10;
	List pl = new List(1, FETCH_COUNT);
	
	public static void main(String[] args) {
		System.out.println("Tetser Start!");
	}
}
