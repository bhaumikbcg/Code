exports.all = function(req, res, next){
	res.writeHead(200, {'Content-Type': 'text/plain'});
	next();
}

exports.get = function(req, res, next){
	res.end('will send all the promotions to you!');
}

exports.post = function(req, res, next){
	res.end('will add the promotion: ' + req.body.name+' with details: '+req.body.description);
}

exports.delete = function(req, res, next){
	res.end('Delete all promotions');
}

exports.a = function(req, res, next){
	res.writeHead(200, {'Content-Type': 'text/plain'});
	next();
}

exports.b = function(req, res, next){
	res.end('will send all the promotions: '+req.params.promoId+' to you!');
}

exports.c = function(req, res, next){
	res.write('Updating the promotion: '+re.params.promoId+'\n');
	res.end('will update the promotion: ' + req.body.name+' with details: '+req.body.description);
}

exports.d = function(req, res, next){
	res.end('Delete promotion: '+req.params.promoId);
}