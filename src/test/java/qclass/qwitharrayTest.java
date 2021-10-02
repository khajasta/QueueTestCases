package qclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class qwitharrayTest {
  
	private qwitharray qwa;
	@Before 
	public void initiate()
	{
		qwa=new qwitharray(0);
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void nullexception() {
		qwa=new qwitharray(-1);
		qwitharray.size=0;
		qwitharray.enqueue(10);
		qwitharray.enqueue(20);
	}
	@Test
	public void testenq()
	{
		qwa=new qwitharray(2);
		qwitharray.enqueue(10);
		qwitharray.enqueue(20);
		Assert.assertEquals(qwitharray.addPointer,qwitharray.array.length-1);
	}
	@Test
	public void equalitycheck()
	{
		int [] array= {1,2,3};
		qwa=new qwitharray(2);
		qwitharray.array[0]=1;
		qwitharray.array[1]=2;
		qwitharray.array[2]=3;
		Assert.assertNotNull(qwitharray.addPointer);
		Assert.assertArrayEquals(array, qwitharray.array);
	}
	@Test
	public void dqcheck()
	{
		int [] array=new int[3];
		qwa=new qwitharray(2);
		qwitharray.array[0]=4;
		qwitharray.array[1]=5;
		qwitharray.array[2]=6;
		array[0]=qwitharray.dequeue();
		array[1]=qwitharray.dequeue();
		array[2]=qwitharray.dequeue();
		Assert.assertNotEquals(array, qwitharray.array);
	}
   @Test(timeout=100)
   public void samecheck()
   {
		qwa=new qwitharray(3);
		qwitharray.array[0]=4;
		qwitharray.array[1]=5;
		qwitharray.array[2]=6;
		//They have same size so they should be same 
		Assert.assertNotSame(3, qwitharray.size);
   }
}
