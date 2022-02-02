/* # of levels: x + y
   branching factor: 3
                           (0, 0)
                       /      |      \
                     (0,1)  (1, 0)    (1, 1)
                   / | \    / | \    / | \
      (0,2) (1,1) (1, 2)(1, 1)(2, 0)(2,1)  (1, 2)(2, 1)(2, 2)

   Time: 3^(x+y)
   Space: x+y
   
   
*/
public static void travel(int x, int y) {
    StringBuilder sb = new StringBuilder();
    dfs(0, 0, x, y, sb);

}
private static void dfs(int curX, int curY, int x, int y, StringBuilder sb) {
    // edge case check
    if (curX > x || curY > y) {
        return;
    }
    
    // collect result
    if (curX == x && curY == y) {
        System.out.println(sb.toString());
        return;
    }
    
    // East
    sb.append("E ");
    dfs(curX+1, curY, x, y, sb);
    sb.setLength(sb.length() - 2);
    
    // North
    sb.append("N ");
    dfs(curX, curY+1, x, y, sb);
    sb.setLength(sb.length() - 2);
    
    // Northeast
    sb.append("NE ");
    dfs(curX+1, curY+1, x, y, sb);
    sb.setLength(sb.length() - 3);
    
}
