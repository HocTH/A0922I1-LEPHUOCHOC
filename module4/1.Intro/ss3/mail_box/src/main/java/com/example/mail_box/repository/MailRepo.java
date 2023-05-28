package com.example.mail_box.repository;

import com.example.mail_box.model.Mail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MailRepo implements IMail {
    private static List<Mail> mails = new ArrayList<>();
    private static List<String> languageList = new ArrayList<>();
    private static List<Integer> sizeList = new ArrayList<>();

    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Chinese");
        languageList.add("Japanese");
        sizeList.add(5);
        sizeList.add(10);
        sizeList.add(15);
        sizeList.add(25);
        sizeList.add(50);
        sizeList.add(100);
        mails.add(new Mail(1, "English", 25, true, "Nghia"));
        mails.add(new Mail(2, "Vietnamese", 10, false, "Tinh"));
        mails.add(new Mail(3, "Chinese", 25, true, "Toan"));
        mails.add(new Mail(4, "English", 25, true, "Thang"));
    }

    @Override
    public List<Mail> findAll() {
        return mails;
    }

    @Override
    public Mail findById(int id) {
        for (Mail mail : mails) {
            if (mail.getId() == id)
                return mail;
        }
        return null;
    }

    @Override
    public void save(Mail mail) {
        for (Mail item : mails) {
            if (item.getId() == mail.getId()) {
                mails.remove(item);
                mails.add(mail);
                break;
            }
        }

    }

    @Override
    public List<String> findLanguage() {
        return languageList;
    }

    @Override
    public List<Integer> findSize() {
        return sizeList;
    }
}
