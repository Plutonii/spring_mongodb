var app = app || {};

(function () {
	'use strict';
	
	var Maps = Backbone.Collection.extend ( {
		  model: app.Map,
		  url: "maps"
		});
	app.maps = new Maps();
}) ();