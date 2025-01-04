import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Activity1 {
	// Initialize a new ArrayList
	static ArrayList<String> list;

	@BeforeEach
	void setUp() {
		list = new ArrayList<String>();
		list.add("alpha"); // at index 0
		list.add("beta"); // at index 1

	}
	@Test
	public void insertTest() {
		assertEquals(2, list.size(), "Wrong size");		
        // Add new element
        list.add(2, "charlie");	
        // Assert with new elements	
        assertEquals(3, list.size(), "Wrong size");
        // Assert individual elements
    	
        assertEquals("alpha", list.get(0), "Wrong element");	
        assertEquals("beta", list.get(1), "Wrong element");	
        assertEquals("charlie", list.get(2), "Wrong element");
	}
    public void replaceTest() {    	
        // Replace new element	
        list.set(1, "charlie");	
        // Assert size of list	
        assertEquals(2, list.size(), "Wrong size");	
        // Assert individual elements	
        assertEquals("alpha", list.get(0), "Wrong element");	
        assertEquals("charlie", list.get(1), "Wrong element");
	
    }
	
}
