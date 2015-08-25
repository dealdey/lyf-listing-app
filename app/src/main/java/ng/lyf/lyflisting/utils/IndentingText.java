package ng.lyf.lyflisting.utils;

/**
 * Created by Swapnil on 3/19/2015.
 */
public class IndentingText {
    private int space;
    private String text;

    public IndentingText(int space, String text) {
        this.space = space;
        this.text = text;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
