var mongoose = require('mongoose'),
assert = require('assert');

var Dishes = require('./models/dishes-3');

//connection to url
var url = 'mongodb://localhost:27017/conFusion';
mongoose.connect(url);
var db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function(){
	//we are connected
	console.log("Connected correctly to server");

	//create a new dish
	Dishes.create({
		name: 'Uthapizza',
		description: 'Test',
		comments:[
		{
			rating:3,
			comment:"this is insane",
			author:"emma"
		}]
	}, function(err, dish){
		if(err)
			throw err;
		console.log('Dish Created');
		console.log(dish);

		var id = dish._id;

		//get all dishes
		setTimeout(function (){
			Dishes.findByIdAndUpdate(id, {
				$set: {
					description: 'Update test'
				}
			}, {
				new: true
			})
			.exec(function (err, dish){
				if(err)
					throw err;
				console.log('Updated Dish!');
				console.log(dish);

				dish.comments.push({
					rating:5,
					comment:"hello",
					author:"watson"
				});

				dish.save(function(err, dish){
					console.log('updated comments');
					console.log(dish);
				

				db.collection('dishes').drop(function (){
					db.close();
				});
			});
			});
		}, 3000);
	});
});