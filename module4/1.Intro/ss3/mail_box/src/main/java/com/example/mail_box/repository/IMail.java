package com.example.mail_box.repository;

import com.example.mail_box.model.Mail;

import java.util.List;

public interface IMail {
    List<Mail> findAll();
    Mail findById(int id);
    void save (Mail mail);
    List<String > findLanguage();
    List<Integer> findSize();
}
