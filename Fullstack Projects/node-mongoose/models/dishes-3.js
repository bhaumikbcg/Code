//grab the things we need
var mongoose = require ('mongoose');
var Schema = mongoose.Schema;

var commentSchema = new Schema({
	rating: {
		type: Number,
		min: 1,
		max: 5,
		required: true
	},
	comment: {
		type: String,
		required: true
	},
	author: {
		type:String,
		required:true
	}
}, {
	timestamps:true
});



//create schema
var dishSchema = new Schema({
	name: {
		type:String,
		required:true,
		unique:true
	},
	description: {
		type:String,
		required:true
	},
	comments:[commentSchema]
}, {
	timestamps: true
});

//the schema is useless so far
//we need to create a model using it

var Dishes = mongoose.model('Dish', dishSchema);

//make this available for our node applications
module.exports = Dishes;