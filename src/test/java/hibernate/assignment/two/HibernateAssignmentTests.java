package hibernate.assignment.two;

import hibernate.assignment.two.entity.Movie;
import hibernate.assignment.two.repository.MovieRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HibernateAssignmentTests {

	@Autowired
	MovieRepo movieRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void showMoviesData(){
		List<Movie> movieList = movieRepo.findAll();
		System.out.println(movieList);
	}

}
