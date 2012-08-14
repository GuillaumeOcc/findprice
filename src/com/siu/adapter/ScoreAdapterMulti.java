package com.siu.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.siu.R;
import com.siu.model.ScoreMulti;


import java.util.List;




/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 13/08/12
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public class ScoreAdapterMulti extends ArrayAdapter<ScoreMulti> {

    public ScoreAdapterMulti(Context context, List<ScoreMulti> objects) {
        super(context, R.layout.list_score_row_multi, objects);
    }

    @Override
    public View getView(int position, View row, ViewGroup parent) {
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_score_row_multi, null);             // ligne
        }

        ScoreMulti scoreMulti = getItem(position);

        ViewHolder viewHolder = (ViewHolder) row.getTag();

        if (viewHolder == null) {                         // equivalent d'un cache
            viewHolder = new ViewHolder(row);
            row.setTag(viewHolder);
        }

        viewHolder.scoreNom1.setText(scoreMulti.getName1().toString()+" a battu ");
        viewHolder.scoreNom2.setText(scoreMulti.getName2().toString());

        return row;
    }
    private static class ViewHolder {

        protected TextView scoreNom1;
        protected TextView scoreNom2;

        ViewHolder(View row) {                  //permet de prendre les parametres de la vue de la ligne
            scoreNom1 = (TextView) row.findViewById(R.id.score_nom1_multi);
            scoreNom2 = (TextView) row.findViewById(R.id.score_nom2_multi);
        }
    }
}