module.exports = function(x,y,callback){
	try{
		if(x<0||y<0){
			throw new Error("Dimensions should be greater than 0");
		}
		else
			callback(null, {
				perimeter: function(x,y){
				return (2*(x+y));
			},
				area: function(x,y){
				return (x*y);
			}
		});
	}
	catch(error){
		callback(error,null);
	}
}