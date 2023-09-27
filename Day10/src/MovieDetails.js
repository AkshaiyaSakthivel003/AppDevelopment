import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import './MovieDetails.css';

const MovieBackdrop = ({ backdropPath }) => (
  <div className="movie__intro">
    <img className="movie__backdrop" src={`https://image.tmdb.org/t/p/original${backdropPath}`} alt="Movie Backdrop" />
  </div>
);

const MoviePoster = ({ posterPath }) => (
  <div className="movie__posterBox">
    <img className="movie__poster" src={`https://image.tmdb.org/t/p/original${posterPath}`} alt="Movie Poster" />
  </div>
);

const MovieDetailInfo = ({ movie }) => (
  <div className="movie__detailRightTop">
    <div className="movie__name">{movie?.original_title || ''}</div>
    <div className="movie__tagline">{movie?.tagline || ''}</div>
    <div className="movie__rating">
      {movie ? `${movie.vote_average} ` : ''}<i className="fas fa-star" />
      <span className="movie__voteCount">{movie ? `(${movie.vote_count}) votes` : ''}</span>
    </div>
    <div className="movie__runtime">{movie?.runtime || ''} mins</div>
    <div className="movie__releaseDate">{movie ? `Release date: ${movie.release_date}` : ''}</div>
    <div className="movie__genres">
      {movie && movie.genres
        ? movie.genres.map((genre) => <span className="movie__genre" key={genre.id}>{genre.name}</span>)
        : ''}
    </div>
  </div>
);

const MovieSynopsis = ({ overview }) => (
  <div className="movie__detailRightBottom">
    <div className="synopsisText">SYNOPSIS</div>
    <div>{overview || ''}</div>
  </div>
);

const MovieActions = ({ isFavorite, handleToggleFavorite }) => (
  <div className="mdetails">
    <button onClick={handleToggleFavorite} className={isFavorite ? 'rem' : 'add'}>
      &#10084; {isFavorite ? 'Remove from Favorites' : 'Add to Favorites'}
    </button>
  </div>
);

const ProductionCompanies = ({ movie }) => (
  <div className="movie__production">
    {movie &&
      movie.production_companies &&
      movie.production_companies.map((company) => (
        <div key={company.id} className="productionCompanyImage">
          <img
            className="movie__productionCompany"
            src={`https://image.tmdb.org/t/p/original${company.logo_path}`}
            alt="Production Company"
            height={70}
            width={270}
          />
          <span>{company.name}</span>
        </div>
      ))}
  </div>
);

const MovieDetails = () => {
  const [currentMovieDetail, setMovie] = useState(null);
  const [favorites, setFavorites] = useState([]);
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    const storedFavorites = JSON.parse(localStorage.getItem('favorites')) || [];
    setFavorites(storedFavorites);
  }, []);

  useEffect(() => {
    getData();
    window.scrollTo(0, 0);
  }, []);

  const getData = () => {
    fetch(`https://api.themoviedb.org/3/movie/${id}?api_key=4e44d9029b1270a757cddc766a1bcb63&language=en-US`)
      .then((res) => res.json())
      .then((data) => setMovie(data));
  };

  const handleToggleFavorite = () => {
    const isCurrentlyFavorite = favorites.find((fav) => fav.id === currentMovieDetail?.id);
    const updatedFavorites = isCurrentlyFavorite
      ? favorites.filter((fav) => fav.id !== currentMovieDetail.id)
      : [...favorites, currentMovieDetail];
    setFavorites(updatedFavorites);
    localStorage.setItem('favorites', JSON.stringify(updatedFavorites));
  };

  const handleHomepageClick = () => {
    if (currentMovieDetail && currentMovieDetail.homepage) {
      window.open(currentMovieDetail.homepage, "_blank");
    }
  };

  const handleIMDBClick = () => {
    if (currentMovieDetail && currentMovieDetail.imdb_id) {
      window.open(`https://www.imdb.com/title/${currentMovieDetail.imdb_id}`, "_blank");
    }
  };

  return (
    <div className="movie">
      <MovieBackdrop backdropPath={currentMovieDetail?.backdrop_path} />
      <div className="movie__detail">
        <div className="movie__detailLeft">
          <MoviePoster posterPath={currentMovieDetail?.poster_path} />
        </div>
        <div className="movie__detailRight">
          <MovieDetailInfo movie={currentMovieDetail} />
          <MovieSynopsis overview={currentMovieDetail?.overview} />
          <div className="mcont">
            <div className="mcard" key={currentMovieDetail?.id}>
              <MovieActions
                isFavorite={favorites.find((fav) => fav.id === currentMovieDetail?.id)}
                handleToggleFavorite={handleToggleFavorite}
              />
            </div>
          </div>
        </div>
      </div>
      <div className="movie__links">
        <div className="movie__heading1">LINKS</div>
        {currentMovieDetail && currentMovieDetail.homepage && (
          <div onClick={handleHomepageClick} style={{ cursor: 'pointer', textDecoration: 'none' }}>
            <p>
              <span className="movie__homeButton">Homepage </span>
            </p>
          </div>
        )}
        {currentMovieDetail && currentMovieDetail.imdb_id && (
          <div onClick={handleIMDBClick} style={{ cursor: 'pointer', textDecoration: 'none' }}>
            <p>
              <span className="movie__imdbButton">IMDb</span>
            </p>
          </div>
        )}
      </div>
      <div className="movie__heading2">PRODUCTION COMPANIES</div>
      <ProductionCompanies movie={currentMovieDetail} />
    </div>
  );
};

export default MovieDetails;
