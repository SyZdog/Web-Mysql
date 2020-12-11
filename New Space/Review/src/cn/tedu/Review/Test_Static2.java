package cn.tedu.Review;

public class Test_Static2 {
//执行顺序：静态，构造代码块，构造方法，局部
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person1 p = new Person1();
		p.eat();
	}

}
class Person1{
	static {
		System.out.println("静态代码块");
	}
	public Person1() {
		System.out.println("构造方法");
	}
	{
		System.out.println("构造代码块");
	}
	public void eat() {
		{
			System.out.println("局部代码块");
		}
	}
}