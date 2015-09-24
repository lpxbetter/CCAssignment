package ch4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by lipingxiong on 9/22/15.
 */
public class routeFound_4_1 {
    class Node{
        int val;
    }
    class Graph{
        int V;
        int E;
        HashMap<Node,LinkedList<Node>> adj;
        public Graph(int V){
            this.V = V;
            adj = new HashMap<>();
        }
    }
    HashSet<Node> visited = new HashSet<>();

    public boolean bfs(Graph g, Node start, Node end ){
        visited.add(start);
        if( start == end ) return true;//find one route
        for( Node neigh: g.adj.get(start)){
            if(!visited.contains(neigh)) {
                if(bfs(g,neigh,end)) return true;
            }
        }
        return false;
    }

}
