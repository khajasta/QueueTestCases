package qclass;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class qlinkedlistTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@SuppressWarnings("unused")
	private final PrintStream originalOut = System.out;
	@SuppressWarnings("unused")
	private final PrintStream originalErr = System.err;
	@Before
	public void setUp() throws Exception {
		 System.setOut(new PrintStream(outContent));
		    System.setErr(new PrintStream(errContent));
	}
	
	@Test
	public void testenq() {
		qlinkedlist.enqueue(10);
		qlinkedlist.enqueue(20);
		qlinkedlist.enqueue(30);
	}
	@Test 
	public void deq()
	{
		
		Assert.assertEquals(10,qlinkedlist.dequeue() );
		Assert.assertEquals(20,qlinkedlist.dequeue() );
		Assert.assertEquals(30,qlinkedlist.dequeue() );
	}
	@Test(timeout=2)
	public void checksize()
	{
		Assert.assertEquals(0, qlinkedlist.size);
		qlinkedlist.enqueue(10);
		qlinkedlist.enqueue(20);
		qlinkedlist.enqueue(30);
		Assert.assertEquals(3, qlinkedlist.size);
	}
   @Test
   public void displaycheck()
   {
	   qlinkedlist.display();			
	   String compare="Queue : 10 20 30 \r\n";
		assertEquals(compare, outContent.toString());
   }
   @Test(expected=NullPointerException.class)
   public void nullexception()
   {
	   int i=0;
	   qlinkedlist.Node  node=qlinkedlist.head;
	   while(i<10)
	   {
		   node=node.next;
	   }
		   
   }
   @Test
   public void assertions()
   {
	   Assert.assertNotNull(qlinkedlist.head);
	   Assert.assertFalse(qlinkedlist.size<3);
   }
}
