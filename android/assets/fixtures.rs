body base = getBody ("lad");


for (uint i = 0 ; i < 20 ; i ++){
	fixture f = base.getFixture(0);
	f = duplicate (f);
    translate(f, 1.2,0.001);
	rotate(f, 0,  0.001);


}