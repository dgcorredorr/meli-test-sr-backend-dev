package com.meli.core.impl;

import java.util.ArrayList;
import java.util.List;

import com.meli.core.AidMessageUseCase;

public class AidMessageUseCaseImpl implements AidMessageUseCase {

    @Override
    public String decodeMessage(String[][] messages) {
      List<String> decodedMessage = new ArrayList<>();

        int maxLength = getMaxLength(messages);
        for (int i = 0; i < maxLength; i++) {
            String word = getWordAtPosition(messages, i);
            decodedMessage.add(word);
        }

        return String.join(" ", decodedMessage).trim();
    }

    private int getMaxLength(String[][] messages) {
        int max = 0;
        for (String[] message : messages) {
            max = Math.max(max, message.length);
        }
        return max;
    }

    private String getWordAtPosition(String[][] messages, int index) {
        for (String[] message : messages) {
            if (index < message.length && !message[index].isEmpty()) {
                return message[index];
            }
        }
        return "";
    }
}
