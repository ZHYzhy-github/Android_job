package castle;

import java.util.HashMap;

public class Room {
    private String description;
    HashMap<String, Room> exits = new HashMap<String,Room>();
//    private Room northExit;
//    private Room southExit;
//    private Room eastExit;
//    private Room westExit;

    public Room(String description) 
    {
        this.description = description;
    }

    public void setExit(String dir,Room room) {
    	exits.put(dir, room);
    }
//    public void setExits(Room north, Room east, Room south, Room west) 
//    {
//        if(north != null)
//            northExit = north;
//        if(east != null)
//            eastExit = east;
//        if(south != null)
//            southExit = south;
//        if(west != null)
//            westExit = west;
//    }

    @Override
    public String toString()
    {
        return description;
    }
    
    public String getExitDoce() {
    	StringBuffer sb = new StringBuffer();
    	for( String dir : exits.keySet()) {
    		sb.append(dir);
    		sb.append(" ");
    	}
    	return sb.toString();
    }
    
    public Room goExit(String direction) {
    	return exits.get(direction);
    }
}
