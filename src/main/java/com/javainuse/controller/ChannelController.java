package com.javainuse.controller;

import com.javainuse.model.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javainuse.service.ChannelService;

@RestController
public class ChannelController {

	private ChannelService channelService;

	@Autowired
	public ChannelController(ChannelService jewelleryShopService) {
		this.channelService = jewelleryShopService;
	}


	@RequestMapping(value = "/getChannel", method = RequestMethod.POST, produces = "application/json")
	public Channel getQuestions(@RequestBody Channel channel) {

        channelService.getChannel(channel);

		return channel;
	}
}
