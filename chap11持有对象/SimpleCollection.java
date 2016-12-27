import java.util.*;

public class SimpleCollection {
	public static void main(String[] args) {
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			s.add(i);
		}
		for(Integer i : s) {
			System.out.print(i + ", ");
		}
	}
}