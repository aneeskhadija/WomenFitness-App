package com.newappzone.Femaleworkout2020.womenworkoutathome.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.newappzone.Femaleworkout2020.womenworkoutathome.R;
import com.newappzone.Femaleworkout2020.womenworkoutathome.adapters.DaysAdapter;
import com.newappzone.Femaleworkout2020.womenworkoutathome.models.DaysModel;
import com.newappzone.Femaleworkout2020.womenworkoutathome.utils.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

public class MealPlan extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView Daysrecycler;
    ArrayList<DaysModel> DaysModelsList;
    //private AdView adView;
    AdView mAdView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // AudienceNetworkAds.initialize(this);
        setContentView(R.layout.meal_plan_activity);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        initialization();
    }

    private void initialization() {

        /*adView = new AdView(this, getString(R.string.ad_banner), AdSize.BANNER_HEIGHT_50);
        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        // Add the ad view to your activity layout
        adContainer.addView(adView);
        // Request an ad
        adView.loadAd();*/

        toolbar = findViewById(R.id.toolbar1);
        toolbar.setTitle("Meal Plan");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Daysrecycler = findViewById(R.id.days_recycler_view);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MealPlan.this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(MealPlan.this,3);
        Daysrecycler.setLayoutManager(gridLayoutManager);
        DaysModelsList = new ArrayList<DaysModel>();
        List<DaysModel> daysModel = SharedPrefManager.getInstance(this).getdays();
        if (daysModel!=null){
            DaysModelsList.addAll(daysModel);
            Log.d("MealPlane","sharedpref not null");
        }else {
            for (int i=1;i<=30;i++){
                DaysModel days=new DaysModel();
                days.setDay("Day "+i);
                days.setStatus("false");
                DaysModelsList.add(days);
            }
            if (SharedPrefManager.getInstance(MealPlan.this).addDaysToPref(DaysModelsList)){
                Log.d("MealPlan","Add to Pref");
            }

        }
        if (DaysModelsList != null) {
            DaysAdapter adapter = new DaysAdapter(MealPlan.this, DaysModelsList);
            Daysrecycler.setAdapter(adapter);
            Log.d("MealPlan", "Adpter Set");
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //menu item selected
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DaysModelsList.clear();
        DaysModelsList = new ArrayList<DaysModel>();
        List<DaysModel> daysModel = SharedPrefManager.getInstance(this).getdays();
        if (daysModel!=null){
            DaysModelsList.addAll(daysModel);
            Log.d("MealPlane","sharedpref not null");
            DaysAdapter adapter = new DaysAdapter(MealPlan.this, DaysModelsList);
            Daysrecycler.setAdapter(adapter);
            Log.d("MealPlan", "Adpter Set");
        }
    }
}
