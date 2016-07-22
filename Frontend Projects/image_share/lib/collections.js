//the lib folder is sent to client and server, so you should be testing where the code is running if needed. It is not needed for the collection code though.
Images = new Mongo.Collection("images");
//set securitu on images collection
//allows to insert images
Images.allow({
	insert:function(userId, doc){
		console.log("testing");
		if(Meteor.user()){
			console.log(doc);//doc is image data that we are gong to insert. server has full access to the data
			//force the image to be owned by user
			doc.createdBy = userId;
			if(userId != doc.createdBy){//user is messing with someone else's data
				return false; 
			}
			else{
				return true;//user has logged in and image has correct userid
			}
		}
		else{//user not logged in
			return false;
		}
	},
	//allows to delete images
	remove:function(user,Id, doc){
		return true;
	}
})