package ia.socplan3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import ia.socplan3.fragments.ChartsFragment;
import ia.socplan3.fragments.ContactsFragment;
import ia.socplan3.fragments.EventsFragment;
import ia.socplan3.fragments.MapsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_events:
                                selectedFragment = EventsFragment.newInstance();
                                break;
                            case R.id.navigation_contacts:
                                selectedFragment = ContactsFragment.newInstance();
                                break;
                            case R.id.navigation_charts:
                                selectedFragment = ChartsFragment.newInstance();
                                break;
                            case R.id.navigation_maps:
                                selectedFragment = MapsFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.content, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, EventsFragment.newInstance());
        transaction.commit();
    }

}
