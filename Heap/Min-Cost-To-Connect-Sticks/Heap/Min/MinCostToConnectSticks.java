/* 
Sample Input 1:
2
3  
2 4 3
4
1 8 3 5 
Sample Output 1:
14
30
Explanation For Sample Input 1:
For the first test case, 
We have sticks of length {2, 4, 3}. First, connect sticks of length 2 and 3 to form a stick of length 5 and which gives a cost of 5. Now we have two sticks of length 5 and 4 each. Now we will connect sticks of length 5 and 4 to form one complete stick of length 9 which gives a cost of 9 and a total cost is 5 + 9 = 14.

For the second test case, 
We have sticks of length {1, 8, 3, 5}. First, connect sticks of length 1 and 3 to form a stick of length 4 and which gives a cost of 4. Now we have sticks of length as {4, 8, 5}. Then connect sticks of length 4 and 5 to form a stick of length 9 and it gives a cost of 9. Now we have sticks of length as {9, 8}. Finally, connect the stick of length 8 and 9 which gives a cost of 17 and a total cost is 4 + 9 + 17= 30.
*/

import java.util.*;

public class MinCostToConnectSticks {

	public static long minimumCostToConnectSticks(ArrayList<Integer> arr) {
	    // Wrtie your code here.
		Queue<Long> pq = new PriorityQueue<>();
		for(int num: arr) pq.add((long)num);

		Long minCost = 0l;
		while(pq.size() > 1){
			Long firstMin = pq.remove();
			Long secondMin = pq.remove();
			Long sum = firstMin + secondMin;
			pq.add(sum);
			minCost += sum;
		}

		return minCost;
	}
}
