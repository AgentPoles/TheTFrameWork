package com.mycompany.myapp.thetframework;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class QuestionFragmentAdapter extends FragmentStatePagerAdapter {
    private static int positio;
    //   private List<Fragment> fragments;
    public QuestionFragmentAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new All();
            case 1:
                return new Answered();
            case 2:
                return new Unanswered() ;

        }
        return null;
    }
    //  public void setItem(Fragment a, Fragment b , Fragment c){
//
//  }
    @Override
    public int getCount(){
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
 case 0: return "All";
    case 1: return "Answered";
    case 2: return "UnAnswered";
//    case 3: return "FrameSpice";
//    case 4: return "Interact";
//    case 5: return "Spicer";
//    case 6: return "Spicenext";
        }
        return null;
    }

}


