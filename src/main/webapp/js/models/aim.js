var app = app || {};

(function () {
	'use strict';
	
	app.Aim = Backbone.Model.extend({
	    defaults: {
	    	"number":0,
	    	"idHead":null,
	    	"description":"0",
	    	"personalAim":"0",
	    	"ratingMeasure":"0",
	    	"expectedValue":0,
	    	"realizDate":null,
	    	"valueAim":0,
	    	"comment":"0",
	    	"expectedRating":0,
	    	"commentRating":"0",
	    	"idCreatorAim":"0",
	    	"idMap":0
	    },
	    urlRoot: 'aim/'
	  });

}) ();