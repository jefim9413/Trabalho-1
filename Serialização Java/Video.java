import java.io.Serializable;

public class Video implements Serializable {
    private String title;
    private int year;

    public Video(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Video [title=" + title + ", year=" + year + "]";
    }
}
