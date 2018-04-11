(function () {
    'use strict';

    angular
        .module('app')
        .service('ForumService', ForumService);

    ForumService.$inject = ['$http'];

    function ForumService($http) {

        var service = {};

        return service;
    }

})();