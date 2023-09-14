package com.learnautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest 
{
	
	@Test
	public void sample1()
	{
		System.out.println("Hello 1");
	}
	
	@Test
	public void sample2()
	{
		System.out.println("Hello 2");
	}
	
	@Test
	public void sample3()
	{
		System.out.println("Hello 3");
		Assert.assertTrue(true);
	}

}
