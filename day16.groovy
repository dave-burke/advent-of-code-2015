import java.util.regex.*;

class Sue {
	Integer id = null;
	Integer children = null;
	Integer cats = null;
	Integer samoyeds = null;
	Integer pomeranians = null;
	Integer akitas = null;
	Integer vizslas = null;
	Integer goldfish = null;
	Integer trees = null;
	Integer cars = null;
	Integer perfumes = null;

	Sue(String s){
		//                      1      2      3      4      5      6      7
		Matcher m = s =~ /Sue (\d+): (\w+): (\d+), (\w+): (\d+), (\w+): (\d+)/;
		if(m){
			this.id = Integer.valueOf(m.group(1));
			this[m.group(2)] = Integer.valueOf(m.group(3));
			this[m.group(4)] = Integer.valueOf(m.group(5));
			this[m.group(6)] = Integer.valueOf(m.group(7));
		} else {
			throw new IllegalArgumentException("${s} is not valid");
		}

	}

	String toString(){
		String s = "${id}: ";
		["children", "cats", "samoyeds", "pomeranians", "akitas", "vizslas", "goldfish", "trees", "cars", "perfumes"].each {
			Integer v = this[it];
			if(v != null){
				s += "${it}: ${v}, "
			}
		}
		return s;
	}
}

def input = new File("day16.txt").collect { new Sue(it) }
print "Part 1: "
input.findAll {
	(it.children == null || it.children == 3) &&
	(it.cats == null || it.cats == 7) &&
	(it.samoyeds == null || it.samoyeds == 2) &&
	(it.pomeranians == null || it.pomeranians == 3) &&
	(it.akitas == null || it.akitas == 0) &&
	(it.vizslas == null || it.vizslas == 0) &&
	(it.goldfish == null || it.goldfish == 5) &&
	(it.trees == null || it.trees == 3) &&
	(it.cars == null || it.cars == 2) &&
	(it.perfumes == null || it.perfumes == 1)
}.each { println it };

print "Part 2: "
input.findAll {
	(it.children == null || it.children == 3) &&
	(it.cats == null || it.cats > 7) &&
	(it.samoyeds == null || it.samoyeds == 2) &&
	(it.pomeranians == null || it.pomeranians < 3) &&
	(it.akitas == null || it.akitas == 0) &&
	(it.vizslas == null || it.vizslas == 0) &&
	(it.goldfish == null || it.goldfish < 5) &&
	(it.trees == null || it.trees > 3) &&
	(it.cars == null || it.cars == 2) &&
	(it.perfumes == null || it.perfumes == 1)
}.each { println it };
