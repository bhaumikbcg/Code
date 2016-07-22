'use strict'

var home_template, category_template, animal_template, about_template;
var breadcrumb_template,current_category, current_animal;

function showTemplate(template, data){
	var html = template(data);
	$('#content').html(html);
}

function clearBreadcrumbs() {
	$(".breadcrumb").empty();
}

function addBreadcrumb(name, className) {
	var data = { name: name, class: className };
	var html = breadcrumb_template(data);
	$(".breadcrumb").append(html);
}

function showCategory(category) {

	showTemplate(category_template, category);

	clearBreadcrumbs();
	addBreadcrumb("Home", "crumb-home");
	addBreadcrumb(category.name, "crumb-category");
}

function showAnimal(animal) {

	showTemplate(animal_template, animal);

	clearBreadcrumbs();
	addBreadcrumb("Home", "crumb-home");
	addBreadcrumb(current_category.name, "crumb-category");
	addBreadcrumb(animal.name, "crumb-animal");
}

$(document).on('ready', function() {

	var templateHtml = $("#home-template").html();
	home_template = Handlebars.compile(templateHtml);

	templateHtml = $("#category-template").html();
	category_template = Handlebars.compile(templateHtml);

	templateHtml = $("#animal-template").html();
	animal_template = Handlebars.compile(templateHtml);

	templateHtml = $("#breadcrumb-template").html();
	breadcrumb_template = Handlebars.compile(templateHtml);

	templateHtml = $("#about-template").html();
	about_template = Handlebars.compile(templateHtml);

	$("body").on('click', "a.goto-home, a.crumb-home", function() {
		showTemplate(home_template, animals_data);

		clearBreadcrumbs();
		addBreadcrumb("Home", "crumb-home");

		$(".nav .active").removeClass("active");
		$("#nav-home").addClass("active");
	});

	$("body").on('click', "a.goto-category", function() {

		var index = $(this).data("id");
		current_category = animals_data.category[index];

		showCategory(current_category);
	});

	$("body").on('click', "a.crumb-category", function() {
		showCategory(current_category);
	});

	$("body").on('click', "a.goto-animal", function() {

		var index = $(this).data("id");
		current_animal = current_category.animals[index];

		showAnimal(current_animal);
	});

	$("body").on('click', "a.crumb-animal", function() {
		showAnimal(current_animal);
	});

	$("body").on('click', "a.view-photo", function() {

		var src = $(this).data("src");
		$("#modal-img").attr("src", src);
		$("#image-modal").modal('show');
	});

	$("body").on('click', "a.goto-about, a.crumb-about", function() {
		showTemplate(about_template, about_text);

		clearBreadcrumbs();
		addBreadcrumb("About", "crumb-about");

		$(".nav .active").removeClass("active");
		$("#nav-about").addClass("active");
	});

	$(".goto-home").first().click();

});