package com.google.sample.countryinfoappusingfragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddCountryFragment extends Fragment {


    Button cancelButton;
    Button doneButton;
    EditText countryNameEditText;

    public static AddCountryFragment CreateInstance() {
        AddCountryFragment frag = new AddCountryFragment();

        Bundle bundle = new Bundle();

        frag.setArguments(bundle);
        return frag;
    }

    public AddCountryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_country, container, false);

        cancelButton = (Button) view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragManager = getFragmentManager();
                if(fragManager.getBackStackEntryCount() > 0) {
                    fragManager.popBackStack();
                }
            }
        });

        doneButton = (Button) view.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countryName = countryNameEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("COUNTRY_NAME", countryName);
                getTargetFragment().onActivityResult(101, Activity.RESULT_OK, intent);
                FragmentManager fragManager = getFragmentManager();
                if(fragManager.getBackStackEntryCount() > 0) {
                    fragManager.popBackStack();
                }
            }
        });

        countryNameEditText = (EditText) view.findViewById(R.id.countryNameEditText);
        return view;
    }

}
