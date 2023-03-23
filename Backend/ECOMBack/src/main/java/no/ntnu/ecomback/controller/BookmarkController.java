package no.ntnu.ecomback.controller;

import no.ntnu.ecomback.model.Bookmark;
import no.ntnu.ecomback.model.User;
import no.ntnu.ecomback.service.BookmarkService;
import no.ntnu.ecomback.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173/")

@RestController
@RequestMapping("/api/bookmark")
public class BookmarkController {

    private static final Logger _logger =
            LoggerFactory.getLogger(ItemService.class);

    private BookmarkService bookmarkService;

    @Autowired
    public void setBookmarkService(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @PostMapping("/add")
    public Bookmark addBookmark(@RequestBody Bookmark bookmark){
        return bookmarkService.addBookmark(bookmark);
    }
    @GetMapping("/get")
    public List<Bookmark> getBookmarks(@RequestBody User user){
        return bookmarkService.getBookmarks(user);
    }

}
