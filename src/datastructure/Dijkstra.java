package datastructure;

import java.util.Arrays;

public class Dijkstra {
	
	int[][] graph;
	int[] distance;
	int size, src;
	
	public Dijkstra(int[][] graph, int source) {
		this.graph = graph.clone();
		//this.graph = graph;
		this.size = graph.length;
		this.src = source;
		compute();
	}
	
	public void compute() {
		distance = new int[size];
		Boolean[] sptSet = new Boolean[size];
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(sptSet, false);
		distance[src] = 0;
		
		for(int i=0;i<size-1;i++) {
			int u = minDistance(distance, sptSet);
			sptSet[u] = true;
			for(int j=0;j<size;j++) {
				if(!sptSet[j] && // if distance[j] not in saved
						graph[u][j]!=0 && // edge is available from u to j
						distance[u]!= Integer.MAX_VALUE && // 
						distance[u]+graph[u][j] < distance[j]) // distance from src to j through u is less than current distance
					distance[j] = distance[u]+graph[u][j];
			}
		}
	}
	
	public int minDistance(int[] distance, Boolean[] sptSet) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for(int i=0;i<size;i++) {
			if(sptSet[i] == false && distance[i] <= min) {
				min = distance[i];
				min_index = i;
			}
		}
		return min_index;
	}
	
	public void printDistances() {
		System.out.println("Distance from source "+src+":");
		for(int i=0;i<size;i++)
			System.out.println(i+"\t"+distance[i]);
	}
}
