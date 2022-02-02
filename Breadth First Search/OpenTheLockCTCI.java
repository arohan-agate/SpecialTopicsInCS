class Solution {

    //Time complexity: O(V + E)
    //Space complexity: O(V)
    public int openLock(String[] deadends, String target) {
        
        //Initialize variables
        HashSet<String> visited = new HashSet();
        for(String deadend: deadends) visited.add(deadend);
        Queue<String> queue = new LinkedList();
        queue.add("0000");
        int level = 0;
        
        //Begin BFS
        while(!queue.isEmpty()){
            //Loop through current level
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curr = queue.poll();
                //Check if current combo has been visited or is the target
                if(visited.contains(curr)) continue;
                if(curr.equals(target)) return level;
                //Add rotations of current combo to queue
                for(String rotation: rotations(curr)){
                     queue.add(rotation);
                }
                //Add current combo to visited set
                visited.add(curr);
            }
            //Current level complete
            level++;
        }
        return -1;
    }
    
    //Get the rotations for a combination
    public String[] rotations(String combo){
        String[] ret = new String[8];
        //Rotate each index
        for(int i = 0; i < 4; i++){
            //Increase index
            char[] arr1 = combo.toCharArray();
            if(arr1[i] == '9') arr1[i] = '0';
            else arr1[i]++;
            ret[i] = new String(arr1);
            //Decrease index
            char[] arr2 = combo.toCharArray();
            if(arr2[i] == '0') arr2[i] = '9';
            else arr2[i]--;
            ret[i + 4] = new String(arr2);
        }
        return ret;
    }
}
