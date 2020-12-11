package cn.tedu.Review;

public class Test_Static {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.name);
		s.study();
		System.out.println(Student.name);
		Student.study();
	}
}
class Student{
	static String name; 
	static public void study() {
		//静态资源不能获获取普通资源
		//System.out.println(age);
		System.out.println("好好学习");
	}
	int age;
	public void eat() {
		//普通资源中可以获取静态资源
		System.out.println(name);
		System.out.println("好好吃饭");
	}
	
}