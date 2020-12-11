package cn.tedu.Review;

public class Test_AnimalConfig {

	public static void main(String[] args) {
		// 继承的作用，提高代码复用性
		//继承的特点：单继承：一个子类只能继承一个父类,一个父类可以被多个子类继承
		//不继承：父类私有资源，构造方法
		Cat cat = new Cat();
		System.out.println(cat.name="小猫");
		cat.eat();
		Bird bird = new Bird();
		System.out.println(bird.name="小鸟");
		bird.eat();
	}

}
