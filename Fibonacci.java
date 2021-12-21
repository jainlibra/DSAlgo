import java.util.List;
import java.util.ArrayList;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>fibonacciList = new ArrayList<>();
		fibonacciList.add(0);//0th element is 0
		fibonacciList.add(1);//1st element  is 1
		int nthFibonacciNumber = 4;//find the 20th FibonacciNumber
		
		for(int i=2;i<=nthFibonacciNumber;i++) {
			fibonacciList.add(i,fibonacciList.get(i-1)+fibonacciList.get(i-2));
		}
		
		System.out.println(fibonacciList.get(nthFibonacciNumber));
	}

}
