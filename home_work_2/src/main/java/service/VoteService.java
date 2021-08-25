package by.it_academy.home_work2.service;


import by.it_academy.home_work2.storage.VoteStorage;

import java.util.List;
import java.util.Map;

public class VoteService {

    private final static VoteService instance = new VoteService();
    private final VoteStorage storage;

    //загружаем в instance значение
    private VoteService() {
        this.storage = VoteStorage.getInstance();
    }

    public void addVote(String artist, String[] genres, String about) {
        /*
        storage - экземпляр класса Storage
        add(about) - метод класса Storage возвращающий текст (about)
         */
        this.storage.getAbout().add(about);
        /*
       getOrDefault - Возвращает значение, которому сопоставлен указанный ключ,
        или defaultValue - значение, если эта карта не содержит сопоставления для ключа
         */
        Integer artistPosition = this.storage.getArtist().getOrDefault(artist, 0);
        /*
        put - возвращает предыдущее значение связанное с ключом, или null, если для ключа не было сопоставления.
        artist - ключ
        ++artistPosition - предыдущее значение увеличенное на 1
         */
        this.storage.getArtist().put(artist, ++artistPosition);


        if (genres != null) {
            if(genres.length<2){
                throw new IllegalArgumentException("Не достаточное количество жанров");
            }
            for (String genre : genres) {
                Integer genrePosition = this.storage.getGenre().getOrDefault(genre, 0);
                this.storage.getGenre().put(genre, ++genrePosition);

            }
        }
    }

    public Map<String, Integer> getArtistResult() {
        return this.storage.getArtist();
    }

    public Map<String, Integer> getGenreResult() {
        return this.storage.getGenre();
    }

    public List<String> getAboutResult() {
        return this.storage.getAbout();
    }

    public static VoteService getInstance() {
        return instance;
    }
}
