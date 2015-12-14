#!groovy

import java.util.regex.*;

def input = [
	"Alice would gain 54 happiness units by sitting next to Bob.",
	"Alice would lose 79 happiness units by sitting next to Carol.",
	"Alice would lose 2 happiness units by sitting next to David.",
	"Bob would gain 83 happiness units by sitting next to Alice.",
	"Bob would lose 7 happiness units by sitting next to Carol.",
	"Bob would lose 63 happiness units by sitting next to David.",
	"Carol would lose 62 happiness units by sitting next to Alice.",
	"Carol would gain 60 happiness units by sitting next to Bob.",
	"Carol would gain 55 happiness units by sitting next to David.",
	"David would gain 46 happiness units by sitting next to Alice.",
	"David would lose 7 happiness units by sitting next to Bob.",
	"David would gain 41 happiness units by sitting next to Carol.",
]

input = new File("day13.txt").collect();

Set people = new HashSet<>();
Map<String, Map<String, Integer>> happyMap = [:].withDefault{ [:] };

input.each {
	Matcher m = it =~ /(\w+) would (gain|lose) (\d+) happiness units by sitting next to (\w+)/;
	if(m){
		String person1 = m.group(1);
		String op = m.group(2);
		Integer value = Integer.valueOf(m.group(3));
		String person2 = m.group(4);

		if(op == "lose") {
			value = value * -1;
		}

		println "${person1} -> ${person2} = ${value}";
		people.addAll([person1, person2]);
		happyMap.get(person1).put(person2, value);
	} else {
		throw new IllegalStateException("${it} couldn't be parsed");
	}
}

//Part 2
String me = "Me";
people.each {
	happyMap.get(it).put(me, 0);
	println "${it} -> ${me} = 0";
	happyMap.get(me).put(it, 0);
	println "${me} -> ${it} = 0";
}
people.add(me);
//end part 2

def max = people.permutations().collect {
	int sum = 0;
	for(int i = 0; i < it.size(); i++){
		String person = it[i];
		String left = i == 0 ? it[it.size() - 1] : it[i-1];
		String right = i == it.size() - 1 ? it[0] : it[i+1];

		Integer leftDelta = happyMap.get(person).get(left);
		Integer rightDelta = happyMap.get(person).get(right);

		sum += leftDelta + rightDelta;

		print " (${leftDelta})${person}(${rightDelta})";
	}
	println " = ${sum}";
	return sum;
}.max();

println max;
