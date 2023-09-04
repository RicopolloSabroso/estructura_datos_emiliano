package estructura.cola;

public class CircularQueue {
	private Object[] queue;
	private int size;
	private int front;
	private int rear;
	public CircularQueue(int size) {
		this.size=0;
		this.front=0;
		this.rear=0;
		this.queue= new Object[size];
	}
	public void enqueue(Object value) {
		if(null==queue[rear]) {
			queue[rear]=value;
			rear++;
			size++;
			if(rear==queue.length) {
				rear=0;
			}
		}
	}
	public Object dequeue() {
		Object value=null;
		if(null!=queue[front]) {
			value= queue[front];
			queue[front]=null;
			front++;
			size--;
			if(front==queue.length) {
				front=0;
			}
		}
		return value;
	}
}
