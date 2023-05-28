package com.example.mailbox.repo;

import com.example.mailbox.model.Mail;

import java.util.List;

public interface IMailRepo {
    List<Mail> findAll();
    Mail findById( int id);
    void save(Mail mail);
    List<String> takeLanguages();
    List<Integer> takeSizes ();
}
