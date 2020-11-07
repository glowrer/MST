package Info;

import java.util.ArrayList;
import java.util.HashMap;

public class Vertex {
	private Person person;
	private HashMap<Vertex,Integer> edges;
	
	public Vertex(Person p) {
		this.person = p;
		this.edges = new HashMap<>();
	}
	
	public Person getPerson() {
		return person;
	}
	
	public ArrayList<Vertex> getEdges() {
		ArrayList<Vertex> allEdges = new ArrayList<>();
		for (Vertex vertex : edges.keySet()) {
			allEdges.add(vertex);
		}
		return allEdges;
	}
	
	public void cleanEdges() {
		edges = new HashMap<Vertex,Integer>();
	}
	
	public int getEdgeSimilarityIndex(Vertex v) {
		return edges.get(v);
	}
	
	public void setEdgeSimilarityIndex(Vertex v) {
		int edgeValue = calculateEdgeSimilarityIndex(v);
		edges.put(v, edgeValue);
	}
	
	private int calculateEdgeSimilarityIndex(Vertex v) {
		return Math.abs(person.getInterest("sports") - v.getPerson().getInterest("sports"))
				+ Math.abs(person.getInterest("music") - v.getPerson().getInterest("music"))
				+ Math.abs(person.getInterest("newsShow") - v.getPerson().getInterest("newsShow"))
				+ Math.abs(person.getInterest("science") - v.getPerson().getInterest("science"));
	}
}
