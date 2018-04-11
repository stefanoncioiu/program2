(function () {
    'use strict';

    angular
        .module('app')
        .config(Routes);

    Routes.$inject = ['$routeProvider'];

    function Routes($routeProvider) {

        $routeProvider.when('/createforum/:loginId', {
            templateUrl: 'src/pages/createforum/createforum.template.html',
            controller: 'CreateForumCtrl',
            controllerAs: 'createforum'
        }).otherwise({
            redirectTo: '/'
        });
    }

})();