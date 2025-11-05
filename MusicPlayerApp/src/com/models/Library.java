package com.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

	public static Map<String, Song> allSongs = new HashMap<>();
	public static Map<String, User> allUsers = new HashMap<>();
	public static Map<String, Artist> allArtists = new HashMap<>();
	public static Map<String, Album> allAlbums=new HashMap<>();
	public static Map<String, Integer> genrePlayCount=new HashMap<>();
	public static Map<String, Integer> artistPlayCount=new HashMap<>();

	public static void initializeSongs() {
		// Taylor - Lover Album
		allSongs.put("False God", new Song(1, "False God", "Taylor", "Lover", "Pop", 2.30, 0));
		allSongs.put("Lover", new Song(2, "Lover", "Taylor", "Lover", "Pop", 3.50, 0));
		allSongs.put("You Need To Calm Down", new Song(3, "You Need To Calm Down", "Taylor", "Lover", "Pop", 2.55, 0));

		// Taylor - Midnights Album
		allSongs.put("Anti-Hero", new Song(4, "Anti-Hero", "Taylor", "Midnights", "Pop", 3.20, 0));
		allSongs.put("Bejeweled", new Song(5, "Bejeweled", "Taylor", "Midnights", "Pop", 3.14, 0));

		// Weekend - Starboy Album
		allSongs.put("Starboy", new Song(6, "Starboy", "Weekend", "Starboy", "Pop", 4.30, 0));
		allSongs.put("Die For You", new Song(7, "Die For You", "Weekend", "Starboy", "Pop", 4.20, 0));

		// Arijit - Ranjhana Album
		allSongs.put("Ranjhana", new Song(8, "Ranjhana", "Arijit", "Ranjhana", "Romantic", 3.30, 0));
		allSongs.put("Tum Hi Ho", new Song(9, "Tum Hi Ho", "Arijit", "Ranjhana", "Romantic", 4.22, 0));
	}

	public static void initializeUsers() {
		allUsers.put("samiksha", new User("samiksha", "sam.xom"));
	}

	public static void initializeArtists() {
		List<Album> taylor=new ArrayList<>();
		taylor.add(allAlbums.get("Lover"));
		taylor.add(allAlbums.get("Midnights"));
		List<Album> weeknd=new ArrayList<>();
		weeknd.add(allAlbums.get("Starboy"));
		List<Album> arijits=new ArrayList<>();
		arijits.add(allAlbums.get("Arijit"));
		
		List<Song> taylorSongs=new ArrayList<>();
		taylorSongs.add(allSongs.get("False God"));
		taylorSongs.add(allSongs.get("Lover"));
		taylorSongs.add(allSongs.get("You Need To Calm Down"));
		taylorSongs.add(allSongs.get("Anti-Hero"));
		taylorSongs.add(allSongs.get("Bejeweled"));
		List<Song> weekndSongs=new ArrayList<>();
		weekndSongs.add(allSongs.get("Starboy"));
		weekndSongs.add(allSongs.get("Die For You"));
		List<Song> arijitSongs=new ArrayList<>();
		arijitSongs.add(allSongs.get("Ranjhana"));
		arijitSongs.add(allSongs.get("Tum Hi Ho"));
		
		allArtists.put("Taylor", new Artist("Taylor", taylor, taylorSongs));
		allArtists.put("Weeknd", new Artist("Weeknd", weeknd, weekndSongs));
		allArtists.put("Arijit", new Artist("Arijit", arijits, arijitSongs));
		
	}

	public static void initializeAlbums() {
		List<Song> lover=new ArrayList<>();
		lover.add(allSongs.get("False God"));
		lover.add(allSongs.get("Lover"));
		lover.add(allSongs.get("You Need To Calm Down"));
		
		
		List<Song> midnights=new ArrayList<>();
		midnights.add(allSongs.get("Anti-Hero"));
		midnights.add(allSongs.get("Bejeweled"));
		
		List<Song> starboy=new ArrayList<>();
		starboy.add(allSongs.get("Starboy"));
		starboy.add(allSongs.get("Die For You"));
		
		List<Song> arijit=new ArrayList<>();
		arijit.add(allSongs.get("Ranjhana"));
		arijit.add(allSongs.get("Tum Hi Ho"));
		
		allAlbums.put("Lover", new Album("Lover", "Taylor", lover));
		allAlbums.put("Midnights", new Album("Midnights", "Taylor", midnights));
		allAlbums.put("Starboy", new Album("Starboy", "Weeknd", starboy));
		allAlbums.put("Arijit", new Album("Arijit", "Arijit", arijit));
	}

	public static void initializegenrePlayCount() {
		genrePlayCount.put("Pop", 0);
        genrePlayCount.put("Romantic", 0);
	}

	public static void initializeartistPlayCount() {
		artistPlayCount.put("Taylor", 0);
        artistPlayCount.put("Weekend", 0);
        artistPlayCount.put("Arijit", 0);
	}
	
	public static void initialize() {
		initializeSongs();
		initializeArtists();
		initializeAlbums();
//		initializegenrePlayCount();
//		initializeartistPlayCount();
	}
}
