package blog_manager_ajax.service.impl;

import blog_manager_ajax.model.Blog;
import blog_manager_ajax.repository.IBlogRepository;
import blog_manager_ajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(String id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog);
    }

    @Override
    public List<Blog> findAllBlogByCategoryId(String id) {
        return iBlogRepository.findAllBlogByCategoryId(id)  ;
    }

    @Override
    public Page<Blog> findAllBlogByTitle(String title, Pageable pageable) {
        return iBlogRepository.findBlogByTitleContaining(title,pageable);
    }

    public Object findName(Pageable pageable, String name) {
        return null;
    }

    public void remove(Integer id) {
    }
}
