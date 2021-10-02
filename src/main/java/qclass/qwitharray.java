package qclass;

public class qwitharray {
	
	static int [] array;  //arary to store values.
	static int size;      //number of elements in the queue.
	static int addPointer;//points to position where the latest number is added.
	static int removePointer;//point to position of the number which is to be deleted.
	
	public qwitharray(int size){
		array=new int[size+1];
		this.size=0;
		addPointer=0;
		removePointer=0;
	}

	//function to add elements into the queue.
	static public void enqueue(int number){
		//if queue is full.
		if(addPointer+1==removePointer){
			System.out.println("Queue is Full.");			
			return;
		}
		if(addPointer==array.length-1){
			if(removePointer==0){
				System.out.println("Queue is Full.");
				return;
			}
			else{
				System.out.println("Enqueue num : " + number);
				array[addPointer]=number;
				addPointer=0;	
				size++;
				return;
			}
		}
	
		System.out.println("Enqueue num : " + number);
		array[addPointer]=number;
		addPointer++;
		size++;
	}
	
	//function to remove element. 
	static public int dequeue(){
		//if queue is empty.
		if(removePointer==addPointer){
			System.out.println("Empty Queue.");
			return -1;
		}

		System.out.println("Dequeue Operation.");

		if(removePointer==array.length-1){
			int temp = array[removePointer];
			removePointer=0;
			size--;
			return temp;
		}
		removePointer++;
		size--;
		return array[removePointer-1];
	}

	//function to display queue.
	static public void display(){
		if(size==0){
			System.out.println("Empty Queue.");
			return;
		}
		
		System.out.print("Queue : ") ;
		for(int i=removePointer;i<size+removePointer;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
