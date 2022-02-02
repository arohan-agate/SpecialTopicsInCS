/*
    # of levels: list.length
    branching factor: 2 -- either you add value or you don't add it
    
    Time Complexity: 2^list.length
    Space Complexity: list.length
    
    List: [10, 20, 30]
                                         0
                                    /          \
                                   10           0
                               /       \     /      \
                              30        10   20      0
                           /    \     /  \  / \      /  \
                          60     30  40  10 50 20    30   0
    
*/



public static int maxSum(List<Integer> list, int limit )
{
	 return dfs(limit, 0, 0, list);
}

private static int dfs(int limit, int partialsum, int index, List<Integer> array)
{
    //base case
    if(index == array.size()) {
        return partialsum;
    }
    
    // gets all possible sums
    int subsum2 = dfs(limit, partialsum,index+1,array);
    
    // checks whether certain sum is greater than current max and less than limit
    if(partialsum+array.get(index)<=limit) {
        subsum2 =Math.max(subsum2,dfs(limit, partialsum+array.get(index),index+1,array));
    }
    return subsum2;
}
