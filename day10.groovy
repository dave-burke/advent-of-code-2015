import java.time.*;

String say(String input){
	//println "Saying ${input}"
	int expectedLength = Math.round(input.size() * 1.3035772690342963912570991121) + 1;
	StringBuffer output = new StringBuffer(expectedLength);

	char prev = input.charAt(0);
	int dupCount = 0;
	for(int i = 0; i < input.size(); i++){
		char c = input.charAt(i);
		//println "This char is ${c}"
		if(c == prev){
			dupCount++;
			//println "That makes ${dupCount} ${c}s so far"
		} else {
			//println "That's the first ${c}"
			output.append(dupCount).append(prev);
			dupCount = 1;
		}
		prev = c;
	}
	//println "The last sequence was ${dupCount} ${prev}s"
	output.append(dupCount).append(prev);
	return output.toString();
}

String input = "3113322113";
for(i in 1..50){
	long start = System.nanoTime();
	input = say(input);
	if(i==40) println "Part 1 = ${input.size()}"
	long end = System.nanoTime();
	println "Finished iteration ${i} in ${Duration.ofNanos(end - start)}"
}
println "Part 2 = ${input.size()}";
