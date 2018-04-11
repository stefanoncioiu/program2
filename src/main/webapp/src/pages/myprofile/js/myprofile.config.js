(function () {
    'use strict';

    angular
        .module('app')
        .config(Routes);

    Routes.$inject = ['$routeProvider'];

    function Routes($routeProvider) {

        $routeProvider.when('/myprofile/:loginId', {
            templateUrl: 'src/pages/myprofile/myprofile.template.html',
            controller: 'MyprofileCtrl',
            controllerAs: 'myprofile'
        }).otherwise({
            redirectTo: '/'
        });
    }

})();