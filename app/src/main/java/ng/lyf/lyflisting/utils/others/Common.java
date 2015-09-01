package ng.lyf.lyflisting.utils.others;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ng.lyf.lyflisting.LyfListingApplication;
import ng.lyf.lyflisting.R;

public class Common {
    public static final String EMAIL_REGEX = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
    public static final String MOBILE_REGEX = "^0(7|8|9)[0-9]{9}$";

    /*
* Useful for checking if the device is tablet or not
* */
    public static Boolean isTablet() {
        if ((LyfListingApplication.getContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE) {

            return true;
        }
        return false;
    }

    public static int getScreenWidth(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    public static int getScreenHeight(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }

    public static int getDIPValue(Context context, int pxValue) {
        return (int) (pxValue * getDeviceDensityScale(context) + 0.5f);
    }

    public static int convertDpToPixel(Context context, float dp) {
        return (int) convertDpToFloatPixel(context, dp);
    }

    public static float convertDpToFloatPixel(Context context, float dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }

    public static float getDeviceDensityScale(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static boolean hasFragmentRemoved(Fragment fragment) {
        return fragment == null
                || fragment.isRemoving()
                || fragment.getActivity() == null
                || fragment.getActivity().isFinishing();
    }

    public static void callNumber(Context context, String telNumber) {
        String number = "tel:" + telNumber;
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number));
        context.startActivity(callIntent);
    }

    public static void showKeyboard(Activity activity, EditText editText) {
        // show virtual keyboard
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(editText, 0);
        }
    }

    public static void hideKeyboard(Activity activity, EditText editText) {
        // hide virtual keyboard
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    public static int getIntFromString(String numberString) {

        String numString = Strings.nullSafeString(numberString);

        try {
            int numberInt = Integer.parseInt(numString);

            return numberInt;
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();

            return 0;
        }
    }

    public static long getLongFromString(String numberString) {

        String numString = Strings.nullSafeString(numberString);

        try {
            long numberLong = Long.parseLong(numString);

            return numberLong;
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();

            return 0;
        }
    }

    public static double getDoubleFromString(String numberString) {

        String numString = Strings.nullSafeString(numberString);

        try {
            double numberDouble = Double.parseDouble(numString);

            return numberDouble;
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();

            return 0;
        }
    }

    public static void shareImageAndText(Activity activity, int drawable, String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        Uri imageUri = null;
        try {
            imageUri = Uri.parse(MediaStore.Images.Media.insertImage(activity.getContentResolver(),
                    BitmapFactory.decodeResource(activity.getResources(), drawable), null, null));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        intent.putExtra(Intent.EXTRA_STREAM, imageUri);

        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(activity, activity.getString(R.string.no_activity_to_share), Toast.LENGTH_LONG).show();
        }
    }

    public static void shareText(Activity activity, String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(activity, activity.getString(R.string.no_activity_to_share), Toast.LENGTH_LONG).show();
        }
    }

    // Image Width and height according to the full width
    private static int dealImageWidth = 0;
    private static int dealImageHeight = 0;

    public static int getDealImageWidth() {
        return dealImageWidth;
    }

    public static void setDealImageWidth(int dealImageWidth) {
        Common.dealImageWidth = dealImageWidth;
    }

    public static void openBrowser(Activity activity, String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        activity.startActivity(i);
    }

    public static String getFormattedDate(String unformattedDate) {

        String formattedDate;
        SimpleDateFormat formatTo = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat formatFrom = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatFrom.parse(unformattedDate);
            formattedDate = formatTo.format(date);
        } catch (ParseException e) {
            formattedDate = unformattedDate;
        }

        return formattedDate;
    }

    public static void hideKeyboard(Activity activity, View view) {
        // hide virtual keyboard
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void underLineTextView(TextView textView, String text) {
        textView.setText(Html.fromHtml("<b><u>" + text + "</u></b>"));
    }

    public static boolean isValidEditText(EditText editText) {
        editText.setError(null);
        if (editText.getText().toString().isEmpty()) {
            editText.setError("This field is required");
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidPasswordEditText(EditText editText) {
        editText.setError(null);
        if (editText.getText().toString().isEmpty()) {
            editText.setError("This field is required");
            return false;
        } else if (editText.getText().toString().length() < 6) {
            editText.setError("Must be more than 6 characters");
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidEmailEditText(EditText editText) {
        editText.setError(null);
        if (editText.getText().toString().isEmpty()) {
            editText.setError("This field is required");
            return false;
        } else if (validateStringWithRegex(editText.getText().toString(), MOBILE_REGEX)) {
            editText.setError("Must be a valid email address");
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidPhoneEditText(EditText editText) {
        editText.setError(null);
        if (editText.getText().toString().isEmpty()) {
            editText.setError("This field is required");
            return false;
        } else if (validateStringWithRegex(editText.getText().toString(), MOBILE_REGEX)) {
            editText.setError("Must be a valid phone number");
            return false;
        } else {
            return true;
        }
    }

    private static boolean validateStringWithRegex(String string, String regex) {
        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Now create matcher object.
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static void togglePasswordInputVisibility(EditText passwordEditText, Button showPasswordButton) {
        int signInPasswordTextStart;
        int signInPasswordTextEnd;

        if (showPasswordButton.getText().toString().equalsIgnoreCase("show")) {
            signInPasswordTextStart = passwordEditText.getSelectionStart();
            signInPasswordTextEnd = passwordEditText.getSelectionEnd();
            passwordEditText.setTransformationMethod(null);
            passwordEditText.setSelection(signInPasswordTextStart, signInPasswordTextEnd);
            showPasswordButton.setText("HIDE");
        } else {
            signInPasswordTextStart = passwordEditText.getSelectionStart();
            signInPasswordTextEnd = passwordEditText.getSelectionEnd();
            passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
            passwordEditText.setSelection(signInPasswordTextStart, signInPasswordTextEnd);
            showPasswordButton.setText("SHOW");
        }
    }
}