var app = app || {};

(function () {
	'use strict';
	
	app.MapView = Backbone.View.extend({
		tagName: 'tr',
		template: '#mapapp',
		
		events: {
			'click .delete': 'delMap',
			'click .showAim': 'showAims'
		},
		
		initialize: function() {
			_.bindAll(this, 'render');
			this.model.on('destroy', this.remove, this);
	    },
	    
		render: function() {
			console.log("In model map render");
			var template = _.template( $(this.template).html() );
			this.$el.html( template( this.model.toJSON() ) );
			return this;	
		},
		
		delMap: function() {
		  this.model.destroy();
		  if (this.model.isNew() === true) console.log("Error:(");
		},
		
		showAims: function() {
			app.idMap = this.model.get('id');
			this.model.trigger('clickShowAims');
		},
		
		remove: function() {
		  $(this.el).remove();
		}
	});
	
}) ();