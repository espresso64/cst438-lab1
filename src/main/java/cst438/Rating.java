package cst438;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Rating {
	@Autowired
	MovieRatingRepository MovieRatingRepository;

	// Get request to get form to user
	@GetMapping("/movies/new")
	public String createMovie(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "movie_form";
	}

	// After form submission, checks validation and sets time of movie
	@PostMapping("/movies/new")
	public String processMovieForm(@Valid Movie movie, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "movie_form";
		}
		DateFormat dateFormating = new SimpleDateFormat("M-dd-yyyy hh:mm:ss");    

		Date time = new java.util.Date();
	
		String timeString = (dateFormating.format(time)).toString();
		
		
		movie.setDate(timeString);
		MovieRatingRepository.save(movie);
		return "movie_confirm";
	}

	// gives back the list
	@GetMapping("/movies")
	public String getAllMovies(Model model) {
		Iterable<Movie> allMovies = MovieRatingRepository.findAllMovieRatingsOrderByTitleDateDesc();
		model.addAttribute("movies", allMovies);
		return "movie_list";
	}

}
