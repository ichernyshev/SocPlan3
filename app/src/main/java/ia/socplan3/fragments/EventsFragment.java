package ia.socplan3.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ia.socplan3.AddContactActivity;
import ia.socplan3.AddEventActivity;
import ia.socplan3.R;


public class EventsFragment extends Fragment {


    public static EventsFragment newInstance(){
        EventsFragment fragment = new EventsFragment();
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
        View v = inflater.inflate(R.layout.fragment_events, container, false);

        //метод вызывающий Activity при нажатии на плавающую кнопку
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab_event);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AddEventActivity.getIntent(getActivity());
                startActivity(intent);
            }
        });

        return v;
    }

}
