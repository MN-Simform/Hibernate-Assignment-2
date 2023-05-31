package hibernate.assignment.two.services;

import hibernate.assignment.two.entity.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> movieList();

    public void addMovie(Movie movie);

    public void deleteMovie(Movie movie);

    public Movie findMovie(Integer id);
}
