package com.example.time;

import android.annotation.SuppressLint;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class CountdownWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            @SuppressLint("RemoteViewLayout") RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

            // Load HTML content into WebView
            setWebViewText(views, R.id.widgetText, getHtmlContent());

            // Update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    private String getHtmlContent() {
        // Load your HTML content here
        // You can read the HTML content from a file, use a raw resource, or store it directly in the code
        // For simplicity, you can hardcode the HTML content
        return "<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>Time Countdown</title>"
                + "    <style>"
                + "        body {"
                + "            font-family: Arial, sans-serif;"
                + "            display: flex;"
                + "            justify-content: center;"
                + "            align-items: center;"
                + "            height: 100vh;"
                + "            margin: 0;"
                + "            background-color: rgb(0, 0, 0);"
                + "            color: rgb(255, 255, 255);"
                + "        }"
                + "        .countdown-container {"
                + "            text-align: center;"
                + "            animation: fadeIn 1s ease-in-out;"
                + "        }"
                + "        #countdown {"
                + "            font-size: 24px;"
                + "            font-weight: bold;"
                + "        }"
                + "        @keyframes fadeIn {"
                + "            from {"
                + "                opacity: 0;"
                + "                transform: translateY(-20px);"
                + "            }"
                + "            to {"
                + "                opacity: 1;"
                + "                transform: translateY(0);"
                + "            }"
                + "        }"
                + "        /* Responsive layout for smaller screens */"
                + "        @media (max-width: 768px) {"
                + "            .countdown-container {"
                + "                width: 80%;"
                + "                margin: 0 auto;"
                + "            }"
                + "        }"
                + "        @font-face {"
                + "            font-family: myFirstFont;"
                + "            src: url(Leaner-Thin.ttf);"
                + "        }"
                + "    </style>"
                + "</head>"
                + "<body>"
                + "    <div class=\"countdown-container\">"
                + "        <h1>Time Passed Since April 30, 2005</h1>"
                + "        <p id=\"countdown\"></p>"
                + "        <p id=\"elapsedYears\"></p>"
                + "        <p id=\"daysPassed\"></p>"
                + "    </div>"
                + "    <script>"
                + "        function updateCountdown() {"
                + "            const userCurrentDate = new Date();"
                + "            const userCurrentYear = userCurrentDate.getFullYear();"
                + "            const startDate = new Date('2005-04-30T00:00:00');"
                + "            const currentDate = new Date();"
                + "            const timeElapsed = currentDate - startDate;"
                + "            const milliseconds = timeElapsed;"
                + "            const seconds = Math.floor(timeElapsed / 1000);"
                + "            const minutes = Math.floor(seconds / 60);"
                + "            const hours = Math.floor(minutes / 60);"
                + "            const days = Math.floor(hours / 24);"
                + "            const years = userCurrentYear - 2006;"
                + "            const elapsedMonths = (userCurrentDate.getMonth() + 0) + (years * 12) - 4;"
                + "            const remainingMonths = elapsedMonths % 12;"
                + "            const currentDayOfMonth = userCurrentDate.getDate();"
                + "            let totalDaysPassed = 1;"
                + "            for (let day = 1; day < currentDayOfMonth; day++) {"
                + "                const tempDate = new Date(userCurrentDate.getFullYear(), userCurrentDate.getMonth(), day);"
                + "                if (tempDate.getMonth() === userCurrentDate.getMonth()) {"
                + "                    totalDaysPassed++;"
                + "                }"
                + "            }"
                + "            const elapsedTimeString = `${years} y.   ${remainingMonths} m.    ${totalDaysPassed}d.   ${hours % 24} h.  ${minutes % 60} min.  ${seconds % 60} s.    ${milliseconds % 1000} ms`;"
                + "            const elapsedYearsString = `Elapsed years: ${years}`;"
                + "            const daysPassedInCurrentMonth = totalDaysPassed;"
                + "            document.getElementById('countdown').textContent = elapsedTimeString;"
                + "        }"
                + "        setInterval(updateCountdown, 1);"
                + "        updateCountdown();"
                + "    </script>"
                + "</body>"
                + "</html>";
    }

    private void setWebViewText(RemoteViews views, int viewId, String htmlText) {
        views.setTextViewText(viewId, "Loading..."); // Set initial text
        views.setCharSequence(viewId, "setText", htmlText);
    }
}
