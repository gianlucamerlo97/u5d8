package gianlucamerlo.u5d8.services;

import gianlucamerlo.u5d8.entities.Blog;
import gianlucamerlo.u5d8.exceptions.NotFoundException;
import gianlucamerlo.u5d8.payloads.NewBlogPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BlogsService {
    private List<Blog> blogsDB= new ArrayList<>();

    public List<Blog> findAll(){
        return this.blogsDB;
    }

    public Blog saveBlog(NewBlogPayload payload){
        Blog newBlog=new Blog(payload.getCategoria(), payload.getTitolo(), "https://picsum.photos/200/300", payload.getContenuto(), payload.getTempoDiLettura());
        this.blogsDB.add(newBlog);
        log.info("Il blog della categoria "+payload.getCategoria()+" è stato salvato correttamente");
        return newBlog;
    }

//    public Blog findById(int blogId){
//        Blog found=null;
//        for(Blog blog:this.blogsDB){
//            if(blog.getId()==blogId) found=blog;
//        }
//        if (found==null) throw new NotFoundException(blogId);
//        return found;
//    }
//
//    public Blog findByIdAndUpdate(int blogId,NewBlogPayload payload){
//        Blog found=null;
//        for(Blog blog:this.blogsDB) {
//            if (blog.getId() == blogId) {
//                found = blog;
//                found.setCategoria(payload.getCategoria());
//                found.setContenuto(payload.getContenuto());
//                found.setTitolo(payload.getTitolo());
//                found.setTempoDiLettura(payload.getTempoDiLettura());
//
//            }
//        }
//            if (found==null) throw new NotFoundException(blogId);
//            return found;
//    }

//    public void findByIdAndDelete(int blogId){
//        Blog found=null;
//        for(Blog blog:this.blogsDB) {
//            if (blog.getId() == blogId)
//                found = blog;
//        }
//            if (found==null) throw new NotFoundException(blogId);
//            this.blogsDB.remove(found);
//    }
}
