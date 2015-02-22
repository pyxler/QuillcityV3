package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.peter.quillcityv3.R;

import java.util.ArrayList;

import Model.Poem;

/**
 * Created by Peter on 15-02-21.
 */
public class PoemAdapter extends ArrayAdapter<Poem>{

    private ArrayList<Poem> mPoems;

    private Context mContext;

    public PoemAdapter(Context context, ArrayList<Poem> poems){
        super(context, R.layout.row_list, poems);

        mContext =context;
        mPoems = poems;

    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        View rowView = convertView;

        if (convertView == null) {

            //initialise inflater
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //inflate row layout
            rowView = inflater.inflate(R.layout.row_list, parent, false);

            TextView author = (TextView) rowView.findViewById(R.id.row_author);
            TextView summary = (TextView) rowView.findViewById(R.id.row_summary);

            author.setText(mPoems.get(position).getAuthor());
            summary.setText(mPoems.get(position).getPoem());
        }

        return rowView;
    }
}
