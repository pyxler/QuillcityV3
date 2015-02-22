package Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.peter.quillcityv3.R;

import Model.Poem;

/**
 * A simple {@link Fragment} subclass.
 */
public class Reader extends Fragment {

    private static volatile Reader instance;
    private static Poem mPoem;

    private TextView author;
    private TextView poem;
    private ImageButton Like;
    private Button Neutral;
    private ImageButton Dislike;

    public static Reader getInstance(){
        if (instance == null)
            instance = new Reader();

        return instance;
    }

    public Reader() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reader, container, false);
    }

    @Override
    public void onActivityCreated(Bundle onSavedInstances){
        super.onActivityCreated(onSavedInstances);
        mPoem = new Poem("Peter","All the world's a page and all the men and women are merely quillers");
        author = (TextView) getActivity().findViewById(R.id.reader_author);
        poem = (TextView) getActivity().findViewById(R.id.reader_poem);

        Like = (ImageButton) getActivity().findViewById(R.id.reader_positive);
        Dislike = (ImageButton) getActivity().findViewById(R.id.reader_negative);

        Like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPoem.Liked();
                Like.setVisibility(View.GONE);
                Dislike.setVisibility(View.GONE);
            }
        });

        Dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPoem.Disliked();
                Like.setVisibility(View.GONE);
                Dislike.setVisibility(View.GONE);
            }
        });

        author.setText("By " + mPoem.getAuthor());
        poem.setText(mPoem.getPoem());
    }

    public void setPoem(Poem nPoem){
        mPoem = nPoem;

        author.setText("By " +  mPoem.getAuthor());
        poem.setText(mPoem.getPoem());

        Like.setVisibility(View.VISIBLE);
        Dislike.setVisibility(View.VISIBLE);
    }


}
