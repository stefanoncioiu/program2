(function () {
    'use strict';

    angular
        .module('app')
        .service('LoginService', LoginService);

    LoginService.$inject = ['$http'];

    function LoginService($http) {

        var service = {};

        service.getUserr = function (userName) {
            var requestConfig = {
                params: {userName: userName}
            };
            return $http.get('user', requestConfig);
        };
        return service;
    }

})();