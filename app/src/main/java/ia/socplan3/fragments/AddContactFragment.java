package ia.socplan3.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import ia.socplan3.ContactLab;
import ia.socplan3.OneContact;
import ia.socplan3.R;

public class AddContactFragment extends Fragment {
    private OneContact mOneContact;
    private EditText mName;
    private EditText mSecondName;
    private EditText mPhone;
    private Button mSaveButton;
    private ImageButton mPhotoButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mOneContact = new OneContact();
    }

    @Override
    public void onPause() {
        super.onPause();

        ContactLab.get(getActivity()).updateOneContact(mOneContact);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_contact, container, false);

        mName = (EditText) v.findViewById(R.id.etName);
        mName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                mOneContact.setName(c.toString());
            }

            @Override
            public void afterTextChanged(Editable c) {

            }
        });

        mSecondName = (EditText) v.findViewById(R.id.etSecondName);
        mSecondName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                mOneContact.setSecondName(c.toString());
            }

            @Override
            public void afterTextChanged(Editable c) {

            }
        });

        mPhone = (EditText) v.findViewById(R.id.etPhone);
        mPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                mOneContact.setPhone(c.toString());
            }

            @Override
            public void afterTextChanged(Editable c) {

            }
        });

        mSaveButton = (Button) v.findViewById(R.id.btnSave);
        mSaveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ContactLab.get(getActivity()).addContact(mOneContact);
                getActivity().finish();
            }
        });

        mPhotoButton = (ImageButton) v.findViewById(R.id.contact_photo);

        return v;
    }
}
