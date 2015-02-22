package Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.peter.quillcityv3.R;

import java.util.ArrayList;

import Adapter.PoemAdapter;
import Model.Poem;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuillList extends Fragment {

    /* Fields */

    private static volatile QuillList instance;
    private ArrayList<Poem> mPoems;


    public static QuillList getInstance(){
        if(instance == null)
            instance = new QuillList();

        return instance;
    }

    public QuillList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quill_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceStates){
        super.onActivityCreated(savedInstanceStates);

        mPoems = new ArrayList<Poem>();
        mPoems.add(new Poem("Peter", "Android is gay"));

        //declares list view
        ListView listView = (ListView) getActivity().findViewById(R.id.quill_listview);

        //adapter
        PoemAdapter poemAdapter = new PoemAdapter(getActivity(), mPoems);
        listView.setAdapter(poemAdapter);
    }


}
