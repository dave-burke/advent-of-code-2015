
def target = 25;
def input = [20, 15, 10, 5, 5];

target = 150; input = [33, 14, 18, 20, 45, 35, 16, 35, 1, 13, 18, 13, 50, 44, 48, 6, 24, 41, 30, 42];

//subsequences only finds truly unique subsequences. For the example, the line below only produces [20,5] once, but there are two 5s which are considered unique.
//println input.subsequences().findAll { it.sum() == target }.size();

def solutions = ((0..input.size() - 1).collect { [it, input[it]] }.subsequences().collect { it.collect { it[1] }}.findAll {it.sum() == target});
println "Part 1: ${solutions.size()}"

def smallest = solutions.min { it.size() }.size();
def smallestSolutions = solutions.findAll { it.size() == smallest };
println "Part 2: Smallest size is ${smallest}. There are ${smallestSolutions.size()} solutions that size."

