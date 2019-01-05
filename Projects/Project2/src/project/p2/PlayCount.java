package project.p2;

/**
 * This class stores a connection between a player ID and a count of the number
 * of plays they've been involved in.
 *
 * @author Mark Hancock
 *
 */
public class PlayCount implements Comparable<PlayCount> {
    public String name;
    public int count;
    
    public PlayCount() {
    	
    }
    
    public PlayCount(String name, int count) {
	    	this.name = name;
	    	this.count = count;
    }

	@Override
	public int compareTo(PlayCount o) {
		return Integer.compare(o.count, this.count);
	}
}
