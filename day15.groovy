import java.util.regex.*;

class Ingredient {
	String name;
	int capacity;
	int durability;
	int flavor;
	int texture;
	int calories;

	Ingredient(String s){
		Matcher m = s =~ /(\w+): capacity (-?\d+), durability (-?\d+), flavor (-?\d+), texture (-?\d+), calories (-?\d+)/;  
		if(m){
			this.name = m.group(1);
			this.capacity = Integer.valueOf(m.group(2));
			this.durability = Integer.valueOf(m.group(3));
			this.flavor = Integer.valueOf(m.group(4));
			this.texture = Integer.valueOf(m.group(5));
			this.calories = Integer.valueOf(m.group(6));
		} else {
			throw new IllegalArgumentException("${s} is not a valid ingredient spec");
		}
	}

	String toString(){
		return "${name}: ${capacity}c, ${durability}d, ${flavor}f, ${texture}t, ${calories}k";
	}
}

def input = [
	"Frosting: capacity 4, durability -2, flavor 0, texture 0, calories 5",
	"Candy: capacity 0, durability 5, flavor -1, texture 0, calories 8",
	"Butterscotch: capacity -1, durability 0, flavor 5, texture 0, calories 6",
	"Sugar: capacity 0, durability 0, flavor -2, texture 2, calories 1",
];

def ingredients = input.collect { new Ingredient(it) };
int tsp = 100;

int max = 0;
int max5c = 0;
def best = [];
def best5c = [];
for(int i = 1; i <= tsp - 3; i++){
	for(int j = 1; j <= tsp - i - 2; j++){
		for(int k = 1; k <= (tsp - i - j - 1); k++){
			int l = tsp - i - j - k;
			int c = (i * ingredients[0].capacity) + (j * ingredients[1].capacity) + (k * ingredients[2].capacity) + (l * ingredients[3].capacity);
			int d = (i * ingredients[0].durability) + (j * ingredients[1].durability) + (k * ingredients[2].durability) + (l * ingredients[3].durability);
			int f = (i * ingredients[0].flavor) + (j * ingredients[1].flavor) + (k * ingredients[2].flavor) + (l * ingredients[3].flavor);
			int t = (i * ingredients[0].texture) + (j * ingredients[1].texture) + (k * ingredients[2].texture) + (l * ingredients[3].texture);
			c = c < 0 ? 0 : c;
			d = d < 0 ? 0 : d;
			f = f < 0 ? 0 : f;
			t = t < 0 ? 0 : t;
			int score = c * d * f * t;
			print "${'*'*i}|${'*'*j}|${'*'*k}|${'*'*l} = ${score}";
			if(score > max){
				max = score;
				best = [i,j,k,l];
				println " !!!";
			} else {
				println "";
			}

			int cals = (i * ingredients[0].calories) + (j * ingredients[1].calories) + (k * ingredients[2].calories) + (l * ingredients[3].calories);
			if(cals == 500 && score > max5c){
				max5c = score;
				best5c = [i,j,k,l];
			}
		}
	}
}
println "Part 1: ${best} = ${max}"; //[24, 29, 31, 16] = 18965440
println "Part 2: ${best5c} = ${max5c}"; //[21, 23, 31, 25] = 15862900

