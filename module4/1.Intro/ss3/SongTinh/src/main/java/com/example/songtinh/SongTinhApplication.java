package com.example.songtinh;

import com.example.songtinh.entity.Category;
import com.example.songtinh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SongTinhApplication{

	public static void main(String[] args) {
		SpringApplication.run(SongTinhApplication.class, args);
	}

}
