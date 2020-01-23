package com.javainuse.service;

import com.javainuse.model.Channel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelService {

    private final KieContainer kieContainer;

    private KieSession kieSession;

    @Autowired
    public ChannelService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
        kieSession = kieContainer.newKieSession("rulesSession");

    }

    public Channel getChannel(Channel channel) {
        kieSession.insert(channel);
        kieSession.fireAllRules();
        return channel;
    }
}