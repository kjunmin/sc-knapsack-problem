import java.util.Scanner;

public class Main {
	
	public static int solve(int[] items, int index, int sum, int cap) {
		//Write Logic below
		if (index > items.length - 1 || cap == 0) {
			return sum;
		}
		
		if (items[index] > cap) {
			return solve(items, index + 1, sum, cap);
		} else {
			int picked = solve(items, index+1, sum+1, cap - items[index]);
			
			int excluded = 0;
			//if item was picked already previously, decrease the sum to prevent double counting
			if (sum > 0) {
				excluded = solve(items, index+1, sum - 1 , cap);
			} else {
				excluded = solve(items, index+1, sum, cap);
			}
			
			return excluded + picked;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] items = new int[num];
		for (int i = 0; i < num; i++) {
			items[i] = sc.nextInt();
		}
		int cap = sc.nextInt();
		
		//int[] items = {3, 2, 7, 6, 5, 4};
		//int cap = 6;
		
		System.out.println(solve(items, 0, 0, cap) + 1);
	}

}
