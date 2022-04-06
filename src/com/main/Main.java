package com.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    private static ArrayList<Album> albumsCreated = new ArrayList<>();

    public static void main(String[] args) {

        int albumToCreate = io.setINT("How many albums do you want to create ? --> ");
        for (int i = 0; i < albumToCreate; i++) {
            Album album = new Album(io.setString("\nName of the Album :"),io.setString("\nName of the Artist :"));
            albumsCreated.add(album);
            int songToCreate = io.setINT("\nHow many songs do want to put in the album ? -->");
            for (int j = 0; j < songToCreate; j++) {
                album.addSong(io.setString("\nSong's title : "),io.setFLOAT("\nSong duration : "));
            }
        }

        LinkedList<Song> PlayList1 = new LinkedList<>();
        int songAddToPlayList = io.setINT("\nHow many songs do you want to add to a playList");

        for (int i = 0; i < songAddToPlayList; i++) {
            albumsCreated.get(i).addToPlayList(io.setString("\nSong's title to add to the playlist :"),PlayList1);
        }

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
            switch (io.setINT("\n--->>>Choose An action Please :")){
                case 0:
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if (listIterator.hasNext()) listIterator.next();
                        forward = true;
                    }
                    if (listIterator.hasNext()) System.out.print("\nNow playing "+listIterator.next().toString());
                    else{
                        System.err.print("\n!! No song available, reached to the end of the list !!");
                        forward = false;
                    }
                    break;
                case  2:
                    if (forward){
                        if (listIterator.hasPrevious()) listIterator.previous();
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) System.out.print("\nNow playing "+listIterator.previous().toString());
                    else{
                        System.err.print("\n!! No previous song available !!");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()) {
                            System.out.print("\nNow playing "+listIterator.previous().toString());
                            forward = false;
                        }else
                            System.err.print("\n!! We are at the start of the list !!");
                    }else{
                        if (listIterator.hasNext()){
                            System.out.print("\nNow playing "+listIterator.next().toString());
                            forward = true;

                        }else System.err.print("\n!! We have reached to the end of list !!");
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.print("\nNow playing "+listIterator.next().toString());

                        }else{
                            if (listIterator.hasPrevious()){
                                System.err.print("\nNow playing "+listIterator.previous().toString());
                            }
                        }
                    }
                    break;
                default:
                    System.err.print("\n!! Wrong input please try again !!");
                    break;
            }
        }

    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
    }

    private static void printMenu(){
        System.out.print("" +
                "\n\nAvailable Options\n"+
                "+++++++++++++++++++++\n"+
                "0.To Quit\n"+
                "1.To Play next song\n"+
                "2.To Play previous song\n"+
                "3.To Replay the current song\n"+
                "4.List of all songs\n"+
                "5.Display all available options\n"+
                "6.Delete current song\n"+
                "+++++++++++++++++++++++++\n"
        );

    }
}
