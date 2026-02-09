package ca.bcit.bookstore2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the bookstore.
 *
 * @author Alex Lee
 * @author asd
 *
 * @version 1.0
 */
public class BookStore
{
    private static final int DECADE_OFFSET = 9;

    private static final String EMPTY_STRING = "";

    private static final int INITIAL_YEAR = 1;
    private static final int CURRENT_YEAR = 2026;

    private static final double PERCENTAGE =  100.0;

    private final String bookStoreName;
    private final List<Novel> novels;

    /**
     * Creates the bookstore.
     *
     * @param bookStoreName name of the bookstore
     */
    public BookStore(final String bookStoreName)
    {
        validateBookStoreName(bookStoreName);

        this.bookStoreName = bookStoreName;
        this.novels = new ArrayList<>();

        populateNovels();
        validateNovels();
    }

    /**
     * Validates a bookstore name.
     *
     * @param bookStoreName the name to validate
     */
    private void validateBookStoreName(final String bookStoreName)
    {
        if(bookStoreName == null || bookStoreName.isBlank())
        {
            throw new IllegalArgumentException("bookstore name must be provided");
        }
    }

    @Override
    public String toString()
    {
        return "BookStore{" +
                "bookStoreName='" + bookStoreName + '\'' +
                ", novels=" + novels +
                '}';
    }

    /**
     * Prints all the titles of the novel in the bookstore in uppercase.
     */
    public void printAllTitles()
    {
        for(final Novel novel : novels)
        {
            System.out.println(novel.getTitle().toUpperCase());
        }
    }

    /**
     * Prints all titles that contain the specified parameter.
     *
     * @param title a specific parameter to be found in title.
     */
    public void printBookTitle(final String title)
    {
        for(final Novel novel : novels)
        {
            if(novel.getTitle().toLowerCase().contains(title))
            {
                System.out.println(novel.getTitle());
            }
        }
    }

    /**
     * Prints all titles in alphabetical order, A-Z.
     */
    public void printTitlesInAlphaOrder()
    {
        List<String> titles = new ArrayList<>();

        for (final Novel novel : novels) {
            titles.add(novel.getTitle());
        }

        titles.sort(String.CASE_INSENSITIVE_ORDER);

        for (final String title : titles) {
            System.out.println(title);
        }
    }

    /**
     * Prints all books for the inputted decade up to its upperbound.
     */
    public void printGroupByDecade(final int decade)
    {
        final int decadeUpperbound = decade + DECADE_OFFSET;

        for(final Novel novel : novels)
        {
            int novelYear = novel.getYearPublished();
            if(novelYear >= decade && novelYear <= decadeUpperbound)
            {
                System.out.println(novel.getTitle());
            }
        }
    }

    /**
     * Finds the longest title in the bookstore.
     */
    public void getLongest()
    {
        String longestTitle = EMPTY_STRING;

        for(final Novel novel : novels)
        {
            final String title;

            title = novel.getTitle();

            if(title.length() > longestTitle.length())
            {
                longestTitle = title;
            }
        }
        System.out.println(longestTitle);
    }

    /**
     * Checks if there is a book that is written in specific year.
     *
     * @param year specific year the book is published
     *
     * @return true if there is one, false otherwise
     */
    public boolean isThereABookWrittenBetween(final int year)
    {
        if (year < INITIAL_YEAR || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException(
                    "year must be between " + INITIAL_YEAR + " and " + CURRENT_YEAR);
        }

        boolean found = false;

        for (final Novel novel : novels)
        {
            if (novel.getYearPublished() == year)
            {
                found = true;
                break;
            }
        }
        return found;
    }


