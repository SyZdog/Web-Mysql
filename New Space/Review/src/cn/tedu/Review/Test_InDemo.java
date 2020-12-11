package cn.tedu.Review;

public class Test_InDemo {

	public static void main(String[] args) {
		// 创建多态对象
		//Test_Interface t = new Test_Interface();
		Test_Interface i = new Test_Impl() {
		};
		System.out.println(i.age);
		i.eat();
		i.play();
	}

}
