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

import java.util.UUID;

import ia.socplan3.ContactLab;
import ia.socplan3.OneContact;
import ia.socplan3.R;
import ia.socplan3.ViewContactActivity;

public class ViewContactFragment extends Fragment {

    private OneContact mOneContact;
    private EditText mName;
    private EditText mSecondName;
    private EditText mPhone;
    private Button mSaveButton;
    private ImageButton mPhotoButton;

    public ViewContactFragment() {
    }

    //Сохранение и передача Contact
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID contactId = (UUID) getActivity().getIntent()
                .getSerializableExtra(ViewContactActivity.EXTRA_CONTACT_ID);
        mOneContact = ContactLab.get(getActivity()).getOneContact(contactId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_contact, container, false);

        mName = (EditText) v.findViewById(R.id.etName);
        mName.setText(mOneContact.getName());
        mName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mOneContact.setName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mSecondName = (EditText) v.findViewById(R.id.etSecondName);
        mSecondName.setText(mOneContact.getSecondName());
        mSecondName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mOneContact.setSecondName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mPhone = (EditText) v.findViewById(R.id.etPhone);
        mPhone.setText(mOneContact.getPhone());
        mPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mOneContact.setPhone(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mSaveButton = (Button) v.findViewById(R.id.btnSave);
        mSaveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ContactLab.get(getActivity()).updateOneContact(mOneContact);
                getActivity().finish();
            }
        });

        return v;
    }

}
