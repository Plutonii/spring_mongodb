var app = app || {};

(function () {
	'use strict';
	
	var Aims = Backbone.Collection.extend ( {
		  model: app.Aim,
		  url: "aim"
		});
	app.aims = new Aims();
}) ();