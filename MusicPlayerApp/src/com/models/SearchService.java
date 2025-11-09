package com.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchService {
	private Map<String, Song> songLibrary; 
	private Map<String, List<Song>> genreMap;
	private Map<String, List<Song>> artistMap;
	
	
	public List<Song> searchByTitle(String title) {
	return songLibrary.values().stream().filter(song->song.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
}

	public List<Song> searchByArtist(String artist) {
        if (artistMap == null) return new ArrayList<>();
        return artistMap.getOrDefault(artist, new ArrayList<>());
    }


    public List<Song> searchByGenre(String genre) {
        if (genreMap == null) return new ArrayList<>();
//       is genreMap is empty return empty list
        return genreMap.getOrDefault(genre, new ArrayList<>());
//        return list of songs by checking genre at key position if it returns null instead  of null pointer return null list
    }
	
	public SearchService(Map<String, Song> allSongs, Map<String, List<Song>> genreMap,
			Map<String, List<Song>> artistMap) {
		super();
		this.songLibrary = allSongs;
		this.genreMap = genreMap;
		this.artistMap = artistMap;
	}

	
	public Map<String, Song> getSongLibrary() {
		return songLibrary;
	}


	public void setSongLibrary(Map<String, Song> songLibrary) {
		this.songLibrary = songLibrary;
	}


	public Map<String, List<Song>> getGenreMap() {
		return genreMap;
	}

	public void setGenreMap(Map<String, List<Song>> genreMap) {
		this.genreMap = genreMap;
	}

	public Map<String, List<Song>> getArtistMap() {
		return artistMap;
	}

	public void setArtistMap(Map<String, List<Song>> artistMap) {
		this.artistMap = artistMap;
	}
	
	

	
	
	
	
	
}
