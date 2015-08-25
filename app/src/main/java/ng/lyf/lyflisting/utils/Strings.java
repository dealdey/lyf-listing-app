package ng.lyf.lyflisting.utils;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ng.lyf.lyflisting.LyfListingApplication;

public class Strings {
    public static final String EMPTY = "";


    public static String nullSafeString(String s) {
        return s == null ? EMPTY : s;
    }

    public static boolean isEmpty(String string) {
        return (string == null || string.trim().equals(EMPTY)) ? true : false;
    }

    public static String removeCommasFromPrice(String string) {
        return (string.replaceAll("[,]", ""));
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static String readAssetFile(String assetPath) {
        try {
            InputStream assetInputStream = LyfListingApplication.getContext().getAssets().open(assetPath);
            return inputStreamToString(assetInputStream);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return EMPTY;
        }
    }

    public static String inputStreamToString(InputStream inputStream) {
        InputStreamReader isr = new InputStreamReader(inputStream);    // Input stream that translates bytes to characters
        BufferedReader br = new BufferedReader(isr);                    // Buffered input character stream
        String str;
        StringBuilder output = new StringBuilder();
        try {
            while ((str = br.readLine()) != null) {
                output.append(str);
            }

            return output.toString();
        } catch (IOException e) {
            e.printStackTrace();

            return EMPTY;
        } finally {
            try {
                isr.close();
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String cleanTags(String string) {
        StringBuilder str = new StringBuilder();
        int indexOfClosingAngularBracket = 0;

        if (string.startsWith("<ul")) {
            str.append("<ul>");
            indexOfClosingAngularBracket = string.indexOf(">");
            str.append(string.substring(indexOfClosingAngularBracket + 1));
        } else if (string.startsWith("<ol")) {
            str.append("<ol>");
            indexOfClosingAngularBracket = string.indexOf(">");
            str.append(string.substring(indexOfClosingAngularBracket + 1));
        } else if (string.startsWith("<li")) {
            str.append("<li>");
            indexOfClosingAngularBracket = string.indexOf(">");
            str.append(string.substring(indexOfClosingAngularBracket + 1));
        } else {
            str.append(string);
        }

        return str.toString();
    }

    public static ArrayList<IndentingText> removeExtraNewLine(ArrayList<IndentingText> indentingTexts) {
        ArrayList<IndentingText> removedLines = new ArrayList<>();
        IndentingText temp = indentingTexts.get(0);
        for (int i = 1; i < indentingTexts.size(); i++) {
            if ((indentingTexts.get(i).getText().startsWith("<p") && temp.getText().endsWith("</p>")) || (indentingTexts.get(i).getText().equals(Strings.EMPTY) && temp.getText().endsWith("</p>"))) {
                temp.setText(temp.getText() + indentingTexts.get(i).getText());
            } else {
                removedLines.add(temp);
                temp = indentingTexts.get(i);
            }
        }

        removedLines.add(temp);

        return removedLines;
    }

    public static String getTextBetweenTags(String taggedText, String tag) {
        final Pattern pattern = Pattern.compile("<" + tag + ">(.*?)</" + tag + ">");
        final Matcher matcher = pattern.matcher(taggedText);

        final Matcher matcherCount = pattern.matcher(taggedText);

        String match = Strings.EMPTY;

        StringBuffer bufStr = new StringBuffer();

        int count = 0;
        while (matcherCount.find()) {
            count++;
        }

        int num = 0;
        while (matcher.find()) {
            num++;
            match = matcher.group(1);

            // The code crashes if it tries to parse string with $ symbol with a number like $2 or $4.
            // try catch implemented to catch those and return the actual string in case of such fatal crash.
            try {
                if (num == count) {
                    matcher.appendReplacement(bufStr, match);
                } else {
                    matcher.appendReplacement(bufStr, "<" + tag + ">" + match + "</" + tag + ">");
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        matcher.appendTail(bufStr);

        return bufStr.toString();
    }

    public static String getTextFromEditText(EditText editText) {
        String text = editText.getText().toString();
        return (text != null) ? text.trim() : Strings.EMPTY;
    }

    public static String getFormattedPrice(String string) {

        String decimalRemovedString = string.split("\\.")[0];
        int value = Common.getIntFromString(decimalRemovedString);
        if (decimalRemovedString.equals("" + value)) {
            return String.format("%,d", value);
        } else {
            return decimalRemovedString;
        }
    }

    public static String getFormattedText(String text) {
        if (!(text.trim().substring(0, 1).equals("*") || text.trim().equals("") || text.trim().equals("&nbsp;"))) {
            text = "&#8226;" + text;
        }
        return text;
    }

    public static SpannableStringBuilder getBoldSpannableText(String string) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableStringBuilder;
    }
}
