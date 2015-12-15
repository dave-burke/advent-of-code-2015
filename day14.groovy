import java.util.regex.*;

class Reindeer {
	String name;
	int speed;
	int stamina;
	int recovery;
	boolean flying;
	int position;

	int maxStamina;
	int maxRecovery;
	int points;

	Reindeer(String name, int speed, int stamina, int recovery){
		this.points = 0;
		this.name = name;
		this.speed = speed;
		this.maxStamina = stamina;
		this.maxRecovery = recovery;

		this.flying = true;
		this.position = 0;
		this.stamina = stamina;
		this.recovery = recovery;
	}

	def step(){
		if(flying){
			this.position += this.speed;
			this.stamina--;
			if(this.stamina == 0){
				println "${name} stopped flying at ${position}"
				this.flying = false;
				this.recovery = 0;
			}
		} else {
			this.recovery++;
			if(this.recovery == this.maxRecovery){
				println "${name} started flying"
				this.flying = true;
				this.stamina = this.maxStamina;
			}
		}
	}

}

def raceTime = 1000;
def input = [
	"Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.",
	"Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds."
];

input = new File("day14.txt").collect(); raceTime = 2503;

def reindeer = input.collect {
	Matcher m = it =~ /(\w+) can fly (\d+) km\/s for (\d+) seconds, but then must rest for (\d+) seconds\./;
	if(m){
		String name = m.group(1);
		int speed = Integer.valueOf(m.group(2));
		int stamina = Integer.valueOf(m.group(3));
		int recovery = Integer.valueOf(m.group(4));
		println "${name} can fly ${speed} for ${stamina}, then rests for ${recovery}."
		return new Reindeer(name, speed, stamina, recovery);
	} else {
		throw new IllegalStateException("Couldn't parse ${it}");
	}
}

for(int i in 1..(raceTime)){
	print "${i}.";
	reindeer.each { it.step() };
	def maxPos = reindeer.collect{it.position}.max();
	reindeer.findAll{it.position == maxPos}.each { it.points++ };

	//Part 1:
	print "Position: ";
	reindeer.sort{ it.position }.reverse().each { print "${it.name}: ${it.position}, " };

	//Part 2:
	print "Points: ";
	reindeer.sort{ it.points}.reverse().each { print "${it.name}: ${it.points}, " };
	println "";
}

