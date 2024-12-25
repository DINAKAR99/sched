package com.example.sched.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyScheduledTask {

    @Autowired
    private RestTemplate restTemplate;  // Inject RestTemplate

    // This method will run every 5 seconds
    @Scheduled(fixedRate = 50000    )
    public void performTask() {
        // Get the current timestamp
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Prepare the message with current time
        String message = "Scheduler ran at " + currentTime;

        // Encode the message to handle spaces and special characters
        String encodedMessage = message.replace(" ", "-");

        // Construct the Telegram API URL
        String url = "https://api.telegram.org/bot8076000458:AAHoLv1MDfpZkp_mjEY8AKFD5I_fQz3PVe8/sendMessage?chat_id=760938516&text=" + encodedMessage;

        try {
            // Send the message using RestTemplate
            restTemplate.getForObject(url, String.class);
            System.out.println("Message sent to Telegram: " + message);
        } catch (Exception e) {
            System.err.println("Failed to send message to Telegram: " + e.getMessage());
        }
    }
}
