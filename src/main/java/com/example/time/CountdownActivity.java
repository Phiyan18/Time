package com.example.time;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class CountdownActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);



        // Configure WebView settings
        WebView webView = findViewById(R.id.widgetWebView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("file:///assets/birthday.html");
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Time Countdown</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "            height: 100vh;\n" +
                "            margin: 0;\n" +
                "            background-color: rgb(0, 0, 0);\n" +
                "            color: rgb(255, 255, 255);\n" +
                "        }\n" +
                "\n" +
                "        .countdown-container {\n" +
                "            text-align: center;\n" +
                "            animation: fadeIn 1s ease-in-out;\n" +
                "        }\n" +
                "\n" +
                "        #countdown {\n" +
                "\n" +
                "            font-size: 24px;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "\n" +
                "        @keyframes fadeIn {\n" +
                "            from {\n" +
                "                opacity: 0;\n" +
                "                transform: translateY(-20px);\n" +
                "            }\n" +
                "\n" +
                "            to {\n" +
                "                opacity: 1;\n" +
                "                transform: translateY(0);\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        /* Responsive layout for smaller screens */\n" +
                "        @media (max-width: 768px) {\n" +
                "            .countdown-container {\n" +
                "                width: 80%;\n" +
                "                margin: 0 auto;\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        @font-face {\n" +
                "            font-family: myFirstFont;\n" +
                "            src: url(Leaner-Thin.ttf);\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <div class=\"countdown-container\">\n" +
                "        <h1>Time Passed Since April 30, 2005</h1>\n" +
                "        <p id=\"countdown\"></p>\n" +
                "        <p id=\"elapsedYears\"></p>\n" +
                "        <p id=\"daysPassed\"></p>\n" +
                "    </div>\n" +
                "\n" +
                "    <script>\n" +
                "        function updateCountdown() {\n" +
                "            const userCurrentDate = new Date(); // Get user's current date\n" +
                "            const userCurrentYear = userCurrentDate.getFullYear(); // Get user's current year\n" +
                "\n" +
                "            const startDate = new Date('2005-04-30T00:00:00');\n" +
                "            const currentDate = new Date();\n" +
                "\n" +
                "            const timeElapsed = currentDate - startDate;\n" +
                "\n" +
                "            const milliseconds = timeElapsed;\n" +
                "            const seconds = Math.floor(timeElapsed / 1000);\n" +
                "            const minutes = Math.floor(seconds / 60);\n" +
                "            const hours = Math.floor(minutes / 60);\n" +
                "            const days = Math.floor(hours / 24);\n" +
                "            const years = userCurrentYear - 2006; // Calculate elapsed years edited\n" +
                "\n" +
                "            const elapsedMonths = (userCurrentDate.getMonth() + 0) + (years * 12) - 4; // Calculate elapsed months\n" +
                "            const remainingMonths = elapsedMonths % 12;\n" +
                "\n" +
                "            const currentDayOfMonth = userCurrentDate.getDate(); // Get current day of the month\n" +
                "            let totalDaysPassed = 1; //edited \n" +
                "\n" +
                "            for (let day = 1; day < currentDayOfMonth; day++) {\n" +
                "                const tempDate = new Date(userCurrentDate.getFullYear(), userCurrentDate.getMonth(), day);\n" +
                "                if (tempDate.getMonth() === userCurrentDate.getMonth()) {\n" +
                "                    totalDaysPassed++;\n" +
                "                }\n" +
                "            }\n" +
                "            const elapsedTimeString = `${years} y.   ${remainingMonths} m.    ${totalDaysPassed}d.   ${hours % 24} h.  ${minutes % 60} min.  ${seconds % 60} s.    ${milliseconds % 1000} ms`;\n" +
                "            const elapsedYearsString = `Elapsed years: ${years}`;\n" +
                "\n" +
                "            const daysPassedInCurrentMonth = totalDaysPassed;\n" +
                "\n" +
                "            document.getElementById('countdown').textContent = elapsedTimeString;\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "        // Update the countdown every millisecond\n" +
                "        setInterval(updateCountdown, 1);\n" +
                "\n" +
                "        // Initial call to display the countdown immediately\n" +
                "        updateCountdown();\n" +
                "    </script>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null);

        // Additional setup code for your CountdownActivity
    }
}

