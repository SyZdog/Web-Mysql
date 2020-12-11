package cn.tedu.Review;



public class Test_Animal {
	String name;
	public void eat() {
		System.out.println("吃");
	}
}

class Cat extends Test_Animal{
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("小猫喜欢吃小鱼干");
	}
	
}
class Bird extends Test_Animal{

	@Override
	public void eat() {
		System.out.println("小鸟吃小虫子");
	}
	
}