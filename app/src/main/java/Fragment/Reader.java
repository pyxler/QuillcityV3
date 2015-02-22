package Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.peter.quillcityv3.R;

import Model.Poem;

/**
 * A simple {@link Fragment} subclass.
 */
public class Reader extends Fragment {

    private static volatile Reader instance;
    private static Poem mPoem;

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
        TextView author = (TextView) getActivity().findViewById(R.id.reader_author);
        TextView poem = (TextView) getActivity().findViewById(R.id.reader_poem);

        author.setText(mPoem.getAuthor());
        poem.setText(mPoem.getPoem());
    }


}
