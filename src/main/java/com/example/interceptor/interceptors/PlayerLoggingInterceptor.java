package com.example.interceptor.interceptors;

import com.example.interceptor.models.PlayerContextObject;
import jakarta.servlet.http.HttpServletRequest;

import java.io.*;
import java.time.LocalDate;

public class PlayerLoggingInterceptor implements PlayerInterceptor {

    @Override
    public void processRequest(HttpServletRequest request, PlayerContextObject contextObject) {
        try {
            LocalDate currentDate = LocalDate.now();
            String fileName = "PlayerLogs" + currentDate.getDayOfMonth() + currentDate.getMonthValue() + currentDate.getYear() + ".txt";

            File logFile = new File(fileName);
            if (logFile.createNewFile()) {
                System.out.println("File created: " + logFile.getName());
            }

            FileWriter myWriter = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            PrintWriter out = new PrintWriter(bw);
            out.println("URL: " + request.getRequestURL());
            out.println("Player song before call: " + contextObject.getSong());
            out.println("Player state before call: " + contextObject.getCurrentState().name());
            out.close();
            bw.close();
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
