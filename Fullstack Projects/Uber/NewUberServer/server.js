//super simple rpc server example
var express = require('express')
, http = require('http')
, mysql = require('mysql')
, path = require('path');

var app = express();
app.set('port', process.env.PORT || 3010);
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());

var amqp = require('amqp')
, util = require('util');
/*var mongoSessionConnectURL = "mongodb://localhost:27017/facebook";
var expressSession = require("express-session");
var mongoStore = require("connect-mongo")(expressSession);
var mongo = require('./services/mongo');
app.use(expressSession({
	secret: 'cmpe273_teststring',
	resave: false,  //don't save session if unmodified
	saveUninitialized: true,	// don't create session until something stored
	duration: 30 * 60 * 1000,    
	activeDuration: 5 * 60 * 1000,
	store: new mongoStore({
		url: mongoSessionConnectURL
	})
}));*/

var login = require('./services/login');

var cnn = amqp.createConnection({host:'127.0.0.1'});

cnn.on('ready', function(){
	
	 cnn.queue('login_signup_queue',function(q){ 
		 q.subscribe(function(message,header,deliveryInfo, m){
			 util.log(util.format(deliveryInfo.routingKey,message));
			 util.log("Message:"+JSON.stringify(message));
			 util.log("DeliveryInfo: "+JSON.stringify(deliveryInfo));
			 if(message.oper==="login")
			 {
				 login.signin(message, function(err,res){
						//return index sent
					 console.log("inside login.signin");
						cnn.publish(m.replyTo, res, {
							contentType:'application/json',
							contentEncoding:'utf-8',
							correlationId:m.correlationId
						});
				 });
			 }
			 if(message.oper==="signup")
			 {
			 login.signup(message, function(err,res){
					//return index sent
				 console.log("inside login.signin");
					cnn.publish(m.replyTo, res, {
						contentType:'application/json',
						contentEncoding:'utf-8',
						correlationId:m.correlationId
					});
				});
			}
			 if(message.oper==="ride")
			 {
			 login.ride(message, function(err,res){
					//return index sent
				 console.log("inside login.ride");
					cnn.publish(m.replyTo, res, {
						contentType:'application/json',
						contentEncoding:'utf-8',
						correlationId:m.correlationId
					});
				});
			}
			 if(message.oper==="history")
			 {
			 login.history(message, function(err,res){
					//return index sent
				 console.log("inside history");
					cnn.publish(m.replyTo, res, {
						contentType:'application/json',
						contentEncoding:'utf-8',
						correlationId:m.correlationId
					});
				});
			}
			 
		 });
	 });
	
	//// Separing queue //////////////////////////
	console.log("listening on login_queue");

	cnn.queue('login_queue', function(q){
		q.subscribe(function(message, headers, deliveryInfo, m){
			util.log(util.format( deliveryInfo.routingKey, message));
			util.log("Message: "+JSON.stringify(message));
			util.log("DeliveryInfo: "+JSON.stringify(deliveryInfo));
			console.log("message.task: "+ message.task);
			var t = message.task;
			console.log("t is: " + t);
			
			console.log("------------------Old Queue--------------------");
			if(t === "abc")
			{
			    console.log("inside value oof t: " + t);
				login.handle_request(message, function(err,res){
               console.log("inside server");
               console.log("server.replyto "+ m.replyTo);
                console.log("server.id "+ m.correlationId);
				//return index sent
				cnn.publish(m.replyTo, res, {
					contentType:'application/json',
					contentEncoding:'utf-8',
					correlationId:m.correlationId
				});
			});
				console.log("Login queue ends");
			}
			
			else if(t ==="taskDriverSignIn"){
				console.log(" Driver Sign In Queue Starts here with task name : " + t);
				login.driver_SignIn(message, function(err,res){
               console.log(" Here response of Sign In Queue to server.js ");
               console.log("server.replyto "+ m.replyTo);
                console.log("server.id "+ m.correlationId);
				//return index sent
				cnn.publish(m.replyTo, res, {
					contentType:'application/json',
					contentEncoding:'utf-8',
					correlationId:m.correlationId
				});
			});
				console.log("Login queue ends");
			}
				
			
			
		});
	});
	
	
	
	cnn.queue('driverUpdate', function(q){
		q.subscribe(function(message, headers, deliveryInfo, m){
			util.log(util.format( deliveryInfo.routingKey, message));
			util.log("Message: "+JSON.stringify(message));
			util.log("DeliveryInfo: "+JSON.stringify(deliveryInfo));
			console.log("------------------Driver Update Queue-------------------");
			
			login.driverupdate_request(message, function(err,res){
               console.log(" Got response from driverupdate_request in login.js here ");
               console.log("server.replyto "+ m.replyTo);
                console.log("server.id "+ m.correlationId);
				//return index sent
				cnn.publish(m.replyTo, res, {
					contentType:'application/json',
					contentEncoding:'utf-8',
					correlationId:m.correlationId
				});
			});
				console.log(" Driver Update queue ends");
			
			
			
		});
	});
	
	cnn.queue('acceptRide', function(q){
		q.subscribe(function(message, headers, deliveryInfo, m){
			util.log(util.format( deliveryInfo.routingKey, message));
			util.log("Message: "+JSON.stringify(message));
			util.log("DeliveryInfo: "+JSON.stringify(deliveryInfo));
			console.log("------------------Accept Ride Queue-------------------");
			
			login.acceptRide(message, function(err,res){
               console.log(" Got response from driverupdate_request in login.js here ");
               console.log("server.replyto "+ m.replyTo);
                console.log("server.id "+ m.correlationId);
				//return index sent
				cnn.publish(m.replyTo, res, {
					contentType:'application/json',
					contentEncoding:'utf-8',
					correlationId:m.correlationId
				});
			});
				console.log(" Driver Update queue ends");
			
			
			
		});
	});
});

/* New Queue For friends */





	



/* New Sign Up Queue Ends here */

/*mongo.connect(mongoSessionConnectURL, function(){
	console.log('Connected to mongo at: ' + mongoSessionConnectURL);
	http.createServer(app).listen(app.get('port'), function(){
		console.log('Express server listening on port ' + app.get('port'));
	});  
});*/