package com.mycompany.myapp.thetframework;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;

public class SlideAnimationUtil {

    /**
     * Animates a view so that it slides in from the left of it's container.
     *
     * @param context
     * @param view
     */
    public static void slideInFromLeft(Context context, View view) {
        runSimpleAnimation(context, view, R.transition.slide_from_left);
    }

    public static void sslideInFromLeft(Context context, View view) {
        runSimpleAnimation(context, view, R.transition.leftin);
    }

    /**
     * Animates a view so that it slides from its current position, out of view to the left.
     *
     * @param context
     * @param view
     */
    public static void slideOutToLeft(Context context, View view) {
        runSimpleAnimation(context, view, R.transition.slide_to_lefta);
    }

    public static void sslideOutToLeft(Context context, View view) {
        runSimpleAnimation(context, view, R.transition.leftto);
    }
    /**
     *
     * Animates a view so that it slides in the from the right of it's container.
     *
     * @param context
     * @param view
     */
    public static void slideInFromRight(Context context, View view) {
        runSimpleAnimation(context, view, R.transition.slide_from_right);
    }

    public static void sslideInFromRight(Context context, View view) {
        runSimpleAnimation(context, view, R.transition.rightin);
    }

    /**
     * Animates a view so that it slides from its current position, out of view to the right.
     *
     * @param context
     * @param view
     */
    public static void slideOutToRight(Context context, View view) {
        runSimpleAnimation(context, view, R.transition.slide_to_righta);
    }

    public static void sslideOutToRight(Context context, View view) {
        runSimpleAnimation(context, view, R.transition.rightto);
    }



    /**
     * Runs a simple animation on a View with no extra parameters.
     *
     * @param context
     * @param view
     * @param animationId
     */
    private static void runSimpleAnimation(Context context, View view, int animationId) {
        view.startAnimation(AnimationUtils.loadAnimation(
                context, animationId
        ));
    }

}
