package ng.lyf.lyflisting.utils.animationHelper;

import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import ng.lyf.lyflisting.LyfListingApplication;
import ng.lyf.lyflisting.R;

/**
 * Created by Admin on 9/9/2015.
 */
public class CustomAnimator {
    private static Context context = LyfListingApplication.getContext();

    public static void slideUpAndRevailView(final View viewToSlideUp, final View viewToReveal) {
        if (viewToSlideUp != null && viewToReveal != null) {
            //Animate and show login form
            viewToReveal.setAlpha(0f);
            viewToReveal.setVisibility(View.VISIBLE);

            Animation animation = AnimationUtils.loadAnimation(context, R.anim.splash_translate);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    viewToReveal.animate().alpha(1f).setDuration(700);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });

            viewToSlideUp.setAnimation(animation);
        }
    }

    public static void animateLayoutChanges(ViewGroup viewGroup){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            LayoutTransition layoutTransition = new LayoutTransition();
            layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
            layoutTransition.setDuration(100);
            viewGroup.setLayoutTransition(layoutTransition);
        }
    }
}
