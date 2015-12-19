
int count(int x, int y, boolean[][] b){
	int size = b.size(); //assumes a square board
	int top, bottom, left, right;
	(left, right, top, bottom) = [x-1, x+1, y-1, y+1].collect {
		if(it < 0){
			return 0;
		} else if(it >= size){
			return size - 1;
		} else {
			return it;
		}
	};

	int n = 0;
	for(int i = top; i<=bottom; i++){
		for(int j = left; j<=right; j++){
			if(i == y && j == x){
				continue;
			}
			if(b[i][j]) n++;
		}
	}
	//println "(${x},${y}) has ${n} neighbors between (${top},${left}) and (${bottom},${right})"
	return n;

}

boolean step(int x, int y, boolean[][] b){
	int n = count(x,y,b);
	boolean cur = b[y][x];
	if(cur){
		return n == 2 || n == 3;
	} else {
		return n == 3;
	}
}

boolean[][] step(boolean[][] cur){
	int size = cur.size(); //assumes a square board
	def next = new boolean[size][size];
	for(int y = 0; y<size; y++){
		for(int x = 0; x<size; x++){
			next[y][x] = step(x,y,cur);
		}
	}
	return next;
}

def show(boolean[][] b, int i = 0){
	int size = b.size(); //assumes a square board
	for(int y = 0; y<size; y++){
		for(int x = 0; x<size; x++){
			print b[y][x] ? '#' : '.';
		}
		println "";
	}
	def count = b.flatten().sum { it ? 1 : 0 };
	println "${i}: ${count}"
}

def stick(boolean[][] b){
	//Part 2
	def size = b.size();
	b[0][0] = true;
	b[0][size-1] = true;
	b[size-1][0] = true;
	b[size-1][size-1] = true;
}

b = [
	[0,1,0,1,0,1],
	[0,0,0,1,1,0],
	[1,0,0,0,0,1],
	[0,0,1,0,0,0],
	[1,0,1,0,0,1],
	[1,1,1,1,0,0],
] as boolean[][];

b = new File("day18.txt").collect { line ->
	line.collect { it == '#' }
} as boolean[][];

show(b, 0);
//stick(b);

(0..99).each {
	b = step(b);
	//stick(b);
	show(b, it);
}

