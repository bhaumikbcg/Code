var Dolby = Dolby || {};

(function () {
	'use strict';

	Dolby.init = function () {
		var audioChannel = document.getElementById('audio-channel');
		if (!Dolby.supportDDPlus) {

		} else {
			audioChannel.src="Happy_Birthday_Dolby.mp4";			
		}
	}
}());