package com.mycompany.myapp.thetframework;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DocFragmentAdapter extends FragmentStatePagerAdapter {

    private static int positio;
    //   private List<Fragment> fragments;
    public DocFragmentAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Doc();
            case 1:
                return new GeneralDoc();
//            case 2:
//                return new Questions();
//            case 3:
//                return new Doc();

//            case 6:
//                return new Spicernexts();
        }
        return null;
    }
    //  public void setItem(Fragment a, Fragment b , Fragment c){
//
//  }
    @Override
    public int getCount(){
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
    case 0: return "Personal";
    case 1: return "General";
//    case 2: return "Unanswered";
//    case 3: return "FrameSpice";
//    case 4: return "Interact";
//    case 5: return "Spicer";
//    case 6: return "Spicenext";
        }
        return null;
    }

}

