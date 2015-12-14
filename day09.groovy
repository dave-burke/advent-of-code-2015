import java.util.regex.*;

List input = [
	"London to Dublin = 464",
	"London to Belfast = 518",
	"Dublin to Belfast = 141",
];

input = new File("day9.txt").readLines();

def part1(List input){
	Set<String> cities = new HashSet<>();
	Map<String, Map<String, Integer>> distances = new HashMap<>();
	input.each {
		//CITY to CITY = n
		Matcher m = (it =~ /(\w+) to (\w+) = (\d+)/);
		if(m){
			String city1 = m.group(1);
			String city2 = m.group(2);
			Integer distance = Integer.valueOf(m.group(3));
			cities.addAll([city1, city2]);

			distances.merge(city1, [(city2): distance]) { map, newEntries -> map.putAll(newEntries); map; };
			distances.merge(city2, [(city1): distance]) { map, newEntries -> map.putAll(newEntries); map; };
		} else {
			throw new IllegalStateException("${s} is not a valid line");
		}
	}
	//println cities;
	println distances;
	println cities.permutations { p ->
		print "${p} = ";
		Integer sum = 0;
		for(int i = 0; i < p.size() - 1; i++){
			String city1 = p[i];
			String city2 = p[i+1];
			Integer distance = distances[city1][city2];
			if(i != 0) print " + ";
			print "${distance}"
			sum += distance;
		}
		println " = ${sum}";
		return sum;
	//}.min(); //part1
	}.max(); //part2
}

part1(input);
