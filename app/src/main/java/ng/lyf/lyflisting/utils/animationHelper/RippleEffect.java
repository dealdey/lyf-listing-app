package ng.lyf.lyflisting.utils.animationHelper;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;

import com.balysv.materialripple.MaterialRippleLayout;

import ng.lyf.lyflisting.R;

/**
 * Created by SWAPNIL on 5/16/2015.
 */
public class RippleEffect {

    public static MaterialRippleLayout addRippleToView(View view) {
        MaterialRippleLayout materialRippleLayout = MaterialRippleLayout.on(view)
                .rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha((float) 0.1)
                .rippleHover(true).rippleRoundedCorners(2).rippleDuration(200)
                .rippleFadeDuration(50).rippleDelayClick(true).rippleDiameterDp(10)
                .create();
        return materialRippleLayout;
    }
}
