package com.mycompany.myapp.thetframework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 2/13/2018.
 */
public class StaticHolder {
    public static List<String> isreadList = new ArrayList<>();

    public static List<String> getIsreadList() {
        return isreadList;
    }

    public static void setIsreadList(List<String> isreadList) {
        StaticHolder.isreadList = isreadList;
    }

}
