var app = angular.module('myApp', ['ngRoute']);
app.config(function($routeProvider, $locationProvider){
	$locationProvider.html5Mode(false).hashPrefix('');
	$routeProvider
        .when('/', {
            templateUrl: 'home.html'
        })
        .when('/first', {
            templateUrl: 'static/pages/firstAngular.html'
        })
        .when('/core', {
            templateUrl: 'static/pages/core.html'
        })
        .when('/control', {
            templateUrl: 'static/pages/control.html'
        })
        .when('/event', {
            templateUrl: 'static/pages/event.html'
        })
        .when('/flashcard', {
            templateUrl: 'static/pages/flashcard.html',
            controller: 'fcCtrl'
        })
        .otherwise({redirectTo: '/'});
});

