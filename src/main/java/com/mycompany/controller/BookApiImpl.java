package com.mycompany.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.api.BooksApi;
import com.mycompany.model.Book;
import com.mycompany.model.BookInput;
import com.mycompany.model.InventoryItem;

import jakarta.validation.Valid;

@RestController
public class BookApiImpl implements BooksApi {

  @Override
  public ResponseEntity<Void> addNewBook(@Valid BookInput bookInput) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addNewBook'");
  }

  @Override
  public ResponseEntity<Book> getBookDetails(String bookId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getBookDetails'");
  }

  @Override
  public ResponseEntity<List<InventoryItem>> getInventory() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getInventory'");
  }

  @Override
  public ResponseEntity<List<Book>> retrieveAllBooks(@Valid String category, @Valid String availability) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'retrieveAllBooks'");
  }}
