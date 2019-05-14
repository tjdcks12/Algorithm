package baekjoon;


public class Hackday2 {
    static class Tree {
        public int x;
        public Tree l;
        public Tree r;

        public Tree(int x){
            this.x = x;
        }
    }

    static int ans = 0;

    public static int solution(Tree T) {
        boolean[] visited = new boolean[50001];

        visited[T.x] = true;
        dfs(T, visited, 1);

        return ans;
    }


    public static void dfs(Tree tree, boolean[] visited, int now) {
        if(!visited[tree.x]) now++;

        visited[tree.x] = true;
        ans = Math.max(ans, now);

        if(tree.l != null) dfs(tree.l, visited, now);
        if(tree.r != null) dfs(tree.r, visited, now);
        visited[tree.x] = false;
    }

}
