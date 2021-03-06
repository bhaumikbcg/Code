var mongoose = require('mongoose'),
assert = require('assert');

var Dishes = require('./models/dishes-1');

//connection to url
var url = 'mongodb://localhost:27017/conFusion';
mongoose.connect(url);
var db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function(){
	//we are connected
	console.log("Connected correctly to server");

	//create a new user
	var newDish = Dishes({
		name: 'Uthapizza',
		description: 'Test'
	});

	//save user
	newDish.save(function(err){
		if(err)
			throw err;
		console.log("Dish created");

		//get all users
		Dishes.find({}, function(err, dishes){
			if(err)
				throw err;

			//object of all users
			console.log(dishes);
			db.collection('dishes').drop(function(){
				db.close();
			});
		});
	});
});