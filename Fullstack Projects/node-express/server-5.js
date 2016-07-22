var express = require('express');
var bodyParser = require('body-parser');
var morgan = require('morgan');
var dish = require('./dish');
var leader = require('./leader');
var promo = require('./promo')

var hostname = 'localhost';
var port = 3000;

var app = express();

app.use(morgan('dev'));
var dishRouter = express.Router();
dishRouter.use(bodyParser.json());

var promoRouter = express.Router();
promoRouter.use(bodyParser.json());

var leaderRouter = express.Router();
leaderRouter.use(bodyParser.json());


dishRouter.route('/').all(dish.all)

.get(dish.get)

.post(dish.post)

.delete(dish.delete);

dishRouter.route('/:dishId').all(dish.a)

.get(dish.b)

.put(dish.c)
.delete(dish.d);

app.use('/dishes', dishRouter);




promoRouter.route('/').all(promo.all)

.get(promo.get)

.post(promo.post)

.delete(promo.delete);

promoRouter.route('/:promoId').all(promo.a)

.get(promo.b)

.put(promo.c)
.delete(promo.d);
app.use('/promotions', promoRouter);


leaderRouter.route('/').all(leader.all)

.get(leader.get)

.post(leader.post)

.delete(leader.delete);

leaderRouter.route('/:leaderId').all(leader.a)

.get(leader.b)

.put(leader.c)
.delete(leader.d);
app.use('/leadership', leaderRouter);



app.use(express.static(__dirname + '/public'));

app.listen(port, hostname, function(){
	console.log('Server running at http://${hostname}:${port}/');
});