import { Session } from 'meteor/session'

//Images = new Mongo.Collection("images");

if (Meteor.isClient){
	Session.set("imageLimit", 8);

	lastScrollTop = 0;

	$(window).scroll(function(event){
		//test if we are near bottom of the window
		if($(window).scrollTop() + $(window).height() > $(document).height()-100){
			//where we are in the page
		var scrollTop = $(this).scrollTop();

		//see if we are going up or down
		if(scrollTop>lastScrollTop){
			Session.set("imageLimit", Session.get("imageLimit")+4);
			//console.log("down");
		}
		//console.log(new Date());
		//test if we are going down
		lastScrollTop = scrollTop;
	}
	})
	// var img_data = [{
	// 	img_src:"1.jpg",
	// 	img_alt:"Emma watson image from meteor"
	// },
	// {
	// 	img_src:"2.jpg",
	// 	img_alt:"Emma watson image 2"
	// },
	// {
	// 	img_src:"3.jpg",
	// 	img_alt:"Emma watson image 3"
	// }
	// ];
	//Template.images.helpers({images:img_data});
	Accounts.ui.config({
		passwordSignupFields:'USERNAME_AND_EMAIL'
	});
	Template.images.helpers({images:function(){
		
		if(Session.get("userFilter")){
		return Images.find({createdBy:Session.get("userFilter")}, {sort:{createdOn: -1, rating:-1}});
	}
		else
			return Images.find({}, {sort:{createdOn: -1, rating:-1}, limit:Session.get("imageLimit")});
	},

	filtering_images:function(){
		if(Session.get("userFilter")){
			return true;
		}
		else{
			return false;
		}
	},
	getFilterUser:function(){
		if(Session.get("userFilter")){
			var user = Meteor.users.findOne(
				{_id:Session.get("userFilter")});
			return user.username;
		}
		else{
			return false;
		}
	},
			getUser:function(user_id){
			var user = Meteor.users.findOne({_id:user_id});
			if(user){
				return user.username;
			}
			else{
				return "annonymous";
			}
		}
	});
//find{} means find all images and sort -1 meand sort from largest to lowest

	Template.body.helpers({username:function(){
		if (Meteor.user()){
			return Meteor.user().username;
			//return Meteor.user().emails[0].address;
		}
		else{
			return "anonymous person";
		}
	}

	});
	Template.images.events({
		'click .js-image':function(event){
			$(event.target).css("width", "50px");
		},
		'click .js-del-image':function(event){
			var image_id = this._id;//mongo sets and creates id for us
			console.log(image_id);
			$("#"+image_id).hide('slow', function(){
				Images.remove({"_id":image_id});
			})
		},
		'click .js-rate-image':function(event){
			console.log('You clicked stars');
			var rating = $(event.currentTarget).data("userrating");
			console.log(rating);
			var images_id = this.id;
			console.log(images_id);
			Images.update({_id:images_id}, {$set:{rating:rating}});//sets_id as images_id, so updates image with _id with the rating.
		},
		'click .js-show-image-form':function(event){
			$("#add-image-form").modal('show');
		},
		'click .js-set-image-filter':function(event){
			Session.set("userFilter", this.createdBy);
		},
		'click .js-unset-image-filter':function(event){
			Session.set("userFilter", undefined);
		},
	});

	Template.image_add_form.events({
		'submit .js-add-image': function(event){
			var img_src, img_alt;
			img_src = event.target.img_src.value;
			img_alt = event.target.img_alt.value;
			console.log("src: "+img_src+" alt:" +img_alt);
			if(Meteor.user()){
				Images.insert({
				img_src:img_src,
				img_alt:img_alt,
				createdOn:new Date(),
				createdBy:Meteor.user()._id//gives access to unique data base id of user
			});
			}
			
			$("#add-image-form").modal('show');
			return false;
		}
	});
}
// if (Meteor.isServer){
// 	console.log("I am server");
// }