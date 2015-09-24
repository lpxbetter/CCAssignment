package ch4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by lipingxiong on 9/23/15.
 * This is a typical topological sort problem.
 * 1) To allow the projects to be built, it should be
 * a acyclic graph, DAG, which means there is no cycle in the graph.
 * 2) The topological sort  is just the reverse post oder of dfs
 */
public class buildOrder_4_7 {
    Stack<String> reversePost = new Stack<>();
    boolean hasCycle=false;
    HashSet<String> visited = new HashSet<>();
    HashSet<String> onStack = new HashSet<>(); //for cycle detection

    /* Assume project is just String, and graph is a HashMap that stores the node and its neighbors, each node
    represents a project.
    */
    Stack<String> buildOrder(String[] projects, String[][] dependencies){
        HashMap<String,ArrayList<String>> graph = new HashMap<>();
        int n = dependencies.length;
        // build graph
        for(int i=0;i<n;i++){
            String project = dependencies[i][0];
            String dep = dependencies[i][1];
            if(!graph.containsKey(project)) {
                graph.put(project, new ArrayList<String>());
            }
            graph.get(project).add(dep); // add the dep to the project.
        }

        //dfs graph
        for(String v : graph.keySet()){
            if(!visited.contains(v)) {
                DFS(graph,v);
            }
        }
        return reversePost;
    }
    public void DFS(HashMap<String,ArrayList<String>> graph,String v){
        if(hasCycle) return;
        visited.add(v);
        onStack.add(v);
        for(String w: graph.get(v)){
            if(!visited.contains(w)) {
                DFS(graph,w);
            }
            else if(onStack.contains(w)){ //for cycle detection
                hasCycle = true;
                return;
            }
        }
        onStack.remove(v);//for cycle detection
        reversePost.push(v); // to build the order
    }
}
