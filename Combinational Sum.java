import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
public class CombinationSum {
 
	static void findNumbers(List<Integer> ar, int sum, List<List<Integer>> res, List<Integer> r, int i) {
		// If current sum becomes negative
		if (sum < 0)
			return;
 
		// if we get exact answer
		if (sum == 0) {
			res.add(new ArrayList<Integer>(r));
			return;
		}
 
		// Recur for all remaining elements that
		// have value smaller than sum.
		while (i < ar.size() && sum - ar.get(i) >= 0) {
 
			// Till every element in the array starting
			// from i which can contribute to the sum
			r.add(ar.get(i)); // add them to list
 
			// recur for next numbers
			findNumbers(ar, sum - ar.get(i), res, r, i);
			i++;
 
			// remove number from list (backtracking)
			r.remove(r.size() - 1);
		}
	}
 
	// Returns all combinations of ar[] that have given
	// sum.
	public static List<List<Integer>> combinationSum(List<Integer> ar, int sum) {
		// sort input array
		Collections.sort(ar);
		List<Integer> r = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		findNumbers(ar, sum, res, r, 0);
		return res;
	}
 
	// Driver code
	public static void main(String a[]) {
		Set<Integer> ar = new HashSet<>();
		ar.add(2);
		ar.add(4);
		ar.add(6);
		ar.add(8);
 
		int sum = 8; // set value of sum
		List<List<Integer>> res = combinationSum(new ArrayList<Integer>(ar), sum);
 
		// If result is empty, then
		if (res.size() == 0) {
			System.out.println("Empty");
		}
 
		// Print all combinations stored in res.
		for (int i = 0; i < res.size(); i++) {
			if (res.size() > 0) {
				System.out.print(" ( ");
				List<Integer> ij = res.get(i);
				for (int j = 0; j < ij.size(); j++) {
					System.out.print(ij.get(j) + " ");
				}
				System.out.print(")");
			}
		}
	}
}
