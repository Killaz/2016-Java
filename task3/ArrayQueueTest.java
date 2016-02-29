import java.io.*;
import java.util.Scanner.*;

public class ArrayQueueTest {
	static int N = 3000;
    public static void main(String args[]) {
/**/
    	ArrayQueue q = new ArrayQueue();
    	for (int i = 0; i < N; i++) {
    		if (((int) Math.random() * 10) % 2 == 0 && !q.isEmpty())
    			q.dequeue();
			else
	    		q.enqueue(i * 5);
			System.out.printf("%d, ", i);
		}
		Object QA[] = q.toArray();
		System.out.printf("\n\t\tArray (len = %d):\n", QA.length);
		for (int i = 0; i < q.size(); i++)
			System.out.println(i + ": "+ QA[i]);
		System.out.printf("\t\tArrayQueue:\n");
		for (int i = 0; !q.isEmpty(); i++)
			System.out.printf("%2d (%2d): %2d = %2d;\n", i, q.size(), q.element(), q.dequeue());
/**//**/
		System.out.printf("\t\tArrayQueueADT:\n");
		ArrayQueueADT qADT = new ArrayQueueADT();
		for (int i = 0; i < N; i++)
    		ArrayQueueADT.enqueue(qADT, i * 5);
		for (int i = 0; !ArrayQueueADT.isEmpty(qADT); i++)
			System.out.printf("%2d (%2d): %2d = %2d\n", i, ArrayQueueADT.size(qADT), ArrayQueueADT.element(qADT), ArrayQueueADT.dequeue(qADT));
/**//**/
		System.out.printf("\t\tArrayQueueModule:\n");
		new ArrayQueueModule();
		for (int i = 0; i < N; i++)
    		ArrayQueueModule.enqueue(i * 5);
		for (int i = 0; !ArrayQueueModule.isEmpty(); i++)
			System.out.printf("%2d (%2d): %2d = %2d\n", i, ArrayQueueModule.size(), ArrayQueueModule.element(), ArrayQueueModule.dequeue());
/**/
    }
}
