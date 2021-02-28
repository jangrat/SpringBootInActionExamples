package com.learningboot.chapter2.controller;

import com.learningboot.chapter2.domain.Book;
import com.learningboot.chapter2.repo.ReadingListRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    public ReadingListController(ReadingListRepository readingListRepository){
        this.readingListRepository=readingListRepository;
    }

    /*
    Method to read Books by Reader
     */

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBook(@PathVariable("reader") String reader, Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);
        if(null != readingList){
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    /*
    Method to a new entry in DB
     */

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";

    }
}

