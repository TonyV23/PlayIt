package com.main;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    private static ArrayList<Album> albumsCreated = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album(io.setString("Name of the Album :"),io.setString("Name of the Artist :"));
        album.addSong(io.setString("Song's title : "),io.setFLOAT("Song duration : "));
        album.addSong(io.setString("Song's title : "),io.setFLOAT("Song duration : "));
        album.addSong(io.setString("Song's title : "),io.setFLOAT("Song duration : "));

        Album album1 = new Album(io.setString("Name of the Album :"),io.setString("Name of the Artist :"));
        album.addSong(io.setString("Song's title : "),io.setFLOAT("Song duration : "));
        album.addSong(io.setString("Song's title : "),io.setFLOAT("Song duration : "));
        album.addSong(io.setString("Song's title : "),io.setFLOAT("Song duration : "));

        albumsCreated.add(album);
        albumsCreated.add(album1);

        LinkedList<Song> PlayList1 = new LinkedList<>();

        albumsCreated.get(0).addToPlayList(io.setString("Song's title to add to the playlist :"),PlayList1);
        albumsCreated.get(1).addToPlayList(io.setString("Song's title to add to the playlist :"),PlayList1);
        albumsCreated.get(2).addToPlayList(io.setString("Song's title to add to the playlist :"),PlayList1);

        play(PlayList1);
    }
    private static void play(LinkedList<Song> playList){

    }
    private static void printMenu(){
        int userChoice = io.setINT("" +
                "Available Options\n"+
                "+++++++++++++++++++++\n"+
                "0.To Quit\n"+
                "1.To Play next song\n"+
                "2.To Play previous song\n"+
                "3.To Replay the current song\n"+
                "4.List of all songs"+
                "5.Display all available options"+
                "6.Delete current song");
        switch (userChoice){
            case 0:
                System.exit(0);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.err.print("!! Incorrect input please try again !!");
                    break;
        }
    }
}
