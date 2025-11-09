package com.models;

import java.util.Deque;

public class PlayerService {

	private Song currentSong;
	private boolean isPlaying;
	private int volumne;

	public void play(Song song, User user) {

		if (Library.allSongs.containsKey(song.getTitle())) {
			System.out.println(song.getTitle() + " is playing........");
			song.incrementPlayCount(song);
			user.getRecentlyPlayed().addLast(song);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void pause() {
		if (isPlaying) {
			isPlaying = false;
			System.out.println("Player Service is paused");
		} else {
			System.out.println("No song is playing");
		}
	}

	public void next(Deque<Song> history, User user) {
		if (history == null || history.size() <= 1) {
			System.out.println("No song in the history");
			return;
		}

		Boolean found = false;
		Song nextSong = null;
		for (Song song : history) {
			if (found) {
				nextSong = song;
				break;
//				store this next song and play...
			}
			if (song.equals(currentSong)) {
				found = true;
			}
//			check if song in history and current song is equal then next loop that will givenext song 
		}

		if (nextSong != null) {
			currentSong = nextSong;
			isPlaying = true;
			play(currentSong, user);
		} else {
			System.out.println("You are at the last song — no next song available");
		}
	}

	public void previous(Deque<Song> history, User user) {
		if (history == null || history.size() <= 1) {
			System.out.println("No previous Song available");
			return;
		}

		history.removeLast();
		Song previousSong = history.peekLast();

		if (previousSong != null) {
			currentSong = previousSong;
			isPlaying = true;
			play(currentSong, user);

		}
	}

	public void adjustVolumne(int value) {
		if (value < 0)
			value = 0;
		if (value > 100)
			value = 100;
		this.volumne = value;
		System.out.println("Volume adjusted to: " + volumne);

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
