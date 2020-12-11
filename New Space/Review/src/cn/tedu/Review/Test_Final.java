package cn.tedu.Review;

public class Test_Final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		son s = new son();
		//son.name="小红";(static String name;)
		//System.out.println(s.name);
		s.eat();
	}

}
//final class Father{特点1：被final修饰后不能被继承
class Father{
	//特点3：被final修饰后的类不可以修改，也就是从变成常量
	//final String name;
	//final public void eat() {特点2：被final修饰后的方法不能被重写
	String name;
	public void eat() {
		System.out.println("Father...eat()");
	}
}
class son extends Father{

	@Override
	public void eat() {
		System.out.println("Zi...eat()");
	}
	
}