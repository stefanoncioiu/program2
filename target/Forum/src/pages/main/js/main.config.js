(function () {
    'use strict';

    angular
        .module('app')
        .config(Routes);

    Routes.$inject = ['$routeProvider'];

    function Routes($routeProvider) {

        $routeProvider.when('/', {
            templateUrl: 'src/pages/main/main.template.html',
            controller: 'MainCtrl',
            controllerAs: 'main'
        }).otherwise({
            redirectTo: '/'
        });
    }

})();