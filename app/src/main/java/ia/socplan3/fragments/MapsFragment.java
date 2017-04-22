package ia.socplan3.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.Toast;

import ia.socplan3.R;


public class MapsFragment extends Fragment {


    public static MapsFragment newInstance() {
        MapsFragment fragment = new MapsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_maps, container, false);

        TabHost tabHost = (TabHost) v.findViewById(R.id.tabhost);
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Карта").setContent(R.id.tab1));

        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Посещенные места").setContent(R.id.tab2));

        tabHost.setCurrentTabByTag("tag2");

        return v;
    }

}
