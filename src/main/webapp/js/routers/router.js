var app = app || {};

(function () {
	'use strict';
	
	var Controller = Backbone.Router.extend({
	    routes: {
	        "": "start",
	        "!/": "start",
	        "!/add": "add",
	        "!/addMap": "addMap",
	        "!/showAims": "showAims",
	        "!/showAllAims": "showAllAims",
	        "!/edit": "edit"
	    },

	    start: function () {
	        //app.aims.trigger('statusStart');
	    },

	    add: function () {
	    	//app.aims.trigger('statusAdd');
	    },
	    
	    addMap: function () {
	    	//app.maps.trigger('statusAddMap');
	    },
	    
	    showAims: function () {
	    	//app.maps.trigger('statusShowAim');
	    },
	    
	    showAllAims: function () {
	    	//app.maps.trigger('statusShowAllAim');
	    },
	    
	    edit: function () {
	    	//app.aims.trigger('statusEdit');
	    }
	});
	
	app.aimRouter = new Controller();
	Backbone.history.start();
}) ();