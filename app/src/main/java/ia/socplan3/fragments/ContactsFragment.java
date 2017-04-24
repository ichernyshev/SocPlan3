package ia.socplan3.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ia.socplan3.AddContactActivity;
import ia.socplan3.ContactLab;
import ia.socplan3.OneContact;
import ia.socplan3.R;

public class ContactsFragment extends Fragment {

    private RecyclerView mContactRecyclerView;
    private ContactAdapter mAdapter;


    public static ContactsFragment newInstance() {
        ContactsFragment fragment = new ContactsFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contacts, container, false);

        mContactRecyclerView = (RecyclerView) v.findViewById(R.id.contact_recycler_view);
        mContactRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        //метод вызывающий Activity при нажатии на плавающую кнопку
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AddContactActivity.getIntent(getActivity());
                startActivity(intent);
            }
        });
        return v;
    }

    private void updateUI() {
        ContactLab contactLab = ContactLab.get(getActivity());
        List<OneContact> oneContacts = contactLab.getContacts();

        if (mAdapter == null) {
            mAdapter = new ContactAdapter(oneContacts);
            mContactRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setOneContacts(oneContacts);
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    private class ContactHolder extends RecyclerView.ViewHolder {

        private OneContact mOneContact;

        public TextView mNameTextView;
        public TextView mSecondNameTextView;
        public TextView mPhone;

        public ContactHolder(View itemView) {
            super(itemView);
            mNameTextView = (TextView) itemView.findViewById(R.id.list_item_name);
            mSecondNameTextView = (TextView) itemView.findViewById(R.id.list_item_secondname);
            mPhone = (TextView) itemView.findViewById(R.id.list_item_phone);
        }

        public void bindOneContact(OneContact oneContact) {
            mOneContact = oneContact;
            mNameTextView.setText(mOneContact.getName());
            mSecondNameTextView.setText(mOneContact.getSecondName());
            mPhone.setText(mOneContact.getPhone());
        }
    }

    private class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {

        private List<OneContact> mOneContacts;

        public ContactAdapter(List<OneContact> oneContacts) {
            mOneContacts = oneContacts;
        }

        // вызывается виджетом RecyclerView, когда ему потребуется новое представление для отображения элемента
        @Override
        public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.list_item,  parent, false);
            return new ContactHolder(v);
        }

        //метод связывает представление View объекта ViewHolder с объектом модели
        @Override
        public void onBindViewHolder(ContactHolder holder, int position) {
            OneContact oneContact = mOneContacts.get(position);
            holder.bindOneContact(oneContact);
        }

        @Override
        public int getItemCount(){
            return mOneContacts.size();
        }

        public void setOneContacts(List<OneContact> oneContacts) {
            mOneContacts = oneContacts;
        }
    }
}
