package ng.lyf.lyflisting.utils.animationHelper;

import android.graphics.Color;
import android.view.View;

import com.balysv.materialripple.MaterialRippleLayout;

/**
 * Created by SWAPNIL on 5/16/2015.
 */
public class RippleEffect {

    public static MaterialRippleLayout addRippleToView(View view) {
        MaterialRippleLayout materialRippleLayout = MaterialRippleLayout.on(view)
                .rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha(0.3f)
                .rippleHover(true).rippleRoundedCorners(2).rippleDuration(350)
                .rippleFadeDuration(70).rippleDelayClick(false).rippleDiameterDp(10)
                .create();
        return materialRippleLayout;
    }
}
