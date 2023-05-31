package hibernate.assignment.two.services.impl;

import hibernate.assignment.two.entity.Movie;
import hibernate.assignment.two.repository.MovieRepo;
import hibernate.assignment.two.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepo movieRepo;

    @Override
    public List<Movie> movieList() {
        return movieRepo.findAll();
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepo.save(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepo.delete(movie);
    }

    @Override
    public Movie findMovie(Integer id) {
        return movieRepo.findMovieById(id);
    }

}