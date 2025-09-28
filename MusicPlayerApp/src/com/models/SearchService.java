package com.models;

import java.util.List;
import java.util.Map;

public class SearchService {
	private Map<Integer, Song> songLibrary; 
	private Map<String, List<Song>> genreMap;
	private Map<String, List<Song>> artistMap;
	
//	public List<Song> searchByTitle(String title) {
//
//	}
//
//	public List<Song> searchByArtist(String artist) {
//	}
//
//	public List<Song> searchByGenre(String genre) {
//
//	}
	
	public SearchService(Map<Integer, Song> songLibrary, Map<String, List<Song>> genreMap,
			Map<String, List<Song>> artistMap) {
		super();
		this.songLibrary = songLibrary;
		this.genreMap = genreMap;
		this.artistMap = artistMap;
	}

	public Map<Integer, Song> getSongLibrary() {
		return songLibrary;
	}

	public void setSongLibrary(Map<Integer, Song> songLibrary) {
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
