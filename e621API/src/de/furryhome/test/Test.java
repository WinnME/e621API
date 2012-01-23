package de.furryhome.test;

/**
 * E621 API Wrapper for Java.
 * This is a simple class for testing methods and features (only w.i.p. used).
 *
 * @author Jens Eichler
 * @version 0.0
 */


import de.furryhome.e621api.List;

public class Test {
	private static final int FETCH_COUNT = 10;
	List pl = new List(FETCH_COUNT);
	
	public static void main(String[] args) {
		System.out.println("Tetser Start!");
		
		/*
		Resty a = new Resty();
		
		try {
			XMLResource b = a.xml("http://www.e621.net/post/index.xml");
			System.out.println(b.get("/posts").item(0).getAttributes().item(0).getNodeValue());
			System.out.println(b.get("/posts").item(0).getAttributes().item(1).getNodeValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
}