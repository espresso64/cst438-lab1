package cst438;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRatingRepository extends CrudRepository<Movie, Long> {
	@Query("select m from Movie m order by movieTitle, date desc")
	
	List<Movie> findAllMovieRatingsOrderByTitleDateDesc();
}
