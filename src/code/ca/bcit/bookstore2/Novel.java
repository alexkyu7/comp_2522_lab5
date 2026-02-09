package ca.bcit.bookstore2;

/**
 * Represents the Novel.
 *
 * @author Alex Lee
 * @author asd
 *
 * @version 1.0
 */
public class Novel
{
    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_BOOK_NAME = 50;

    private static final int INITIAL_YEAR = 1;
    private static final int CURRENT_YEAR = 2026;

    private final String title;
    private final String authorName;
    private final int yearPublished;


    public Novel(final String title,
                 final String authornName,
                 final int yearPublished)
    {
        validateTitle(title);
        validateName(authornName);
        validateYearPublished(yearPublished);

        this.title = title;
        this.authorName = authornName;
        this.yearPublished = yearPublished;
    }

    /**
     * Getter for title.
     *
     * @return title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Getter for novel name.
     *
     * @return novel name
     */
    public String getAuthorName()
    {
        return authorName;
    }

    /**
     * Getter for year a novel is published.
     *
     * @return year it published
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Validates a name.
     *
     * @param name the name to validate
     */
    private void validateName(final String name)
    {
        if(name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name must be provided");
        }

        if(name.length() > MAX_NAME_LENGTH)
        {
            throw new IllegalArgumentException("name cannot be over " + MAX_NAME_LENGTH + "long.") ;
        }
    }

    /**
     * Validates the book title.
     *
     * @param title the title to validate
     */
    private void validateTitle(final String title)
    {
        if(title == null || title.isBlank())
        {
            throw new IllegalArgumentException("title must be provided");
        }

        if(title.length() > MAX_BOOK_NAME)
        {
            throw new IllegalArgumentException("Title cannot be over " + MAX_BOOK_NAME + " long.") ;
        }
    }

    /**
     * Validates the publication year.
     *
     * @param year the publication year to validate
     */
    private void validateYearPublished(final int year)
    {
        if(year < INITIAL_YEAR|| year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException(
                    "year published must be between " + INITIAL_YEAR +
                            " and " + CURRENT_YEAR + ".");
        }
    }

    /**
     * ToString method to show all the instance variables for novel.
     *
     * @return String of all instance variable
     */
    @Override
    public String toString()
    {
        return "Novel{" +
                "title='" + title + '\'' +
                ", name='" + authorName + '\'' +
                ", yearPublished=" + yearPublished +
                '}' + "\n";
    }
}
