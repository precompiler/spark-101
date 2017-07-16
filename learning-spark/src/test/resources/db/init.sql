create schema if not exists ut;

create table ut.movie_rating(movie_id varchar2(100), movie_title varchar2(500), movie_year varchar2(4), avg_rating decimal(5, 2) );