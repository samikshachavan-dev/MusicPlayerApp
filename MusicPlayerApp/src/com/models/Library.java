package com.models;

import java.util.HashMap;
import java.util.Map;

public class Library {

	public static  Map<String, Song> allSongs=new HashMap<>();
	public static Map<String, User> allUsers;
	public static Map<String, Artist> allArtists;
	public static Map<String, Album> allAlbums;
	public static Map<String, Integer> genrePlayCount; 
	public static Map<String, Integer> artistPlayCount;

	public static void initializeSongs() {
		allSongs.put("False God", new Song(1, "False God", "Talyor", "Lover", "Pop", 2.30, 0));
		allSongs.put("StarBoy", new Song(2, "StarBoy", "Weekend", "Solo", "Pop", 4.30, 0));
		allSongs.put("Ranjhana", new Song(3, "Ranjhana", "Arijit", "Ranjhana", "Romantic", 3.30, 0));
	}
	
}
