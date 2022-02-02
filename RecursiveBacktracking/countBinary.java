/* # of levels: n
   branching factor: 2
   
   Time Complexity: 2^n
   Space Complexity: n
   
                              ''
                         /           \
                         0            1
                     /       \     /      \ 
                    0         1    0       1

*/
public static void countBinary(int n) {
    StringBuilder sb = new StringBuilder();
    dfs(0, n, sb);

}

private static void dfs(int curY, int y, StringBuilder sb) {
    if (curY > y) {
        return;
    }
    
    //collect result
    if (curY == y) {
        System.out.println(sb.toString());
        return;
    }
    
    // 0
    sb.append('0');
    dfs(curY+1, y, sb);
    sb.setLength(sb.length()-1);
    
    // 1
    sb.append('1');
    dfs(curY+1, y, sb);
    sb.setLength(sb.length()-1);

}
