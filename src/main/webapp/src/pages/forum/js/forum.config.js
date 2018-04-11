(function () {
    'use strict';

    angular
        .module('app')
        .config(Routes);

    Routes.$inject = ['$routeProvider'];

    function Routes($routeProvider) {

        $routeProvider.when('/forum/:todoId/:loginId', {
            templateUrl: 'src/pages/forum/forum.template.html',
            controller: 'ForumCtrl',
            controllerAs: 'forum'
        }).otherwise({
            redirectTo: '/'
        });
    }

})();