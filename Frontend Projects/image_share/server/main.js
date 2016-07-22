import { Meteor } from 'meteor/meteor';

Meteor.startup(() => {
  // code to run on server at startup
  	//Images = new Mongo.Collection("images");
	console.log(Images.find().count());
	if (Images.find().count() == 0){
		for(var i=1; i<16;i++){
			Images.insert(
			{
				img_src:""+i+".jpg",
				img_alt:"Emma watson image from meteor"
			});
		}//end of for loop
		console.log(Images.find().count());
	}//end of number of images

});
