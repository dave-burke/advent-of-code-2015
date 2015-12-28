import java.util.regex.*;

def input = [
	"H => HO",
	"H => OH",
	"O => HH",
	"",
	"HOH"
];

//Part 2
input = [
	"e => H",
	"e => O",
	"H => HO",
	"H => OH",
	"O => HH",
	"",
	"HOHOHO"
];

input = new File("day19.txt").collect();

def molecule = input[input.size() - 1];
input.remove(input.size() - 1);
input.remove(input.size() - 1);

println input
println molecule

def replacements = input.inject([:].withDefault{[]}) { map, it ->
	Matcher m = it =~ /(\w+) => (\w+)/
	if(m){
		def i = m.group(1);
		def o = m.group(2);
		println "${i} -> ${o}"
		map[i] << o;
		return map;
	} else {
		throw new IllegalStateException("Invalid replacement: ${it}");
	}
};

println replacements;

String replaceNth(String s, String search, String replace, int n){
	//println "Finding the ${n}th instance of ${search} in ${s} and replace it with ${replace}";
	Matcher m = s =~ search;

	int nMatches = m.size();
	m.reset(); //m.size() uses up the matcher

	StringBuffer sb = new StringBuffer(s.size() + (replace.size() - search.size()) );
	for(int i = 0; i < nMatches; i++){
		if(!m){
			//println "No more matches"
			break;
		}
		if(i == n){
			//println "Replacing the ${i}th instance of ${search}"
			m.appendReplacement(sb, replace);
		} else {
			//println "Leaving the ${i}th instance of ${search} alone."
			m.appendReplacement(sb, search);
		}
	}
	m.appendTail(sb);
	return sb.toString();
}

String[] replaceEach(String s, String search, String replace){
	Matcher m = s =~ search;
	def results = [];
	for(int i in (0..m.size())){
		results << replaceNth(s, search, replace, i);
	}
	return results;
}

String[] allReplacements(String s, Map replacements){
	def result = replacements.collect { from, toOptions ->
		return toOptions.collect { to ->
			return replaceEach(s, from, to);
		}
	}.flatten() as Set;
	result.remove(s);
	return result;
}

def result = allReplacements(molecule, replacements);
println "Part 1: ${result.size()}"//: ${result}"

def initPart2 = "e";
def results = [initPart2];
def i = 0;

println results;
while(!results.contains(molecule)){
	def next = results.collect { allReplacements(it, replacements) }.flatten();
	next.removeAll(results);
	results = next;
	//println results;
	i++;
	//if(i == 7) return;
}

println "Part 2: ${i}"

//while(!results.contains(molecule)){
	//results = results.collect { result ->
		//return replacements.collect { from, toArr ->
			//Matcher m = result =~ from;
			//return toArr.collect { to ->
				//def replaced = [];
				//for(int i in (0..m.size())){
					//replaced << replaceNth(result, from, to, i);
				//}
				//return replaced;
			//}.flatten();
		//}.flatten();
	//}.flatten();
	//results = results as Set;
	//results.remove(molecule);
	//count++;
	//println "${count}: ${results}"
//}
//println count;

