import java.util.*;

class GrannSmith extends Apples {}
class Gala extends Apples {}
class Fuji extends Apples {}
class Braeburn extends Apple{}

public class GenericsAndUpcasting {
	public static void main(String[] args) {
		ArrayLis<Apple> apples = new ArrayLis<Apple>();
		apples.add(new GrannSmith());
		apples.add(new Gala());
		apples.add(new Fuji());
		apples.add(new Braeburn());
		for(Apple c : apples) {
			System.out.println(c);
		}
	}
}