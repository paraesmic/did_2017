package it.polito.did.app_android;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class SearchableActivity extends ListActivity {

    List<Lampada> lista_trovate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);


        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    private void doMySearch(String query){
        LampManager manager= LampManager.getInstance();
        List<Lampada> lista_lampade = manager.getLamps();
        for(int i = 0; i<=lista_lampade.size(); i++){
            Lampada l = lista_lampade.get(i);
            String nome_lampada = l.getNome();
            if(nome_lampada.contains(query)){
                lista_trovate.add(l);
            }

        }

    }
}
