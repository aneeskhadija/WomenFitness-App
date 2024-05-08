package com.newappzone.Femaleworkout2020.womenworkoutathome.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.newappzone.Femaleworkout2020.womenworkoutathome.R;
import com.newappzone.Femaleworkout2020.womenworkoutathome.activities.MainActivity;

import static com.newappzone.Femaleworkout2020.womenworkoutathome.utils.NotificationScheduler.TAG;

public class HomeFragment extends Fragment{

    View view;
    CardView daysChallenge,abs_beginner,abs_inter,abs_advance,arm_cardview,butt_beginner,butt_inter,butt_advance,chest_cardview,leg_beginner,leg_inter,leg_advance, beauty_cardView;
    /*private AdView adView;
    private InterstitialAd interstitialAd;
    InterstitialAdListener interstitialAdListener;*/
    AdView mAdView;
    InterstitialAd mInterstitialAd;
    int int_daysChallenge, int_abs_beginner, int_abs_inter, int_abs_advance, int_arm_cardview,int_butt_beginner, int_butt_inter, int_butt_advance, int_chest_cardview, int_leg_beginner, int_leg_inter, int_leg_advance, int_beauty_cardView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // AudienceNetworkAds.initialize(getContext());
        view=inflater.inflate(R.layout.home_fragment,container,false);

        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
                loadAd();
            }
        });

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        abs_beginner=view.findViewById(R.id.abs_beginner_cardview);
        abs_inter=view.findViewById(R.id.abs_inter_cardview);
        abs_advance=view.findViewById(R.id.abs_advance_cardview);
        arm_cardview=view.findViewById(R.id.arms_cardview);
        butt_advance=view.findViewById(R.id.butt_advance_cardview);
        butt_beginner=view.findViewById(R.id.butt_beginner_cardview);
        butt_inter=view.findViewById(R.id.butt_inter_cardview);
        chest_cardview=view.findViewById(R.id.chest_cardview);
        leg_advance=view.findViewById(R.id.leg_advance_cardview);
        leg_beginner=view.findViewById(R.id.leg_beginner_cardview);
        leg_inter=view.findViewById(R.id.leg_inter_cardview);
        daysChallenge=view.findViewById(R.id.day_challenge_cardview);
        beauty_cardView=view.findViewById(R.id.beauty_cardview);

        /*interstitialAd = new InterstitialAd(getContext(), "2629021960684688_2629023264017891");
        // Set listeners for the Interstitial Ad
        interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                Log.e(TAG, "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                Log.e(TAG, "Interstitial ad dismissed.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                // Show the ad
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                Log.d(TAG, "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                Log.d(TAG, "Interstitial ad impression logged!");
            }
        };*/

        daysChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaysWorkoutListFragment fragment3=new DaysWorkoutListFragment();
                Bundle args3 = new Bundle();
                args3.putString("lebal", "Day Challenge");
                fragment3.setArguments(args3);
                FragmentTransaction fragmentTransaction3 = getFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.main_frame, fragment3);
                fragmentTransaction3.addToBackStack("forgetpass_fragment");
                fragmentTransaction3.commit();

            }
        });
        abs_beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallFragment("ABS beginner");

            }
        });
        abs_inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int_abs_inter = 1;

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(getActivity());
                } else {

                    CallFragment("ABS intermediate");
                }



            }
        });
        abs_advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallFragment("ABS advanced");

            }
        });
        arm_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int_arm_cardview = 2;

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(getActivity());
                } else {

                    CallFragment("ARM workout");
                }

            }
        });
        butt_inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallFragment("BUTT intermediate");
            }
        });
        butt_beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int_butt_beginner = 3;

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(getActivity());
                } else {

                    CallFragment("BUTT beginner");
                }

            }
        });
        butt_advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int_butt_advance = 4;

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(getActivity());
                } else {

                    CallFragment("BUTT advanced");
                }

            }
        });
        chest_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int_chest_cardview = 5;

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(getActivity());
                } else {

                    CallFragment("CHEST workout");
                }

            }
        });
        leg_inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int_leg_inter = 6;

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(getActivity());
                } else {

                    CallFragment("LEG intermediate");
                }
            }
        });
        leg_beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallFragment("LEG beginner");
            }
        });
        leg_advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallFragment("LEG advanced");
            }
        });
        beauty_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeautyTips fragment4 = new BeautyTips();
                FragmentTransaction fragmentTransaction4 = getFragmentManager().beginTransaction();
                fragmentTransaction4.replace(R.id.main_frame, fragment4);
                fragmentTransaction4.addToBackStack("forgetpass_fragment");
                fragmentTransaction4.commit();
            }
        });

        /*adView = new AdView(getContext(), getString(R.string.ad_banner), AdSize.BANNER_HEIGHT_50);
        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) view.findViewById(R.id.banner_container);
        // Add the ad view to your activity layout
        adContainer.addView(adView);
        // Request an ad
        adView.loadAd();*/

        return view;

    }

    private void loadAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        initializeNewAdsRequest();
    }

    private void initializeNewAdsRequest() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(getActivity(), getString(R.string.AdMob_InterstitialAd_ID), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                mInterstitialAd = interstitialAd;
                //  Log.i(TAG, "onAdLoaded");

                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {

                        //  Log.d("TAG", "The ad was dismissed.");
                        loadAd();

                        if (int_abs_inter == 1){

                            CallFragment("ABS intermediate");

                        }else if (int_arm_cardview == 2){

                            CallFragment("ARM workout");

                        }else if(int_butt_beginner == 3){

                            CallFragment("BUTT beginner");

                        }else if(int_butt_advance == 4){

                            CallFragment("BUTT advanced");

                        } else if(int_chest_cardview == 5){

                            CallFragment("CHEST workout");

                        }else if(int_leg_inter == 6){

                            CallFragment("LEG intermediate");

                        }else {
                            Toast.makeText(getActivity(), "Something Issue!!!", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                        Log.d("TAG", "The ad failed to show.");
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        mInterstitialAd = null;
                        Log.d("TAG", "The ad was shown.");
                    }
                });
            }


            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                // Log.i(TAG, loadAdError.getMessage());
                mInterstitialAd = null;
            }
        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Home");
        super.onViewCreated(view, savedInstanceState);
    }

    private void CallFragment(final String workout) {

            SingleWorkOutList fragment3=new SingleWorkOutList();
            Bundle args3 = new Bundle();
            args3.putString("lebal", workout);
            args3.putString("plan", workout);
            fragment3.setArguments(args3);
            FragmentTransaction fragmentTransaction3 = getFragmentManager().beginTransaction();
            fragmentTransaction3.replace(R.id.main_frame, fragment3);
            fragmentTransaction3.addToBackStack("forgetpass_fragment");
            fragmentTransaction3.commit();

    }
}
