package com.daimajia.slider.library.Transformers;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by dennis on 11/4/15.
 */
public class BubboeTransformer extends BaseTransformer {
    private static final float MIN_SCALE = 0.8f;

    @Override
    protected void onTransform(View view, float position) {
        if (position <= 0f) {
            ViewHelper.setTranslationX(view, 0f);
            ViewHelper.setScaleX(view, 1f);
            ViewHelper.setScaleY(view, 1f);
        } else if (position <= 1f) {
            final float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
            ViewHelper.setPivotX(view, 0.5f * view.getWidth());
            ViewHelper.setPivotY(view, 0.5f * view.getHeight());
            ViewHelper.setTranslationX(view, view.getWidth() * -position);
            ViewHelper.setScaleX(view, scaleFactor);
            ViewHelper.setScaleY(view, scaleFactor);
        }
    }

    @Override
    protected boolean isPagingEnabled() {
        return true;
    }
}
