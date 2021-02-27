//Complete the Film class with attributes that map to the columns of the film table. Use appropriate datatypes and Java naming conventions.
//Provide getters and setters, and appropriate constructors. Also add a good toString, and equals and hashCode methods.

package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	
	private int id;
	private String title;
	private String description;
	private Integer releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalrate;
	private Integer length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actorsList;
		

	//constructors
	public Film() {
		
	}


	public Film(int id, String title, String description, Integer releaseYear, int languageId, int rentalDuration,
			double rentalrate, Integer length, double replacementCost, String rating, String specialFeatures,
			List<Actor> actorsList) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalrate = rentalrate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actorsList = actorsList;
	}


	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public String getDescription() {
		return description;
	}


	public Integer getReleaseYear() {
		return releaseYear;
	}


	public int getLanguageId() {
		return languageId;
	}


	public int getRentalDuration() {
		return rentalDuration;
	}


	public double getRentalrate() {
		return rentalrate;
	}


	public Integer getLength() {
		return length;
	}


	public double getReplacementCost() {
		return replacementCost;
	}


	public String getRating() {
		return rating;
	}


	public String getSpecialFeatures() {
		return specialFeatures;
	}


	public List<Actor> getActorsList() {
		return actorsList;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}


	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}


	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}


	public void setRentalrate(double rentalrate) {
		this.rentalrate = rentalrate;
	}


	public void setLength(Integer length) {
		this.length = length;
	}


	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}


	public void setActorsList(List<Actor> actorsList) {
		this.actorsList = actorsList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorsList == null) ? 0 : actorsList.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rentalrate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actorsList == null) {
			if (other.actorsList != null)
				return false;
		} else if (!actorsList.equals(other.actorsList))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rentalrate) != Double.doubleToLongBits(other.rentalrate))
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
				+ ", languageId=" + languageId + ", rentalDuration=" + rentalDuration + ", rentalrate=" + rentalrate
				+ ", length=" + length + ", replacementCost=" + replacementCost + ", rating=" + rating
				+ ", specialFeatures=" + specialFeatures + ", actorsList=" + actorsList + "]";
	}
	
	

	
	

	
}


// desc film;
/*                                          Film Table
+------------------+---------------------------------------------------------------------+------+-----+---------+----------------+
| Field            | Type                                                                | Null | Key | Default | Extra          |
+------------------+---------------------------------------------------------------------+------+-----+---------+----------------+
| id               | int(10) unsigned                                                    | NO   | PRI | NULL    | auto_increment |
| title            | varchar(255)                                                        | NO   | MUL | NULL    |                |
| description      | text                                                                | YES  |     | NULL    |                |
| release_year     | year(4)                                                             | YES  |     | NULL    |                |
| language_id      | smallint(5) unsigned                                                | NO   | MUL | NULL    |                |
| rental_duration  | tinyint(3) unsigned                                                 | NO   |     | 3       |                |
| rental_rate      | decimal(4,2)                                                        | NO   |     | 4.99    |                |
| length           | smallint(5) unsigned                                                | YES  |     | NULL    |                |
| replacement_cost | decimal(5,2)                                                        | NO   |     | 19.99   |                |
| rating           | enum('G','PG','PG13','R','NC17')                                    | YES  |     | G       |                |
| special_features | set('Trailers','Commentaries','Deleted Scenes','Behind the Scenes') | YES  |     | NULL    |                |
+------------------+---------------------------------------------------------------------+------+-----+---------+----------------+
*/