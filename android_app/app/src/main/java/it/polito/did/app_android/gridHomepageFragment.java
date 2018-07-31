package it.polito.did.app_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class gridHomepageFragment extends Fragment {


    public gridHomepageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        final List<Lampada> lista_lampade = new ArrayList<>();
//        GridView lay = getActivity().findViewById(R.id.grid_layout);
//        //
//        // LampManager manager= LampManager.getInstance();
//        // manager.discover();  // da usare una volta imparato ad usare il manager!
//        int nLampade = 12; //dato che non prendiamo le lampade da nessuna parte facciamo che siano 6
//        for (int i = 0; i < nLampade; i++) {
//            Lampada lamp = new Lampada("urltemp");
//            lista_lampade.add(lamp);
//            CustomGridAdapter adapter = new CustomGridAdapter(getActivity(), (ArrayList<Lampada>) lista_lampade);
//            lay.setAdapter(adapter);
//
//        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid_homepage, container, false);
    }


}
