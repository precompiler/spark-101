create table movie_avg_rating (
  title text,
  year text,
  genres text,
  avg_rating decimal,
  primary key(title)
);

create index idx_movie_avg_rating_year on movie_avg_rating(year);
