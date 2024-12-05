package com.kitm;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}

	public boolean addSong(String title, double duration) {
		if (findSong(title) == null) {
			songs.add(new Song(title, duration));
			return true;
		}
		return false;
	}
	
	private Song findSong(String title) {
		for (Song song : songs) {
			if (song.getTitle().equals(title))
				return song;
		}
		return null;
	}
	
	public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
		if (trackNumber < 0 || trackNumber > songs.size())
			return false;

		Song song = songs.get(trackNumber);
		playList.add(song);
		return true;
	}

	public boolean addToPlayList(String title, LinkedList<Song> playList) {
		Song song = findSong(title);
		if (song != null) {
			playList.add(song);
			return true;
		}
		return false;
	}
}
