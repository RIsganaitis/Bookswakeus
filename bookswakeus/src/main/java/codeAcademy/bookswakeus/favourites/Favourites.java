package codeAcademy.bookswakeus.favourites;

import codeAcademy.bookswakeus.books.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Favourites {

    private final List<FavouritesItem> favs;

//    private final List<FavouritesItem> items = new ArrayList<>();

    public Favourites(){
        this.favs = new ArrayList<>();
    }

    public void add(Book book) {
        Optional<FavouritesItem> item = favs.stream()
                        .filter(i -> i.getBook().getId().equals(book.getId()))
                        .findFirst();

        if(!item.isPresent()){
            favs.add(new FavouritesItem(book));
        }
    }

//    public void remove(Book book) {
//        Optional<FavouritesItem> item = favs.stream()
//                .filter(i -> i.getBook().getId().equals(book.getId()))
//                .findFirst();
//
//        if(item.isPresent()){
//            favs.remove(item);
//        }
//    }

    @Data
    public static class FavouritesItem {
        private final Book book;
    }

    public int getSize(){
        return favs.size();
    }

}