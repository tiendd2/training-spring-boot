package com.tiendd.bookservice.api.service;

import com.tiendd.bookservice.api.model.Author;
import com.tiendd.bookservice.api.model.Book;
import com.tiendd.bookservice.api.model.Category;
import com.tiendd.bookservice.api.model.Publisher;
import com.tiendd.bookservice.responsitory.AuthorRespository;
import com.tiendd.bookservice.responsitory.CategoryRespository;
import com.tiendd.bookservice.responsitory.PersonRespository;
import com.tiendd.bookservice.utils.validator.CommonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService extends CommonService {
    @Autowired
    AuthorRespository authorRespository;

    @Autowired
    CategoryRespository categoryRespository;

    @Autowired
    PersonRespository personRespository;

    public BookService(@Qualifier("bookRespository") JpaRepository repository,
                       @Qualifier("book") CommonValidator validator) {
        super(repository, validator);
    }

    @Override
    public Object addItem(Object object) {
        if (validator.isValid(object)) {
            if (authorRespository.findById(((Book) object).getAuthor().getId()).isEmpty()) {
                Author author = authorRespository.save(((Book) object).getAuthor());
                ((Book) object).setAuthor(author);
            }
            if (categoryRespository.findById(((Book) object).getCategory().getId()).isEmpty()) {
                Category category = categoryRespository.save(((Book) object).getCategory());
                ((Book) object).setCategory(category);
            }
            if (personRespository.findById(((Book) object).getPublisher().getId()).isEmpty()) {
                Publisher publisher = personRespository.save(((Book) object).getPublisher());
                ((Book) object).setPublisher(publisher);
            }
            return repository.save(object);
        }
        return null;
    }
}
