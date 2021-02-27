package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.*;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		String user = "student";
		String pass = "student";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalrate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				List<Actor> actors = new ArrayList<>();
				actors = findActorsByFilmId(rs.getInt("id"));
				film.setActorsList(actors); 
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> findFilmBySearchWord(String searchWordByUser) {
		String user = "student";
		String pass = "student";
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + searchWordByUser + "%");
			stmt.setString(2, "%" + searchWordByUser + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				Integer releaseYear = rs.getInt("release_year");
				int languageId = rs.getInt("language_id");
				int rentalDuration = rs.getInt("rental_duration");
				double rentalrate = rs.getDouble("rental_rate");
				Integer length = rs.getInt("length");
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeatures = rs.getString("special_features");
				List<Actor> actors = new ArrayList<>();
				actors = findActorsByFilmId(id);

				Film film = new Film(id, title, description, releaseYear, languageId, rentalDuration, rentalrate,
						length, replacementCost, rating, specialFeatures, actors);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;
	}

	@Override
	public String findLangByLangId(int langIdNum) {
		String langOfFilm = null;
		String user = "student";
		String pass = "student";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT name FROM language WHERE ? = language.id";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, langIdNum);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				langOfFilm = rs.getString("name");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return langOfFilm;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		String user = "student";
		String pass = "student";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	};

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		String user = "student";
		String pass = "student";
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, first_name, last_name";
			sql += " FROM actor JOIN film_actor ON actor.id = film_actor.actor_id " + " WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Actor actor = new Actor(id, firstName, lastName);
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}
}
