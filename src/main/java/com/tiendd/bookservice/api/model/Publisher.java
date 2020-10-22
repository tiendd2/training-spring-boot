package com.tiendd.bookservice.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tiendd.bookservice.utils.core.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Publisher extends Person {

    public Publisher() {
        setType((int) Constant.PUBLISHER_TYPE);
    }

    public Publisher(Long id, String fullName, String address, String phoneNumber, Integer type, Collection<Book> books) {
        super(id, fullName, address, phoneNumber, type);
        this.books = books;
        setType((int) Constant.PUBLISHER_TYPE);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Book> books;
}
