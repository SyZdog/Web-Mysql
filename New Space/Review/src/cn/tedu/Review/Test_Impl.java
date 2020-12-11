package cn.tedu.Review;

public abstract class Test_Impl extends Object implements Test_Interface, Test_Interfdace2 {
	public Test_Impl() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("吃");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("玩");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("跑");
	}

}
