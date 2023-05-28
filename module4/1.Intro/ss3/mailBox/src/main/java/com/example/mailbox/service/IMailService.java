package com.example.mailbox.service;

import com.example.mailbox.model.Mail;

import java.util.List;

public interface IMailService {
    List<Mail> findAll();
    Mail findById( int id);
    void save(Mail mail);
    List<String> takeLanguages();
    List<Integer> takeSizes ();
}
