package com.mycompany.myapp.thetframework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 3/3/2018.
 */
public class ResolveList {
    List<question> Answeredquestions = new ArrayList<question>();
    List<question> Unansweredquestions = new ArrayList<question>();
    List<question> Allquestions = new ArrayList<question>();

    private static ResolveList ourInstance = new ResolveList();

    public void setAllquestions(List<question> allquestions) {
        Allquestions = allquestions;
    }

    public void setAnsweredquestions(List<question> answeredquestions) {
        Answeredquestions = answeredquestions;
    }

    public static void setOurInstance(ResolveList ourInstance) {
        ResolveList.ourInstance = ourInstance;
    }

    public void setUnansweredquestions(List<question> unansweredquestions) {
        Unansweredquestions = unansweredquestions;
    }

    public List<question> getAllquestions() {
        return Allquestions;
    }

    public List<question> getAnsweredquestions() {
        return Answeredquestions;
    }

    public List<question> getUnansweredquestions() {
        return Unansweredquestions;
    }

    public static ResolveList getOurInstance() {
        return ourInstance;
    }


    public static ResolveList getInstance() {
        return ourInstance;
    }

    private ResolveList() {
    }
}
