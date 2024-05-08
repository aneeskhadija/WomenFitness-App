package com.newappzone.Femaleworkout2020.womenworkoutathome.fragments;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.newappzone.Femaleworkout2020.womenworkoutathome.R;
import com.newappzone.Femaleworkout2020.womenworkoutathome.utils.constants;

public class WorkoutGuideFragment extends Fragment implements Html.ImageGetter {

    View view;
    TextView textView;
    AdView mAdView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // AudienceNetworkAds.initialize(getContext());
        view=inflater.inflate(R.layout.workout_guide_fragment,container,false);

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

       /* adView = new AdView(getContext(), getString(R.string.ad_banner), AdSize.BANNER_HEIGHT_50);
        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) view.findViewById(R.id.banner_container);
        // Add the ad view to your activity layout
        adContainer.addView(adView);
        // Request an ad
        adView.loadAd();*/

        textView = view.findViewById(R.id.tv_guideline);
        Spanned spanned = Html.fromHtml(constants.guide, this, null);
        textView.setText(spanned);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle(" Workout Guide");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public Drawable getDrawable(String s) {
        // TODO Auto-generated method stub
        int id = 0;

        if(s.equals("guide1.png")){
            id = R.drawable.guide1;
        }

        if(s.equals("guide2.png")){
            id = R.drawable.guide2;
        }
        if(s.equals("chest.png")){
            id = R.drawable.chest;
        }
        LevelListDrawable d = new LevelListDrawable();
        Drawable empty = getResources().getDrawable(id);
        d.addLevel(0, 0, empty);
        d.setBounds(10, 10, 920, 350);

        return d;
    }
}
