exports.all = function(req, res, next){
	res.writeHead(200, {'Content-Type': 'text/plain'});
	next();
}

exports.get = function(req, res, next){
	res.end('will send all the dishes to you!');
}

exports.post = function(req, res, next){
	res.end('will add the dish: ' + req.body.name+' with details: '+req.body.description);
}

exports.delete = function(req, res, next){
	res.end('Delete all dishes');
}

exports.a = function(req, res, next){
	res.writeHead(200, {'Content-Type': 'text/plain'});
	next();
}

exports.b = function(req, res, next){
	res.end('will send all the dishes: '+req.params.dishId+' to you!');
}

exports.c = function(req, res, next){
	res.write('Updating the dish: '+re.params.dishId+'\n');
	res.end('will update the dish: ' + req.body.name+' with details: '+req.body.description);
}

exports.d = function(req, res, next){
	res.end('Delete dish: '+req.params.dishId);
}