package ng.lyf.lyflisting.utils.analytics;

import android.content.Context;


import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import ng.lyf.lyflisting.Constants;
import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.utils.others.Log;

public class GoogleTagManagerHelper {

    private static TagManager tagManager;

    public static void initializeTagManager(Context context) {
//        if(tagManager == null) {
//            tagManager = TagManager.getInstance(context);
//
//            if (Constants.TESTING) {
//                // Modify the log level of the logger to print out not only
//                // warning and error messages, but also verbose, debug, info messages.
//                tagManager.setVerboseLoggingEnabled(true);
//            }
//
//            PendingResult<ContainerHolder> pending;
//
//            if (Constants.DEBUG) {
//                pending = tagManager.loadContainerPreferNonDefault(context.getString(R.string.google_tag_manager_container_id_debug),
//                        R.raw.gtm_ngvkd4_v10);
//            } else {
//                pending = tagManager.loadContainerPreferNonDefault(context.getString(R.string.google_tag_manager_container_id_prod),
//                        R.raw.gtm_pw7gfd_v3);
//            }
//
//            // The onResult method will be called as soon as one of the following happens:
//            //     1. a saved container is loaded
//            //     2. if there is no saved container, a network container is loaded
//            //     3. the request times out. The example below uses a constant to manage the timeout period.
//            pending.setResultCallback(new ResultCallback<ContainerHolder>() {
//                @Override
//                public void onResult(ContainerHolder containerHolder) {
//
//                    ContainerHolderSingleton.setContainerHolder(containerHolder);
//                    Container container = containerHolder.getContainer();
//                    if (!containerHolder.getStatus().isSuccess()) {
//                        Log.d("GoogleTagManager: failure loading container");
//                        return;
//                    }
//                    ContainerHolderSingleton.setContainerHolder(containerHolder);
//                    ContainerLoadedCallback.registerCallbacksForContainer(container);
//                    containerHolder.setContainerAvailableListener(new ContainerLoadedCallback());
//                }
//            }, 2, TimeUnit.SECONDS);
//        }
    }

    private static class ContainerLoadedCallback implements ContainerHolder.ContainerAvailableListener {
        @Overrideit 
        public void onContainerAvailable(ContainerHolder containerHolder, String containerVersion) {
            // We load each container when it becomes available.
            Container container = containerHolder.getContainer();
            registerCallbacksForContainer(container);
        }

        public static void registerCallbacksForContainer(Container container) {
//            // Register two custom function call macros to the container.
//            container.registerFunctionCallMacroCallback("increment", new CustomMacroCallback());
//            container.registerFunctionCallMacroCallback("mod", new CustomMacroCallback());
//            // Register a custom function call tag to the container.
//            container.registerFunctionCallTagCallback("custom_tag", new CustomTagCallback());
        }
    }

}
