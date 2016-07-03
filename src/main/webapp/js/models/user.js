var app = app || {};

(function () {
	'use strict';
	
	app.Map = Backbone.Model.extend({
	    defaults: {
	    	"year":1234,
	    	"status":"Yes",
	    	"lastChange":null
	    },
	    urlRoot: 'maps/'
	  });

}) ();