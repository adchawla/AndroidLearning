package com.google.sample.countryinfoappusingfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AddCountry {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)  addCountryListFragment();
    }

    private void addCountryListFragment() {
        CountryListFragment countryListFragment = CountryListFragment.CreateInstance("");
        countryListFragment.setDelegate(this);

        // get access to the fragment manager
        FragmentManager manager = getSupportFragmentManager();

        // create a transaction
        FragmentTransaction trans = manager.beginTransaction();
        trans.add(R.id.mainLayout, countryListFragment, "CLF");
        //trans.addToBackStack("a");
        trans.commit();
    }

    @Override
    public void switchToAddCountry() {
        AddCountryFragment frag = new AddCountryFragment();
        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction trans = mgr.beginTransaction();

        Fragment clfFragment = mgr.findFragmentByTag("CLF");
        frag.setTargetFragment(clfFragment, 101);
        trans.remove(clfFragment).add(R.id.mainLayout, frag, "ACF").addToBackStack("").commit();
    }
}
