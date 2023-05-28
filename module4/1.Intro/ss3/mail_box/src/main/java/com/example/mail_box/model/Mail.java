package com.example.mail_box.model;

public class Mail {
    private int id;
    private String language;
    private int sizePage;
    private boolean isSpam;
    private String content;


    public Mail(int id, String language, int sizePage, boolean isSpam, String content) {
        this.id = id;
        this.language = language;
        this.sizePage = sizePage;
        this.isSpam = isSpam;
        this.content = content;
    }

    public Mail() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSizePage() {
        return sizePage;
    }

    public void setSizePage(int sizePage) {
        this.sizePage = sizePage;
    }

    public boolean isSpam() {
        return isSpam;
    }

    public void setSpam(boolean spam) {
        isSpam = spam;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
