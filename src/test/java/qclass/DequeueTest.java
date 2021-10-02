package qclass;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DequeueTest {
	private Dequeue dq;
    @Before
    public void beforetest()
    {
    	dq=new Dequeue(0);
    }
	@Test
	public void testaddleft() {
		dq=new Dequeue(5);
		for(int i=0;i<5;i++)
		dq.addLeft(i+i);
	}
	@Test
	public void testaddright() {
		dq=new Dequeue(5);
		for(int i=0;i<5;i++)
		dq.addRight(i+2);
	}
	@Test 
	public void compare()
	{
		dq=new Dequeue(10);
		for(int i=0;i<10;i++)
		{
			if (i<5)
				dq.addLeft(i);
			else 
				dq.addRight(i);	
		}
		int []array={0,1,2,3,4,9,8,7,6,5};
		
		for(int i=0;i<10;i++)
			Assert.assertArrayEquals(array,dq.array);
	}
	@Test
	public void testexceptions() 
	{
     Assert.assertNotSame(dq.leftPointer, dq.rightPointer);
	}
	@Test (timeout=2)
	public void assertions()
	{
		Assert.assertNotNull(dq.leftPointer);
		Assert.assertTrue(dq.leftPointer>dq.rightPointer);
		
	}
	@Test
	public void testpointers()
	{
		dq=new Dequeue(10);
		for(int i=0;i<6;i++)
		{
			if (i<5)
				dq.addLeft(i);
			else 
				dq.addRight(i);	
		}
		Assert.assertEquals(4, dq.rightPointer);
	}

}
