package Model;

/**
 * Created by Peter on 15-02-21.
 */
public class Poem {

    private String mAuthor;
    private boolean mAnonymous;
    private String mPoem;
    private double mLat;
    private double mLong;

    //mock constructor
    public Poem(String author, String Text){
        mAuthor = author;
        mPoem = Text;
    }

    public String getAuthor(){
        return mAuthor;
    }

    public boolean isAnonymous(){
        return mAnonymous;
    }

    public String getPoem(){
        return mPoem;
    }

    public double getLat(){
        return mLat;
    }

    public double getLong(){
        return mLong;
    }
}
