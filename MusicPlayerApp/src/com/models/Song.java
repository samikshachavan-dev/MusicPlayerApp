package com.models;

public class Song {
	private int id;
	private String title;
	private String artistName;
	private String albumName;
	private String genre;
	private double duration;
	private int playCount;

	public void incrementPlayCount(Song song) {
		song.setPlayCount(song.getPlayCount() + 1);
		Library.genrePlayCount.put(song.getGenre(), Library.genrePlayCount.getOrDefault(song.getGenre(), 0) + 1);

		Library.artistPlayCount.put(song.getArtistName(),
				Library.artistPlayCount.getOrDefault(song.getArtistName(), 0) + 1);

	}

	public String getInfo() {
		return "String";
	}

	public Song(int id, String title, String artistName, String albumName, String genre, double duration,
			int playCount) {
		this.id = id;
		this.title = title;
		this.artistName = artistName;
		this.albumName = albumName;
		this.genre = genre;
		this.duration = duration;
		this.playCount = playCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

}