var rect = {
	perimeter: function(x,y){
		return (2*(x+y));
	},
	area: function(x,y){
		return (x*y);
	}
};

function solveRect(l,b){
	console.log("solving rectangle with l = "+l+ ", b = "+b);
	if(l<0 || b<0){
		console.log("Both dimensions must be greater than 0");
	}
	else{
		console.log("Area of rectangle is "+rect.area(l,b));
		console.log("Perimeter of rectangle is "+rect.perimeter(l,b));
	}
}

solveRect(3,4);
solveRect(5,6);
solveRect(-3,4);