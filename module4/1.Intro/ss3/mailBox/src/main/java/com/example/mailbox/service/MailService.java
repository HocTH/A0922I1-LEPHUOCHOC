package com.example.mailbox.service;

import com.example.mailbox.model.Mail;
import com.example.mailbox.repo.IMailRepo;
import com.example.mailbox.repo.MailRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MailService implements IMailService{
    IMailRepo iMailRepo = new MailRepo();
    @Override
    public List<Mail> findAll() {
        return iMailRepo.findAll();
    }

    @Override
    public Mail findById(int id) {
        return iMailRepo.findById(id);
    }

    @Override
    public void save(Mail mail) {
        iMailRepo.save(mail);
    }

    @Override
    public List<String> takeLanguages() {
        return iMailRepo.takeLanguages();
    }

    @Override
    public List<Integer> takeSizes() {
        return iMailRepo.takeSizes();
    }


}
