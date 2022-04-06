package com.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

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
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) System.err.print("!!! This playList has no Song !!!");
        else{
            System.out.print("Now Playing "+listIterator.next().toString());
            printMenu();
        }
        while (!quit){
            switch (io.setINT("\nChoose An action Please :")){
                case 0:
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if (listIterator.hasNext()) listIterator.next();
                        forward = true;
                    }
                    if (listIterator.hasNext()) System.out.print("Now playing "+listIterator.next().toString());
                    else{
                        System.err.print("!! No song available, reached to the end of the list !!");
                        forward = false;
                    }
                    break;
                case  2:
                    if (forward){
                        if (listIterator.hasPrevious()) listIterator.previous();
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) System.out.print("Now playing "+listIterator.previous().toString());
                    else{
                        System.err.print("!! No previous song available !!");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()) {
                            System.out.print("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }else
                            System.err.print("!! We are at the start of the list !!");
                    }else{
                        if (listIterator.hasNext()){
                            System.out.print("Now playing "+listIterator.next().toString());
                            forward = true;

                        }else System.err.print("!! We have reached to the end of list !!");
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                default:
                    System.err.print("!! Wrong input please try again !!");
                    break;
            }
        }

    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.err.println("-----------------------------------------");
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
        System.err.println("-----------------------------------------");
    }

    private static void printMenu(){
        System.out.print("" +
                "Available Options\n"+
                "+++++++++++++++++++++\n"+
                "0.To Quit\n"+
                "1.To Play next song\n"+
                "2.To Play previous song\n"+
                "3.To Replay the current song\n"+
                "4.List of all songs"+
                "5.Display all available options"+
                "6.Delete current song"
        );

    }
}
