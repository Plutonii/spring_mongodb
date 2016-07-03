﻿var app = app || {};

(function () {
	'use strict';
	
	app.AppView = Backbone.View.extend({
		el: '#globalDiv',
		
		events: {
			'click .addAimBut': 'adding',
			'click .addMapBut': 'addMap',
			'click .cancelAddMap': 'statusStart',
			'click .cancelAddAim': 'statusShowAim',
			'click .editBut': 'saveEdit',
			'click #addNewAimClick': 'statusAdd',
			'click #showAllAimsClick': 'statusShowAllAims',
			'click #showAllMapsClick': 'statusStart',
			'click #addNewMapClick': 'statusAddMap'
		},
		
		initialize: function(){
			
			//global section
			this.$main = this.$('.listAims');
			this.$maps = this.$('.listMaps');
			this.$addMap = this.$('.addMap');
			this.$listMaps = this.$('.tableListMaps');
			this.$list = this.$('.tableListAims');
			this.$edit = this.$('.edit');
			this.$add = this.$('.add');
			this.$infoMap = this.$('.infoMap');
			
			//menu
			this.$addAimMenu = this.$('#addNewAimClick');
			this.$showAllAimsMenu = this.$('#showAllAimsClick');
			this.$showAllMapsMenu = this.$('#showAllMapsClick');
			this.$addMapMenu = this.$('#addNewMapClick');
			
			//add aim section
			this.$inNumber = this.$('.number');
			this.$inAim = this.$('.personalAim-input');
			this.$inDesc = this.$('.description-input');
			this.$inValue = this.$('.valueAim');
			this.$inExpRat= this.$('.expectedRating');
			this.$inCom = this.$('.comment');
			//edit aim section
			this.$edNumber = this.$('.numberEd');
			this.$edAim = this.$('.personalAimEd');
			this.$edDesc = this.$('.descriptionEd');
			this.$edValue = this.$('.valueAimEd');
			this.$edExpRat= this.$('.expectedRatingEd');
			this.$edCom = this.$('.commentEd');
			
			//add map section
			this.$inYear = this.$('.year');
			this.$inLastChange = this.$('.lastChange');
			this.$inStatusMap = this.$('.statusMap');
			
			this.statusStart();
			
			//listen events for aims
			this.listenTo(app.aims, 'add', this.addOne);
			this.listenTo(app.aims, 'reset', this.addAll);
			this.listenTo(app.aims, 'clickEditModel', this.edit);
			this.listenTo(app.aims, 'saveEdit', this.loadCurrentAims);
			//this.listenTo(app.aims, 'statusStart', this.statusStart);
			//this.listenTo(app.aims, 'statusAdd', this.statusAdd);
			//this.listenTo(app.aims, 'statusEdit', this.statusEdit);
			//this.listenTo(app.aims, 'all', this.render);
			
			//listen events for maps
			this.listenTo(app.maps, 'add', this.addOneMap);
			this.listenTo(app.maps, 'reset', this.addAllMaps);
			this.listenTo(app.maps, 'clickShowAims', this.showAims);
			//this.listenTo(app.maps, 'statusShowAim', this.statusShowAim);
			//this.listenTo(app.maps, 'statusShowAllAim', this.statusShowAllAim);
			//this.listenTo(app.maps, 'statusAddMap', this.statusAddMap);
			
			console.log("In initializ before");
			
			app.aims.fetch({reset: true});
			
			console.log("In initializ in");
			
			app.maps.fetch({reset:true});
			
			console.log("In initializ after+");
	    },
	    
	    addAll: function() {
	    	console.log("In addAll appView");
	    	this.$list.html('');
	    	this.$infoMap.html('');
	    	if (typeof(app.idMap) !== "object" && typeof(app.idMap) !== "undefined") {
		    	var mapActiv = app.maps.get(app.idMap);
		    	this.$infoMap.append('Цели для карты ' + mapActiv.get('year') + ' года');
	    	}
			this.$list.append('<tr><th>Номер</th><th>Цель</th><th>Описание</th>'+
					'<th>Вес цели</th><th>Ожидаемый рейтинг</th><th>Комментарий</th><th>Функции</th></tr>');
	    	app.aims.each(this.addOne, this);
	    	console.log("End addAll appView");
	    },
	    
	    addOne: function(aimArg) {
	    	//console.log("In addOne appView");
			var aimVie = new app.AimView({ model: aimArg });
			this.$list.append( aimVie.render().el );
	    },
	    
	    statusStart: function() {
	    	this.$addMapMenu.show();
	    	this.$showAllAimsMenu.show();
	    	this.$showAllMapsMenu.hide();
	    	this.cleanInput();
	    	this.$addAimMenu.hide();
	    	this.$main.hide();
	    	this.$maps.show();
	    	this.$add.hide();
	    	this.$edit.hide();
	    	this.$addMap.hide();
	    },
	    
	    statusShowAim: function() {
	    	this.$showAllAimsMenu.hide();
	    	this.$showAllMapsMenu.show();
	    	this.$addAimMenu.show();
	    	this.$main.show();
	    	this.$maps.hide();
	    	this.$add.hide();
	    	this.$edit.hide();
	    	this.$addMap.hide();
	    },
	    
	    statusShowAllAims: function() {
	    	this.$showAllAimsMenu.hide();
	    	this.$showAllMapsMenu.show();
	    	app.idMap = null;
	    	app.aims.fetch({reset:true});
	    	this.$main.show();
	    	this.$maps.hide();
	    	this.$add.hide();
	    	this.$edit.hide();
	    	this.$addMap.hide();
	    },
	    
	    statusAdd: function() {
	    	if (typeof(app.idMap) !== "string") {
		    	alert("Вы пытаетесь создать цель без привязки к карте. " +
		    			"Вернитесь на главную и выберите карту (показать цели)");
		    	return;
		    }
	    	app.aims.url = "aim/allForMap/" + app.idMap;
	    	app.aims.fetch({reset:true});
	    	app.aims.url = "aim";
	    	this.$addAimMenu.hide();
	    	this.$main.show();
	    	this.$add.show();
	    	this.$edit.hide();
	    	this.$maps.hide();
	    	this.$addMap.hide();
	    },
	    
	    statusEdit: function() {
	    	this.$main.show();
	    	this.$add.hide();
	    	this.$edit.show();
	    },
	    
	    statusAddMap: function() {
	    	this.$addMapMenu.hide();
	    	this.$showAllAimsMenu.show();
	    	this.$showAllMapsMenu.show();
	    	this.$main.hide();
	    	this.$add.hide();
	    	this.$edit.hide();
	    	this.$maps.show();
	    	this.$addMap.show();
	    },
	    
	    adding: function() {
	    	app.aims.create(this.newAim());
	    	this.$inNumber.val('');
	    	this.$inDesc.val('');
	    	this.$inAim.val('');
	    	this.$inValue.val('');
	    	this.$inCom.val('');
	    	this.$inExpRat.val('');
	    	this.statusShowAim();
	    },
	    
	    newAim: function() {
	    	return {
	    		"number":this.$inNumber.val(),
	        	"description":this.$inDesc.val(),
	        	"personalAim":this.$inAim.val(),
	        	"valueAim":this.$inValue.val(),
	        	"comment":this.$inCom.val(),
	        	"expectedRating":this.$inExpRat.val(),
	        	"idMap":app.idMap
	    	};
	    },
	    
	    edit: function() {
	    	this.statusEdit();
	    	var that = this;
	    	function loadAim (that) {
	    		that.$edNumber.val(edAim.get('number'));
	    		that.$edDesc.val(edAim.get('description'));
	    		that.$edAim.val(edAim.get('personalAim'));
	    		that.$edValue.val(edAim.get('valueAim'));
	    		that.$edCom.val(edAim.get('comment'));
	    		that.$edExpRat.val(edAim.get('expectedRating'));
	    	};
	    	var edAim = new app.Aim();
	    	edAim.set({id:app.idEdit});
	    	edAim.fetch().done( function() {
	    		loadAim(that);
	        });
	    },
	    
	    saveEdit: function() {
	    	var editsAim = new app.Aim();
	    	var that = this;
	    	editsAim = this.editAim(editsAim);
	    	editsAim.save().done( function() {
	    		app.aims.trigger('saveEdit');
	    		if (typeof(app.idMap) !== "string")
	    		{
	    			that.statusShowAllAims();
	    		} else {
	    			that.showAims();
	    		}
	    	});
	    },
	    
	    editAim: function(editsAim) {
	    	editsAim.set({
	    		number: this.$edNumber.val(),
	    		description: this.$edDesc.val(),
	        	personalAim: this.$edAim.val(),
	        	valueAim: this.$edValue.val(),
	        	comment: this.$edCom.val(),
	        	expectedRating: this.$edExpRat.val(),
	        	id:app.idEdit
	        });
	    	return editsAim;
	    		
	    },
	    
	    loadCurrentAims: function() {
	    	app.aims.fetch({reset: true});
	    },
	    
	    addAllMaps: function() {
	    	console.log("In addAll appView MAPS");
	    	this.$listMaps.html('');
			this.$listMaps.append('<tr><th>Год</th><th>Статус</th><th>Последнее изменение</th><th>Функции</th></tr>');
	    	app.maps.each(this.addOneMap, this);
	    	console.log("End addAll appView MAPS")
	    },
	    
	    addOneMap: function(mapArg) {
			var mapVie = new app.MapView({ model: mapArg });
			this.$listMaps.append( mapVie.render().el );
	    },
	    
	    addMap: function() {
	    	app.maps.create(this.newMap());
	    	this.$inYear.val('');
	    	this.$inLastChange.val('');
	    	this.$inStatusMap.val('');
	    	this.statusStart();
	    },
	    
	    newMap: function() {
	    	return {
	    		"year":this.$inYear.val(),
	        	"status":this.$inStatusMap.val(),
	        	"lastChange":this.$inLastChange.val()
	    	};
	    },
	    
	    showAims: function() {
	    	app.aims.url = "aim/allForMap/" + app.idMap;
	    	app.aims.fetch({reset:true});
	    	this.statusShowAim();
	    	app.aims.url = "aim";
	    },
	    
		render: function() {
				this.statusStart();
				console.log("In render appview");
				this.addAll();
		},	
		
		cleanInput: function() {
			this.$inNumber.val('');
	    	this.$inDesc.val('');
	    	this.$inAim.val('');
	    	this.$inValue.val('');
	    	this.$inCom.val('');
	    	this.$inExpRat.val('');
			this.$inYear.val('');
	    	this.$inLastChange.val('');
	    	this.$inStatusMap.val('');
		},
		
		remove: function() {
			  $(this.el).remove();
		}
	});
	
}) ();