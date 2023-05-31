package hibernate.assignment.two.controller;

import hibernate.assignment.two.dto.MovieDto;
import hibernate.assignment.two.entity.Movie;
import hibernate.assignment.two.services.DirectorService;
import hibernate.assignment.two.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    DirectorService directorService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping("/")
    public List<Movie> movieList(){
        return movieService.movieList();
    }

    @RequestMapping(value = "/add_movie", method = RequestMethod.POST)
    public String addMovie(@RequestBody MovieDto movieDto){
        if(movieDto.getMovieName() != null){
            Movie movie = modelMapper.map(movieDto, Movie.class);
            movie.setDirector(directorService.findDirectorId(movieDto.getDirector()));
            movieService.addMovie(movie);
            return "Movie Added Successfully";
        }
        return "Something Went Wrong";
    }

    @RequestMapping(value = "/delete_movie/{id}", method = RequestMethod.DELETE)
    public String deleteMovie(@PathVariable Integer id){
        if(id != null){
            movieService.deleteMovie(movieService.findMovie(id));
            return "Movie Deleted Successfully";
        }
        return "Something Went Wrong";
    }
}
