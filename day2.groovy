class Present {
    int l;
    int w;
    int h;
    
    Present(int l, int w, int h){
        this.l = l;
        this.w = w;
        this.h = h;
    }
    
    int getFrontArea(){ w*h }
    int getSideArea() { l*h }
    int getTopArea() { l*w }
    
    int getSurfaceArea(){ 2*this.frontArea + 2*this.sideArea + 2*this.topArea }
    
    int getWrappingPaper(){
        return this.surfaceArea + [this.frontArea, this.sideArea, this.topArea].min();
    }
    
    int getFrontPerimiter() { 2*w + 2*h }
    int getSidePerimiter() { 2*l + 2*h }
    int getTopPerimiter() { 2*l + 2*w }
    
    int getBowLength() { l*w*h }
    
    int getRibbonLength(){ [this.frontPerimiter, this.sidePerimiter, this.topPerimiter].min() + this.bowLength }
}

def proc(List<Present> input){
    input.sum { it.wrappingPaper };
}

def proc2(List<Present> input){
    input.sum { it.ribbonLength };
}

List<Present> input = [
    new Present(3, 11, 24), new Present(13, 5, 19), new Present(1, 9, 27), new Present(24, 8, 21), new Present(6, 8, 17), new Present(19, 18, 22), new Present(10, 9, 12), new Present(12, 2, 5), new Present(26, 6, 11), new Present(9, 23, 15), new Present(12, 8, 17),
    new Present(13, 29, 10), new Present(28, 18, 6), new Present(22, 28, 26), new Present(1, 5, 11), new Present(29, 26, 12), new Present(8, 28, 29), new Present(27, 4, 21), new Present(12, 7, 16), new Present(7, 4, 23), new Present(15, 24, 8), new Present(15, 14, 2),
    new Present(11, 6, 29), new Present(28, 19, 9), new Present(10, 3, 1), new Present(5, 20, 13), new Present(10, 25, 1), new Present(22, 17, 7), new Present(16, 29, 3), new Present(18, 22, 8), new Present(18, 11, 19), new Present(21, 24, 20), new Present(4, 7, 17),
    new Present(22, 27, 12), new Present(1, 26, 6), new Present(5, 27, 24), new Present(29, 21, 3), new Present(25, 30, 2), new Present(21, 26, 2), new Present(10, 24, 27), new Present(10, 16, 28), new Present(18, 16, 23), new Present(6, 5, 26), new Present(19, 12, 20),
    new Present(6, 24, 25), new Present(11, 20, 7), new Present(4, 8, 5), new Present(2, 13, 11), new Present(11, 17, 1), new Present(13, 24, 6), new Present(22, 29, 16), new Present(4, 24, 20), new Present(10, 25, 10), new Present(12, 29, 23), new Present(23, 27, 12),
    new Present(11, 21, 9), new Present(13, 2, 6), new Present(15, 30, 2), new Present(8, 26, 24), new Present(24, 7, 30), new Present(22, 22, 8), new Present(29, 27, 8), new Present(28, 23, 27), new Present(13, 16, 14), new Present(9, 28, 20), new Present(21, 4, 30),
    new Present(21, 20, 20), new Present(11, 17, 30), new Present(9, 14, 22), new Present(20, 2, 6), new Present(10, 11, 14), new Present(1, 8, 23), new Present(23, 19, 19), new Present(26, 10, 13), new Present(21, 12, 12), new Present(25, 7, 24), new Present(1, 28, 17),
    new Present(20, 23, 9), new Present(2, 24, 27), new Present(20, 24, 29), new Present(1, 3, 10), new Present(5, 20, 14), new Present(25, 21, 3), new Present(15, 5, 22), new Present(14, 17, 19), new Present(27, 3, 18), new Present(29, 23, 19), new Present(14, 21, 19),
    new Present(20, 8, 3), new Present(22, 27, 12), new Present(24, 15, 18), new Present(9, 10, 19), new Present(29, 25, 28), new Present(14, 22, 6), new Present(4, 19, 28), new Present(4, 24, 14), new Present(17, 19, 17), new Present(7, 19, 29), new Present(28, 8, 26),
    new Present(7, 20, 16), new Present(11, 26, 29), new Present(2, 18, 3), new Present(12, 7, 18), new Present(11, 15, 21), new Present(24, 7, 26), new Present(2, 22, 23), new Present(2, 30, 5), new Present(1, 19, 8), new Present(15, 29, 10), new Present(15, 26, 22),
    new Present(20, 16, 14), new Present(25, 29, 22), new Present(3, 13, 19), new Present(1, 12, 30), new Present(3, 15, 27), new Present(19, 9, 11), new Present(30, 8, 21), new Present(26, 12, 20), new Present(11, 17, 19), new Present(17, 25, 1), new Present(19, 24, 12),
    new Present(30, 6, 20), new Present(11, 19, 18), new Present(18, 15, 29), new Present(18, 8, 9), new Present(25, 15, 5), new Present(15, 6, 26), new Present(13, 27, 19), new Present(23, 24, 12), new Present(3, 15, 28), new Present(17, 10, 10), new Present(15, 4, 7),
    new Present(15, 27, 7), new Present(21, 8, 11), new Present(9, 18, 2), new Present(7, 20, 20), new Present(17, 23, 12), new Present(2, 19, 1), new Present(7, 26, 26), new Present(13, 23, 8), new Present(10, 3, 12), new Present(11, 1, 9), new Present(1, 11, 19),
    new Present(25, 14, 26), new Present(16, 10, 15), new Present(7, 6, 11), new Present(8, 1, 27), new Present(20, 28, 17), new Present(3, 25, 9), new Present(30, 7, 5), new Present(17, 17, 4), new Present(23, 25, 27), new Present(23, 8, 5), new Present(13, 11, 1),
    new Present(15, 10, 21), new Present(22, 16, 1), new Present(12, 15, 28), new Present(27, 18, 26), new Present(25, 18, 5), new Present(21, 3, 27), new Present(15, 25, 5), new Present(29, 27, 19), new Present(11, 10, 12), new Present(22, 16, 21), new Present(11, 8, 18),
    new Present(6, 10, 23), new Present(21, 21, 2), new Present(13, 27, 28), new Present(2, 5, 20), new Present(23, 16, 20), new Present(1, 21, 7), new Present(22, 2, 13), new Present(11, 10, 4), new Present(7, 3, 4), new Present(19, 2, 5), new Present(21, 11, 1),
    new Present(7, 27, 26), new Present(12, 4, 23), new Present(12, 3, 15), new Present(25, 7, 4), new Present(20, 7, 15), new Present(16, 5, 11), new Present(1, 18, 26), new Present(11, 27, 10), new Present(17, 6, 24), new Present(19, 13, 16), new Present(6, 3, 11),
    new Present(4, 19, 18), new Present(16, 15, 15), new Present(1, 11, 17), new Present(19, 11, 29), new Present(18, 19, 1), new Present(1, 25, 7), new Present(8, 22, 14), new Present(15, 6, 19), new Present(5, 30, 18), new Present(30, 24, 22), new Present(11, 16, 2),
    new Present(21, 29, 19), new Present(20, 29, 11), new Present(27, 1, 18), new Present(20, 5, 30), new Present(12, 4, 28), new Present(3, 9, 30), new Present(26, 20, 15), new Present(18, 25, 18), new Present(20, 28, 28), new Present(21, 5, 3), new Present(20, 21, 25),
    new Present(19, 27, 22), new Present(8, 27, 9), new Present(1, 5, 15), new Present(30, 6, 19), new Present(16, 5, 15), new Present(18, 30, 21), new Present(4, 15, 8), new Present(9, 3, 28), new Present(18, 15, 27), new Present(25, 11, 6), new Present(17, 22, 15),
    new Present(18, 12, 18), new Present(14, 30, 30), new Present(1, 7, 23), new Present(27, 21, 12), new Present(15, 7, 18), new Present(16, 17, 24), new Present(11, 12, 19), new Present(18, 15, 21), new Present(6, 18, 15), new Present(2, 21, 4), new Present(12, 9, 14),
    new Present(19, 7, 25), new Present(22, 3, 1), new Present(29, 19, 7), new Present(30, 25, 7), new Present(6, 27, 27), new Present(5, 13, 9), new Present(21, 4, 18), new Present(13, 1, 16), new Present(11, 21, 25), new Present(27, 20, 27), new Present(14, 25, 9),
    new Present(23, 11, 15), new Present(22, 10, 26), new Present(15, 16, 4), new Present(14, 16, 21), new Present(1, 1, 24), new Present(17, 27, 3), new Present(25, 28, 16), new Present(12, 2, 29), new Present(9, 19, 28), new Present(12, 7, 17), new Present(6, 9, 19),
    new Present(15, 14, 24), new Present(25, 21, 23), new Present(26, 27, 25), new Present(7, 18, 13), new Present(15, 10, 6), new Present(22, 28, 2), new Present(15, 2, 14), new Present(3, 24, 18), new Present(30, 22, 7), new Present(18, 27, 17), new Present(29, 18, 7),
    new Present(20, 2, 4), new Present(4, 20, 26), new Present(23, 30, 15), new Present(5, 7, 3), new Present(4, 24, 12), new Present(24, 30, 20), new Present(26, 18, 17), new Present(6, 28, 3), new Present(29, 19, 29), new Present(14, 10, 4), new Present(15, 5, 23),
    new Present(12, 25, 4), new Present(7, 15, 19), new Present(26, 21, 19), new Present(18, 2, 23), new Present(19, 20, 3), new Present(3, 13, 9), new Present(29, 21, 24), new Present(26, 13, 29), new Present(30, 27, 4), new Present(20, 10, 29), new Present(21, 18, 8),
    new Present(7, 26, 10), new Present(29, 16, 21), new Present(22, 5, 11), new Present(17, 15, 2), new Present(7, 29, 5), new Present(6, 18, 15), new Present(23, 6, 14), new Present(10, 30, 14), new Present(26, 6, 16), new Present(24, 13, 25), new Present(17, 29, 20),
    new Present(4, 27, 19), new Present(28, 12, 11), new Present(23, 20, 3), new Present(22, 6, 20), new Present(29, 9, 19), new Present(10, 16, 22), new Present(30, 26, 4), new Present(29, 26, 11), new Present(2, 11, 15), new Present(1, 3, 30), new Present(30, 30, 29),
    new Present(9, 1, 3), new Present(30, 13, 16), new Present(20, 4, 5), new Present(23, 28, 11), new Present(24, 27, 1), new Present(4, 25, 10), new Present(9, 3, 6), new Present(14, 4, 15), new Present(4, 5, 25), new Present(27, 14, 13), new Present(20, 30, 3),
    new Present(28, 15, 25), new Present(5, 19, 2), new Present(10, 24, 29), new Present(29, 30, 18), new Present(30, 1, 25), new Present(7, 7, 15), new Present(1, 13, 16), new Present(23, 18, 4), new Present(1, 28, 8), new Present(24, 11, 8), new Present(22, 26, 19),
    new Present(30, 30, 14), new Present(2, 4, 13), new Present(27, 20, 26), new Present(16, 20, 17), new Present(11, 12, 13), new Present(28, 2, 17), new Present(15, 26, 13), new Present(29, 15, 25), new Present(30, 27, 9), new Present(2, 6, 25), new Present(10, 26, 19),
    new Present(16, 8, 23), new Present(12, 17, 18), new Present(26, 14, 22), new Present(13, 17, 4), new Present(27, 27, 29), new Present(17, 13, 22), new Present(9, 8, 3), new Present(25, 15, 20), new Present(14, 13, 16), new Present(8, 7, 13), new Present(12, 4, 21),
    new Present(27, 16, 15), new Present(6, 14, 5), new Present(28, 29, 17), new Present(23, 17, 25), new Present(10, 27, 28), new Present(1, 28, 21), new Present(18, 2, 30), new Present(25, 30, 16), new Present(25, 21, 7), new Present(2, 3, 4), new Present(9, 6, 13),
    new Present(19, 6, 10), new Present(28, 17, 8), new Present(13, 24, 28), new Present(24, 12, 7), new Present(5, 19, 5), new Present(18, 10, 27), new Present(16, 1, 6), new Present(12, 14, 30), new Present(1, 2, 28), new Present(23, 21, 2), new Present(13, 3, 23),
    new Present(9, 22, 10), new Present(10, 17, 2), new Present(24, 20, 11), new Present(30, 6, 14), new Present(28, 1, 16), new Present(24, 20, 1), new Present(28, 7, 7), new Present(1, 24, 21), new Present(14, 9, 7), new Present(22, 8, 15), new Present(20, 1, 21),
    new Present(6, 3, 7), new Present(7, 26, 14), new Present(5, 7, 28), new Present(5, 4, 4), new Present(15, 7, 28), new Present(30, 16, 23), new Present(7, 26, 2), new Present(1, 2, 30), new Present(24, 28, 20), new Present(5, 17, 28), new Present(4, 15, 20),
    new Present(15, 26, 2), new Present(1, 3, 23), new Present(22, 30, 24), new Present(9, 20, 16), new Present(7, 15, 2), new Present(6, 21, 18), new Present(21, 21, 29), new Present(29, 10, 10), new Present(4, 3, 23), new Present(23, 2, 18), new Present(29, 24, 14),
    new Present(29, 29, 16), new Present(22, 28, 24), new Present(21, 18, 24), new Present(16, 21, 6), new Present(3, 9, 22), new Present(9, 18, 4), new Present(22, 9, 9), new Present(12, 9, 13), new Present(18, 21, 14), new Present(7, 8, 29), new Present(28, 28, 14),
    new Present(1, 6, 24), new Present(11, 11, 3), new Present(8, 28, 6), new Present(11, 16, 10), new Present(9, 16, 16), new Present(6, 6, 19), new Present(21, 5, 12), new Present(15, 17, 12), new Present(3, 6, 29), new Present(19, 1, 26), new Present(10, 30, 25),
    new Present(24, 26, 21), new Present(1, 10, 18), new Present(6, 1, 16), new Present(4, 17, 27), new Present(17, 11, 27), new Present(15, 15, 21), new Present(14, 23, 1), new Present(8, 9, 30), new Present(22, 22, 25), new Present(20, 27, 22), new Present(12, 7, 9),
    new Present(9, 26, 19), new Present(26, 25, 12), new Present(8, 8, 16), new Present(28, 15, 10), new Present(29, 18, 2), new Present(25, 22, 6), new Present(4, 6, 15), new Present(12, 18, 4), new Present(10, 3, 20), new Present(17, 28, 17), new Present(14, 25, 13),
    new Present(14, 10, 3), new Present(14, 5, 10), new Present(7, 7, 22), new Present(21, 2, 14), new Present(1, 21, 5), new Present(27, 29, 1), new Present(6, 20, 4), new Present(7, 19, 23), new Present(28, 19, 27), new Present(3, 9, 18), new Present(13, 17, 17),
    new Present(18, 8, 15), new Present(26, 23, 17), new Present(10, 10, 13), new Present(11, 5, 21), new Present(25, 15, 29), new Present(6, 23, 24), new Present(10, 7, 2), new Present(19, 10, 30), new Present(4, 3, 23), new Present(22, 12, 6), new Present(11, 17, 16),
    new Present(6, 8, 12), new Present(18, 20, 11), new Present(6, 2, 2), new Present(17, 4, 11), new Present(20, 23, 22), new Present(29, 23, 24), new Present(25, 11, 21), new Present(22, 11, 15), new Present(29, 3, 9), new Present(13, 30, 5), new Present(17, 10, 12),
    new Present(10, 30, 8), new Present(21, 16, 17), new Present(1, 5, 26), new Present(22, 15, 16), new Present(27, 7, 11), new Present(16, 8, 18), new Present(29, 9, 7), new Present(25, 4, 17), new Present(10, 21, 25), new Present(2, 19, 21), new Present(29, 11, 16),
    new Present(18, 26, 21), new Present(2, 8, 20), new Present(17, 29, 27), new Present(25, 27, 4), new Present(14, 3, 14), new Present(25, 29, 29), new Present(26, 18, 11), new Present(8, 24, 28), new Present(7, 30, 24), new Present(12, 30, 22), new Present(29, 20, 6),
    new Present(3, 17, 1), new Present(6, 15, 14), new Present(6, 22, 20), new Present(13, 26, 26), new Present(12, 2, 1), new Present(7, 14, 12), new Present(15, 16, 11), new Present(3, 21, 4), new Present(30, 17, 29), new Present(9, 18, 27), new Present(11, 28, 16),
    new Present(22, 3, 25), new Present(18, 15, 15), new Present(2, 30, 12), new Present(3, 27, 22), new Present(10, 8, 8), new Present(26, 16, 14), new Present(15, 2, 29), new Present(12, 10, 7), new Present(21, 20, 15), new Present(2, 15, 25), new Present(4, 14, 13),
    new Present(3, 15, 13), new Present(29, 8, 3), new Present(7, 7, 28), new Present(15, 10, 24), new Present(23, 15, 5), new Present(5, 7, 14), new Present(24, 1, 22), new Present(1, 11, 13), new Present(26, 4, 19), new Present(19, 16, 26), new Present(5, 25, 5),
    new Present(17, 25, 14), new Present(23, 7, 14), new Present(24, 6, 17), new Present(5, 13, 12), new Present(20, 20, 5), new Present(22, 29, 17), new Present(11, 17, 29), new Present(25, 6, 4), new Present(29, 8, 16), new Present(28, 22, 24), new Present(24, 23, 17),
    new Present(16, 17, 4), new Present(17, 8, 25), new Present(22, 9, 13), new Present(24, 4, 8), new Present(18, 10, 20), new Present(21, 23, 21), new Present(13, 14, 12), new Present(23, 26, 4), new Present(4, 10, 29), new Present(2, 18, 18), new Present(19, 5, 21),
    new Present(2, 27, 23), new Present(6, 29, 30), new Present(21, 9, 20), new Present(6, 5, 16), new Present(25, 10, 27), new Present(5, 29, 21), new Present(24, 14, 19), new Present(19, 11, 8), new Present(2, 28, 6), new Present(19, 25, 6), new Present(27, 1, 11),
    new Present(6, 8, 29), new Present(18, 25, 30), new Present(4, 27, 26), new Present(8, 12, 1), new Present(7, 17, 25), new Present(7, 14, 27), new Present(12, 9, 5), new Present(14, 29, 13), new Present(18, 17, 5), new Present(23, 1, 3), new Present(28, 5, 13),
    new Present(3, 2, 26), new Present(3, 7, 11), new Present(1, 8, 7), new Present(12, 5, 4), new Present(2, 30, 21), new Present(16, 30, 11), new Present(3, 26, 4), new Present(16, 9, 4), new Present(11, 9, 22), new Present(23, 5, 6), new Present(13, 20, 3),
    new Present(4, 3, 2), new Present(14, 10, 29), new Present(11, 8, 12), new Present(26, 15, 16), new Present(7, 17, 29), new Present(18, 19, 18), new Present(8, 28, 4), new Present(22, 6, 13), new Present(9, 23, 7), new Present(11, 23, 20), new Present(13, 11, 26),
    new Present(15, 30, 13), new Present(1, 5, 8), new Present(5, 10, 24), new Present(22, 25, 17), new Present(27, 20, 25), new Present(30, 10, 21), new Present(16, 28, 24), new Present(20, 12, 8), new Present(17, 25, 1), new Present(30, 14, 9), new Present(14, 18, 6),
    new Present(8, 28, 29), new Present(12, 18, 29), new Present(9, 7, 18), new Present(6, 12, 25), new Present(20, 13, 24), new Present(22, 3, 12), new Present(5, 23, 22), new Present(8, 10, 17), new Present(7, 23, 5), new Present(10, 26, 27), new Present(14, 26, 19),
    new Present(10, 18, 24), new Present(8, 4, 4), new Present(16, 15, 11), new Present(3, 14, 9), new Present(18, 5, 30), new Present(29, 12, 26), new Present(16, 13, 12), new Present(15, 10, 7), new Present(18, 5, 26), new Present(14, 1, 6), new Present(10, 8, 29),
    new Present(3, 4, 9), new Present(19, 4, 23), new Present(28, 17, 23), new Present(30, 7, 17), new Present(19, 5, 9), new Present(26, 29, 28), new Present(22, 13, 17), new Present(28, 2, 1), new Present(20, 30, 8), new Present(15, 13, 21), new Present(25, 23, 19),
    new Present(27, 23, 1), new Present(4, 6, 23), new Present(29, 29, 24), new Present(5, 18, 7), new Present(4, 6, 30), new Present(17, 15, 2), new Present(27, 4, 2), new Present(25, 24, 14), new Present(28, 8, 30), new Present(24, 29, 5), new Present(14, 30, 14),
    new Present(10, 18, 19), new Present(15, 26, 22), new Present(24, 19, 21), new Present(29, 23, 27), new Present(21, 10, 16), new Present(7, 4, 29), new Present(14, 21, 3), new Present(21, 4, 28), new Present(17, 16, 15), new Present(24, 7, 13), new Present(21, 24, 15),
    new Present(25, 11, 16), new Present(10, 26, 13), new Present(23, 20, 14), new Present(20, 29, 27), new Present(14, 24, 14), new Present(14, 23, 12), new Present(18, 6, 5), new Present(3, 18, 9), new Present(8, 18, 19), new Present(20, 26, 15), new Present(16, 14, 13),
    new Present(30, 16, 3), new Present(17, 13, 4), new Present(15, 19, 30), new Present(20, 3, 8), new Present(13, 4, 5), new Present(12, 10, 15), new Present(8, 23, 26), new Present(16, 8, 15), new Present(22, 8, 11), new Present(12, 11, 18), new Present(28, 3, 30),
    new Present(15, 8, 4), new Present(13, 22, 13), new Present(21, 26, 21), new Present(29, 1, 15), new Present(28, 9, 5), new Present(27, 3, 26), new Present(22, 19, 30), new Present(4, 11, 22), new Present(21, 27, 20), new Present(22, 26, 7), new Present(19, 28, 20),
    new Present(24, 23, 16), new Present(26, 12, 9), new Present(13, 22, 9), new Present(5, 6, 23), new Present(20, 7, 2), new Present(18, 26, 30), new Present(3, 6, 28), new Present(24, 18, 13), new Present(28, 19, 16), new Present(25, 21, 25), new Present(25, 19, 23),
    new Present(22, 29, 10), new Present(29, 19, 30), new Present(4, 7, 27), new Present(5, 12, 28), new Present(8, 26, 6), new Present(14, 14, 25), new Present(17, 17, 2), new Present(5, 27, 11), new Present(8, 2, 2), new Present(3, 20, 24), new Present(26, 10, 9),
    new Present(22, 28, 27), new Present(18, 15, 20), new Present(12, 11, 1), new Present(5, 14, 30), new Present(7, 3, 16), new Present(2, 16, 16), new Present(18, 20, 15), new Present(13, 14, 29), new Present(1, 17, 12), new Present(13, 5, 23), new Present(19, 4, 10),
    new Present(25, 19, 11), new Present(15, 17, 14), new Present(1, 28, 27), new Present(11, 9, 28), new Present(9, 10, 18), new Present(30, 11, 22), new Present(21, 21, 20), new Present(2, 1, 5), new Present(2, 25, 1), new Present(7, 3, 4), new Present(22, 15, 29),
    new Present(21, 28, 15), new Present(12, 12, 4), new Present(21, 30, 6), new Present(15, 10, 7), new Present(10, 14, 6), new Present(21, 26, 18), new Present(14, 25, 6), new Present(9, 7, 11), new Present(22, 3, 1), new Present(1, 16, 27), new Present(1, 14, 23),
    new Present(2, 13, 8), new Present(14, 19, 11), new Present(21, 26, 1), new Present(4, 28, 13), new Present(12, 16, 20), new Present(21, 13, 9), new Present(3, 4, 13), new Present(14, 9, 8), new Present(21, 21, 12), new Present(27, 10, 17), new Present(6, 20, 6),
    new Present(28, 23, 23), new Present(2, 28, 12), new Present(8, 10, 10), new Present(3, 9, 2), new Present(20, 3, 29), new Present(19, 4, 16), new Present(29, 24, 9), new Present(26, 20, 8), new Present(15, 28, 26), new Present(18, 17, 10), new Present(7, 22, 10),
    new Present(20, 15, 9), new Present(6, 10, 8), new Present(7, 26, 21), new Present(8, 8, 16), new Present(15, 6, 29), new Present(22, 30, 11), new Present(18, 25, 8), new Present(6, 21, 20), new Present(7, 23, 25), new Present(8, 25, 26), new Present(11, 25, 27),
    new Present(22, 18, 23), new Present(3, 2, 14), new Present(16, 16, 1), new Present(15, 13, 11), new Present(3, 9, 25), new Present(29, 25, 24), new Present(9, 15, 1), new Present(12, 4, 1), new Present(23, 30, 20), new Present(3, 1, 23), new Present(6, 10, 29),
    new Present(28, 13, 24), new Present(4, 19, 17), new Present(6, 6, 25), new Present(27, 29, 17), new Present(12, 13, 2), new Present(10, 7, 13), new Present(14, 15, 8), new Present(22, 2, 3), new Present(27, 17, 19), new Present(23, 10, 16), new Present(5, 9, 25),
    new Present(9, 25, 14), new Present(11, 18, 6), new Present(18, 10, 12), new Present(9, 4, 15), new Present(7, 16, 14), new Present(17, 24, 10), new Present(11, 4, 6), new Present(12, 9, 17), new Present(22, 18, 12), new Present(6, 24, 24), new Present(6, 22, 23),
    new Present(5, 17, 30), new Present(6, 9, 5), new Present(17, 20, 10), new Present(6, 8, 12), new Present(14, 17, 13), new Present(29, 10, 17), new Present(22, 4, 5), new Present(10, 19, 30), new Present(22, 29, 11), new Present(10, 12, 29), new Present(21, 22, 26),
    new Present(16, 6, 25), new Present(1, 26, 24), new Present(30, 17, 16), new Present(27, 28, 5), new Present(30, 13, 22), new Present(7, 26, 12), new Present(11, 24, 30), new Present(1, 17, 25), new Present(22, 1, 3), new Present(29, 24, 6), new Present(4, 8, 24),
    new Present(13, 9, 20), new Present(8, 12, 9), new Present(21, 25, 4), new Present(23, 23, 28), new Present(5, 2, 19), new Present(29, 3, 15), new Present(22, 1, 14), new Present(3, 23, 30), new Present(8, 25, 3), new Present(15, 8, 14), new Present(30, 14, 6),
    new Present(23, 27, 24), new Present(19, 1, 2), new Present(10, 9, 13), new Present(13, 8, 7), new Present(8, 13, 22), new Present(5, 15, 20), new Present(17, 14, 8), new Present(5, 11, 20), new Present(5, 10, 27), new Present(24, 17, 19), new Present(21, 2, 3),
    new Present(15, 30, 26), new Present(21, 19, 15), new Present(2, 7, 23), new Present(13, 17, 25), new Present(30, 15, 19), new Present(26, 4, 10), new Present(2, 25, 8), new Present(9, 9, 10), new Present(2, 25, 8), new Present(19, 21, 30), new Present(17, 26, 12),
    new Present(7, 5, 10), new Present(2, 22, 14), new Present(10, 17, 30), new Present(1, 8, 5), new Present(23, 2, 25), new Present(22, 29, 8), new Present(13, 26, 1), new Present(26, 3, 30), new Present(25, 17, 8), new Present(25, 18, 26), new Present(26, 19, 15),
    new Present(8, 28, 10), new Present(12, 16, 29), new Present(30, 6, 29), new Present(28, 19, 4), new Present(27, 26, 18), new Present(15, 23, 17), new Present(5, 21, 30), new Present(8, 11, 13), new Present(2, 26, 7), new Present(19, 9, 24), new Present(3, 22, 23),
    new Present(6, 7, 18), new Present(4, 26, 30), new Present(13, 25, 20), new Present(17, 3, 15), new Present(8, 20, 18), new Present(23, 18, 23), new Present(28, 23, 9), new Present(16, 3, 4), new Present(1, 29, 14), new Present(20, 26, 22), new Present(3, 2, 22),
    new Present(23, 8, 17), new Present(19, 5, 17), new Present(21, 18, 20), new Present(17, 21, 8), new Present(30, 28, 1), new Present(29, 19, 23), new Present(12, 12, 11), new Present(24, 18, 7), new Present(21, 18, 14), new Present(14, 26, 25), new Present(9, 11, 3),
    new Present(10, 7, 15), new Present(27, 6, 28), new Present(14, 26, 4), new Present(28, 4, 1), new Present(22, 25, 29), new Present(6, 26, 6), new Present(1, 3, 13), new Present(26, 22, 12), new Present(6, 21, 26), new Present(23, 4, 27), new Present(26, 13, 24),
    new Present(5, 24, 28), new Present(22, 16, 7), new Present(3, 27, 24), new Present(19, 28, 2), new Present(11, 13, 9), new Present(29, 16, 22), new Present(30, 10, 24), new Present(14, 14, 22), new Present(22, 23, 16), new Present(14, 8, 3), new Present(20, 5, 14),
    new Present(28, 6, 13), new Present(3, 15, 25), new Present(4, 12, 22), new Present(15, 12, 25), new Present(10, 11, 24), new Present(7, 7, 6), new Present(8, 11, 9), new Present(21, 10, 29), new Present(23, 28, 30), new Present(8, 29, 26), new Present(16, 27, 11),
    new Present(1, 10, 2), new Present(24, 20, 16), new Present(7, 12, 28), new Present(28, 8, 20), new Present(14, 10, 30), new Present(1, 19, 6), new Present(4, 12, 20), new Present(18, 2, 7), new Present(24, 18, 17), new Present(16, 11, 10), new Present(1, 12, 22),
    new Present(30, 16, 28), new Present(18, 12, 11), new Present(28, 9, 8), new Present(23, 6, 17), new Present(10, 3, 11), new Present(5, 12, 8), new Present(22, 2, 23), new Present(9, 19, 14), new Present(15, 28, 13), new Present(27, 20, 23), new Present(19, 16, 12),
    new Present(19, 30, 15), new Present(8, 17, 4), new Present(10, 22, 18), new Present(13, 22, 4), new Present(3, 12, 19), new Present(22, 16, 23), new Present(11, 8, 19), new Present(8, 11, 6), new Present(7, 14, 7), new Present(29, 17, 29), new Present(21, 8, 12),
    new Present(21, 9, 11), new Present(20, 1, 27), new Present(1, 22, 11), new Present(5, 28, 4), new Present(26, 7, 26), new Present(30, 12, 18), new Present(29, 11, 20), new Present(3, 12, 15), new Present(24, 25, 17), new Present(14, 6, 11)
];

println proc(input);
println proc2(input);
