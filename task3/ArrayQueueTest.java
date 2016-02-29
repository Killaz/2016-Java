import java.io.*;
import java.util.Scanner.*;

public class ArrayQueueTest {
    public static void main(String args[]) {
		System.out.printf("\t\tArrayQueue:\n");
    	ArrayQueue q = new ArrayQueue();
    	for (int i = 0; i < 20; i++)
    		q.enqueue(i * 5);
		for (int i = 0; !q.isEmpty(); i++)
			System.out.printf("%2d (%2d): %2d = %2d\n", i, q.size(), q.element(), q.dequeue());

		System.out.printf("\t\tArrayQueueADT:\n");
		ArrayQueueADT qADT = new ArrayQueueADT();
		for (int i = 0; i < 20; i++)
    		ArrayQueueADT.enqueue(qADT, i * 5);
		for (int i = 0; !ArrayQueueADT.isEmpty(qADT); i++)
			System.out.printf("%2d (%2d): %2d = %2d\n", i, ArrayQueueADT.size(qADT), ArrayQueueADT.element(qADT), ArrayQueueADT.dequeue(qADT));
    }
}
