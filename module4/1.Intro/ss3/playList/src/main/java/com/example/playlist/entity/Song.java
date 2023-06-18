package com.example.playlist.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "findProductByName",
                query = "select p from Song p where p.name like '%:name%'")
})
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String artist;
    private String path;

    public Song() {
    }

    public Song(int id, String name, String artist, String path) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
