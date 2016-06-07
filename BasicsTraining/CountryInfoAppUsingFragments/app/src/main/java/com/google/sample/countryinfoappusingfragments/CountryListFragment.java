package com.google.sample.countryinfoappusingfragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountryListFragment extends Fragment {

    Button addCountryButton;
    TextView countryListTextView;
    AddCountry delegate;
    Set<String> countrySet = new HashSet<>();
    ArrayList<String> countryList = new ArrayList<>();
    boolean countrySetChanged = false;

    public static CountryListFragment CreateInstance(String arg1) {
        CountryListFragment frag = new CountryListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("ARG1", arg1);

        frag.setArguments(bundle);
        return frag;
    }

    public CountryListFragment() {
        // Required empty public constructor
    }

    public void setDelegate(AddCountry c) {
        delegate = c;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // TOREM: the last parameter should always be false. True means attach the view to the
        // container. After the call from this function the same view will again be attached to the
        // container in the activity class. So always pass false.
        View view = inflater.inflate(R.layout.fragment_country_list, container, false);

        addCountryButton = (Button) view.findViewById(R.id.addNewCountry);
        countryListTextView = (TextView) view.findViewById(R.id.countryListTextView);

        addCountryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delegate!= null) delegate.switchToAddCountry();
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( requestCode == 101 && resultCode == Activity.RESULT_OK ) {
            String countryName = data.getStringExtra("COUNTRY_NAME");
            if (countryName != null && countryName.length() != 0 ) {
                int initialSize = countrySet.size();
                countrySet.add(countryName.toUpperCase());
                if (countrySet.size() > initialSize) {
                    countrySetChanged = true;
                    countryList.add(countryName);
                }
            }
        }

    }

    private String getStringFromArrayList(ArrayList<String> list) {
        StringBuffer buffer = new StringBuffer();
        for (String name : list ) {
            buffer.append(name);
            buffer.append("\n");
        }
        return buffer.toString();
    }

    @Override
    public void onResume() {
        super.onResume();

            countryListTextView.setText(getStringFromArrayList(countryList));
            countrySetChanged = false;

    }
}
