(function () {
    'use strict';

    angular
        .module('app')
        .service('SigninService', SigninService);

    SigninService.$inject = ['$http'];

    function SigninService($http) {

        var service = {};

        return service;
    }

})();