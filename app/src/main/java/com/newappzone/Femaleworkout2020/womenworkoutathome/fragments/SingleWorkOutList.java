package com.newappzone.Femaleworkout2020.womenworkoutathome.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.newappzone.Femaleworkout2020.womenworkoutathome.R;
import com.newappzone.Femaleworkout2020.womenworkoutathome.activities.ReadyToStart;
import com.newappzone.Femaleworkout2020.womenworkoutathome.adapters.WorkListAdapter;
import com.newappzone.Femaleworkout2020.womenworkoutathome.models.WorkoutDetailModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SingleWorkOutList extends Fragment implements View.OnClickListener{

    View view;
    RecyclerView recyclerViewSingle;
    Button StartBtn;
    String exercise="",daypoistion="",planno="";
    List<WorkoutDetailModel> WorkoutList;
   // private AdView adView;
   AdView mAdView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  AudienceNetworkAds.initialize(getContext());
        view=inflater.inflate(R.layout.single_workout_list_fragment,container,false);

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


        if (getArguments() != null) {
            exercise = getArguments().getString("lebal");
            daypoistion = getArguments().getString("position");
            planno = getArguments().getString("plan");
           // Log.d("singin", "LOVE WORKOUT" + exercise+" "+planno+" "+daypoistion);
        } else {
            Toast.makeText(getActivity(), "Basic info not save", Toast.LENGTH_SHORT).show();
        }
        intial();
        get_data();
        return view;
    }

    private void intial() {

        WorkoutList=new ArrayList<>();
        StartBtn=view.findViewById(R.id.workout_start_button);
        StartBtn.setOnClickListener(this);
        recyclerViewSingle = view.findViewById(R.id.single_workout_recyclerview);
      //  GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerViewSingle.setLayoutManager(new GridLayoutManager(getContext(),2));
        WorkListAdapter workListAdapter=new WorkListAdapter(getContext(),WorkoutList);
        recyclerViewSingle.setAdapter(workListAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.workout_start_button:

                    Intent intent = new Intent(getContext(), ReadyToStart.class);
                    //intent.putExtra("ID",WorkoutId);
                    intent.putExtra("plan", exercise);
                    intent.putExtra("title", planno);
                    intent.putExtra("position", daypoistion);
                    startActivity(intent);

                break;
        }
    }

    public void get_data(){
        String json;
        try {
            String path=exercise.replaceAll(" ", "");
            Log.d("SINGLE","PATH"+path);
            InputStream is=getActivity().getAssets().open(path+".json");
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();

            json =new String(buffer,"UTF-8");
            JSONArray jsonArray=new JSONArray(json);

            for (int i = 0; i<jsonArray.length(); i++ ){
                JSONObject jsonObject=jsonArray.getJSONObject(i);

                    WorkoutDetailModel model=new WorkoutDetailModel();
                    model.setName(jsonObject.getString("name"));
                    model.setUrl(jsonObject.getString("url"));
                    model.setCalories(jsonObject.getString("calories"));
                    model.setCorrectForm(jsonObject.getString("correctForm"));
                    model.setDisplayName(jsonObject.getString("display"));
                    model.setHowtodo(jsonObject.getString("howTo"));
                    model.setId(jsonObject.getInt("id"));
                    model.setInfo(jsonObject.getString("info"));
                    model.setTurns(jsonObject.getString("turns"));
                    WorkoutList.add(model);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle(planno);
        super.onViewCreated(view, savedInstanceState);
    }
}
