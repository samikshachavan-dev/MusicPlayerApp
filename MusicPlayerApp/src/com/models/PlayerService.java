package com.models;

import java.util.Deque;

public class PlayerService {

	private Song currentSong;
	private boolean isPlaying;
	private int volumne;
	
	public void play(Song song) {
		
	}
	
	public void pause() {
		
	}
	
	public void next(Deque<Song> history) {
		
	}
	
	public void previous(Deque<Song> history) {
		
	}
	
	public void adjustVolumne(int value) {
		
	}

	public PlayerService(Song currentSong, boolean isPlaying, int volumne) {
		super();
		this.currentSong = currentSong;
		this.isPlaying = isPlaying;
		this.volumne = volumne;
	}

	public Song getCurrentSong() {
		return currentSong;
	}

	public void setCurrentSong(Song currentSong) {
		this.currentSong = currentSong;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public int getVolumne() {
		return volumne;
	}

	public void setVolumne(int volumne) {
		this.volumne = volumne;
	}
	
	
}
