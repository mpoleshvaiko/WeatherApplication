package com.mpol.weatherapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatter {
    public static String formatTime(
            String rawTime,
            SimpleDateFormat inputFormat,
            SimpleDateFormat outputFormat
    ) {
        try {
            Date date = inputFormat.parse(rawTime);
            assert date != null;
            String formatted = outputFormat.format(date);
            return formatted.substring(0, formatted.length() - 3);
        } catch (ParseException e) {
            return rawTime;
        }
    }

    public static String formatDate(
            String rawDate,
            SimpleDateFormat inputFormat,
            SimpleDateFormat outputFormat
    ) {
        try {
            Date date = inputFormat.parse(rawDate);

            Calendar calendar = Calendar.getInstance();
            assert date != null;
            calendar.setTime(date);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            String[] daysOfWeek = new String[]{
                    "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
            };

            Calendar today = Calendar.getInstance();

            if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                    calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)) {
                return "Today";
            } else if (dayOfWeek >= 1 && dayOfWeek <= 7) {
                return daysOfWeek[dayOfWeek - 1];
            } else {
                return outputFormat.format(date);
            }

        } catch (Exception e) {
            return rawDate;
        }
    }
}
