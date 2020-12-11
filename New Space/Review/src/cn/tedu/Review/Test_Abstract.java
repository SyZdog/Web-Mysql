package cn.tedu.Review;

public class Test_Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个多态对象
		Animal1 a = new Cat11();
		a.eat();
		Dog d =new Dog();
		d.eat();
	}

}
abstract class Animal1{
	public Animal1() {
		// TODO Auto-generated constructor stub
		System.out.println("抽象类的无参构造");
	}
	abstract public void eat();
	public void sleep() {
		
	}
}
class Cat11 extends Animal1{
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Cat.....eat()");
	}
}
class Dog extends Animal1{
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Dog...eat()");
	}
}