(function () {
    'use strict';

    angular
        .module('app')
        .service('RequestService', RequestService);

    RequestService.$inject = ['$http'];

    function RequestService($http) {

        var service = {};

        service.initConfig = function () {
            return $http.get('config');
        };

        service.getUser = function (userName) {
            var requestConfig = {
                params: {userName: userName}
            };
            return $http.get('user', requestConfig);
        };

        return service;
    }

})();