/*
   # of levels: n
   branching factor: 2
   
   Time Complexity: 2^n
   Space Complexity: n
*/



public static boolean partitionable(List<Integer> list) 
	{
		return dfs(list,0, 0, 0);
	}


private static boolean dfs(List<Integer> list,int partialsum1,int partialsum2,int index) {
    if(index == list.size()) {
        return partialsum1==partialsum2;
    }
    boolean result = false;
    result = dfs(list,partialsum1+list.get(index), partialsum2,index+1);
    result = dfs(list,partialsum1, partialsum2+list.get(index),index+1);
    return result; 
    }
