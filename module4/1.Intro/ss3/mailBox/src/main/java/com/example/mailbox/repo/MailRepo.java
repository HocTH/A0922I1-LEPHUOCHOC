package com.example.mailbox.repo;

import com.example.mailbox.model.Mail;

import java.util.ArrayList;
import java.util.List;

public class MailRepo implements IMailRepo{
    private static List<Mail> mails = new ArrayList<>();
    private static List<String> languages = new ArrayList<>();
    private static List<Integer> sizes = new ArrayList<>();
    static {
        mails.add(new Mail(1,"English",25,true,"Nam"));
        mails.add(new Mail(2,"Chinese",25,true,"Sen"));
        mails.add(new Mail(3,"Vietnamese",25,true,"Nghia"));
        mails.add(new Mail(4,"English",25,false,"Huy"));
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Chinese");
        languages.add("Japanese");
        sizes.add(5);
        sizes.add(10);
        sizes.add(15);
        sizes.add(25);
        sizes.add(50);
        sizes.add(100);

    }
    @Override
    public List<Mail> findAll() {
        return mails;
    }

    @Override
    public Mail findById(int id) {
        for (Mail mail:mails) {
            if (mail.getId() == id)
                return mail;
        }
        return null;
    }

    @Override
    public void save(Mail mail) {
        for (Mail mailCheck:mails) {
            if (mail.getId() == mailCheck.getId()){
                mails.remove(mailCheck);
            mails.add(mail);
            break;}
        }
    }
    public List<String> takeLanguages(){
        return languages;
    }
    public List<Integer> takeSizes (){
        return sizes;
    }
}
