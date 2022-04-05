package com.main;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist, ArrayList<Song> songs){
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public Album(){}

    public Song findSongs(String title){
        for(Song checkedSong : songs){
            if (checkedSong.getTitle().equals(title))
                return checkedSong;
        }
        return null;
    }

    public boolean addSong(String title, double duration){
        if (findSongs(title) == null){
            songs.add(new Song(title,duration));
            System.out.print(title+ "Successfully added to the list");
            return true;
        }else{
            System.err.print("Song with this name "+title+" already exists !!");
            return false;
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList){
        int index = trackNumber - 1;
        if (index > 0 && index < this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
        System.err.print("This album does not have song with trackNumber :"+trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> PlayList){
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title))
                PlayList.add(checkedSong);
                return true;
        }
        System.err.print(title+" there is no such song in the album");
        return false;
    }
}
