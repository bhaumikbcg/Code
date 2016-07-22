exports.all = function(req, res, next){
	res.writeHead(200, {'Content-Type': 'text/plain'});
	next();
}

exports.get = function(req, res, next){
	res.end('will send all the Leaders to you!');
}

exports.post = function(req, res, next){
	res.end('will add the leader: ' + req.body.name+' with details: '+req.body.description);
}

exports.delete = function(req, res, next){
	res.end('Delete all Leaders');
}

exports.a = function(req, res, next){
	res.writeHead(200, {'Content-Type': 'text/plain'});
	next();
}

exports.b = function(req, res, next){
	res.end('will send all the leaders: '+req.params.leaderId+' to you!');
}

exports.c = function(req, res, next){
	res.write('Updating the leader: '+re.params.leaderId+'\n');
	res.end('will update the leader: ' + req.body.name+' with details: '+req.body.description);
}

exports.d = function(req, res, next){
	res.end('Delete leader: '+req.params.leaderId);
}