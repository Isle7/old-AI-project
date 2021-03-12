import java.util.*;
import java.util.Collection;

public class FastBridgeCrossing {

	public static void main(String[] args) {

		int totalTime = 0;

		List<Integer> family = new ArrayList<Integer>();

		System.out.println("How many members does the family have?\n");

		Scanner myInput = new Scanner(System.in);
		int N = myInput.nextInt();

		for (int i = 0; i < N; i++) {
			System.out.println("Enter the time of a family member.");
			family.add(myInput.nextInt());
		}

		Collections.sort(family);

		
		
		
		
		
		
		
		
		if (N == 1) {
			System.out.println("it takes " + family.get(0)+" minutes");
		} else if (N == 2) {
			System.out.println("it takes " + (family.get(0) + family.get(1))+" minutes");
		} else {
			
			int guide1 = family.get(0);
			int guide2 = family.get(1);


			for (int i = 0; i < N - 2; i++) {
				// System.out.println(i);

					//Checks if for the 2 next trips 2 type 2 transfers are better than 1 type 1
				if (N - i - 1 > 2 && (guide1 + (2*(guide2))+family.get(i))<((2*guide1)+family.get(N-1-i)+family.get(N-2-i))){
					
					System.out.println("transfer type: 1");
					
					totalTime += guide2;
					System.out.println("Family members of times " + guide1 + " and " + guide2 + " crossed to the left");
					System.out.println("time passed: " + totalTime);

					totalTime += guide1;
					System.out.println("Family member of time " + guide1 + " crossed back to the right");
					System.out.println("time passed: " + totalTime);

					totalTime += family.get(N - i - 1);
					System.out.println("Family members of times " + family.get(N - i - 1) + " and "
							+ family.get(N - i - 2) + " crossed to the left");
					System.out.println("time passed: " + totalTime);

					totalTime += guide2;
					System.out.println("Family member of time " + guide2 + " crossed back to the right");
					System.out.println("time passed: " + totalTime);
					
					i++;
					
				} else {
					System.out.println("Transfer type: 2");
					//System.out.println("i check " + (N - 1 - i));
					totalTime += family.get(N - i - 1);
					System.out.println("Family members of times " + family.get(N - i - 1) + " and " + guide1
							+ " crossed to the left");
					System.out.println("time passed: " + totalTime);

					totalTime += guide1;
					System.out.println("Family member of time " + guide1 + " crossed back to the right");
					System.out.println("time passed: " + totalTime);

				}
			}

			totalTime += guide2; // τελικό πέρασμα των 2 πιο γρήγορων
			System.out.println("Family members of times " + guide1 + " and " + guide2 + " crossed to the left");
			System.out.println(totalTime);
		}
	}
}

