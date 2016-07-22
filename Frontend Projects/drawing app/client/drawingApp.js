'use strict';

Router.configure({
  layoutTemplate: 'applicationLayout'
});

Router.route('/', {
    name:   'home',
    action: function action() {
        this.render('intro');
        
    }
});

Router.route('/machine', {
    name:   'machine',
    action: function action() {
        this.render('wall');

    }
});

Router.route('/about', {
    name:   'about',
    action: function action() {
        this.render('about');

    }
});
