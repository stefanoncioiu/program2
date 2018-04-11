(function () {
    'use strict';

    angular
        .module('app')
        .config(Routes);

    Routes.$inject = ['$routeProvider'];

    function Routes($routeProvider) {

        $routeProvider.when('/signin', {
            templateUrl: 'src/pages/signin/signin.template.html',
            controller: 'SigninCtrl',
            controllerAs: 'signin'
        }).otherwise({
            redirectTo: '/'
        });
    }

})();