package design;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class RateLimiter {

    HashMap<String, Integer> clientTokens;
    HashMap<String, Integer> currentClientTokens;

    public void addOrUpdateClient(String clientName, Integer tokens) {
        clientTokens.put(clientName, tokens);
    }

    public boolean isTokenAvailable(String clientName) {
        Integer availableTokens = currentClientTokens.get(clientName);
        if(availableTokens>0){
            currentClientTokens.put(clientName, availableTokens-1);
            return true;
        }
        return false;
    }

    public void refillTokens() {
        currentClientTokens = new HashMap<>();
        currentClientTokens.putAll(clientTokens);
    }

}
