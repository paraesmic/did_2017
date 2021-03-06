package it.polito.did.app_android;


import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    public LampManager manager = LampManager.getInstance();
    public RecyclerView recycler_layout;
    public RecyclerViewAdapter recyclerViewAdapter;
    public UDPCommunication udp_task =  new UDPCommunication(new Runnable() {
        @Override
        public void run() {

                recyclerViewAdapter.notifyDataSetChanged();
        }
    }

    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceManager.setDefaultValues(this,R.xml.preferences,false);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // da usare una volta imparato ad usare il manager!
        manager.discover(udp_task);


        //int nLampade = 12; //dato che non prendiamo le lampade da nessuna parte facciamo che siano 6
       /* for (int i = 0; i < 3; i++) {
            Lampada lamp = new Lampada("urltemp","null", true);
        manager.lista_lampade.add(lamp);
       }*/

       recycler_layout = findViewById(R.id.recycler_layout);
       if(manager.statoMain==0)
           recycler_layout.setLayoutManager(new LinearLayoutManager(this));
       else
           recycler_layout.setLayoutManager(new GridLayoutManager(this,3));

       recyclerViewAdapter = new RecyclerViewAdapter(this);
       recycler_layout.setAdapter(recyclerViewAdapter);


    }

    @Override
    protected void onResume() {
        recyclerViewAdapter.notifyDataSetChanged();

        super.onResume();
    }

    @Override
    protected void onRestart() {
        recyclerViewAdapter.notifyDataSetChanged();
        super.onRestart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainmenu, menu);

//        // Associate searchable configuration with the SearchView
//        SearchManager searchManager =
//                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView =
//                (SearchView) menu.findItem(R.id.action_search).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

//            case R.id.action_search:
//                onSearchRequested();
//                return true;
            case R.id.action_settings:
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
                return true;

            case R.id.action_changeview:

                if(manager.statoMain==0){
                    manager.statoMain=1;
                    recycler_layout.setLayoutManager(new GridLayoutManager(this, 3));
                    recycler_layout.setAdapter(recyclerViewAdapter);
                    recyclerViewAdapter.notifyDataSetChanged();
                    item.setIcon(R.drawable.action_view_list);
                }else{
                    manager.statoMain=0;
                    recycler_layout.setLayoutManager(new LinearLayoutManager(this));
                    recycler_layout.setAdapter(recyclerViewAdapter);
                    recyclerViewAdapter.notifyDataSetChanged();
                    item.setIcon(R.drawable.action_view_comfy);
                }
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}


