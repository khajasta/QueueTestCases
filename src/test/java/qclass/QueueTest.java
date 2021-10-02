package qclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Exception;


import junit.framework.Assert;



@SuppressWarnings("deprecation")
public class QueueTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	Queue q;
	@Before
	public void setUp() throws Exception {
		q=new Queue(0);
		 System.setOut(new PrintStream(outContent));
		    System.setErr(new PrintStream(errContent));
	}
	@After
	public void restore()
	{
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void Testenq() throws Exception {
		q=new Queue(4);
		for(int i=0;i<4;i++)
		q.enqueue(i+10);	
	}
   @Test
   public void Testdq() throws Exception
   {
	   
		q=new Queue(3);
		for(int i=0;i<3;i++)
		q.enqueue(i+10);
		for(int i=0;i<3;i++)
			q.dequeue();
   }
   
@Test 
   public void compareenq() throws Exception
   {
	   int []array=new int[4];
		for(int i=0;i<4;i++)
			array[i]=i+10;
	   q=new Queue(4);
		for(int i=0;i<4;i++)
		q.enqueue(i+10);
		for(int i=0;i<4;i++)
			Assert.assertEquals(array[i],q.dequeue());
	   
   }
   @Test
   public void Testassert()
   {
	   Assert.assertEquals(q.addPointer, q.removePointer);
   }
   @Test (expected=Exception.class)
   public void exception() throws Exception
   {
	   q.dequeue();
    }
   @Test (expected=Exception.class)
   public void exceptionone() throws  java.lang.Exception 
   {
	   q.enqueue(0);
   }
   @Test
   public void testempty()
   {
	   Assert.assertEquals(true, q.empty());
	   q.sizeofQueue=4;
	   Assert.assertFalse(q.empty());
   }
   @Test
   public void testsize() throws Exception
   {
	   q=new Queue(4);
	   q.enqueue(10);
	   q.enqueue(10);
	   q.enqueue(10);
	  Assert.assertEquals(3,q.size());
   }
   @Test
   public void testdisplay()
   {
	   q.sizeofQueue=0;
	   q.display();			
			assertEquals("Empty Queue.\r\n", outContent.toString());
		
   }
   @Test
   public void testdisplayone() throws Exception
   {
	   q=new Queue(1);
	   q.enqueue(10);
	   String compare=("Inserting : 10\r\n");
	   assertEquals(compare, outContent.toString());
   }
   
    @Test (timeout=5)
    public void testpointerslocation() throws Exception
    {
    	q=new Queue(4);
    	for(int i=0;i<4;i++)
			q.enqueue(i+10);
    	Assert.assertEquals(4,q.addPointer);
    	Assert.assertEquals(0, q.removePointer);
    }
   }


