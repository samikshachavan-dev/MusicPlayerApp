package com.models;

import java.util.Deque;

public class PlayerService {

	private Song currentSong;
	private boolean isPlaying;
	private int volumne;
	
	public void play(Song song) {
		if(Library.allSongs.containsKey(song.getTitle())) {
			System.out.println(song.getTitle()+" is playing........");
			song.incrementPlayCount(song);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
