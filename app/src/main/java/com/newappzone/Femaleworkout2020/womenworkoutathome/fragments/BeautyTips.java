package com.newappzone.Femaleworkout2020.womenworkoutathome.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.newappzone.Femaleworkout2020.womenworkoutathome.R;

public class BeautyTips extends Fragment {

    AdView mAdView;
  //  private AdView adView, adView1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      //  AudienceNetworkAds.initialize(getContext());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beauty_tips, container, false);

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        /*adView = new AdView(getContext(), getString(R.string.ad_banner), AdSize.BANNER_HEIGHT_50);
        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) view.findViewById(R.id.banner_container);
        // Add the ad view to your activity layout
        adContainer.addView(adView);
        // Request an ad
        adView.loadAd();*/

        /*adView1 = new AdView(getContext(), getString(R.string.ad_banner), AdSize.BANNER_HEIGHT_50);
        // Find the Ad Container
        LinearLayout adContainer1 = (LinearLayout) view.findViewById(R.id.banner_container1);
        // Add the ad view to your activity layout
        adContainer.addView(adView1);
        // Request an ad
        adView1.loadAd();*/

        return view;
    }
}