    /**
     * Counts how many books contain specific word.
     *
     * @param word specific word to be found
     *
     * @return number of books containing the word
     */
    public int howManyBooksContain(final String word)
    {
        int counter = 0;

        for(final Novel novel : novels)
        {
            if(novel.getTitle().toLowerCase().contains(word.toLowerCase()))
            {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Calculate the percentage of the book were written between these two years.
     *
     * @param first left bound of the year
     * @param last right bound of the year
     *
     * @return percentage of the book
     */
    public double whichPercentWrittenBetween(final int first, final int last)
    {
        double percentage;

        if (first > last)
        {
            throw new IllegalArgumentException(
                    "first year must be less than or equal to last year");
        }

        if (first < INITIAL_YEAR || last > CURRENT_YEAR)
        {
            throw new IllegalArgumentException(
                    "Year must be between " + INITIAL_YEAR + " and " + CURRENT_YEAR);
        }

        int numberCounter = 0;

        for (final Novel novel : novels)
        {
            int year = novel.getYearPublished();
            if (year >= first && year <= last)
            {
                numberCounter++;
            }
        }

        percentage = numberCounter * PERCENTAGE / novels.size();

        return percentage;
    }


    /**
     * Returns the oldest book in the bookstore.
     */
    public Novel getOldestBook()
    {
        if (novels.isEmpty())
        {
            return null;
        }

        Novel oldest = null;

        for (Novel novel : novels)
        {
            if (oldest == null ||
                    novel.getYearPublished() < oldest.getYearPublished()) {
                oldest = novel;
            }
        }

        return oldest;
    }


    /**
     * Returns a List of all books whose title is this length
     *
     * @param titleLength desired length of the title
     *
     * @return desired list of novel
     */
    public List<Novel> getBooksThisLength(final int titleLength )
    {
        List<Novel> desiredBook;
        desiredBook = new ArrayList<>();

        for(final Novel novel : novels)
        {
            String title = novel.getTitle();
            if(title.length() == titleLength)
                desiredBook.add(novel);
        }
        return desiredBook;
    }

    /**
     * Returns all novel present.
     *
     * @return list of novels
     */
    public List<Novel> getAllNovels()
    {
        return novels;
    }

    /**
     * Assigns the novel to bookstore class.
     */
    public void populateNovels()
    {
        novels.add(new Novel("The Adventures of Augie March", "Saul Bellow", 1953));
        novels.add(new Novel("All the King’s Men", "Robert Penn Warren", 1946));
        novels.add(new Novel("American Pastoral", "Philip Roth", 1997));
        novels.add(new Novel("An American Tragedy", "Theodore Dreiser", 1925));
        novels.add(new Novel("Animal Farm", "George Orwell", 1946));
        novels.add(new Novel("Appointment in Samarra", "John O'Hara", 1934));
        novels.add(new Novel("Are You There God? It's Me, Margaret.", "Judy Blume", 1970));
        novels.add(new Novel("The Assistant", "Bernard Malamud", 1957));
        novels.add(new Novel("At Swim-Two-Birds", "Flann O'Brien", 1938));
        novels.add(new Novel("Atonement", "Ian McEwan", 2002));
        novels.add(new Novel("Beloved", "Toni Morrison", 1987));
        novels.add(new Novel("The Berlin Stories", "Christopher Isherwood", 1946));
        novels.add(new Novel("The Big Sleep", "Raymond Chandler", 1939));
        novels.add(new Novel("The Blind Assassin", "Margaret Atwood", 2000));
        novels.add(new Novel("Blood Meridian", "Cormac McCarthy", 1986));
        novels.add(new Novel("Brideshead Revisited", "Evelyn Waugh", 1946));
        novels.add(new Novel("The Bridge of San Luis Rey", "Thornton Wilder", 1927));
        novels.add(new Novel("Call It Sleep", "Henry Roth", 1935));
        novels.add(new Novel("Catch-22", "Joseph Heller", 1961));
        novels.add(new Novel("The Catcher in the Rye", "J.D. Salinger", 1951));
        novels.add(new Novel("A Clockwork Orange", "Anthony Burgess", 1963));
        novels.add(new Novel("The Confessions of Nat Turner", "William Styron", 1967));
        novels.add(new Novel("The Corrections", "Jonathan Franzen", 2001));
        novels.add(new Novel("The Crying of Lot 49", "Thomas Pynchon", 1966));
        novels.add(new Novel("A Dance to the Music of Time", "Anthony Powell", 1951));
        novels.add(new Novel("The Day of the Locust", "Nathanael West", 1939));
        novels.add(new Novel("Death Comes for the Archbishop", "Willa Cather", 1927));
        novels.add(new Novel("A Death in the Family", "James Agee", 1958));
        novels.add(new Novel("The Death of the Heart", "Elizabeth Bowen", 1958));
        novels.add(new Novel("Deliverance", "James Dickey", 1970));
        novels.add(new Novel("Dog Soldiers", "Robert Stone", 1974));
        novels.add(new Novel("Falconer", "John Cheever", 1977));
        novels.add(new Novel("The French Lieutenant's Woman", "John Fowles", 1969));
        novels.add(new Novel("The Golden Notebook", "Doris Lessing", 1962));
        novels.add(new Novel("Go Tell It on the Mountain", "James Baldwin", 1953));
        novels.add(new Novel("Gone with the Wind", "Margaret Mitchell", 1936));
        novels.add(new Novel("The Grapes of Wrath", "John Steinbeck", 1939));
        novels.add(new Novel("Gravity's Rainbow", "Thomas Pynchon", 1973));
        novels.add(new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        novels.add(new Novel("A Handful of Dust", "Evelyn Waugh", 1934));
        novels.add(new Novel("The Heart Is a Lonely Hunter", "Carson McCullers", 1940));
        novels.add(new Novel("The Heart of the Matter", "Graham Greene", 1948));
        novels.add(new Novel("Herzog", "Saul Bellow", 1964));
        novels.add(new Novel("Housekeeping", "Marilynne Robinson", 1981));
        novels.add(new Novel("A House for Mr. Biswas", "V.S. Naipaul", 1962));
        novels.add(new Novel("I, Claudius", "Robert Graves", 1934));
        novels.add(new Novel("Infinite Jest", "David Foster Wallace", 1996));
        novels.add(new Novel("Invisible Man", "Ralph Ellison", 1952));
        novels.add(new Novel("Light in August", "William Faulkner", 1932));
        novels.add(new Novel("The Lion, The Witch and the Wardrobe", "C.S. Lewis", 1950));
        novels.add(new Novel("Lolita", "Vladimir Nabokov", 1955));
        novels.add(new Novel("Lord of the Flies", "William Golding", 1954));
        novels.add(new Novel("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        novels.add(new Novel("Loving", "Henry Green", 1945));
        novels.add(new Novel("Lucky Jim", "Kingsley Amis", 1954));
        novels.add(new Novel("The Man Who Loved Children", "Christina Stead", 1940));
        novels.add(new Novel("Midnight's Children", "Salman Rushdie", 1981));
        novels.add(new Novel("Money", "Martin Amis", 1984));
        novels.add(new Novel("The Moviegoer", "Walker Percy", 1961));
        novels.add(new Novel("Mrs. Dalloway", "Virginia Woolf", 1925));
        novels.add(new Novel("Naked Lunch", "William Burroughs", 1959));
        novels.add(new Novel("Native Son", "Richard Wright", 1940));
        novels.add(new Novel("Neuromancer", "William Gibson", 1984));
        novels.add(new Novel("Never Let Me Go", "Kazuo Ishiguro", 2005));
        novels.add(new Novel("1984", "George Orwell", 1948));
        novels.add(new Novel("On the Road", "Jack Kerouac", 1957));
        novels.add(new Novel("One Flew Over the Cuckoo's Nest", "Ken Kesey", 1962));
        novels.add(new Novel("The Painted Bird", "Jerzy Kosinski", 1965));
        novels.add(new Novel("Pale Fire", "Vladimir Nabokov", 1962));
        novels.add(new Novel("A Passage to India", "E.M. Forster", 1924));
        novels.add(new Novel("Play It as It Lays", "Joan Didion", 1970));
        novels.add(new Novel("Portnoy's Complaint", "Philip Roth", 1969));
        novels.add(new Novel("Possession", "A.S. Byatt", 1990));
        novels.add(new Novel("The Power and the Glory", "Graham Greene", 1939));
        novels.add(new Novel("The Prime of Miss Jean Brodie", "Muriel Spark", 1961));
        novels.add(new Novel("Rabbit, Run", "John Updike", 1960));
        novels.add(new Novel("Ragtime", "E.L. Doctorow", 1975));
        novels.add(new Novel("The Recognitions", "William Gaddis", 1955));
        novels.add(new Novel("Red Harvest", "Dashiell Hammett", 1929));
        novels.add(new Novel("Revolutionary Road", "Richard Yates", 1961));
        novels.add(new Novel("The Sheltering Sky", "Paul Bowles", 1949));
        novels.add(new Novel("Slaughterhouse-Five", "Kurt Vonnegut", 1969));
        novels.add(new Novel("Snow Crash", "Neal Stephenson", 1992));
        novels.add(new Novel("The Sot-Weed Factor", "John Barth", 1960));
        novels.add(new Novel("The Sound and the Fury", "William Faulkner", 1929));
        novels.add(new Novel("The Sportswriter", "Richard Ford", 1986));
        novels.add(new Novel("The Spy Who Came in from the Cold", "John le Carré", 1964));
        novels.add(new Novel("The Sun Also Rises", "Ernest Hemingway", 1926));
        novels.add(new Novel("Their Eyes Were Watching God", "Zora Neale Hurston", 1937));
        novels.add(new Novel("Things Fall Apart", "Chinua Achebe", 1959));
        novels.add(new Novel("To Kill a Mockingbird", "Harper Lee", 1960));
        novels.add(new Novel("To the Lighthouse", "Virginia Woolf", 1929));
        novels.add(new Novel("Tropic of Cancer", "Henry Miller", 1934));
        novels.add(new Novel("Ubik", "Philip K. Dick", 1969));
        novels.add(new Novel("Under the Net", "Iris Murdoch", 1954));
        novels.add(new Novel("Under the Volcano", "Malcolm Lowry", 1947));
        novels.add(new Novel("Watchmen", "Alan Moore and Dave Gibbons", 1986));
        novels.add(new Novel("White Noise", "Don DeLillo", 1985));
        novels.add(new Novel("White Teeth", "Zadie Smith", 2000));
        novels.add(new Novel("Wide Sargasso Sea", "Jean Rhys", 1966));
    }

    /**
     * Validate the Novel array.
     */
    private void validateNovels() {
        if (novels.isEmpty()) {
            throw new IllegalStateException("Bookstore must contain novels");
        }

        for (Novel n : novels) {
            if (n == null) {
                throw new IllegalStateException("Novel list contains null");
            }
        }
    }
}
