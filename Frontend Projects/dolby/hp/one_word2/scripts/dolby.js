var Dolby = Dolby || {};

(function () {
	'use strict';

	Dolby.init = function () {
		var videoChannel1 = document.getElementById('video-channel1');
		if (!Dolby.supportDDPlus) {

		} else {
			videoChannel1.src="test.mp4";			
		}
	}
	Dolby.init = function () {
		var videoChannel2 = document.getElementById('video-channel2');
		if (!Dolby.supportDDPlus) {

		} else {
			videoChannel2.src="harry_Dolby.mp4";			
		}
	}
	Dolby.init = function () {
		var videoChannel3 = document.getElementById('video-channel3');
		if (!Dolby.supportDDPlus) {

		} else {
			videoChannel3.src="linux_Dolby.mp4";			
		}
	}
}());