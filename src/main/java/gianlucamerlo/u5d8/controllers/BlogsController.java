package gianlucamerlo.u5d8.controllers;

import gianlucamerlo.u5d7.entities.Blog;
import gianlucamerlo.u5d7.payloads.NewBlogPayload;
import gianlucamerlo.u5d7.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
    @Autowired
    private BlogsService blogsService;

    @GetMapping
    public List<Blog> getBlogs(){
        return this.blogsService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createBlog(@RequestBody NewBlogPayload body){
        return this.blogsService.saveBlog(body);
    }

    @GetMapping("/{blogId}")
    public Blog getBlogById(@PathVariable int blogId){
        return this.blogsService.findById(blogId);
    }

    @PutMapping("/{blogId}")
    public Blog findBlogByIdAndUpdate(@PathVariable int blogId,@RequestBody NewBlogPayload body)
    {
        return this.blogsService.findByIdAndUpdate(blogId,body);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findBlogByIdAndDelete(@PathVariable int blogId){
        this.blogsService.findByIdAndDelete(blogId);
    }

}
