package com.example.lab4ex2.demo.controller;

import com.example.lab4ex2.demo.NoSuchResourceException;
import com.example.lab4ex2.demo.dao.BookDao;
import com.example.lab4ex2.demo.entity.Book;
import com.example.lab4ex2.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String redirectRoot() {
        return "redirect:/books";
    }

//    @Resource
//    private IBookDao bookDao;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
//   @GetMapping
    public String getAll(Model model) {

        model.addAttribute("books", bookService.getAllBookList());
        return "bookList";
    }

    @RequestMapping(value = "/addbooks", method = RequestMethod.GET)
//   @GetMapping
    public String addBooks(@ModelAttribute("book") Book book) {
        return "addBook";
    }

    @RequestMapping(value = "/addbooks", method = RequestMethod.POST)
//    @PostMapping
    public String add(@Valid Book book, BindingResult bindingResult) {

        System.out.println(book);
        if (!bindingResult.hasErrors()) {
            bookService.add(book);
//            bookDao.add(book);
            return "redirect:/books";
        } else {
            return "addBook";
        }

    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {

        model.addAttribute("book", bookService.get(id));
        System.out.println(""+bookService.get(id));
        return "bookDetail";
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.POST)
//    @PostMapping
    public String update(@Valid Book book, @PathVariable int id) {
        bookService.update(id, book);
        return "redirect:/books";
    }

    @RequestMapping(value = "books/delete", method = RequestMethod.POST)
//    @PostMapping
    public String delete(int bookId) {
        bookService.delete(bookId);
        return "redirect:/books";
    }

    @ExceptionHandler(value = NoSuchResourceException.class)
    public ModelAndView handle(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModel().put("e", e);
        mv.setViewName("noSuchResource");
        return mv;
    }

}
