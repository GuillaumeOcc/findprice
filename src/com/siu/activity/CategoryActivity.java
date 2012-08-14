package com.siu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.siu.R;
import com.siu.solitaire.SoloGameContext;
import com.siu.model.Category;
import com.siu.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 17/07/12
 * Time: 18:58
 * To change this template use File | Settings | File Templates.
 */
public class CategoryActivity extends Activity {

    private ImageButton buttonClothesShoes;
    private GetCategoriesTask task;
    private List<Category> categories;
    private ImageView imageView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);


      //  imageView = (ImageView) findViewById(R.id.picture);

        buttonClothesShoes = (ImageButton) findViewById(R.id.button_clothes_shoes);

        buttonClothesShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoloGameContext.getInstance().setNumber(49);
             //   imageView.setImageResource(R.drawable.bookslogo);

                Intent intent = new Intent(CategoryActivity.this, Game.class);
                startActivity(intent);
            }
        });


        task = new GetCategoriesTask();             // creer une nouvelle instance de l'objet
        task.setActivity(this);                   //sert a relier le fragment a l'instance
        task.execute();                          // la lance
    }

    @Override
    protected void onDestroy() {             //permet de detruire l'Asynctask
        super.onDestroy();
        if (null != task) {
            task.setActivity(null);
        }
    }

    public void onFinishGetCategoriesTask(List<Category> categories) {
        this.categories = categories;
    }

    private static class GetCategoriesTask extends AsyncTask<Void, Void, List<Category>> {

        private CategoryActivity activity;

        public void setActivity(CategoryActivity activity) {
            this.activity = activity;
        }

        @Override
        protected List<Category> doInBackground(Void... voids) {        // qui peut etre rappelé avec autant de parametre qu'on veut
            List<Category> categories = new ArrayList<Category>();

            categories.add(new Category("categorie 1"));
            categories.add(new Category("categorie 2"));
            categories.add(new Category("categorie 3"));
            categories.add(new Category("categorie 4"));
            categories.add(new Category("categorie 5"));

            return categories;
        }

        @Override
        protected void onPostExecute(List<Category> categories) {
            if (null != activity && null != categories) {
                activity.onFinishGetCategoriesTask(categories);
            }
        }
    }
}