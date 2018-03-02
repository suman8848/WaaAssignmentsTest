package cs544.exercise8;

import cs544.sample.NoSuchResourceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class BookController {


    @RequestMapping("/")
    public String redirectRoot() {
        return "redirect:/books";
    }

    @Resource
    private IBookDao bookDao;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
//   @GetMapping
    public String getAll(Model model) {

        model.addAttribute("books", bookDao.getAll());
        return "bookList";
    }
    @RequestMapping(value = "/addbooks", method = RequestMethod.GET)
//   @GetMapping
    public String addBooks(@ModelAttribute("book") Book book ) {
        return "addBook";
    }

    @RequestMapping(value = "/addbooks" ,method = RequestMethod.POST)
//    @PostMapping
    public String add(@Valid  Book book, BindingResult bindingResult) {

        System.out.println(book);
        if (!bindingResult.hasErrors()) {
            bookDao.add(book);
            return "redirect:/books";
        } else {
            return "addBook";
        }

    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("book", bookDao.get(id));
        return "bookDetail";
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.POST)
//    @PostMapping
    public String update(@Valid Book book, @PathVariable int id) {
        bookDao.update(id, book);
        return "redirect:/books";
    }

    @RequestMapping(value = "books/delete", method = RequestMethod.POST)
//    @PostMapping
    public String delete(int bookId) {
        bookDao.delete(bookId);
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
