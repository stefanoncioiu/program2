(function () {
    'use strict';

    angular
        .module('app')
        .service('MyprofileService', MyprofileService);

    MyprofileService.$inject = ['$http'];

    function MyprofileService($http) {

        var service = {};

        return service;
    }

})();