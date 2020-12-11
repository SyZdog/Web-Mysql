package cn.tedu.Review;
//这个类用来测试this
public class Test_This {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person();
		p.eat();
		Person p1= new Person("rose");
		
	}

}
class Person{
	int sum = 20;//成员变量
	public void eat() {
		int sum = 10;//局部变量
		System.out.println(sum);//就近原则
		System.out.println(this.sum);//this可以访问成员变量
	}
	public Person() {
		//this("jack");
		System.out.println("这个是无参构造");
	}
	public Person(String name) {
		this();
		System.out.println("含参构造"+name);
	}
}