package ia.socplan3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import ia.socplan3.fragments.AddContactFragment;

public class AddContactActivity extends AppCompatActivity {

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, AddContactActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_add_contact);

        if (fragment == null){
            fragment = new AddContactFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_add_contact, fragment)
                    .commit();
        }
    }
}
