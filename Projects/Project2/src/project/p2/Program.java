package project.p2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

//import project.p2.solution.HockeyData;

public class Program {
    // TODO: change this to the directory you store the data in (you can use this
    // one in your project, if you want)
    private static final String GAME_DATA_DIRECTORY = "nhl-game-data";

    // TODO: when testing, you may want to choose a smaller portion of the dataset.
    // This number lets you limit it to only the first MAX_ENTRIES. Setting this
    // over 3.5 million will get all the data.
    //
    //private static final int MAX_ENTRIES = 100000;
    private static final int MAX_ENTRIES = 4000000;

    private static Stopwatch stopwatch = new Stopwatch();

    public static void main(String[] args) {
        try {
            Path dir = Paths.get(GAME_DATA_DIRECTORY);
            if (!dir.toFile().exists()) {
                throw new IOException("Directory " + GAME_DATA_DIRECTORY + " does not exist.");
            }

            // We are going to read all of the players and stats in and store them
            // in a list to make the rest of your project easier for you. This is NOT the way
            // one would normally operate. There is no reason to store all of the data in
            // RAM. We only need to read data from the files, count them, and then move on
            // to the rest of the file.
            List<HockeyData> plays = readData(dir.resolve("simple_play_data.csv"),
                    "stats about plays", MAX_ENTRIES);

            // ************************ IMPORTANT ***************************************
            //
            // NOTE: You may NOT change anything about this list!
            // You should only read stats from index 0 to index plays.size() - 1
            // Do NOT sort the list or change them in any way.
            //
            // **************************************************************************

            // --------------------------------------------------------------------------
            //
            // TODO: Add your code here to count the stats, etc. You will do best to create
            // many methods to organize your work and experiments.
            
            //*************
            //Map Design 1
            //*************
            ArrayList<PlayCount> mapList = new ArrayList<>();
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.reset();
            stopwatch.start();
            for (HockeyData data: plays) {
	            boolean playerFound = false;
            		if(mapList.size() == 0) {
            			PlayCount playCount = new PlayCount(data.get(0), 1);
        				mapList.add(playCount);
        				playerFound = true;
            		} else {
            			for(int i = 0; i < mapList.size(); i++) {
                			if(mapList.get(i).name.equals(data.get(0))) {
                				mapList.get(i).count++;
                				playerFound = true;
                			} 
                		}
            		}
            		if(!playerFound) {
        				PlayCount playCount = new PlayCount(data.get(0), 1);
        				mapList.add(playCount);
        			}
            }    
            stopwatch.stop();
	    		double timeTaken_mapList = stopwatch.getElapsedSeconds();
	    		System.out.println("To count all the plays with an ArrayList took " + timeTaken_mapList + " seconds.");
	    		System.out.println("Found " + mapList.size() + " unique players.");
	    		getTopByPriorityQueue(mapList);
	    		
            //*************
            //Map Design 2
            //*************
            Map<String, Integer> mapTree = new TreeMap<String, Integer>();
            stopwatch.reset();
            stopwatch.start();
            for (HockeyData data: plays) {
	    			if(mapTree.containsKey(data.get(0))) {
	    				mapTree.put(data.get(0), mapTree.get(data.get(0)) + 1);
	    			} else {
	    				mapTree.put(data.get(0), 1);
	    			}
            }    
            stopwatch.stop();
	    		double timeTaken_mapTree = stopwatch.getElapsedSeconds();
	    		System.out.println("To count all the plays with an TreeMap took " + timeTaken_mapTree + " seconds.");
	    		System.out.println("Found " + mapTree.size() + " unique players.");
	    		getTopByPriorityQueue(mapTree);
            
            //*************
            //Map Design 3
            //*************
            Map<String, Integer> mapHash = new HashMap<String, Integer>();
            stopwatch.reset();
            stopwatch.start();
            for (HockeyData data: plays) {
	    			if(mapHash.containsKey(data.get(0))) {
	    				mapHash.put(data.get(0), mapHash.get(data.get(0)) + 1);
	    			} else {
	        			mapHash.put(data.get(0), 1);
	    			}
            }    
            stopwatch.stop();
	    		double timeTaken_mapHash = stopwatch.getElapsedSeconds();
	    		System.out.println("To count all the plays with an HashMap took " + timeTaken_mapHash + " seconds.");
	    		System.out.println("Found " + mapHash.size() + " unique players.");
	    		getTopByPriorityQueue(mapHash); 
	    		
	    		
            // --------------------------------------------------------------------------
        } catch (IOException ex) {
            System.err.println("Caught unhandled exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    //Please note that the methods created below were partly for testing purposes. 
    //Not all methods created below have been used. I used what I believed would create the most appropriate solution.

    //Converts map into list of PlayCount objects 
    public static ArrayList<PlayCount> convertMapToList(Map<String, Integer> map) {
        		ArrayList<PlayCount> list = new ArrayList<>();
        		for(String key: map.keySet()) {
    				list.add(new PlayCount(key, map.get(key)));
        		}
        		return list;
    }
    
    //Getting top players and scores using the collections.sort() by inputting a list of PlayCount objects
    public static void getTopBySort(ArrayList<PlayCount> list) {
    		Collections.sort(list);
		System.out.println("The 20 players with the most frequent plays and their counts retrieved using the Collections.sort() method are: ");
		for(int i = 0; i < 20; i++) {
			System.out.println(list.get(i).name + " " + list.get(i).count);
		}
    }
    
    //Getting top players and scores using the priority queue by inputting a map (not best method)
    public static void getTopBySort(Map<String, Integer> map) {
    		Stopwatch sortst = new Stopwatch();
    		sortst.start();
		ArrayList<PlayCount> list = convertMapToList(map);
		Collections.sort(list);
		System.out.println("The 20 players with the most frequent plays and their counts retrieved using the Collections.sort() method are: ");
		for(int i = 0; i < 20; i++) {
			System.out.println(list.get(i).name + " " + list.get(i).count);
		}
		sortst.stop();
		double timeTaken = sortst.getElapsedSeconds();
		System.out.println("getTopBySort Time: " + timeTaken + "." );
    }
    
    //Getting top players and scores using the priority queue by inputting a list of PlayCount objects
    public static void getTopByPriorityQueue(ArrayList<PlayCount> list) {
    		PriorityQueue<PlayCount> pq = new PriorityQueue<PlayCount>(20);
    		for(PlayCount PlayCount: list) {
    			pq.add(PlayCount);
    		}
    		System.out.println("The 20 players with the most frequent plays and their counts retrieved using the priority queue method are: ");
    		for(int i = 0; i < 20; i++) {
    			System.out.println(pq.peek().name + " " + pq.remove().count);
    		}
    }
    
    //Getting top players and scores using the priority queue by inputting a map
    public static void getTopByPriorityQueue(Map<String, Integer> map) {
    		Stopwatch pqst = new Stopwatch();
    		pqst.start();
    		ArrayList<PlayCount> list = convertMapToList(map);
		PriorityQueue<PlayCount> pq = new PriorityQueue<PlayCount>(20);
		for(PlayCount PlayCount: list) {
			pq.add(PlayCount);
		}
		System.out.println("The 20 players with the most frequent plays and their counts retrieved using the priority queue method are: ");
		for(int i = 0; i < 20; i++) {
			System.out.println(pq.peek().name + " " + pq.remove().count);
		}
		pqst.stop();
		double timeTaken = pqst.getElapsedSeconds();
		System.out.println("getTopByPriorityQueue Time: " + timeTaken + "." );
    }

    private static ArrayList<HockeyData> readData(Path path, String description, int limit)
            throws IOException {
        stopwatch.reset();
        stopwatch.start();

        ArrayList<HockeyData> list = Files.lines(path, Charset.forName("ISO-8859-1"))
        	.skip(1)
                .filter(s -> !s.isEmpty())
                .limit(limit).map(HockeyData::parse)
                .collect(Collectors.toCollection(() -> new ArrayList<>(limit)));
        stopwatch.stop();
        System.out.printf("Finished reading %,d %s in %f seconds.\n", list.size(), description,
                stopwatch.getElapsedSeconds());

        return list;
    }
}
