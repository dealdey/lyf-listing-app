package ng.lyf.lyflisting.utils.others;


import static ng.lyf.lyflisting.Constants.DEBUG;

public class Log {
	private static String app = "dealdey ";

	public static final void d(Throwable throwable) {
		if (DEBUG)
			android.util.Log.d(app, "", throwable);
	}

	public static final void d(Object object) {
		if (DEBUG)
			android.util.Log.d(app, object != null ? app + object.toString() : null);
	}

	public static final void d(Object object, Throwable throwable) {
		if (DEBUG)
			android.util.Log.d(app, object != null ? app + object.toString() : null, throwable);
	}
}