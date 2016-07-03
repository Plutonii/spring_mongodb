var app = app || {};

(function () {
	'use strict';
	
	app.AimView = Backbone.View.extend({
		tagName: 'tr',
		template: '#aimapp',
		
		events: {
			'click .edit': 'editAim',
			'click .delete': 'delAim'
		},
		
		initialize: function() {
			_.bindAll(this, 'render');
			this.model.on('destroy', this.remove, this);
	    },
	    
		render: function() {
			console.log("In model render");
			var template = _.template( $(this.template).html() );
			this.$el.html( template( this.model.toJSON() ) );
			return this;	
		},
		
		editAim: function() {
			app.idEdit = this.model.get('id');
			this.model.trigger('clickEditModel');
			
			//alert(this.model.get('number'));
			
		},
		
		delAim: function() {
		  this.model.destroy();
		  if (this.model.isNew() === true) console.log("Error:(");
		},
		
		remove: function() {
		  $(this.el).remove();
		}
	});
	
}) ();