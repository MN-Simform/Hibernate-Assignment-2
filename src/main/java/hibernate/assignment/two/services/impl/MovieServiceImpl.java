package hibernate.assignment.two.services.impl;

import hibernate.assignment.two.entity.Director;
import hibernate.assignment.two.entity.Movie;
import hibernate.assignment.two.repository.MovieRepo;
import hibernate.assignment.two.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepo movieRepo;

    @Override
    public List<Movie> movieList() {
        if (movieRepo.count() == 0) {
            log.info("No Records Exist");
        } else {
            log.info("{} Record Fetched Successfully", movieRepo.count());
        }
        return movieRepo.findAll();
    }

    @Override
    public String addMovie(Movie movie) {
        try{
            if(movie.getMovieName() != null){
                movieRepo.save(movie);
                log.info("Movie Added Successfully");
                return "Movie Added Successfully";
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            log.error("Movie Has Not Been Added");
            log.error("Exception Caught {}", e.getMessage());
            return "Movie Does Not Added";
        }
    }

    @Override
    public String deleteMovie(Movie movie) {
        try{
            if(movie.getId() != null){
                movieRepo.delete(movie);
                log.info("Director From Id :" + movie.getId() + "Has Been Deleted");
                return "Movie Deleted Successfully";
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e){
            log.error("Exception Caught {}", e.getMessage());
            return "Movie Does Not Deleted";
        }
    }

    @Override
    public Movie findMovie(Integer id) {
        Movie movie = movieRepo.findMovieById(id);
        try {
            if (movie != null) {
                log.info("Movie Id :'" + id + "' Fetched");
                return movie;
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            log.error("Id :'" + id + "' doesn't exist");
            log.error("Exception Caught {}" , e.getMessage());
        }
        return movie;
    }
}