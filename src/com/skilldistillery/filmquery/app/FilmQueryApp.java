// Notes:
// - Assuming user will give good input

package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.*;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		// User Story 1 -- prompt user for further action
		int uChoice;
		do {
			printMenu();
			uChoice = input.nextInt();
		} while (uChoice < 1 || uChoice > 3);

		// handle user's choice
		switch (uChoice) {
		case 1:
			int filmIdByUser;
			System.out.println(" -- Film Search by Id -- ");
			System.out.println("Please enter the Film Id: ");
			filmIdByUser = input.nextInt();
			System.out.println("Thank you, and let me fetch that for you...\n");
			filmByIdSetUp(filmIdByUser);
			break;
		case 2:
			String searchWord;
			System.out.println(" == Film Search by Search Word == ");
			System.out.println("What is the search word? ");
			searchWord = input.next();
			filmBySearchWordSetUp(searchWord);
			break;
		case 3:
			exitApp();
			break;
		default:
			System.out.println("Sorry, but that selection is invalid. Please try again"); // in case somehow user is
																							// here
			break;
		}
	}

	private void filmByIdSetUp(int filmIdByUser) {
		Film film = db.findFilmById(filmIdByUser);
		if (film == null) {
			System.out.println("Film Not Found");
		} else {
			System.out.println(film.getTitle());
			System.out.println(film.getReleaseYear());
			System.out.println(film.getRating());
			System.out.println(film.getDescription());			
			// display language
			System.out.println(db.findLangByLangId(film.getLanguageId()));
			// display list of actors
			System.out.println(film.getActorsList().toString());
		}
	}

	private void filmBySearchWordSetUp(String searchWordByUser) {
		List<Film> films = db.findFilmBySearchWord(searchWordByUser);
		if (films.size() == 0) {
			System.out.println("Unfortunately, that search word did not produce a good match");
			
		} else {
			for (Film films2: films) {
				System.out.println(films2.getTitle());
				System.out.println(films2.getReleaseYear());
				System.out.println(films2.getRating());
				System.out.println(films2.getDescription());
				// display language
				System.out.println(db.findLangByLangId(films2.getLanguageId()));
				// display list of actors
				System.out.println(films2.getActorsList().toString());

			}
		}

	}

	private void printMenu() {
		System.out.println("Please select: ");
		System.out.println(" ------------------------ ");
		System.out.println("| 1. Film by id          |");
		System.out.println("| 2. Film by search word |");
		System.out.println("| 3. Exit App            |");
		System.out.println(" ------------------------ ");
	}

	private void exitApp() {
		System.out.println("Thank you for you time, and have a good day!");
		System.exit(0);
	}

//	private void test() {
//		// test the findFilmByID
//		Film film = db.findFilmById(1);
//		if (film == null) {
//			System.out.println("Film Not Found");
//		} else {
//			System.out.println(film.getTitle());
//			System.out.println(film.getReleaseYear());
//			System.out.println(film.getRating());
//			System.out.println(film.getDescription());
//		}
//		// test the findActorByID
//		Actor actor = db.findActorById(1);
//		if (actor == null) {
//			System.out.println("Actor Not Found");
//		} else {
//			System.out.println(actor.getFirstName() + " " + actor.getLastName());
//		}
//		// test findActorsByFilmId
//
//		List<Actor> actors = db.findActorsByFilmId(1);
//		if (actors == null) {
//			System.out.println("Film Not Found");
//		} else {
//			for (Actor actor2 : actors) {
//				System.out.println(actor2.getFirstName() + " " + actor2.getLastName() + " \n");
//			}
//		}
//	}
}