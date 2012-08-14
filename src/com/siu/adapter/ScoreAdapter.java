package com.siu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.siu.R;
import com.siu.model.Score;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Chedly
 * Date: 26/06/12
 * Time: 14:22
 * To change this template use File | Settings | File Templates.
 */
public class ScoreAdapter extends ArrayAdapter<Score> {

    public ScoreAdapter(Context context, List<Score> objects) {
        super(context, R.layout.list_score_row, objects);
    }

    @Override
    public View getView(int position, View row, ViewGroup parent) {
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_score_row, null);             // ligne
        }

        Score score = getItem(position);

        ViewHolder viewHolder = (ViewHolder) row.getTag();

        if (viewHolder == null) {                         // equivalent d'un cache
            viewHolder = new ViewHolder(row);
            row.setTag(viewHolder);
        }

        viewHolder.scoreNom.setText(score.getName().toString());
        viewHolder.scoreCoups.setText(String.valueOf(score.getCounter())+" coups : " );

        return row;
    }
    private static class ViewHolder {

        protected TextView scoreNom;
        protected TextView scoreCoups;

        ViewHolder(View row) {                  //permet de prendre les parametres de la vue de la ligne
            scoreNom = (TextView) row.findViewById(R.id.score_nom);
            scoreCoups = (TextView) row.findViewById(R.id.score_coups);
        }
    }
}