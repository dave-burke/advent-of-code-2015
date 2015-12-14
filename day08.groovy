import java.util.regex.*;

String decode(String s){
	s2 = s;
	s2 = s2.replaceAll(~/"(.*)"/, "\$1"); //surrounding quotes
	s2 = s2.replaceAll("\\\\\\\\", "S"); //escaped slashes
	s2 = s2.replaceAll("\\\\\\\"", "Q"); //escaped quotes
	s2 = s2.replaceAll("\\\\x[0-9a-f]{2}", "X"); //escaped ascii
	return s2;
}

String encode(String s){
	s2 = s;
	s2 = s2.replaceAll("\\\\", "\\\\\\\\");
	s2 = s2.replaceAll("\"", "\\\\\"");
	return "\"${s2}\"";
}

List input = [
	"\"\"",
	"\"abc\"",
	"\"aaa\\\"aaa\"",
	"\"\\x27\"",
	//"\"\\xyz\"",
	//"\"\\\\x01\"",
];

input = new File("day8.txt").readLines();

def part1(List input){
	input.each { 
		int c = it.size();
		String d = decode(it);
		int m = d.size();
		println "${it} -> ${d}: ${c} - ${m} = ${c-m}" 
	};
	int diff = input.sum { it.size() - decode(it).size() };
	println "Part1: ${diff}"
	//1401 is too high
	//1392 is too high
}

def part2(List input){
	input.each { 
		String e = encode(it);
		int m = e.size();
		int c = it.size();
		println "${it} -> ${e}: ${m} - ${c} = ${m-c}" 
	};
	int diff = input.sum { encode(it).size() - it.size() };
	println "Part2: ${diff}"
}

part1(input);
part2(input);
