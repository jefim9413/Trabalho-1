

public class Movie extends Video {
    private String director;

    public Movie(String title, int year, String director) {
        super(title, year);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie [title=" + getTitle() + ", year=" + getYear() + ", director=" + director + "]";
    }
}
