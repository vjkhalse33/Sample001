package com.fd.springbootprojects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class StringHelper1Test {

	
	
	@Mock
	IService service;
	@InjectMocks
	StringHelper1 obj;
	
	@Before
	public void setup()
	{
		  MockitoAnnotations.initMocks(this);
		obj=new StringHelper1(service);	
     

	}

	
	@Test
	public void testSwapLast2CharsWithLength4() {	
		assertEquals("A12B",obj.swapLast2Chars("A1B2"));
	}
	
	@Test
	public void testSwapLast2CharsWithLength1() {
		assertEquals("A",obj.swapLast2Chars("A"));
	}
	@Test
	public void testSwapLast2CharsWithLength2() {
			assertEquals("AB",obj.swapLast2Chars("BA"));
	
	}
	@Test
	public void testSwapLast2CharsWithLength0() {
		assertEquals("",obj.swapLast2Chars(""));
		
	}
	
	@Test
	public void testRemoveAIfPresentInFirstTwoChar1() {
		
		 String str="AaBAA"; 
		 String str1="BAA";
		 when(service.StringHelperService(str)).thenReturn(str1);
		assertEquals(str1,obj.removeAFromFirstTwo(str));
		//verify(service.StringHelperService(str));
		
	}
	/*
	 * @Test public void testRemoveAIfPresentInFirstTwoChar2() {
	 * 
	 * assertEquals("",obj.removeAFromFirstTwo("AA"));
	 * 
	 * }
	 * 
	 * @Test public void testRemoveAIfPresentInFirstTwoChar3() {
	 * assertEquals("b",obj.removeAFromFirstTwo("ab"));
	 * 
	 * }
	 * 
	 * @Test public void testRemoveAIfPresentInFirstTwoChar() {
	 * assertEquals("",obj.removeAFromFirstTwo(""));
	 * 
	 * }
	 * 
	 * 
	 */
}
