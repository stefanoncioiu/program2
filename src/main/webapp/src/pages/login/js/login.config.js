(function () {
    'use strict';

    angular
        .module('app')
        .config(Routes);

    Routes.$inject = ['$routeProvider'];

    function Routes($routeProvider) {

        $routeProvider.when('/', {
            templateUrl: 'src/pages/login/login.template.html',
            controller: 'LoginCtrl',
            controllerAs: 'login'
        }).otherwise({
            redirectTo: '/'
        });
    }

})();