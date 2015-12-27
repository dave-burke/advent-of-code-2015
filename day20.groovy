import java.util.concurrent.*;
import java.time.*;

class Producer implements Runnable {
	static final int POISON = -1;
	BlockingQueue q;
	int max;

	Producer(BlockingQueue q, int target){ 
		this.q = q 
		this.max = target / 10; /**/
	}

	void run(){
		try{
			for(int i = 1; i <= max; i++){
				q.put(i);
			}
			q.put(POISON);
		} catch(InterruptedException e){
			println e.message
		}
	}
}

class Consumer implements Callable<Integer> {
	int target;
	final BlockingQueue q;

	Consumer(BlockingQueue q, int target){ 
		this.q = q
		this.target = target;
	}

	Integer call(){
		try {
			while(q.peek() != Producer.POISON){
				int h = -1;
				try {
					h = q.take();
					if(h % 10_000 == 0) {
						println "${h}..."
					}
					if(countPresents(h) >= target){
						println "Found house ${h}"
						return h;
					}
				} catch(InterruptedException inner){
					if(h != -1){
						println "Finishing up checking house ${h}"
						if(countPresents(h) >= target){
							println "Also found house ${h}"
							return h;
						}
					} else {
						throw inner;
					}
				}
			}
		} catch(InterruptedException outer){
			println outer.message
		}
		println "Consumer done."
	}

	int countPresents(int input){
		int nPresents = 0;
		for(int i = 1; i <= input; i++){
			if(input % i == 0){
				nPresents += i;
			}
		}
		nPresents *= 10;
		return nPresents;
	}
}

int input = 33_100_000;
//input = 200;

//This is not the ideal solution, but it was a fun excuse to play with a thread pool.
//This takes a little under a half-hour on my Intel i7.
int proc(int input){
	BlockingQueue q = new ArrayBlockingQueue(1_000);

	List<Callable> workers = [
		new Consumer(q, input),
		new Consumer(q, input),
		new Consumer(q, input),
		new Consumer(q, input),
	];

	Instant start = Instant.now();
	println "Creating executor"
	Executor p = new ThreadPoolExecutor(workers.size(), workers.size(), 1, TimeUnit.SECONDS, new ArrayBlockingQueue(workers.size()));
	println "Starting workers"
	p.execute(new Producer(q, input));
	List<Future> results = p.invokeAll(workers);

	println "Waiting for workers"
	while(results.find { it.done } == null){ }
	println "At least one worker finished!"
	int solution = results.collect{ it.get() }.min();
	results.each{ it.cancel(true) };
	p.shutdown();

	println "Done in ${Duration.between(start, Instant.now())}"
	return solution;
}

//This is a better solution. It takes 2 seconds because you don't have to waste time checking each elf (modulo) to see whether it stops at a given house.
int ideal(int input){
	Instant start = Instant.now();
	int[] houses = new int[input / 10]; //

	for(int e = 1; e <= houses.length; e++){
		for(int h = e - 1; h < houses.length; h+=e){
			houses[h] += (e * 10);
		}
	}
	//println houses;
	for(int i = 0; i < houses.length; i++){
		if(houses[i] >= input){
			println "Done in ${Duration.between(start, Instant.now())}"
			return i + 1;
		}
	}
	return -1;
}
println ideal(input);
println proc(input);
